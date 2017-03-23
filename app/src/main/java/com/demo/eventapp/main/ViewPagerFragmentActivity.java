package com.demo.eventapp.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.demo.eventapp.R;
import com.demo.eventapp.broadcast.BroadcastFragment;
import com.demo.eventapp.groups.Tab2Fragment;
import com.demo.eventapp.map.Tab3Fragment;
import com.demo.eventapp.outgoings.Tab1Fragment;

import java.util.List;
import java.util.Vector;


/**
 * The <code>ViewPagerFragmentActivity</code> class is the fragment activity hosting the ViewPager
 * @author mwho
 */
public class ViewPagerFragmentActivity extends FragmentActivity{
    /** maintains the pager adapter*/
    private PagerAdapter mPagerAdapter;
    /* (non-Javadoc)
     * @see android.support.v4.app.FragmentActivity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.viewpager_layout);
        //initialsie the pager
        this.initialisePaging();
    }

    private void setTab(final ViewPager viewPager1){

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager1,true);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     * Initialise the fragments to be paged
     */
    private void initialisePaging() {

        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, BroadcastFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, Tab1Fragment.class.getName()));
        //fragments.add(Fragment.instantiate(this, Tab2Fragment.class.getName()));
        //fragments.add(Fragment.instantiate(this, Tab3Fragment.class.getName()));

        ViewPager pager = (ViewPager)super.findViewById(R.id.viewpager);
        this.mPagerAdapter  = new PagerAdapter(super.getSupportFragmentManager(), fragments, pager);
        pager.setAdapter(this.mPagerAdapter);
        setTab(pager);
    }


}