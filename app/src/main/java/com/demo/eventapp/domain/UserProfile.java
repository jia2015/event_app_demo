package com.demo.eventapp.domain;

/**
 * Created by mrli on 3/22/2017.
 */

public class UserProfile {
    private int id;
    private String name;
    private String profile_image;
    private String gender;
    private int followersCount;
    private int followingCount;

    public UserProfile(int id, String name,String profile_image, String gender, int followersCount, int followingCount) {
        this.id = id;
        this.name = name;
        this.profile_image = profile_image;
        this.gender = gender;
        this.followersCount = followersCount;
        this.followingCount = followingCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(int followingCount) {
        this.followingCount = followingCount;
    }


}
