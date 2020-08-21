package com.example.myapplication.bean.base;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class BaseHttpResult<T> implements Parcelable {
    protected int count;
    protected int start;
    protected int total;
    protected String title;
    public List<T> datas;

    protected BaseHttpResult(Parcel in) {
        count = in.readInt();
        start = in.readInt();
        total = in.readInt();
        title = in.readString();
    }

    public static final Creator<BaseHttpResult> CREATOR = new Creator<BaseHttpResult>() {
        @Override
        public BaseHttpResult createFromParcel(Parcel in) {
            return new BaseHttpResult(in);
        }

        @Override
        public BaseHttpResult[] newArray(int size) {
            return new BaseHttpResult[size];
        }
    };

    public BaseHttpResult() {

    }

    @Override
    public String toString() {
        return "BaseHttpResult{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", title='" + title + '\'' +
                ", datas=" + datas +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(count);
        dest.writeInt(start);
        dest.writeInt(total);
        dest.writeString(title);
    }
}
