package com.yoox.a20190722_cavallaro_yoox.Activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.yoox.a20190722_cavallaro_yoox.Model.Search;
import com.yoox.a20190722_cavallaro_yoox.Persistence.Communicator;
import com.yoox.a20190722_cavallaro_yoox.R;
import com.yoox.a20190722_cavallaro_yoox.Fragment.FragmentHome;
import com.yoox.a20190722_cavallaro_yoox.ViewModel.ListAdapterItem;
import com.yoox.a20190722_cavallaro_yoox.ViewModel.ModelItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);

        loadFragment(new FragmentHome());


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sort_menu){
            Intent i = new Intent(MainActivity.this, NavActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
