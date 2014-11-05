package com.omnia.applemaps119;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;


public class BaseActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks
{

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /*
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle = "oops";

    public void restoreActionBar()
    {
        ActionBar actionBar = getActionBar();
        actionBar.setTitle(mTitle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        //findViewById(R.id.navigation_drawer).setMinimumWidth(getResources().getConfiguration().screenWidthDp - R.dimen.abc_action_bar_default_height_material);

        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(
                R.id.navigation_drawer);
        //mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position)
    {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = new Fragment();
        switch (position)
        {
            case 0:
                mTitle = getString(R.string.title_home);
                fragment = new HomeFragment();
                break;
            case 1:
                mTitle = getString(R.string.title_calendar);
                fragment = new CalendarFragment();
                break;
        }
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        ActionBar actionBar = getActionBar();
        actionBar.setTitle(mTitle);
    }
}
