package com.gorilla.gorillabook.util;

import com.gorilla.gorillabook.model.Feed;

import java.util.List;

public class FeedsManager {

    private static FeedsManager instance;
    private List<Feed> feeds;

    public static FeedsManager getInstance(){
        if(instance == null){
            instance = new FeedsManager();
        }
        return instance;
    }

    private FeedsManager() {
    }

    public List<Feed> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Feed> feeds) {
        this.feeds = feeds;
    }
}
