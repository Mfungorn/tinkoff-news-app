package com.fungorn.android.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContentPayload {

    @SerializedName("resultCode")
    @Expose
    private String resultCode;
    @SerializedName("payload")
    @Expose
    private NewsContent payload;
    @SerializedName("trackingId")
    @Expose
    private String trackingId;

    /**
     * No args constructor for use in serialization
     *
     */
    public ContentPayload() {
    }

    /**
     *
     * @param resultCode
     * @param payload
     */
    public ContentPayload(String resultCode, NewsContent payload) {
        super();
        this.resultCode = resultCode;
        this.payload = payload;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public NewsContent getPayload() {
        return payload;
    }

    public void setPayload(NewsContent payload) {
        this.payload = payload;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }
}
