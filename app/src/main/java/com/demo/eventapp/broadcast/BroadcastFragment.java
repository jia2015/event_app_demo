package com.demo.eventapp.broadcast;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.eventapp.R;
import com.demo.eventapp.domain.BroadcastMsg;
import com.demo.eventapp.helper.LoadedData;
import com.demo.eventapp.profile.ProfileActivity;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class BroadcastFragment extends Fragment {
    private List<BroadcastMsg> broadcastMsg = LoadedData.broadcastMsg;
    private BroadCastMsgsAdapter adapter;
    private RecyclerView recyclerView;
    private int currentMenu;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rt = inflater.inflate(R.layout.fragment_broadcast, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        recyclerView = (RecyclerView) rt.findViewById(R.id.broadcast_msgs_view);
        recyclerView.setHasFixedSize(true);
        adapter = new BroadCastMsgsAdapter(broadcastMsg);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        EditText editText = (EditText) rt.findViewById(R.id.edit_post);
        currentMenu = R.id.chat_latest;
        Log.d("STATE","Hello, this is Shao");
        OnFocusChangeListioner ofcListener = new OnFocusChangeListioner();
        editText.setOnFocusChangeListener(ofcListener);

        Button chat_latest = (Button) rt.findViewById(R.id.chat_latest);
        Button chat_popular = (Button) rt.findViewById(R.id.chat_popular);
        Button chat_my = (Button) rt.findViewById(R.id.chat_my);
        ImageButton post_msg = (ImageButton) rt.findViewById(R.id.post_msg);

        chat_latest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                chatMenuSwitch(v);
            }
        });
        chat_popular.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                chatMenuSwitch(v);
            }
        });
        chat_my.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                chatMenuSwitch(v);
            }
        });
        post_msg.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onPost(v);
            }
        });

        return rt;
    }

    public void onPost(View view){
        Log.d("STATE","Hello, this is lalee message");
        EditText content = (EditText) getView().findViewById(R.id.edit_post);
        if(content.getText().toString() == null || content.getText().toString().isEmpty()) return;
        broadcastMsg.add(0,new BroadcastMsg(8, 8, content.getText().toString(),
                "Now",
                "lee",
                "lalee","M"));
        if(currentMenu == R.id.chat_latest){
            adapter.notifyItemInserted(0);
            recyclerView.scrollToPosition(0);
        }else if(currentMenu == R.id.chat_my){
            adapter.updateList(LoadedData.getMyList());
        }else{
            adapter.updateList(LoadedData.getPopularList());
        }

        if (getActivity().getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        CharSequence text = "Message sent";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getActivity().getBaseContext(), text, duration);
        toast.show();
        content.setText(null);
    }

    public void chatMenuSwitch(View view){
        if(currentMenu == view.getId()) return;
        currentMenu = view.getId();
        Button latest = (Button) getView().findViewById(R.id.chat_latest);
        Button my = (Button) getView().findViewById(R.id.chat_my);
        Button popular = (Button) getView().findViewById(R.id.chat_popular);
        popular.setTypeface(null, Typeface.NORMAL);
        latest.setTypeface(null, Typeface.NORMAL);
        my.setTypeface(null, Typeface.NORMAL);
        switch(view.getId()) {
            case R.id.chat_latest:
                latest.setTypeface(null, Typeface.BOLD);
                adapter.updateList(LoadedData.broadcastMsg);
                break;
            case R.id.chat_my:
                my.setTypeface(null, Typeface.BOLD);
                adapter.updateList(LoadedData.getMyList());
                break;
            case R.id.chat_popular:
                adapter.updateList(LoadedData.getPopularList());
                popular.setTypeface(null, Typeface.BOLD);
                break;
        }
        adapter.notifyDataSetChanged();
    }

    private class OnFocusChangeListioner implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            Log.d("STATE","Hello, this is Shao");
            if(v.getId() == R.id.edit_post && !hasFocus) {
                InputMethodManager imm =  (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        }
    }


}
