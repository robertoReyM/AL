package com.smartplace.ahorrolibre.main;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;

import com.smartplace.ahorrolibre.Constants;
import com.smartplace.ahorrolibre.R;
import com.smartplace.ahorrolibre.account.AccountFragment;
import com.smartplace.ahorrolibre.friends.FriendsFragment;
import com.smartplace.ahorrolibre.history.HistoryFragment;
import com.smartplace.ahorrolibre.savings.SavingsFragment;

public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks,OnFragmentInteractionListener {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;


    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));


    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();

        switch (position) {
            case Constants.SECTION_MY_SAVINGS:
                mCurrentFragment = SavingsFragment.newInstance(position);
                break;
            case Constants.SECTION_MY_FRIENDS:
                mCurrentFragment = FriendsFragment.newInstance(position);
                break;
            case Constants.SECTION_MY_HISTORY:
                mCurrentFragment = HistoryFragment.newInstance(position);
                break;
            case Constants.SECTION_ACCOUNT:
                mCurrentFragment = AccountFragment.newInstance(position);
                break;
        }

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.container, mCurrentFragment)
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case Constants.SECTION_MY_SAVINGS:
                mTitle = getString(R.string.section_my_savings);
                break;
            case Constants.SECTION_MY_FRIENDS:
                mTitle = getString(R.string.section_my_friends);
                break;
            case Constants.SECTION_MY_HISTORY:
                mTitle = getString(R.string.section_my_history);
                break;
            case Constants.SECTION_ACCOUNT:
                mTitle = getString(R.string.section_account);
                break;

        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentInteraction(String data) {

    }
}
