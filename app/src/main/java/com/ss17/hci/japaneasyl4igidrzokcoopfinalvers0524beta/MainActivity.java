package com.ss17.hci.japaneasyl4igidrzokcoopfinalvers0524beta;

import android.content.SharedPreferences;
import android.graphics.Path;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String PREFS_NAME = "japaneasyPrefs";

    public static final CharacterContents allChars = new CharacterContents();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){

            public void onDrawerSlide(View drawerView, float slideOffset) {
                if(slideOffset != 0.0) {
                    Log.i("Mainacitvity", "onDrawerSlide(); offset != 0 "+String.valueOf(slideOffset));
                    SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
                    String name = settings.getString(SettingsFrag.USER_NAME, null);
                    if(name == null)
                        name = "Name";
                    TextView nameText = (TextView) findViewById(R.id.user_name);
                    nameText.setText(name);

                    ImageView profilePic = (ImageView) findViewById(R.id.currentProfilPic);
                    int picId = settings.getInt(SettingsFrag.PIC_ID, SettingsFrag.DEFAULT_PIC_ID);
                    switch (picId) {
                        case 1: profilePic.setImageResource(R.drawable.pic_1); break;
                        case 2: profilePic.setImageResource(R.drawable.pic_2); break;
                        case 3: profilePic.setImageResource(R.drawable.pic_3); break;
                        case 4: profilePic.setImageResource(R.drawable.pic_4); break;
                        case 5: profilePic.setImageResource(R.drawable.pic_5); break;
                        case 6: profilePic.setImageResource(R.drawable.pic_6); break;
                        case 7: profilePic.setImageResource(R.drawable.pic_7); break;
                        case 8: profilePic.setImageResource(R.drawable.pic_8); break;
                        case 9: profilePic.setImageResource(R.drawable.pic_9); break;
                        default: profilePic.setImageResource(R.drawable.pic_1); break;
                    }
                } else {
                    Log.i("Mainacitvity", "onDrawerSlide(); offset == 0");
                }
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setTitle("Nearby");
        Homefragment homefragment=new Homefragment();
        FragmentManager fragmentManager= getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment, homefragment).commit();



    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_wörterbuch) {

            setTitle("Wörterbuch");
            DictionaryFrag dictionaryFrag=new DictionaryFrag();
            FragmentManager fragmentManager= getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, dictionaryFrag).commit();


        } else if (id == R.id.nav_lernen) {

            setTitle("Lernen");
            LearnFrag learnFrag=new LearnFrag();
            FragmentManager fragmentManager= getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, learnFrag).commit();

        } else if (id == R.id.nav_nearby) {

            setTitle("Nearby");
            Homefragment homefragment=new Homefragment();
            FragmentManager fragmentManager= getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, homefragment).commit();

        } else if (id == R.id.nav_einstellungen) {

            setTitle("Einstellungen");
            SettingsFrag settingsFrag=new SettingsFrag();
            FragmentManager fragmentManager= getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, settingsFrag).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
