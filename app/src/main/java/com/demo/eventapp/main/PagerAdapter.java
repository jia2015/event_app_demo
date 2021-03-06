/**
 *
 */
package com.demo.eventapp.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * The <code>PagerAdapter</code> serves the fragments when paging.
 * @author mwho
 */
public class PagerAdapter extends FragmentPagerAdapter {
    private String[] titles = new String[]{
      "broadcasts","outgoings","groups","map","profile"
    };
    private List<Fragment> fragments;
    private ViewPager pager;
    /**
     * @param fm
     * @param fragments
     */
    public PagerAdapter(FragmentManager fm, List<Fragment> fragments,ViewPager pager) {
        super(fm);
        this.fragments = fragments;
        this.pager = pager;
    }
    /* (non-Javadoc)
     * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
     */
    @Override
    public Fragment getItem(int position) {
        pager.setCurrentItem(position);
        return this.fragments.get(position);
    }

    /* (non-Javadoc)
     * @see android.support.v4.view.PagerAdapter#getCount()
     */
    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // return your title there
        return titles[position];
    }
}