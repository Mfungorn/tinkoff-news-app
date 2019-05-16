package com.fungorn.android.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PublicationDate {

    @SerializedName("milliseconds")
    @Expose
    private long milliseconds;

    /**
     * No args constructor for use in serialization
     *
     */
    public PublicationDate() {
    }

    /**
     *
     * @param milliseconds
     */
    public PublicationDate(long milliseconds) {
        super();
        this.milliseconds = milliseconds;
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }

}
