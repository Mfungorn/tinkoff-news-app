package com.fungorn.android.app.presentation.content;

import android.util.Log;

import com.fungorn.android.app.models.ContentPayload;
import com.fungorn.android.app.models.NewsContent;
import com.fungorn.android.app.network.NetworkClient;
import com.fungorn.android.app.network.NewsApi;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class NewsContentPresenter implements NewsContentPresenterInterface {
    NewsContentViewInterface viewInterface;
    private String TAG = "NewsTitlePresenter";
    private String newsId;

    public NewsContentPresenter(NewsContentViewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Override
    public void getNews(String id) {
        newsId = id;
        getObservable().subscribeWith(getObserver());
    }

    public Observable<ContentPayload> getObservable() {
        return NetworkClient.getRetrofit().create(NewsApi.class)
                .getNews(newsId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<ContentPayload> getObserver() {
        return new DisposableObserver<ContentPayload>() {

            @Override
            public void onNext(ContentPayload payload) {
                Log.d(TAG,"OnNext" + payload.getPayload().getTitle().getName());
                viewInterface.showNewsContent(payload.getPayload());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
                viewInterface.showError("Error fetching NewsContent");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
            }
        };
    }
}
