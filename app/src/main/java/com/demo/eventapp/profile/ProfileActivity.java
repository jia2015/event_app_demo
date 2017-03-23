package com.demo.eventapp.profile;

import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.eventapp.R;
import com.demo.eventapp.domain.UserProfile;
import com.demo.eventapp.helper.LoadUserData;

public class ProfileActivity extends AppCompatActivity {

    //private List<UserProfile> users = LoadUserData.users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle bundle = getIntent().getExtras();
        int userId = bundle.getInt("user_id");
        UserProfile user = LoadUserData.getUserFromList(userId);

        TextView name = (TextView) findViewById(R.id.profile_username);
        TextView gender = (TextView) findViewById(R.id.profile_gender);
        TextView following = (TextView) findViewById(R.id.followingCount);
        TextView followers = (TextView) findViewById(R.id.followerCount);
        ImageView profile_image = (ImageView) findViewById(R.id.profile_image);
        Resources res = getResources();
        int resourceId = res.getIdentifier(user.getProfile_image(), "drawable", getPackageName());
        profile_image.setImageResource( resourceId );

        name.setText(user.getName());
        gender.setText(user.getGender());
        following.setText(Integer.toString(user.getFollowingCount()));
        followers.setText(Integer.toString(user.getFollowersCount()));

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpagerProfile);
        viewPager.setAdapter(new ProfilePagerAdapter(getSupportFragmentManager(),
                ProfileActivity.this));

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);



    }
}
