package com.demo.eventapp.broadcast;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.demo.eventapp.EventDetailActivity;
import com.demo.eventapp.R;
import com.demo.eventapp.domain.BroadcastMsg;
import com.demo.eventapp.profile.ProfileActivity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xu_s on 3/16/17.
 */

public class BroadCastMsgsAdapter extends RecyclerView.Adapter<BroadCastMsgsAdapter.ViewHolder>{
    private List<BroadcastMsg> broadcastMsg;

    public BroadCastMsgsAdapter(List<BroadcastMsg> broadcastMsg){
        this.broadcastMsg = broadcastMsg;
    }

    public void updateList(List<BroadcastMsg> broadcastMsg){
        this.broadcastMsg = broadcastMsg;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private View cardView;

        protected ImageView profile_image;
        protected TextView userName_text;
        protected TextView datetime_text;
        protected TextView content;
        protected ImageButton btn_like;

        public ViewHolder(View v){
            super(v);
            cardView = v;
            profile_image = (ImageView) cardView.findViewById(R.id.broadcast_profileImage);
            userName_text = (TextView) cardView.findViewById(R.id.broadcast_username);
            datetime_text  = (TextView) cardView.findViewById(R.id.datetime);
            content  = (TextView) cardView.findViewById(R.id.broadcast_content);
            btn_like = (ImageButton) cardView.findViewById(R.id.thumb_up);

            btn_like.setOnClickListener(this);
            content.setOnClickListener(this);
            profile_image.setOnClickListener(this);
            cardView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.broadcast_profileImage:
                    launchProfile(view);
                    break;
                case R.id.broadcast_content:
                    launchEventDetail(view);
                    break;
                case R.id.thumb_up:
                    btn_like.setSelected(!btn_like.isSelected());
                    break;
            }
        }

        private void launchProfile (View view) {

            Intent intent = new Intent(view.getContext(), ProfileActivity.class);
            intent.putExtra("user_id", (int) view.getTag());
            view.getContext().startActivity(intent);
        }

        private void launchEventDetail(View view) {
            //BroadcastMsg item = (BroadcastMsg) view.getTag();
            Intent intent = new Intent(view.getContext(), EventDetailActivity.class);
            if (btn_like.isSelected()) {
                intent.putExtra("liked", true);
            }
            intent.putExtra("event_id", (int) view.getTag());
            view.getContext().startActivity(intent);
        }


    }

    @Override
    public BroadCastMsgsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View cv = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.broadcast_msg,parent,false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        View cardView = holder.cardView;

        BroadcastMsg item = broadcastMsg.get(position);

        Resources resources = cardView.getResources();
        final int resourceId = resources.getIdentifier(item.getProfile_image(), "drawable",
                cardView.getContext().getPackageName());
        holder.profile_image.setImageResource(resourceId);
        holder.userName_text.setText(item.getUserName());
        holder.datetime_text.setText(item.getBroadcast_dateTime());
        holder.content.setText(item.getBroadcast_content());

        holder.profile_image.setTag(item.getUser_id());
        holder.content.setTag(item.getMsg_id());
    }

    @Override
    public int getItemCount(){
        return broadcastMsg.size();
    }
}
