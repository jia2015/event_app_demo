package com.demo.eventapp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.eventapp.domain.BroadcastMsg;
import com.demo.eventapp.helper.LoadUserData;
import com.demo.eventapp.helper.LoadedData;

public class EventDetailActivity extends Activity {

    private ImageView profile_image;
    private TextView userName_text;
    private TextView datetime_text;
    private TextView content;
    private ImageButton btn_like;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);

        Bundle bundle = getIntent().getExtras();
        int msg_id = bundle.getInt("event_id");
        boolean liked = bundle.getBoolean("liked");
        BroadcastMsg item = LoadedData.getMsgFromList(msg_id);

        profile_image = (ImageView) findViewById(R.id.broadcast_profileImage);
        userName_text = (TextView) findViewById(R.id.broadcast_username);
        datetime_text  = (TextView) findViewById(R.id.datetime);
        content  = (TextView) findViewById(R.id.broadcast_content);
        btn_like = (ImageButton) findViewById(R.id.thumb_up);

        Resources res = getResources();
        int resourceId = res.getIdentifier(item.getProfile_image(), "drawable", getPackageName());
        profile_image.setImageResource(resourceId);
        userName_text.setText(item.getUserName());
        datetime_text.setText(item.getBroadcast_dateTime());
        content.setText(item.getBroadcast_content());
        btn_like.setSelected(liked);
    }
}
