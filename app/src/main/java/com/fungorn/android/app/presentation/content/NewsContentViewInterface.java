package com.fungorn.android.app.presentation.content;

import com.fungorn.android.app.models.NewsContent;

public interface NewsContentViewInterface {
    void showNewsContent(NewsContent payload);
    void showToast(String s);
    void showError(String s);
}
