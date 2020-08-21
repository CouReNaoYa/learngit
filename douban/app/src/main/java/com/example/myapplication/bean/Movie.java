package com.example.myapplication.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;
public  class Movie implements Parcelable{
    private Rating rating;
    private String title;
    private int collect_count;
    private String mainland_pubdate;
    private boolean has_video;
    private String original_title;
    private String subtype;
    private String year;
    private Images images;
    private String alt;
    private String id;
    private List<String> genres;
    private List<Casts> casts;
    private List<String> durations;
    private List<Directors> directors;
    private List<String> pubdates;

    protected Movie(Parcel in) {
        rating = in.readParcelable(Rating.class.getClassLoader());
        title = in.readString();
        collect_count = in.readInt();
        mainland_pubdate = in.readString();
        has_video = in.readByte() != 0;
        original_title = in.readString();
        subtype = in.readString();
        year = in.readString();
        images = in.readParcelable(Images.class.getClassLoader());
        alt = in.readString();
        id = in.readString();
        genres = in.createStringArrayList();
        casts = in.createTypedArrayList(Casts.CREATOR);
        durations = in.createStringArrayList();
        directors = in.createTypedArrayList(Directors.CREATOR);
        pubdates = in.createStringArrayList();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getMainland_pubdate() {
        return mainland_pubdate;
    }

    public void setMainland_pubdate(String mainland_pubdate) {
        this.mainland_pubdate = mainland_pubdate;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
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

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<Casts> getCasts() {
        return casts;
    }

    public void setCasts(List<Casts> casts) {
        this.casts = casts;
    }

    public List<String> getDurations() {
        return durations;
    }

    public void setDurations(List<String> durations) {
        this.durations = durations;
    }

    public List<Directors> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Directors> directors) {
        this.directors = directors;
    }

    public List<String> getPubdates() {
        return pubdates;
    }

    public void setPubdates(List<String> pubdates) {
        this.pubdates = pubdates;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(rating, flags);
        dest.writeString(title);
        dest.writeInt(collect_count);
        dest.writeString(mainland_pubdate);
        dest.writeByte((byte) (has_video ? 1 : 0));
        dest.writeString(original_title);
        dest.writeString(subtype);
        dest.writeString(year);
        dest.writeParcelable(images, flags);
        dest.writeString(alt);
        dest.writeString(id);
        dest.writeStringList(genres);
        dest.writeTypedList(casts);
        dest.writeStringList(durations);
        dest.writeTypedList(directors);
        dest.writeStringList(pubdates);
    }




}
