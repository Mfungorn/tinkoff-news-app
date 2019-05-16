package com.fungorn.android.app.network;

import com.fungorn.android.app.models.Payload;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NewsApi {
    @GET("news")
    Observable<Payload> getNews();
}
