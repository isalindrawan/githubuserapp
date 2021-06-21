package com.example.mygithubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.mygithubuser.datamodel.UserAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private UserAdapter userAdapter;
    private ParseData parseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {

        listView = findViewById(R.id.user_list);
        userAdapter = new UserAdapter(this);
        listView.setAdapter(userAdapter);

        parseData = new ParseData(getApplicationContext());
        parseData.generateUser();
    }
}