package com.example.mygithubuser.datamodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mygithubuser.R;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<User> users;

    public UserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    private class ViewHolder {

        private TextView name, username;
        private ImageView picture;

        ViewHolder(View view) {

            name = view.findViewById(R.id.name);
            username = view.findViewById(R.id.username);
            picture = view.findViewById(R.id.picture);
        }

        void bind(User user) {

            name.setText(user.getName());
            username.setText(user.getUsername());
            // picture.setImageResource(user.getAvatar());
            // Drawable res = context.getResources().getDrawable(user.getAvatar());
            picture.setImageResource(user.getAvatar());
        }
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public User getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View userView = view;
        if (userView == null)
            userView = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(userView);
        User user = (User) getItem(position);
        viewHolder.bind(user);

        return userView;
    }
}
