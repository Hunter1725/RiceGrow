package com.hunter.ricegrow.Activity.ChatBot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.hunter.ricegrow.Activity.Planning.Calendar.CalendarUtils;
import com.hunter.ricegrow.DatabaseFiles.Model.Message;
import com.example.ricegrow.R;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder>{

    private List<Message> messageList;
    private Context context;

    public MessageAdapter(List<Message> messageList, Context context) {
        this.messageList = messageList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chatView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,null);
        return new ViewHolder(chatView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Message message = messageList.get(position);
        if(message.getSentBy().equals(Message.SENT_BY_ME)){
            holder.leftChatView.setVisibility(View.GONE);
            holder.rightChatView.setVisibility(View.VISIBLE);
            holder.txtRightChatView.setText(message.getMessage());
            holder.txtDateMe.setText(CalendarUtils.formattedMonthDay(message.getCreatedAt()));
            holder.txtTimestampMe.setText(CalendarUtils.formattedTime(message.getCreatedAt()));
        }else{
            holder.rightChatView.setVisibility(View.GONE);
            holder.leftChatView.setVisibility(View.VISIBLE);
            holder.txtLeftChatView.setText(message.getMessage());
            holder.txtDateOther.setText(CalendarUtils.formattedMonthDay(message.getCreatedAt()));
            holder.txtTimeStampOther.setText(CalendarUtils.formattedTime(message.getCreatedAt()));
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ConstraintLayout leftChatView, rightChatView;
        private TextView txtLeftChatView, txtRightChatView, txtDateMe, txtTimestampMe, txtDateOther, txtTimeStampOther;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            leftChatView = itemView.findViewById(R.id.leftChatView);
            rightChatView = itemView.findViewById(R.id.rightChatView);
            txtLeftChatView = itemView.findViewById(R.id.txtLeftChatView);
            txtRightChatView = itemView.findViewById(R.id.txtRightChatView);
            txtDateMe = itemView.findViewById(R.id.txtDateMe);
            txtTimestampMe = itemView.findViewById(R.id.txtTimestampMe);
            txtDateOther = itemView.findViewById(R.id.txtDateOther);
            txtTimeStampOther = itemView.findViewById(R.id.txtTimeStampOther);
        }
    }
}
