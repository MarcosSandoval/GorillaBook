package com.gorilla.gorillabook.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gorilla.gorillabook.R;
import com.gorilla.gorillabook.model.Feed;

import org.w3c.dom.Text;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedHolder>{

    private List<Feed> feeds;

    public FeedAdapter(List<Feed> feeds) {
        this.feeds = feeds;
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
        feedHolder.nameTextView.setText(feeds.get(i).getFirstName());
        feedHolder.dateTextView.setText(Integer.toString(feeds.get(i).getPostDate()));
        feedHolder.postTextView.setText(feeds.get(i).getBody());
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

        public FeedHolder(View v) {
            super(v);
            nameTextView = (TextView) itemView.findViewById(R.id.name);
            dateTextView = (TextView) itemView.findViewById(R.id.name);
            postTextView = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
