package com.fungorn.android.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fungorn.android.app.R;
import com.fungorn.android.app.models.News;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    List<News> newsList;
    Context context;
    SimpleDateFormat dateFormat;

    public NewsAdapter(List<News> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
        this.dateFormat = new SimpleDateFormat("HH:mm, dd MMM yyyy", Locale.ENGLISH);
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.news_item, parent,false);
        NewsHolder newsHolder = new NewsHolder(v);
        return newsHolder;
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        holder.nameTextView.setText(newsList.get(position).getText());
        holder.publicationDateTextView.setText(dateFormat.format(new Date(
                newsList.get(position).getPublicationDate().getMilliseconds()
        )));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {

        TextView nameTextView, publicationDateTextView;

        public NewsHolder(View v) {
            super(v);
            nameTextView = v.findViewById(R.id.name_text);
            publicationDateTextView = v.findViewById(R.id.date_text);
        }
    }
}
