package com.fungorn.android.app.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TitlePayload {

    @SerializedName("resultCode")
    @Expose
    private String resultCode;
    @SerializedName("payload")
    @Expose
    private List<NewsTitle> payload = null;
    @SerializedName("trackingId")
    @Expose
    private String trackingId;

    /**
     * No args constructor for use in serialization
     *
     */
    public TitlePayload() {
    }

    /**
     *
     * @param trackingId
     * @param resultCode
     * @param payload
     */
    public TitlePayload(String resultCode, List<NewsTitle> payload, String trackingId) {
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

    public List<NewsTitle> getPayload() {
        return payload;
    }

    public void setPayload(List<NewsTitle> payload) {
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

