package com.example.mygithubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mygithubuser.datamodel.User;
import com.example.mygithubuser.datamodel.UserAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private UserAdapter userAdapter;
    private ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateUser();
        listView = findViewById(R.id.user_list);
        userAdapter = new UserAdapter(this, users);
        listView.setAdapter(userAdapter);
        userAdapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private void generateUser() {

        try {
            JSONObject jsonObject = new JSONObject(loadJSON());
            JSONArray jsonArray = jsonObject.getJSONArray("users");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject inside = jsonArray.getJSONObject(i);

                User user = new User(
                        inside.getString("username"),
                        inside.getString("name"),
                        inside.getString("company"),
                        inside.getString("location"),
                        inside.getInt("repository"),
                        inside.getInt("follower"),
                        inside.getInt("following"),
                        resID(inside.getString("avatar"))
                );

                users.add(user);

                Log.d("DATA", String.valueOf(user));
            }

        } catch (JSONException e) {

            e.printStackTrace();
            Log.d("ERROR", e.getMessage());
        }
    }

    private String loadJSON() {

        String json = null;

        try {

            InputStream is = getAssets().open("githubuser.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {

            ex.printStackTrace();
            Log.d("ERROR", ex.getMessage());
            return null;
        }

        return json;
    }

    private int resID(String url) {

        int id = getResources().getIdentifier(url, null, getPackageName()); //get image  resource
        Log.d("ID", String.valueOf(id));
        return id;
    }
}