package com.omnia.applemaps119;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;


public class BaseActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks
{

    private int mToolbarId = 0;

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(
                R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        findViewById(R.id.navigation_drawer).setMinimumWidth(getResources().getConfiguration().screenWidthDp - R.dimen.abc_action_bar_default_height_material);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position)
    {
        FragmentManager fragmentManager = getFragmentManager();
        ActionBarFragment fragment = new ActionBarFragment();
        switch (position)
        {
            case 0:
                fragment = new HomeFragment();
                mToolbarId = R.id.toolbar_home;
                break;
            case 1:
                fragment = new CalendarFragment();
                mToolbarId = R.id.toolbar_calendar;
                break;
        }
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }
}
