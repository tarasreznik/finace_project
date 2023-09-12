package com.finaceproject;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.finaceproject.fragment.BillsFragment;
import com.finaceproject.fragment.CurrencyFragment;
import com.finaceproject.fragment.DiagramFragment;
import com.finaceproject.fragment.HomeFragment;
import com.finaceproject.fragment.PaymentsFragment;
import com.finaceproject.fragment.ProfileFragment;
import com.finaceproject.fragment.RateFragment;
import com.finaceproject.fragment.ReminderFragment;
import com.finaceproject.fragment.ReportsFragment;
import com.finaceproject.fragment.SettingsFragment;
import com.finaceproject.fragment.ShareFragment;
import com.finaceproject.fragment.SupportFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    private static final int LAYOUT = R.layout.activity_main;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ViewPager viewPager;
    private ActionBarDrawerToggle drawerToggle;
    private Toolbar toolbar;
    private FragmentManager fragmentManager;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showPage() {
        viewPager.setCurrentItem(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initToolBar();
        initNavigationView();

        FloatingActionButton fab = findViewById(R.id.fab);

        setSupportActionBar(toolbar);




//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.home) {
                replaceFragment(new HomeFragment());
                return true;
            } else if (item.getItemId() == R.id.diagram) {
                replaceFragment(new DiagramFragment());
                return true;
            } else if (item.getItemId() == R.id.reports) {
                replaceFragment(new ReportsFragment());
                return true;
            } else if (item.getItemId() == R.id.profile) {
                replaceFragment(new ProfileFragment());
                return true;
            }
            return false;
        });

        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.home);
        }
        replaceFragment(new HomeFragment());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomDialog();
                Toast.makeText(MainActivity.this, "is clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initToolBar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.bills) {
                replaceFragment(new BillsFragment());
            } else if (item.getItemId() == R.id.currency) {
                replaceFragment(new CurrencyFragment());
            } else if (item.getItemId() == R.id.payments) {
                replaceFragment(new PaymentsFragment());
            } else if (item.getItemId() == R.id.reminder) {
                replaceFragment(new ReminderFragment());
            } else if (item.getItemId() == R.id.share) {
                replaceFragment(new ShareFragment());
            } else if (item.getItemId() == R.id.rate) {
                replaceFragment(new RateFragment());
            } else if (item.getItemId() == R.id.settings) {
                replaceFragment(new SettingsFragment());
            } else if (item.getItemId() == R.id.support) {
                replaceFragment(new SupportFragment());
            } else if (item.getItemId() == R.id.bills) {
                Toast.makeText(this, "You clicked " + R.string.bills, Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.currency) {
                Toast.makeText(this, "You clicked " + R.string.currency, Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.payments) {
                Toast.makeText(this, "You clicked " + R.string.payments, Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.reminder) {
                Toast.makeText(this, "You clicked " + R.string.remind, Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.share) {
                Toast.makeText(this, "You clicked " + R.string.share, Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.rate) {
                Toast.makeText(this, "You clicked " + R.string.rate, Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.settings) {
                Toast.makeText(this, "You clicked " + R.string.settings, Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.support) {
                Toast.makeText(this, "You clicked " + R.string.support, Toast.LENGTH_SHORT).show();
            }
            return true;
        });
    }

    private void initNavigationView() {
        drawerLayout = findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                if (item.getItemId() == R.id.bills) {
                    replaceFragment(new BillsFragment());
                } else if (item.getItemId() == R.id.currency) {
                    replaceFragment(new CurrencyFragment());
                } else if (item.getItemId() == R.id.payments) {
                    replaceFragment(new PaymentsFragment());
                } else if (item.getItemId() == R.id.reminder) {
                    replaceFragment(new ReminderFragment());
                } else if (item.getItemId() == R.id.share) {
                    replaceFragment(new ShareFragment());
                } else if (item.getItemId() == R.id.rate) {
                    replaceFragment(new RateFragment());
                } else if (item.getItemId() == R.id.settings) {
                    replaceFragment(new SettingsFragment());
                } else if (item.getItemId() == R.id.support) {
                    replaceFragment(new SupportFragment());
                }
                return true;
            }
        });

    }

    private void showBottomDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        LinearLayout videoLayout = dialog.findViewById(R.id.layoutVideo);
        LinearLayout shortsLayout = dialog.findViewById(R.id.layoutShorts);
        LinearLayout liveLayout = dialog.findViewById(R.id.layoutLive);
        ImageView cancelButton = dialog.findViewById(R.id.cancelButton);

        videoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Upload a Video is clicked", Toast.LENGTH_SHORT).show();

            }
        });

        shortsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Create a short is Clicked", Toast.LENGTH_SHORT).show();

            }
        });

        liveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Go live is Clicked", Toast.LENGTH_SHORT).show();

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
        Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }


    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}