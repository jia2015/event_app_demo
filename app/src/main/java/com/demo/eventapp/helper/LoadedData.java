package com.demo.eventapp.helper;

import com.demo.eventapp.domain.BroadcastMsg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadedData {
    static public List<BroadcastMsg> broadcastMsg = new ArrayList<>(Arrays.asList(
            new BroadcastMsg(0, 0, "I am a basketball superstar, wanna play ball together?",
            "2 hours ago",
            "Kevin Garnett",
            "profile","M"),
            new BroadcastMsg(1, 1, "i am miss hong kong, i am 25 years old" +
                             ", i want to visit new york,where can i go, i am boring, very very boring, new to this nice app",
                             "1 hours ago",
                             "Lai ik",
                             "pic1","F"),
            new BroadcastMsg(2,2, "i want to go for a party",
                                     "1 hours ago",
                                     "wong lee",
                                     "pic2","F"),
            new BroadcastMsg(3, 3, "i want to walk around...",
                    "30 mins ago",
                    "kevin wang",
                    "pic3","M"),
            new BroadcastMsg(4, 4, "What is 34th street...",
                    "30 mins ago",
                    "jack wang",
                    "pic4","M"),
            new BroadcastMsg(5, 5, "Cool Day",
                    "30 mins ago",
                    "mike wang",
                    "pic5","F"),
            new BroadcastMsg(6, 6, "want to enjoy the sunny day.",
                    "30 mins ago",
                    "john wang",
                    "pic6","F")));

    public static BroadcastMsg getMsgFromList(int id) {
        for(BroadcastMsg cur : broadcastMsg){
            if(cur.getMsg_id() == id){
                return cur;
            }
        }
        return null;
    }

    static public List<BroadcastMsg> getPopularList(){
        List<BroadcastMsg> rt = new ArrayList<>();
        for(BroadcastMsg cur : broadcastMsg){
            if(cur.getGender().equals("F")){
                rt.add(cur);
            }
        }
        return rt;
    }

    static public List<BroadcastMsg> getMyList(){
        List<BroadcastMsg> rt = new ArrayList<>();
        for(BroadcastMsg cur : broadcastMsg){
            if(cur.getUserName().equals("lee")){
                rt.add(cur);
            }
        }
        return rt;
    }
}
