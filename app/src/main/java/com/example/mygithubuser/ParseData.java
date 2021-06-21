package com.example.mygithubuser;

import android.content.Context;
import android.util.Log;

import com.example.mygithubuser.datamodel.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ParseData {

    private ArrayList<User> users;
    private Context context;

    public ParseData(Context context) {

        this.context = context;
        users = new ArrayList<>();
    }

    public void generateUser() {

        try {
            JSONObject jsonObject = new JSONObject(loadJSON());
            JSONArray jsonArray = jsonObject.getJSONArray("users");
            ArrayList<HashMap<String, String>> userList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> temp;

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
                        inside.getInt("avatar")
                );

                users.add(user);

                Log.d("DATA", String.valueOf(user));
            }

        } catch (JSONException e) {

            e.printStackTrace();
            Log.d("ERROR", e.getMessage());
        }
    }

    public String loadJSON() {

        String json = null;

        try {

            InputStream is = context.getAssets().open("githubuser.json");
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
}
