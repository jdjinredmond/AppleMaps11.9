package com.omnia.applemaps119;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import java.util.*;
import java.text.*;


public class BaseActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks
{
    private static final String STATE_LOGGED_IN = "logged_in";

    private int mToolbarId = 0;
    ActionBarFragment mFragment = new ActionBarFragment();

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        if (!PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean(STATE_LOGGED_IN, false))
        {
            startActivity(new Intent(this, LoginActivity.class));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(
                R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout)/*, mFragment.getToolbar()*/);

        findViewById(R.id.navigation_drawer).setMinimumWidth(getResources().getConfiguration().screenWidthDp - R.dimen.abc_action_bar_default_height_material);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position)
    {
        FragmentManager fragmentManager = getFragmentManager();
        switch (position)
        {
            case 0:
                mFragment = new HomeFragment();
                mToolbarId = R.id.toolbar_home;
                break;
            case 1:
                mFragment = new CalendarFragment();
                mToolbarId = R.id.toolbar_calendar;
                break;
            case 2:
                mFragment = new ClassesFragment();
                mToolbarId = R.id.toolbar_classes;
                break;
            case 3:
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putBoolean(STATE_LOGGED_IN, false).apply();
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
        mFragment.setNavigationDrawerFragment(mNavigationDrawerFragment);
        fragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
    }
}
