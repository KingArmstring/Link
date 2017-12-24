package com.armstring.linkchattingapplication.ui.view.main_view;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.armstring.linkchattingapplication.R;
import com.armstring.linkchattingapplication.ui.view.mvp_contracts.MainActivityContract;
import com.armstring.linkchattingapplication.ui.view.start_view.StartActivity;
import com.armstring.linkchattingapplication.ui.view.main_view.controllers.SectionsPagerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements MainActivityContract.MainView{

    private FirebaseAuth mAuth;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private SectionsPagerAdapter sectionsPagerAdapter;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mohammad Elsayed Chatting App");

        viewPager = (ViewPager)findViewById(R.id.viewPagerMainActivityId);
        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);
        tabLayout = (TabLayout)findViewById(R.id.mainTabLayoutId);
        tabLayout.setupWithViewPager(viewPager);//using this method requires overriding the method getPageTitle.
        mAuth = FirebaseAuth.getInstance();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.mainLogout){
            FirebaseAuth.getInstance().signOut();
            travelToStartActivity();
        }else if(item.getItemId() == R.id.allUsersId){
            Toast.makeText(MainActivity.this, "All Users", Toast.LENGTH_LONG).show();
        }else if(item.getItemId() == R.id.mainAccountSettingsId){
            Toast.makeText(MainActivity.this, "Account Settings", Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUer = mAuth.getCurrentUser();
        if(currentUer == null){
            travelToStartActivity();
        }
    }

    private void travelToStartActivity() {
        Intent startIntent = new Intent(MainActivity.this, StartActivity.class);
        startActivity(startIntent);
        finish();
    }
}
