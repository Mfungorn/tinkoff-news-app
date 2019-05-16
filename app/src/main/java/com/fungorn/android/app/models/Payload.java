package com.fungorn.android.app.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payload {

    @SerializedName("resultCode")
    @Expose
    private String resultCode;
    @SerializedName("payload")
    @Expose
    private List<News> payload = null;
    @SerializedName("trackingId")
    @Expose
    private String trackingId;

    /**
     * No args constructor for use in serialization
     *
     */
    public Payload() {
    }

    /**
     *
     * @param trackingId
     * @param resultCode
     * @param payload
     */
    public Payload(String resultCode, List<News> payload, String trackingId) {
        super();
        this.resultCode = resultCode;
        this.payload = payload;
        this.trackingId = trackingId;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public List<News> getPayload() {
        return payload;
    }

    public void setPayload(List<News> payload) {
        this.payload = payload;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    @Override
    public String toString() {
        return resultCode;
    }

}

