package com.example.ricegrow.Activity.Main;

import static com.example.ricegrow.Activity.Planning.Plan.PlanGenerate.SHOW_FRAGMENT;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.WindowCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ricegrow.Activity.Calculating.FertilizerCalculating.FertilizerCalculate;
import com.example.ricegrow.Activity.Calculating.MainCalculating;
import com.example.ricegrow.Activity.Calculating.PesticideCalculating.SelectPesticide;
import com.example.ricegrow.Activity.ChatBot.ChatActivity;
import com.example.ricegrow.Activity.Knowledge.MainKnowledge;
import com.example.ricegrow.Activity.Knowledge.Management.DeficienciesToxicities.ListDeftox;
import com.example.ricegrow.Activity.Knowledge.Management.Disease.ListDisease;
import com.example.ricegrow.Activity.Knowledge.Management.Pest.ListPest;
import com.example.ricegrow.Activity.Knowledge.Management.Weed.ListWeed;
import com.example.ricegrow.Activity.Notification.NotificationService;
import com.example.ricegrow.Activity.Planning.MainPlanning;
import com.example.ricegrow.Activity.Planning.Plan.PlanGenerate;
import com.example.ricegrow.Activity.Setting.ContextWrapper;
import com.example.ricegrow.Activity.Setting.GetCurrentLanguage;
import com.example.ricegrow.Activity.Setting.SettingActivity;
import com.example.ricegrow.Activity.Setting.WebsiteActivity;
import com.example.ricegrow.DatabaseFiles.Model.PlanActivities;
import com.example.ricegrow.DatabaseFiles.Model.PlanStages;
import com.example.ricegrow.DatabaseFiles.Model.Setting;
import com.example.ricegrow.DatabaseFiles.Model.UserCrops;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFICATION_REQUEST_CODE = 2233;
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
    private List<UserCrops> userCropsList = new ArrayList<>();
    private Setting setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                checkNotificationsSettings();
            }
        }
        initView();
        // Get the data from the intent
        Intent intent = getIntent();
        if (intent != null) {
            String fragmentToShow = intent.getStringExtra(SHOW_FRAGMENT);
            if ("planFragment".equals(fragmentToShow)) {
                // Show the desired fragment using FragmentTransaction
                setting.setMore(false);
                db.settingDao().updateSetting(setting);
                replaceFragment(new MainPlanning());
                bottomNavigationView.setSelectedItemId(R.id.planBottom);
            }
        }
        if (!userCropsList.isEmpty()) {
            if (setting.isNotification()) {
                startService(new Intent(this, NotificationService.class));
            }
            if (setting.isShowAgain() && setting.isMore()) {
                showFarmingPlanDialog();
                setting.setMore(false);
                db.settingDao().updateSetting(setting);
            }
        }

        //Get user info from Firebase
