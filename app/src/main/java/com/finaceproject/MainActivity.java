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
import android.widget.Button;
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

import com.finaceproject.fragment.AbstractTabFragment;
import com.finaceproject.fragment.AddButtonFragment;
import com.finaceproject.fragment.AddCostsFragment;
import com.finaceproject.fragment.AddIncomesFragment;
import com.finaceproject.fragment.BillsFragment;
import com.finaceproject.fragment.CurrencyFragment;
import com.finaceproject.fragment.DiagramFragment;
import com.finaceproject.fragment.HomeFragment;
import com.finaceproject.fragment.LogoutFragment;
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
    private ActionBarDrawerToggle drawerToggle;
    private Toolbar toolbar;
    private FragmentManager fragmentManager;
    private AbstractTabFragment addIncomesFragment, addCostsFragment, homeFragment, addButtonFragment;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        addButtonFragment = new AddButtonFragment();
        addCostsFragment = new AddCostsFragment();
        addIncomesFragment = new AddIncomesFragment();
        homeFragment = new HomeFragment();

        initToolBar();
        initNavigationView();

        setSupportActionBar(toolbar);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.home) {
                replaceFragment(homeFragment);
                toolbar.setTitle(R.string.home);
                return true;
            } else if (item.getItemId() == R.id.diagram) {
                replaceFragment(new DiagramFragment());
                toolbar.setTitle(R.string.diagrams);
                return true;
            } else if (item.getItemId() == R.id.reports) {
                replaceFragment(new ReportsFragment());
                toolbar.setTitle(R.string.reports);
                return true;
            } else if (item.getItemId() == R.id.profile) {
                replaceFragment(new ProfileFragment());
                toolbar.setTitle(R.string.profile);
                return true;
            }
            return false;
        });

        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, homeFragment).commit();
            navigationView.setCheckedItem(R.id.home);
        }
        replaceFragment(homeFragment);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                showBottomDialog();
                replaceFragment(addButtonFragment);
                toolbar.setTitle(R.string.add);
            }
        });
    }

    private void initToolBar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.home);
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
                    toolbar.setTitle(R.string.bills);
                    Toast.makeText(MainActivity.this, "You clicked Bills", Toast.LENGTH_SHORT).show();
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
                } else if (item.getItemId() == R.id.logout) {
                    replaceFragment(new LogoutFragment());
                }
                return true;
            }
        });

    }

    private void showBottomDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fragment_add_button);

        Button btnAddCosts = dialog.findViewById(R.id.costs_btn);
        Button btnAddIncomes = dialog.findViewById(R.id.income_btn);
//        FloatingActionButton cancelButton = dialog.findViewById(R.id.back_button_add);

        initFragmentTransaction(addCostsFragment);

        btnAddCosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initFragmentTransaction(addCostsFragment);
//                replaceFragment(new AddCostsFragment());
            }
        });
        btnAddIncomes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initFragmentTransaction(addIncomesFragment);
//                replaceFragment(new AddIncomesFragment());
            }
        });
//        cancelButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });

        dialog.show();
        Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }


    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void initFragmentTransaction(AbstractTabFragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.addToBackStack(null);
        ft.commit();
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