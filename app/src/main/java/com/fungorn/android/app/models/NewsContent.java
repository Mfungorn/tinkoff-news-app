package com.fungorn.android.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsContent {

    @SerializedName("title")
    @Expose
    private NewsTitle title;
    @SerializedName("creationDate")
    @Expose
    private PublicationDate creationDate;
    @SerializedName("lastModificationDate")
    @Expose
    private PublicationDate lastModificationDate;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("bankInfoTypeId")
    @Expose
    private Long bankInfoTypeId;
    @SerializedName("typeId")
    @Expose
    private String typeId;

    /**
     * No args constructor for use in serialization
     *
     */
    public NewsContent() {
    }

    /**
     *
     * @param content
     * @param creationDate
     * @param title
     * @param lastModificationDate
     */
    public NewsContent(NewsTitle title, PublicationDate creationDate, PublicationDate lastModificationDate, String content) {
        super();
        this.title = title;
        this.creationDate = creationDate;
        this.lastModificationDate = lastModificationDate;
        this.content = content;
    }

    public NewsTitle getTitle() {
        return title;
    }

    public void setTitle(NewsTitle title) {
        this.title = title;
    }

    public PublicationDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(PublicationDate creationDate) {
        this.creationDate = creationDate;
    }

    public PublicationDate getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(PublicationDate lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getBankInfoTypeId() {
        return bankInfoTypeId;
    }

    public void setBankInfoTypeId(Long bankInfoTypeId) {
        this.bankInfoTypeId = bankInfoTypeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

}
