package com.ar.tothestars.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ariviere on 23/04/15.
 */
public class APODPhoto implements Parcelable {

    public static final Parcelable.Creator<APODPhoto> CREATOR = new Parcelable.Creator<APODPhoto>() {
        public APODPhoto createFromParcel(Parcel source) {
            return new APODPhoto(source);
        }

        public APODPhoto[] newArray(int size) {
            return new APODPhoto[size];
        }
    };

    public static final String VIMEO = "player.vimeo.com";
    public static final String YOUTUBE = "www.youtube.com";

    private String title;
    private String url;
    private String explanation;
    private Date date;
    private ArrayList<String> concepts;

    public APODPhoto() {
    }

    private APODPhoto(Parcel in) {
        this.title = in.readString();
        this.url = in.readString();
        this.explanation = in.readString();
        long tmpDate = in.readLong();
        this.date = tmpDate == -1 ? null : new Date(tmpDate);
        this.concepts = (ArrayList<String>) in.readSerializable();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.url);
        dest.writeString(this.explanation);
        dest.writeLong(date != null ? date.getTime() : -1);
        dest.writeSerializable(this.concepts);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<String> getConcepts() {
        return concepts;
    }

    public void setConcepts(ArrayList<String> concepts) {
        this.concepts = concepts;
    }

    public boolean isValid() {
        if (getUrl().contains(VIMEO)) {
            return false;
        } else if (getUrl().contains(YOUTUBE)) {
            return false;
        }

        return true;
    }

    public Calendar getCalendarDate() {
        Calendar dateCal = Calendar.getInstance();
        dateCal.setTime(getDate());
        dateCal.set(Calendar.HOUR, 0);
        dateCal.set(Calendar.MINUTE, 0);
        dateCal.set(Calendar.SECOND, 0);
        dateCal.set(Calendar.MILLISECOND, 0);
        return dateCal;
    }
}
