package com.fungorn.android.app.presentation.content;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.fungorn.android.app.R;
import com.fungorn.android.app.models.NewsContent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsContentActivity extends AppCompatActivity implements NewsContentViewInterface {
    @BindView(R.id.title_text)
    TextView titleTextView;

    @BindView(R.id.content_text)
    TextView contentTextView;

    @BindView(R.id.content_date_text)
    TextView dateTextView;

    private String TAG = "NewsContentActivity";
    NewsContentPresenter presenter;
    String newsId;
    SimpleDateFormat dateFormat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_activity);
        ButterKnife.bind(this);

        newsId = getIntent().getStringExtra("id");
        dateFormat = new SimpleDateFormat("HH:mm, dd MMM yyyy", Locale.ENGLISH);

        initPresenter();
        initViews();
        getNewsContent();
    }

    private void initPresenter() {
        presenter = new NewsContentPresenter(this);
    }

    private void initViews() {
        contentTextView.setMovementMethod(new ScrollingMovementMethod());
    }

    private void getNewsContent() {
        presenter.getNews(newsId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showNewsContent(NewsContent payload) {
        if(payload != null) {
            Log.d(TAG, payload.getTitle().getName());
            titleTextView.setText(payload.getTitle().getText());
            //contentTextView.setText(payload.getContent());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                contentTextView.setText(Html.fromHtml(payload.getContent(),
                        Html.FROM_HTML_MODE_COMPACT));
            else
                contentTextView.setText(Html.fromHtml(payload.getContent()));
            dateTextView.setText(dateFormat.format(new Date(
                    payload.getCreationDate().getMilliseconds()
            )));
        } else {
            Log.d(TAG,"NewsContent payload is null");
        }
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String e) {
        showToast(e);
    }
}
