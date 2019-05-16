package com.fungorn.android.app.presentation.main;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.fungorn.android.app.R;
import com.fungorn.android.app.adapters.NewsAdapter;
import com.fungorn.android.app.models.Payload;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity implements NewsViewInterface {
    @BindView(R.id.news_list)
    RecyclerView newsRecyclerView;

    private String TAG = "NewsActivity";
    RecyclerView.Adapter adapter;
    NewsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);

        initPresenter();
        initViews();
        getMovieList();
    }

    private void initPresenter() {
        presenter = new NewsPresenter(this);
    }

    private void initViews(){
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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

    private void getMovieList() {
        presenter.getNews();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void showNews(Payload newsPayload) {
        if(newsPayload != null) {
            Log.d(TAG, newsPayload.getPayload().get(1).getName());
            newsPayload.getPayload().sort((o1, o2) ->
                    Long.compare(
                            o2.getPublicationDate().getMilliseconds(),
                            o1.getPublicationDate().getMilliseconds()
                    )
            );
            adapter = new NewsAdapter(newsPayload.getPayload(), this);
            newsRecyclerView.setAdapter(adapter);
        } else {
            Log.d(TAG,"News payload is null");
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