//        String userId = fb.getCurrentUser().getUid();
//        Users user = db.userDao().getUserById(userId);
//        if (user != null) {
//            String avatar = user.getAvatar();
//            avatarUser.setImageResource(getResources().getIdentifier(avatar, "drawable", getPackageName()));
//            userName.setText(user.getName());
//            userEmail.setText(user.getEmail());
//        }

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        //Avatar listener
        avatarUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Enjoy this moment!", Toast.LENGTH_SHORT).show();
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
                    replaceFragment(new MainPlanning());
                    bottomNavigationView.setSelectedItemId(R.id.planBottom);
                } else if (itemId == R.id.newPlan) {
                    // Handle "New plan" item selection
                    startActivity(new Intent(MainActivity.this, PlanGenerate.class));
                } else if (itemId == R.id.pesticide) {
                    // Handle "Pesticide" item selection
                    startActivity(new Intent(MainActivity.this, SelectPesticide.class));
                } else if (itemId == R.id.fertilizer) {
                    // Handle "Fertilizer" item selection
                    startActivity(new Intent(MainActivity.this, FertilizerCalculate.class));
                } else if (itemId == R.id.pest) {
                    // Handle "Pest" item selection
                    startActivity(new Intent(MainActivity.this, ListPest.class));
                } else if (itemId == R.id.disease) {
                    // Handle "Disease" item selection
                    startActivity(new Intent(MainActivity.this, ListDisease.class));
                } else if (itemId == R.id.weed) {
                    // Handle "Weed" item selection
                    startActivity(new Intent(MainActivity.this, ListWeed.class));
                } else if (itemId == R.id.deftox) {
                    // Handle "Weed" item selection
                    startActivity(new Intent(MainActivity.this, ListDeftox.class));
                } else if (itemId == R.id.term) {
                    // Handle "Terms" item selection
                    Intent intent = new Intent(MainActivity.this, WebsiteActivity.class);
                    String message = "https://www.freeprivacypolicy.com/live/0fa5afbc-8836-4aec-8c85-d6f10530d399";
                    intent.putExtra("TERMS_KEY", message);
                    startActivity(intent);
                } else if (itemId == R.id.licence) {
                    // Handle "Licences" item selection
                    Intent intent = new Intent(MainActivity.this, WebsiteActivity.class);
                    String message = "https://www.freeprivacypolicy.com/live/e5a4b424-1b2a-4fee-ab8a-5b5db5ab7d96";
                    intent.putExtra("PRIVACY_KEY", message);
                    startActivity(intent);
                } else if (itemId == R.id.setting) {
                    startActivity(new Intent(MainActivity.this, SettingActivity.class));
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
                    // Apply click effect or perform any desired action
                    startActivity(new Intent(MainActivity.this, SearchActivity.class));
                    return true; // Return true to indicate that the event has been handled
                }
                return false; // Return false to indicate that the event has not been handled
            }
        });

        //Bottom navigation listener
