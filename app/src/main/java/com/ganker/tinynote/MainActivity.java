package com.ganker.tinynote;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ganker.tinynote.frament.MainActivityFragment;
import com.ganker.tinynote.frament.NoteFragment;

public class MainActivity extends AppCompatActivity implements MainActivityFragment.OnFragmentInteractionListener,NoteFragment.OnFragmentInteractionListener{
    private final String TAG = "MainActivity";

    private DrawerLayout mdrawerlayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.notes_title);
        setSupportActionBar(toolbar);
        //给左上角加上一个返回图标
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //设定左上角图标可以点击
        getSupportActionBar().setHomeButtonEnabled(true);

        mdrawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout_left);
        //菜单出现和消失时绑定一些事件,点击按钮，出现/关闭菜单
        mDrawerToggle = new ActionBarDrawerToggle(this, mdrawerlayout, toolbar,R.string.open_menu,R.string.close_menu){
            @Override
            public void onDrawerOpened(View drawerview) {
                super.onDrawerOpened(drawerview);
                invalidateOptionsMenu();
            }
            @Override
            public void onDrawerClosed(View drawerview) {
                super.onDrawerClosed(drawerview);
                invalidateOptionsMenu();
            }

        };
        mDrawerToggle.syncState();
        //绑定菜单事件
        mdrawerlayout.setDrawerListener(mDrawerToggle);

        if(savedInstanceState == null) {
            Log.d(TAG, "call fragment");
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainActivityFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_setting) {
            Snackbar.make(findViewById(R.id.toolbar), "default seting", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new NoteFragment())
                .commit();
    }
}
