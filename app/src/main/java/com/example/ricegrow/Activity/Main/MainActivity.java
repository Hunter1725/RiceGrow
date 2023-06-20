package com.example.ricegrow.Activity.Main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ricegrow.Activity.Authenticate.LoginNormal.LoginActivity;
import com.example.ricegrow.Activity.Knowledge.MainKnowledge;
import com.example.ricegrow.Activity.Knowledge.Management.Disease.ListDisease;
import com.example.ricegrow.Activity.Knowledge.Management.Pest.ListPest;
import com.example.ricegrow.Activity.Knowledge.Management.Weed.ListWeed;
import com.example.ricegrow.Activity.Knowledge.PesticideFertilizer.MainPestFer;
import com.example.ricegrow.DatabaseFiles.Model.Users;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.search.SearchBar;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabScrollToTop;
    private NestedScrollView nestedScrollView;
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
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
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

                // Close the drawer
                drawer.closeDrawers();

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
                    startActivity(new Intent(MainActivity.this, ListPest.class));
                } else if (itemId == R.id.disease) {
                    // Handle "Disease" item selection
                    startActivity(new Intent(MainActivity.this, ListDisease.class));
                } else if (itemId == R.id.weed) {
                    // Handle "Weed" item selection
                    startActivity(new Intent(MainActivity.this, ListWeed.class));
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
                    //Inflate fragment
                    replaceFragment(new MainKnowledge());

                }

                return true;
            }
        });

        fabScrollToTop.hide();
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                // Check the scroll position
                if (scrollY == 0) {
                    // Scroll is at the top, hide the FloatingActionButton
                    fabScrollToTop.hide();
                } else if (scrollY > oldScrollY) {
                    // Scrolling downwards, hide the FloatingActionButton
                    fabScrollToTop.hide();
                } else {
                    // Scrolling upwards, show the FloatingActionButton
                    fabScrollToTop.show();
                }
            }
        });

        //FAB scroll up
        // Set an OnClickListener for the FloatingActionButton
        fabScrollToTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Scroll to the top of the NestedScrollView
                nestedScrollView.smoothScrollTo(0, 0);
            }
        });

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
        nestedScrollView = findViewById(R.id.nestedScrollView);
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
        fabScrollToTop = findViewById(R.id.fabScrollToTop);
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        nestedScrollView.smoothScrollTo(0, 0);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
            nestedScrollView.smoothScrollTo(0, 0);
        } else {
            // No remaining fragments, show exit confirmation dialog
            new MaterialAlertDialogBuilder(this)
                    .setTitle("Exit")
                    .setMessage("Are you sure you want to exit the app?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Exit the app
                            finishAffinity();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        }
    }


}