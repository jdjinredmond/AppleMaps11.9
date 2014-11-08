package com.omnia.applemaps119;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;


public class BaseActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks
{

    private int toolbarId = 0;

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
        Fragment fragment = new Fragment();
        switch (position)
        {
            case 0:
                fragment = new HomeFragment();
                toolbarId = R.id.toolbar_home;
                break;
            case 1:
                fragment = new CalendarFragment();
                toolbarId = R.id.toolbar_calendar;
                break;
        }
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }
}
