package com.example.akashravi.vriksha;

//import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
//import android.app.Fragment;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.support.v7.widget.Toolbar;

import com.example.akashravi.vriksha.db.govsh;
import com.google.firebase.auth.FirebaseAuth;


public class Home1 extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
    private Toolbar mActionBarToolbar;
    private MenuFragment menuFragment;
    private AccountFragment accountFragment;
    private webhomeFragment webhomeFragment;
    private WebView mWebview ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);

        mMainFrame = (FrameLayout) findViewById(R.id.frame_main);
        mMainNav = (BottomNavigationView) findViewById(R.id.nav_main);

/*
        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        //setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("Hello! name");
*/

/*        getSupportActionBar().setTitle("Hello world App");
*/


        menuFragment = new MenuFragment();
        webhomeFragment = new webhomeFragment();
        accountFragment = new AccountFragment();

        setFragment(webhomeFragment);

        /*
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(menuFragment);

                        return true;

                    case R.id.nav_alert:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(webhomeFragment);
                        return true;

                    case R.id.nav_acc:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(accountFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });
        */

        mMainNav.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        //mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        //mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(menuFragment);
                       // return true;
                        break;

                    case R.id.nav_dash:
                        //mMainNav.setItemBackgroundResource(R.color.colorAccent);
                       // WebView browser = (WebView) findViewById(R.id.home_webview);
                        //browser.loadUrl("http://techtocore.github.io/test2.html");

                        setFragment(webhomeFragment);
                       // return true;
                        break;

                    case R.id.nav_acc:
                        //mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        //mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(accountFragment);

                       // return true;
                        break;
                }
                //return false;
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_main,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    public void onClick1(View view) {
        Intent intent= new Intent(getApplicationContext(),Buyer_menu.class);
        startActivity(intent);
    }
    public void on_sell(View view) {
        Intent intent= new Intent(getApplicationContext(),Seller.class);
        startActivity(intent);
    }
    public void on_log(View view)
    {
        Intent intent= new Intent(getApplicationContext(),Transporter.class);
        startActivity(intent);
    }

    public void on_warehouse(View view)
    {
        Intent intent= new Intent(getApplicationContext(),Storage_space.class);
        startActivity(intent);
    }

    public void on_predict(View view)
    {
        Intent intent= new Intent(getApplicationContext(),predict.class);
        startActivity(intent);
    }

    public void log_out(View view)
    {
        finish();
        Intent intent= new Intent(getApplicationContext(),login.class);
        startActivity(intent);
        FirebaseAuth.getInstance().signOut();
    }

    public void todo(View view)
    {
        Intent intent= new Intent(getApplicationContext(),TodoActivity.class);
        startActivity(intent);
    }

    public void reset_pw(View view) {
        Intent intent= new Intent(getApplicationContext(),ResetPasswordActivity.class);
        startActivity(intent);
    }

    public void on_notif(View view) {
        Intent intent= new Intent(getApplicationContext(),view_notifications.class);
        startActivity(intent);
    }
    public void schemes(View view)
    {
        Intent intent= new Intent(getApplicationContext(),govsh.class);
        startActivity(intent);
    }
    public void community(View view)
    {
        Intent intent= new Intent(getApplicationContext(),Community.class);
        startActivity(intent);
    }
}
