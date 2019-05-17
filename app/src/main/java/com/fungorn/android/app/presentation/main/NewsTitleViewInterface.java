package com.fungorn.android.app.presentation.main;

import com.fungorn.android.app.models.TitlePayload;

public interface NewsTitleViewInterface {
    void showNews(TitlePayload payload);
    void showToast(String s);
    void showError(String s);
}
