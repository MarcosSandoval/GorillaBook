package com.gorilla.gorillabook.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Feed implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Feed createFromParcel(Parcel in) {
            return new Feed(in);
        }

        public Feed[] newArray(int size) {
            return new Feed[size];
        }
    };

    private int id;
    @SerializedName("first_name")
    private String firstName;

    @SerializedName("post_body")
    private String body;

    @SerializedName("unix_timestamp")
    private int postDate;

    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getPostDate() {
        return postDate;
    }

    public void setPostDate(int postDate) {
        this.postDate = postDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Feed(Parcel parcel) {
        this.id = parcel.readInt();
        this.firstName = parcel.readString();
        this.body = parcel.readString();
        this.postDate = parcel.readInt();
        this.image = parcel.readString();
    }

    public Feed(int id, String firstName, String body, int postDate, String image) {
        this.id = id;
        this.firstName = firstName;
        this.body = body;
        this.postDate = postDate;
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.firstName);
        parcel.writeString(this.body);
        parcel.writeInt(this.postDate);
        parcel.writeString(this.image);
    }
}


