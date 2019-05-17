package com.fungorn.android.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsTitle {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("publicationDate")
    @Expose
    private PublicationDate publicationDate;
    @SerializedName("bankInfoTypeId")
    @Expose
    private int bankInfoTypeId;

    /**
     * No args constructor for use in serialization
     *
     */
    public NewsTitle() {
    }

    /**
     *
     * @param id
     * @param name
     * @param milliseconds
     */
    public NewsTitle(String id, String name, Long milliseconds) {
        super();
        this.id = id;
        this.name = name;
        this.publicationDate = new PublicationDate(milliseconds);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public PublicationDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(PublicationDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getBankInfoTypeId() {
        return bankInfoTypeId;
    }

    public void setBankInfoTypeId(int bankInfoTypeId) {
        this.bankInfoTypeId = bankInfoTypeId;
    }

    @Override
    public String toString() {
        return name;
    }

}
