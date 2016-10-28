package com.navigationdrawer;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        private NavigationView navigationView;
        private Fragment fragment = null;
        private boolean finalize = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

          fragment = new FragmentCamera();
          getSupportFragmentManager().beginTransaction()
                  .replace(R.id.content_main,fragment)
                  .commit();





    /*    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
       // navigationView.getMenu().getItem(0).setChecked(true);
        //onNavigationItemSelected (navigationView.getMenu().getItem (0));
        getSupportActionBar().setTitle("Import");


    }
   /* @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState,"myfragment",fragment);
    }
    @Override
    public void onRestoreInstanceState(Bundle inState){
        super.onRestoreInstanceState(inState);
        fragment = getSupportFragmentManager().getFragment(inState,"myfragment");

    }*/

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
             if(finalize==true){
                finish();
            }else {
                 getSupportActionBar().setTitle("Import");
                 // navigationView.getMenu().getItem(0).setChecked(true);
                 super.onBackPressed();
             }
        }
        Log.i("finalize", String.valueOf(finalize));


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        boolean FragmentTransaction = false;
        finalize = false;
       // Fragment fragment = null;


        if (id == R.id.nav_camera) {
            fragment = new FragmentCamera();
            FragmentTransaction = true;
          ///  navigationView.getMenu().getItem(0).setChecked(true);
               finalize = true;

        } else if (id == R.id.nav_gallery) {
            fragment = new FragmentGallery();
            FragmentTransaction = true;
           // navigationView.getMenu().getItem(1).setChecked(true);


        } else if (id == R.id.nav_slideshow) {
            fragment = new FragmentSlideshow();
            FragmentTransaction = true;
            // navigationView.getMenu().getItem(2).setChecked(true);

        } else if (id == R.id.nav_manage) {
            fragment = new FragmentTools();
            FragmentTransaction = true;
            // navigationView.getMenu().getItem(3).setChecked(true);

        } else if (id == R.id.nav_share) {
            fragment = new FragmentShare();
            FragmentTransaction = true;
            // navigationView.getMenu().getItem(4).setChecked(true);

        } else if (id == R.id.nav_send) {
            fragment = new FragmentSend();
            FragmentTransaction = true;
            // navigationView.getMenu().getItem(5).setChecked(true);

        }

        if (FragmentTransaction){
           /* getSupportFragmentManager().popBackStack("FragmentCamera", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_main, fragment)
                     .addToBackStack("FragmentCamera")
                    .commit(); esto sirve para ir a un fragment específico*/

            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_main, fragment)
                    .addToBackStack(null)
                    .commit();

            item.setCheckable(true);
            getSupportActionBar().setTitle(item.getTitle());


            Log.i("finalize", String.valueOf(finalize));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
