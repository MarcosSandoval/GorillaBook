package com.gorilla.gorillabook.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gorilla.gorillabook.R;
import com.gorilla.gorillabook.model.Feed;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.gorilla.gorillabook.util.Constants.DATE_FORMAT;


public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedHolder>{

    private List<Feed> feeds;
    private Fragment fragmentContext;

    public FeedAdapter(List<Feed> feeds, Fragment context) {
        this.feeds = feeds;
        this.fragmentContext = context;
    }

    @NonNull
    @Override
    public FeedHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.feed, viewGroup, false);
        return new FeedHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedHolder feedHolder, int i) {
        Feed feed = feeds.get(i);

        feedHolder.nameTextView.setText(feed.getFirstName());
        feedHolder.dateTextView.setText(convertTimeStamp(feed.getPostDate()));
        feedHolder.postTextView.setText(feed.getBody());
        if(feed.getImage() != null && !feed.getImage().isEmpty()){
            Glide.with(fragmentContext).load(feed.getImage()).into(feedHolder.postImageView);
            feedHolder.postImageView.setVisibility(View.VISIBLE);
        }
        else{
            feedHolder.postImageView.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    public static class FeedHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nameTextView;
        public TextView dateTextView;
        public TextView postTextView;
        public ImageView postImageView;

        public FeedHolder(View v) {
            super(v);
            nameTextView = itemView.findViewById(R.id.name);
            dateTextView = itemView.findViewById(R.id.date);
            postTextView = itemView.findViewById(R.id.post);
            postImageView = itemView.findViewById(R.id.post_image);
        }
    }

    private String convertTimeStamp(int time){
        Date date = new Date(time*1000L);
        SimpleDateFormat jdf = new SimpleDateFormat(DATE_FORMAT);
        return jdf.format(date);
    }
}
