package com.fungorn.android.app.presentation.main;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.fungorn.android.app.R;
import com.fungorn.android.app.adapters.NewsAdapter;
import com.fungorn.android.app.models.TitlePayload;
import com.fungorn.android.app.presentation.content.NewsContentActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsTitleActivity extends AppCompatActivity implements NewsTitleViewInterface {
    @BindView(R.id.news_list)
    RecyclerView newsRecyclerView;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout refreshLayout;

    private String TAG = "NewsTitleActivity";
    RecyclerView.Adapter adapter;
    NewsTitlePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);

        initPresenter();
        initViews();
        getNewsList();
    }

    private void initPresenter() {
        presenter = new NewsTitlePresenter(this);
    }

    private void initViews(){
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        refreshLayout.setOnRefreshListener(() -> {
            refreshLayout.setRefreshing(true);
            refreshLayout.postDelayed(() -> {
                refreshLayout.setRefreshing(false);
                getNewsList();
            }, 2000);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.menu_refresh) {
            getNewsList();
        }

        return super.onOptionsItemSelected(item);
    }

    private void getNewsList() {
        presenter.getNews();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void showNews(TitlePayload payload) {
        if(payload != null) {
            Log.d(TAG, payload.getPayload().get(0).getName());
            payload.getPayload().sort((o1, o2) ->
                    Long.compare(
                            o2.getPublicationDate().getMilliseconds(),
                            o1.getPublicationDate().getMilliseconds()
                    )
            );
            adapter = new NewsAdapter(payload.getPayload(), this, newsTitle -> {
                Intent intent = new Intent(this, NewsContentActivity.class);
                intent.putExtra("id", newsTitle.getId());
                startActivity(intent);
            });
            newsRecyclerView.setAdapter(adapter);
        } else {
            Log.d(TAG,"NewsTitle payload is null");
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
