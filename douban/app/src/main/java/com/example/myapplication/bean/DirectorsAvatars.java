package com.example.myapplication.bean;


import android.os.Parcel;
import android.os.Parcelable;

public class DirectorsAvatars implements Parcelable {
        /**
         * small : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1589336680.53.webp
         * large : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1589336680.53.webp
         * medium : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1589336680.53.webp
         */

        private String small;
        private String large;
        private String medium;

    protected DirectorsAvatars(Parcel in) {
        small = in.readString();
        large = in.readString();
        medium = in.readString();
    }

    public static final Creator<DirectorsAvatars> CREATOR = new Creator<DirectorsAvatars>() {
        @Override
        public DirectorsAvatars createFromParcel(Parcel in) {
            return new DirectorsAvatars(in);
        }

        @Override
        public DirectorsAvatars[] newArray(int size) {
            return new DirectorsAvatars[size];
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


