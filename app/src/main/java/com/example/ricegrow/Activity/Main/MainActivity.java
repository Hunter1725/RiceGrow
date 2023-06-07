package com.example.ricegrow.Activity.Main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ricegrow.Activity.Authenticate.LoginNormal.LoginActivity;
import com.example.ricegrow.Activity.Knowledge.MainKnowledge;
import com.example.ricegrow.DatabaseFiles.Model.Users;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private MaterialToolbar toolbar;
    private BottomNavigationView bottomNavigationView;
    private FirebaseAuth fb;
    private RiceGrowDatabase db;
    private int selectItemDrawer;
    private int selectItemBottom;

    private ShapeableImageView avatarUser;

    private TextView userName, userEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        String userId = fb.getCurrentUser().getUid();
        Users user = db.userDao().getUserById(userId);
        if(userId != null){
            String avatar = user.getAvatar();
            avatarUser.setImageResource(getResources().getIdentifier(avatar, "drawable", getPackageName()));
            userName.setText(user.getName());
            userEmail.setText(user.getEmail());
        }


        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        //Avatar listener
        avatarUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "This is avatar", Toast.LENGTH_SHORT).show();
                drawer.closeDrawers();
            }
        });


        //Navigation drawer listener
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // Handle item selection
                int itemId = item.getItemId();

                // Update selected item
                selectItemDrawer = itemId;

                // Set checked state for the selected item
                item.setChecked(true);


                // Perform actions based on the selected item
                if (itemId == R.id.allPlan) {
                    // Handle "All plans" item selection
                    Toast.makeText(MainActivity.this, "All plans selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.newPlan) {
                    // Handle "New plan" item selection
                    Toast.makeText(MainActivity.this, "New plan selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.pesticide) {
                    // Handle "Pesticide" item selection
                    Toast.makeText(MainActivity.this, "Pesticide selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.fertilizer) {
                    // Handle "Fertilizer" item selection
                    Toast.makeText(MainActivity.this, "Fertilizer selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.pest) {
                    // Handle "Pest" item selection
                    Toast.makeText(MainActivity.this, "Pest selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.disease) {
                    // Handle "Disease" item selection
                    Toast.makeText(MainActivity.this, "Disease selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.weed) {
                    // Handle "Weed" item selection
                    Toast.makeText(MainActivity.this, "Weed selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.term) {
                    // Handle "Terms" item selection
                    Toast.makeText(MainActivity.this, "Terms selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.licence) {
                    // Handle "Licences" item selection
                    Toast.makeText(MainActivity.this, "Licences selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.logout) {
                    fb.signOut();
                    Toast.makeText(MainActivity.this, "Logout successfully!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }

                // Close the drawer
                drawer.closeDrawers();

                return true;
            }
        });

        //Toolbar listener
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.search) {
                    // Handle search item click here
                    // Apply click effect or perform any desired action
                    Toast.makeText(MainActivity.this, "Search clicked", Toast.LENGTH_SHORT).show();
                    return true; // Return true to indicate that the event has been handled
                }
                return false; // Return false to indicate that the event has not been handled
            }
        });

        //Bottom navigation listener
        bottomNavigationView.setSelectedItemId(R.id.homeBottom);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle item selection
                int itemId = item.getItemId();

                selectItemBottom = itemId;

                // Set checked state for the selected item
                item.setChecked(true);

                if(itemId == R.id.homeBottom){
                    Toast.makeText(MainActivity.this, "Home selected!", Toast.LENGTH_SHORT).show();
                } else if(itemId == R.id.planBottom){
                    Toast.makeText(MainActivity.this, "Plan selected!", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.calculatorBottom) {
                    Toast.makeText(MainActivity.this, "Calculator selected!", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.knowledge) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, new MainKnowledge());
                    transaction.commit();
                }

                return true;
            }
        });

//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.container, new MainFragment());
//        transaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_app_bar, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem avatarItem = toolbar.getMenu().findItem(R.id.miniAvatar);
        avatarItem.setActionView(R.layout.menu_item_avatar);
        View avatarActionView = avatarItem.getActionView();
        ShapeableImageView avatarImageView = avatarActionView.findViewById(R.id.miniAvatar);

        String userId = fb.getCurrentUser().getUid();
        String avatar = db.userDao().getAvatarById(userId);
        avatarImageView.setImageResource(getResources().getIdentifier(avatar, "drawable", getPackageName()));

        avatarImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Mini avatar clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return super.onPrepareOptionsMenu(menu);
    }



    private void initView() {
        drawer = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        bottomNavigationView = findViewById(R.id.bottomNavView);
        db = RiceGrowDatabase.getInstance(this);
        fb = FirebaseAuth.getInstance();
        View headerView = navigationView.getHeaderView(0);
        avatarUser = headerView.findViewById(R.id.avatarUser);
        userName = headerView.findViewById(R.id.userName);
        userEmail = headerView.findViewById(R.id.userEmail);
    }
}