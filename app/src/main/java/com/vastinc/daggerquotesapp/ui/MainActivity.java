package com.vastinc.daggerquotesapp.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.bumptech.glide.RequestManager;
import com.google.android.material.navigation.NavigationView;
import com.vastinc.daggerquotesapp.BaseApplication;
import com.vastinc.daggerquotesapp.R;
import com.vastinc.daggerquotesapp.data.remote.model.Quote;
import com.vastinc.daggerquotesapp.di.main.MainComponent;
import com.vastinc.daggerquotesapp.util.Resource;
import com.vastinc.daggerquotesapp.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    DrawerLayout drawerLayout;
    public MainComponent mainComponent;

    @Inject
    MainActivityViewModel mainActivityViewModel;

    @Inject
    RequestManager requestManager;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainComponent = ((BaseApplication)getApplicationContext()).getAppComponent().mainComponent().create();
        mainComponent.inject(this);

        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        NavigationView navView = findViewById(R.id.nav_view);
        NavigationUI.setupWithNavController(navView, navController);
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);

        //observers();
        //mainActivityViewModel = ViewModelProviders.of(this,providerFactory).get(MainActivityViewModel.class);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp();
    }


}