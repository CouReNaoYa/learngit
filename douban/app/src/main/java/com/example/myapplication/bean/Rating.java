package com.example.myapplication.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.jar.Pack200;

public  class Rating implements Parcelable {
        /**
         * ax : 10
         * average : 8.4
         * details : {"1":93,"3":5978,"2":508,"5":16134,"4":20542}
         * stars : 45
         * min : 0
         */

        private int max;
        private double average;
        //            private DetailsBean details;
        private String stars;
        private int min;

    protected Rating(Parcel in) {
        max = in.readInt();
        average = in.readDouble();
        stars = in.readString();
        min = in.readInt();
    }

    public static final Creator<Rating> CREATOR = new Creator<Rating>() {
        @Override
        public Rating createFromParcel(Parcel in) {
            return new Rating(in);
        }

        @Override
        public Rating[] newArray(int size) {
            return new Rating[size];
        }
    };

    public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }
//
//            public DetailsBean getDetails() {
//                return details;
//            }
//
//            public void setDetails(DetailsBean details) {
//                this.details = details;
//            }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(max);
        dest.writeDouble(average);
        dest.writeString(stars);
        dest.writeInt(min);
    }

//            public static class DetailsBean {
//                /**
//                 * 1 : 93.0
//                 * 3 : 5978.0
//                 * 2 : 508.0
//                 * 5 : 16134.0
//                 * 4 : 20542.0
//                 */
//
//                @com.google.gson.annotations.SerializedName("1")
//                private double _$1;
//                @com.google.gson.annotations.SerializedName("3")
//                private double _$3;
//                @com.google.gson.annotations.SerializedName("2")
//                private double _$2;
//                @com.google.gson.annotations.SerializedName("5")
//                private double _$5;
//                @com.google.gson.annotations.SerializedName("4")
//                private double _$4;
//
//                public double get_$1() {
//                    return _$1;
//                }
//
//                public void set_$1(double _$1) {
//                    this._$1 = _$1;
//                }
//
//                public double get_$3() {
//                    return _$3;
//                }
//
//                public void set_$3(double _$3) {
//                    this._$3 = _$3;
//                }
//
//                public double get_$2() {
//                    return _$2;
//                }
//
//                public void set_$2(double _$2) {
//                    this._$2 = _$2;
//                }
//
//                public double get_$5() {
//                    return _$5;
//                }
//
//                public void set_$5(double _$5) {
//                    this._$5 = _$5;
//                }
//
//                public double get_$4() {
//                    return _$4;
//                }
//
//                public void set_$4(double _$4) {
//                    this._$4 = _$4;
//                }
//            }


}
