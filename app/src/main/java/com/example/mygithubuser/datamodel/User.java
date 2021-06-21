package com.example.mygithubuser.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String username, name, company, location;
    private int repository, follower, following, avatar;

    public User(String username, String name, String company, String location, int repository, int follower, int following, int avatar) {
        this.username = username;
        this.name = name;
        this.company = company;
        this.location = location;
        this.repository = repository;
        this.follower = follower;
        this.following = following;
        this.avatar = avatar;
    }

    protected User(Parcel in) {
        username = in.readString();
        name = in.readString();
        company = in.readString();
        location = in.readString();
        repository = in.readInt();
        follower = in.readInt();
        following = in.readInt();
        avatar = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(name);
        dest.writeString(company);
        dest.writeString(location);
        dest.writeInt(repository);
        dest.writeInt(follower);
        dest.writeInt(following);
        dest.writeInt(avatar);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public int getRepository() {
        return repository;
    }

    public int getFollower() {
        return follower;
    }

    public int getFollowing() {
        return following;
    }

    public int getAvatar() {
        return avatar;
    }
}
