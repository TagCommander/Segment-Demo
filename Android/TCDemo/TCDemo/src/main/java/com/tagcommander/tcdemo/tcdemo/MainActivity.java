package com.tagcommander.tcdemo.tcdemo;

import android.Manifest;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.tagcommander.lib.segment.TCSegment;

import java.util.List;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener
{
    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;
    Double latitude = 0.0;
    Double longitude = 0.0;
    SegmentFragment segmentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the action bar.
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the app.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
        {
            @Override
            public void onPageSelected(int position)
            {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        new SegmentExample().initializeSegmentation(this);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); ++i)
        {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(actionBar.newTab().setText(mSectionsPagerAdapter.getPageTitle(i)).setTabListener(this));
        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void finishActivity(int requestCode)
    {
        super.finishActivity(requestCode);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
    {
        // When the given tab is selected, switch to the corresponding page in the ViewPager.
        Log.d("DEBUG", "onTabSelected: " + tab.getText());

        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
    {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
    {
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter
    {
        public SectionsPagerAdapter(FragmentManager fm) { super(fm); }

        @Override
        public Fragment getItem(int position)
        {
            // getItem is called to instantiate the fragment for the given page.
            Fragment fragment;

            if (position == 1)
            {
                fragment = new MapFragment();
            }
            else if (position == 0)
            {
                fragment = new RestaurantListFragment();
            }
            else
            {
                segmentFragment = new SegmentFragment();
                fragment = segmentFragment;
            }

            return fragment;
        }

        @Override
        public int getCount() { return 3; }

        @Override
        public CharSequence getPageTitle(int position)
        {
            switch (position)
            {
                case 0:
                    return getString(R.string.title_restaurant_list);
                case 1:
                    return getString(R.string.title_map);
                case 2:
                    return getString(R.string.title_segment);
                case 3:
                    return getString(R.string.title_settings);
            }
            return null;
        }
    }

    @Override
    public void onResume()
    {
        Log.d("DEBUG", "resume of MainActivity");
        super.onResume();
    }

    @Override
    public void onStart() {
        Log.e("DEBUG", "onEnterForeground");
        super.onStart();
    }

    @Override
    protected void onStop()
    {
        Log.e("DEBUG", "onExitForeground");
        super.onStop();
    }

    @Override
    public void onPause()
    {
        Log.d("DEBUG", "OnPause of MainActivity");
        super.onPause();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults)
    {
        switch (requestCode)
        {
            case 1:
            {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                }
                else
                {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    /**
     * Send the content of the kTCNotification_SegmentAvailable notification containing the
     * segment fetched to the Segment fragment to display them.
     * @param segment the fragment list as a string.
     */
    public void printSegment(String segment)
    {
        segmentFragment.displaySegment(segment);
    }

    /**
     * Button callback method to fetch segments
     * @param view useless param.
     */
    public void fetchSegments(View view)
    {
        TCSegment.getInstance().fetchSegments();
    }
}