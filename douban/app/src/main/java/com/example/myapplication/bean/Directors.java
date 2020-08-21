package com.example.myapplication.bean;

import android.os.Parcel;
import android.os.Parcelable;

import Bean.Bean1;


public class Directors implements Parcelable {
    /**
     * avatars : {"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1589336680.53.webp","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1589336680.53.webp","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1589336680.53.webp"}
     * name_en : Taika Waititi
     * name : 塔伊加·维迪提
     * alt : https://movie.douban.com/celebrity/1076354/
     * id : 1076354
     */

    private Bean1.SubjectsBean.DirectorsBean.AvatarsBeanX avatars;
    private String name_en;
    private String name;
    private String alt;
    private String id;

    protected Directors(Parcel in) {
        name_en = in.readString();
        name = in.readString();
        alt = in.readString();
        id = in.readString();
    }

    public static final Creator<Directors> CREATOR = new Creator<Directors>() {
        @Override
        public Directors createFromParcel(Parcel in) {
            return new Directors(in);
        }

        @Override
        public Directors[] newArray(int size) {
            return new Directors[size];
        }
    };

    public Bean1.SubjectsBean.DirectorsBean.AvatarsBeanX getAvatars() {
        return avatars;
    }

    public void setAvatars(Bean1.SubjectsBean.DirectorsBean.AvatarsBeanX avatars) {
        this.avatars = avatars;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name_en);
        dest.writeString(name);
        dest.writeString(alt);
        dest.writeString(id);
    }

    public static class AvatarsBeanX {
        /**
         * small : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1589336680.53.webp
         * large : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1589336680.53.webp
         * medium : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1589336680.53.webp
         */

        private String small;
        private String large;
        private String medium;

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
}