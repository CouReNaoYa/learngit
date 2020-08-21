package com.example.myapplication.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class CastsAvatars implements Parcelable {
    /**
     * small : http://img9.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557910186.94.webp
     * large : http://img9.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557910186.94.webp
     * medium : http://img9.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557910186.94.webp
     */

    private String small;
    private String large;
    private String medium;

    protected CastsAvatars(Parcel in) {
        small = in.readString();
        large = in.readString();
        medium = in.readString();
    }

    public static final Creator<CastsAvatars> CREATOR = new Creator<CastsAvatars>() {
        @Override
        public CastsAvatars createFromParcel(Parcel in) {
            return new CastsAvatars(in);
        }

        @Override
        public CastsAvatars[] newArray(int size) {
            return new CastsAvatars[size];
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(small);
        dest.writeString(large);
        dest.writeString(medium);
    }
}
