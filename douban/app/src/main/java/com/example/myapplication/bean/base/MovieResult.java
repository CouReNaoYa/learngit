package com.example.myapplication.bean.base;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.myapplication.bean.Movie;
import com.example.myapplication.bean.base.BaseHttpResult;

public class MovieResult extends BaseHttpResult<Movie> implements Parcelable {
    public MovieResult(Parcel in) {
        super(in);
    }

    public MovieResult() {
        super();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MovieResult> CREATOR = new Creator<MovieResult>() {
        @Override
        public MovieResult createFromParcel(Parcel in) {
            return new MovieResult(in);
        }

        @Override
        public MovieResult[] newArray(int size) {
            return new MovieResult[size];
        }
    };
}
