package com.fungorn.android.app.presentation.main;

import android.util.Log;

import com.fungorn.android.app.models.TitlePayload;
import com.fungorn.android.app.network.NetworkClient;
import com.fungorn.android.app.network.NewsApi;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class NewsTitlePresenter implements NewsTitlePresenterInterface {
    NewsTitleViewInterface viewInterface;
    private String TAG = "NewsTitlePresenter";

    public NewsTitlePresenter(NewsTitleViewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Override
    public void getNews() {
        getObservable().subscribeWith(getObserver());
    }

    public Observable<TitlePayload> getObservable() {
        return NetworkClient.getRetrofit().create(NewsApi.class)
                .getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<TitlePayload> getObserver() {
        return new DisposableObserver<TitlePayload>() {

            @Override
            public void onNext(TitlePayload payload) {
                Log.d(TAG,"OnNext" + payload.getPayload().size());
                viewInterface.showNews(payload);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
                viewInterface.showError("Error fetching NewsTitle");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
            }
        };
    }
}
