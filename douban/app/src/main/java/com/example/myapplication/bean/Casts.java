package com.example.myapplication.bean;

import android.os.Parcel;
import android.os.Parcelable;


public  class Casts implements Parcelable {
    /**
     * avatars : {"small":"http://img9.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557910186.94.webp","large":"http://img9.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557910186.94.webp","medium":"http://img9.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557910186.94.webp"}
     * name_en : Roman Griffin Davis
     * name : 罗曼·格里芬·戴维斯
     * alt : https://movie.douban.com/celebrity/1416281/
     * id : 1416281
     */

    private CastsAvatars avatars;
    private String name_en;
    private String name;
    private String alt;
    private String id;

    protected Casts(Parcel in) {
        name_en = in.readString();
        name = in.readString();
        alt = in.readString();
        id = in.readString();
    }

    public static final Creator<Casts> CREATOR = new Creator<Casts>() {
        @Override
        public Casts createFromParcel(Parcel in) {
            return new Casts(in);
        }

        @Override
        public Casts[] newArray(int size) {
            return new Casts[size];
        }
    };

    public CastsAvatars getAvatars() {
        return avatars;
    }

    public void setAvatars(CastsAvatars avatars) {
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

    public static class AvatarsBean {
        /**
         * small : http://img9.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557910186.94.webp
         * large : http://img9.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557910186.94.webp
         * medium : http://img9.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557910186.94.webp
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
