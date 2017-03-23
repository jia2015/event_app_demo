package com.demo.eventapp.profile;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.demo.eventapp.OneFragment;

/**
 * Created by mrli on 3/17/2017.
 */

public class ProfilePagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] { "Posts", "Comments", "Tab3" };
    private Context context;

    public ProfilePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return OneFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}
