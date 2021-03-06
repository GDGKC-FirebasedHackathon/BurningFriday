package com.gdgkorea.partispot;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private BackPressCloseHandler backPressCloseHandler;
    Toolbar toolbar;
    FloatingActionButton fab;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    android.support.v4.app.Fragment fragment;
    android.support.v4.app.FragmentTransaction ft;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //startActivity(new Intent(getApplicationContext(), SplashActivity.class));

        initView();
        initModel();
        initListener();

        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        // 첫 Fragment를 FindWord로 띄우기
        //fragment = new FindWordFragment();
        //ft.replace(R.id.content, fragment).commit();
    }

    private void initModel() {

        backPressCloseHandler = new BackPressCloseHandler(this);
        fragment = null;
        title = getString(R.string.app_name);
        ft = getSupportFragmentManager().beginTransaction();
    }

    private void initView() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        setSupportActionBar(toolbar);
    }

    private void initListener() {

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            backPressCloseHandler.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();
        ft = getSupportFragmentManager().beginTransaction();

        if (id == R.id.nav_setAlbaInfo) {
            fragment = new AlbaInfoFragment();
            title = "내 정보 관리";
            // Handle the camera action
        } else if (id == R.id.nav_setAlbaTime) {
            fragment = new SetAlbaTimeFragment();
            title = "출퇴근 관리";
        } else if (id == R.id.nav_checkAlbaTime) {
            //fragment = new VocaFragment();
            title = "아르바이스 시간 관리";
        } else if (id == R.id.nav_manageStore) {
            title = "내 점포 관리";
        } else if (id == R.id.nav_manageAlba) {
            //fragment = new SettingFragment();
            title = "아르바이생 관리";
        }

        if (fragment != null) {
            ft.replace(R.id.content, fragment);
            ft.commit();
        }

        // set the toolbar title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
