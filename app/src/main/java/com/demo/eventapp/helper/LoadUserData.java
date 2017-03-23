package com.demo.eventapp.helper;

import com.demo.eventapp.domain.UserProfile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mrli on 3/22/2017.
 */

public class LoadUserData {
    public static List<UserProfile> users = new ArrayList<>(Arrays.asList(
            new UserProfile(0, "Kevin Garnett", "profile","M", 234, 453),
            new UserProfile(1, "Lai ik", "pic1","F", 224, 4533),
            new UserProfile(2, "wong lee", "pic2","F", 23234, 3453),
            new UserProfile(3, "kevin wang", "pic3","M", 5275, 4423),
            new UserProfile(4, "jack wang", "pic4","M", 2234, 45543),
            new UserProfile(5, "mike wang", "pic5","F", 25434, 45443),
            new UserProfile(6, "john wang", "pic6","F", 2434, 4533)
    ));

    public static UserProfile getUserFromList (int id) {
        for (UserProfile profile : users) {
            if (profile.getId() == id) {
                return profile;
            }
        }
        return null;
    }
}
