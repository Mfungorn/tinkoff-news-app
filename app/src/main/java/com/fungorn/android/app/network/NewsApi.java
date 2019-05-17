package com.fungorn.android.app.network;

import com.fungorn.android.app.models.ContentPayload;
import com.fungorn.android.app.models.TitlePayload;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("news")
    Observable<TitlePayload> getNews();

    @GET("news_content")
    Observable<ContentPayload> getNews(@Query("id") String id);
}