//        bottomNavigationView.setSelectedItemId(R.id.homeBottom);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle item selection
                int itemId = item.getItemId();

                selectItemBottom = itemId;

                // Set checked state for the selected item
                item.setChecked(true);

                if (itemId == R.id.homeBottom) {
                    replaceFragment(new MainFragment());
                } else if (itemId == R.id.planBottom) {
                    replaceFragment(new MainPlanning());
                } else if (itemId == R.id.calculatorBottom) {
                    replaceFragment(new MainCalculating());
                } else if (itemId == R.id.knowledge) {
                    replaceFragment(new MainKnowledge());
                } else if (itemId == R.id.chat) {
                    startActivity(new Intent(MainActivity.this, ChatActivity.class));
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
    protected void onDestroy() {
        setting = db.settingDao().getAll();
        setting.setMore(true);
        db.settingDao().updateSetting(setting);
        super.onDestroy();
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


    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    private void checkNotificationsSettings() {
        // Request permissions
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.POST_NOTIFICATIONS)) {
            // User has previously denied the permission, show a rationale and request again if needed
            showSnackbar();
        } else {
            // Request the permissions directly
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.POST_NOTIFICATIONS
            }, NOTIFICATION_REQUEST_CODE);
        }
    }

    private void showSnackbar() {
        // Show a Snackbar to explain the need for permissions and prompt the user to grant them
        Snackbar.make(findViewById(android.R.id.content), getString(R.string.notification_is_required_for_this_app_to_work), Snackbar.LENGTH_INDEFINITE)
                .setAction("Grant", new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
                    @Override
                    public void onClick(View v) {
                        // Request the permissions when the "Grant" button is clicked in the Snackbar
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                                Manifest.permission.POST_NOTIFICATIONS
                        }, NOTIFICATION_REQUEST_CODE);
                    }
                })
                .show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == NOTIFICATION_REQUEST_CODE) {
            // Check if the permissions were granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, getString(R.string.notification_is_available), Toast.LENGTH_SHORT).show();
            } else {
                // Permissions are denied, handle this case (e.g., show an error message)
                Toast.makeText(this, getString(R.string.notification_permissions_are_required_for_this_app_to_work), Toast.LENGTH_LONG).show();
            }
        }
    }

    private void showFarmingPlanDialog() {
        // Inflate the dialog layout
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_farming_plan, null);

        // Access the TextView in the dialog layout
        TextView farmingPlanTextView = dialogView.findViewById(R.id.txtContentTodo);
        MaterialCheckBox cbNotShowAgain = dialogView.findViewById(R.id.cbNotShowAgain);

        //Content todolist
        List<String> content = new ArrayList<>();
        userCropsList = db.userCropDao().getAllUserCrops();
        for (UserCrops userCrop : userCropsList) {
            ArrayList<PlanStages> planStages = (ArrayList<PlanStages>) db.planStageDao().getAllPlanStageByUserCropId(userCrop.getId());
            for (PlanStages planStage : planStages) {
                if (planStage.getStartDate().isBefore(LocalDate.now().plusDays(1)) && planStage.getEndDate().isAfter(LocalDate.now())) {
                    ArrayList<PlanActivities> planActivities = (ArrayList<PlanActivities>) db.planActivityDao().getAllPlanActivitiesByPlanStageId(planStage.getId());
                    for (PlanActivities planActivity : planActivities) {
                        if (planActivity.getStartDate().isBefore(LocalDate.now().plusDays(1)) && planActivity.getEndDate().isAfter(LocalDate.now())) {
                            String reminder = "";
                            if(GetCurrentLanguage.getCurrentLanguage(MainActivity.this).equals("en")) {
                                reminder = "- " + "\"" + db.activityDao().getActivityById(planActivity.getActivityId()).getNameEn() + "\"" + getString(R.string.for_the_plan) + " \"" + userCrop.getName() + "\"";
                            } else {
                                reminder = "- " + "\"" + db.activityDao().getActivityById(planActivity.getActivityId()).getNameVi() + "\"" + getString(R.string.for_the_plan) + " \"" + userCrop.getName() + "\"";
                            }
                            content.add(reminder);
                            content.add("\n\n");
                        }
                    }
                }
            }
        }
        content.remove(content.size() - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (String cropStageString : content) {
            stringBuilder.append(cropStageString);
        }
        farmingPlanTextView.setText(stringBuilder.toString());

        //Checkbox do not show again
        cbNotShowAgain.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setting.setShowAgain(false);
                    db.settingDao().updateSetting(setting);
                } else {
                    setting.setShowAgain(true);
                    db.settingDao().updateSetting(setting);
                }
            }
        });

        // Create a MaterialAlertDialogBuilder
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this, R.style.ThemeOverlay_App_MaterialAlertDialog2);
        builder.setView(dialogView)
                .setTitle(getString(R.string.today_s_farming_plan))
                .setNegativeButton(getString(R.string.view_plan), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        replaceFragment(new MainPlanning());
                        bottomNavigationView.setSelectedItemId(R.id.planBottom);
                    }
                })
                .setPositiveButton(getString(R.string.close), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        // Show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
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
//        View avatarActionView = avatarItem.getActionView();
//        ShapeableImageView avatarImageView = avatarActionView.findViewById(R.id.miniAvatar);

//        String userId = fb.getCurrentUser().getUid();
//        String avatar = db.userDao().getAvatarById(userId);
//        avatarImageView.setImageResource(getResources().getIdentifier(avatar, "drawable", getPackageName()));

//        avatarImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Mini avatar clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

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
        replaceFragment(new MainFragment());
        userCropsList = db.userCropDao().getAllUserCrops();
        setting = db.settingDao().getAll();
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
        if (fragmentManager.getBackStackEntryCount() > 1) {
            fragmentManager.popBackStack();
            nestedScrollView.smoothScrollTo(0, 0);
        } else {
            // No remaining fragments, show exit confirmation dialog
            new MaterialAlertDialogBuilder(this, R.style.ThemeOverlay_App_MaterialAlertDialog2)
                    .setTitle(getString(R.string.exit))
                    .setMessage(getString(R.string.are_you_sure_you_want_to_exit_the_app))
                    .setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Exit the app
                            finishAffinity();
                        }
                    })
                    .setNegativeButton(getString(R.string.no), null)
                    .show();
        }
    }


}