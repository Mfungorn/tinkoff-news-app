package com.fungorn.android.app.presentation.main;

import com.fungorn.android.app.models.Payload;

public interface NewsViewInterface {
    void showNews(Payload movieResponse);
    void showToast(String s);
    void showError(String s);
}
