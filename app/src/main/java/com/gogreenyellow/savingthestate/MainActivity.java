package com.gogreenyellow.savingthestate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.gogreenyellow.savingthestate.autosaving.AutosavingScrollPositionActivity;
import com.gogreenyellow.savingthestate.dynamicallyreplacedfragments.DynamicallyReplacedFragmentsActivity;
import com.gogreenyellow.savingthestate.fragmentsinviewpager.FragmentsInViewPagerActivity;
import com.gogreenyellow.savingthestate.transientstate.TransientStateActivity;

/**
 * Created by wkjan on 04.02.2018.
 */

public class MainActivity extends AppCompatActivity {

    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.am_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.am_drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        NavigationView navigationView = findViewById(R.id.am_navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mn_autosaving: {
                        Intent intent = new Intent(MainActivity.this,
                                AutosavingScrollPositionActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.mn_transient_state: {
                        Intent intent = new Intent(MainActivity.this,
                                TransientStateActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.mn_dynamically_added_fragments: {
                        Intent intent = new Intent(MainActivity.this,
                                DynamicallyReplacedFragmentsActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.mn_fragments_in_viewpager: {
                        Intent intent = new Intent(MainActivity.this,
                                FragmentsInViewPagerActivity.class);
                        startActivity(intent);
                        break;
                    }
                }
                return false;
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }
}
