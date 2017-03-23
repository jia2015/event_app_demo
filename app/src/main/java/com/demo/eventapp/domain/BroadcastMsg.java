package com.demo.eventapp.domain;

/**
 * Created by xu_s on 3/16/17.
 */

public class BroadcastMsg {

    private int msg_id;
    private int user_id;
    private String broadcast_content;
    private String broadcast_dateTime;
    private String userName;
    private String profile_image;
    private String gender;


    public BroadcastMsg(int msg_id, int user_id, String broadcast_content, String broadcast_dateTime, String userName, String profile_image,String gender) {
        this.msg_id = msg_id;
        this.user_id = user_id;
        this.broadcast_content = broadcast_content;
        this.broadcast_dateTime = broadcast_dateTime;
        this.userName = userName;
        this.profile_image = profile_image;
        this.gender = gender;
    }

    public String getBroadcast_content() {
        return broadcast_content;
    }

    public void setBroadcast_content(String broadcast_content) {
        this.broadcast_content = broadcast_content;
    }

    public String getBroadcast_dateTime() {
        return broadcast_dateTime;
    }

    public void setBroadcast_dateTime(String broadcast_dateTime) {
        this.broadcast_dateTime = broadcast_dateTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(int msg_id) {
        this.msg_id = msg_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

}
