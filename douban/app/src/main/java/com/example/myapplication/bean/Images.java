package com.example.myapplication.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class Images implements Parcelable {
    /**
     * small : http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2614997041.webp
     * large : http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2614997041.webp
     * medium : http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2614997041.webp
     */

    private String small;
    private String large;
    private String medium;

    protected Images(Parcel in) {
        small = in.readString();
        large = in.readString();
        medium = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(small);
        dest.writeString(large);
        dest.writeString(medium);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Images> CREATOR = new Creator<Images>() {
        @Override
        public Images createFromParcel(Parcel in) {
            return new Images(in);
        }

        @Override
        public Images[] newArray(int size) {
            return new Images[size];
        }
    };

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
