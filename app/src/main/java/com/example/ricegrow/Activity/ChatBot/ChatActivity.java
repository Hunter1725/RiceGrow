package com.example.ricegrow.Activity.ChatBot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ricegrow.Activity.Main.NetworkUtils;
import com.example.ricegrow.Activity.Setting.ContextWrapper;
import com.example.ricegrow.DatabaseFiles.Model.Message;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChatActivity extends AppCompatActivity implements NetworkUtils.OnConnectivityChangeListener{

    private RecyclerView recyclerView;
    private EditText edtMessage;
    private ImageButton btnSend;
    private List<Message> messageList;
    private MessageAdapter messageAdapter;
    private RelativeLayout bottom_layout;
    private ConstraintLayout lostLayout;
    private NetworkUtils networkUtils;
    private MaterialToolbar toolbarTerm;
    private RiceGrowDatabase db;

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    private OkHttpClient client = new OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .build();

    public static final String GUIDE_STRING = "I wanna you to act as a Agricultural Expert and answer the following question based on their language (limit to 60 words): \n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_chat);
        initView();
        // Create an instance of NetworkConnectivityMonitor and register the listener
        networkUtils = new NetworkUtils(ChatActivity.this);
        networkUtils.setListener(this);
        networkUtils.register();
        initListener();
    }

    void addToChat(String message,String sentBy){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageList.add(new Message(message,sentBy, LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)));
                messageAdapter.notifyDataSetChanged();
                recyclerView.smoothScrollToPosition(messageAdapter.getItemCount());
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        RiceGrowDatabase db = RiceGrowDatabase.getInstance(this);
        String lng = db.settingDao().getAll().getLanguage();
        Locale locale;
        locale = new Locale(lng);
        Locale.setDefault(locale);

        Context context = ContextWrapper.wrap(newBase, locale);
        super.attachBaseContext(context);
    }

    private void initListener() {
        btnSend.setOnClickListener(v -> {
            String question = edtMessage.getText().toString().trim();
            addToChat(question,Message.SENT_BY_ME);
            edtMessage.setText("");
            callAPI(question);
        });
        toolbarTerm.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        toolbarTerm.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.resetChat) {
                    //Show dialog to choose temp unit
                    db.messageDao().deleteAllMessages();
                    initView();
                    initRecyclerView();
                    return true;
                }
                return false; // Return false to indicate that the event has not been handled
            }
        });
        initRecyclerView();
    }

    private void initRecyclerView() {
        if (networkUtils.isConnected()) {
            bottom_layout.setVisibility(View.VISIBLE);
            lostLayout.setVisibility(View.GONE);
            //Recycler view
            messageAdapter = new MessageAdapter(messageList, ChatActivity.this);
            recyclerView.setAdapter(messageAdapter);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            llm.setStackFromEnd(true);
            recyclerView.setLayoutManager(llm);
            if (messageList.isEmpty()) {
                addToChat(getString(R.string.i_will_be_your_supporter_ask_me_something_that_you_need_to_know_3), Message.SENT_BY_BOT);
            }
        }
        else {
            bottom_layout.setVisibility(View.GONE);
            lostLayout.setVisibility(View.VISIBLE);
        }
    }

    void addResponse(String response){
        messageList.remove(messageList.size()-1);
        addToChat(response,Message.SENT_BY_BOT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (Message m : messageList){
            Message existingMessage = db.messageDao().getMessageById(m.getId()); // Adjust this based on your DAO method
            if (existingMessage == null){
                db.messageDao().insert(m);
            }
        }
    }

    private void callAPI(String question) {
        String finalMessage = GUIDE_STRING.concat(question);
        //okhttp
        messageList.add(new Message(getString(R.string.typing),Message.SENT_BY_BOT,  LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)));

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("model","gpt-3.5-turbo");

            JSONArray messageArr = new JSONArray();
            JSONObject obj = new JSONObject();
            obj.put("role","user");
            obj.put("content",finalMessage);
            messageArr.put(obj);
            jsonBody.put("messages",messageArr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(jsonBody.toString(),JSON);
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/chat/completions")
                .header("Authorization","Bearer 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")
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                addResponse(getString(R.string.failed_to_load_response_due_to)+e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){
                    JSONObject  jsonObject = null;
                    try {
                        jsonObject = new JSONObject(response.body().string());
                        JSONArray jsonArray = jsonObject.getJSONArray("choices");
                        String result = jsonArray.getJSONObject(0)
                                .getJSONObject("message")
                                .getString("content");
                        addResponse(result.trim());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    addResponse(getString(R.string.failed_to_load_response_due_to) + response.body().toString());
                    Log.e("API_RESPONSE_ERROR", response.body().string());
                }
            }
        });
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        edtMessage = findViewById(R.id.edtMessage);
        btnSend = findViewById(R.id.btnSend);
        bottom_layout = findViewById(R.id.bottom_layout);
        lostLayout = findViewById(R.id.lostLayout);
        toolbarTerm = findViewById(R.id.toolbarTerm);
        db = RiceGrowDatabase.getInstance(this);
        if(db.messageDao().getAllMessages().isEmpty()) {
            messageList = new ArrayList<>();
        } else {
            messageList = db.messageDao().getAllMessages();
        }
    }

    @Override
    public void onConnectivityChanged(boolean isConnected) {
        if (isConnected) {
            runOnUiThread(() -> {
                bottom_layout.setVisibility(View.VISIBLE);
                lostLayout.setVisibility(View.GONE);
                initRecyclerView();
            });
        } else {
            runOnUiThread(() -> {
                bottom_layout.setVisibility(View.GONE);
                lostLayout.setVisibility(View.VISIBLE);
            });
        }
    }
}