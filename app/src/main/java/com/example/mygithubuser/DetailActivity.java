package com.example.mygithubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mygithubuser.datamodel.User;

public class DetailActivity extends AppCompatActivity {

    private User user;
    private Intent intent;
    private TextView name, username, following, follower, location, company, repository;
    private ImageView avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();
        intent = getIntent();
        this.user = intent.getParcelableExtra("user");
        Log.d("USER", String.valueOf(user.getFollowing()));
        showData();
    }

    @SuppressLint({"CutPasteId", "WrongViewCast"})
    private void init() {

        avatar = findViewById(R.id.avatar);
        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        following = findViewById(R.id.following_count);
        follower = findViewById(R.id.follower_count);
        location = findViewById(R.id.location);
        company = findViewById(R.id.company);
        repository = findViewById(R.id.repo_count);
    }

    private void showData() {

        avatar.setImageResource(user.getAvatar());
        name.setText(user.getName());
        username.setText(user.getUsername());
        following.setText(String.valueOf(user.getFollowing()));
        follower.setText(String.valueOf(user.getFollower()));
        location.setText(user.getLocation());
        company.setText(user.getCompany());
        repository.setText(String.valueOf(user.getRepository()));
    }
}