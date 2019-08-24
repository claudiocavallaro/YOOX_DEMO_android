package com.yoox.a20190722_cavallaro_yoox.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.yoox.a20190722_cavallaro_yoox.R;
import com.yoox.a20190722_cavallaro_yoox.Fragment.FragmentHigh;
import com.yoox.a20190722_cavallaro_yoox.Fragment.FragmentLatest;
import com.yoox.a20190722_cavallaro_yoox.Fragment.FragmentLow;

public class NavActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_latest:
                    fragment = new FragmentLatest();
                    return loadFragment(fragment);
                case R.id.navigation_lowest:
                    fragment = new FragmentLow();
                    return loadFragment(fragment);
                case R.id.navigation_highest:
                    fragment = new FragmentHigh();
                    return loadFragment(fragment);
            }
            return false;
        }
    };

    private boolean loadFragment(Fragment fragment){

        if (fragment != null){

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();

            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(new FragmentLatest());
    }
}
