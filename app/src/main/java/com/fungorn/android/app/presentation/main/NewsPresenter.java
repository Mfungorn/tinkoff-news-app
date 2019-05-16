package com.fungorn.android.app.presentation.main;

import android.util.Log;

import com.fungorn.android.app.models.Payload;
import com.fungorn.android.app.network.NetworkClient;
import com.fungorn.android.app.network.NewsApi;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class NewsPresenter implements NewsPresenterInterface {
    NewsViewInterface viewInterface;
    private String TAG = "NewsPresenter";

    public NewsPresenter(NewsViewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Override
    public void getNews() {
        getObservable().subscribeWith(getObserver());
    }

    public Observable<Payload> getObservable() {
        return NetworkClient.getRetrofit().create(NewsApi.class)
                .getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<Payload> getObserver() {
        return new DisposableObserver<Payload>() {

            @Override
            public void onNext(Payload payload) {
                Log.d(TAG,"OnNext" + payload.getPayload().size());
                viewInterface.showNews(payload);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
                viewInterface.showError("Error fetching News");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
            }
        };
    }
}
