package com.gorilla.gorillabook.view;

import com.gorilla.gorillabook.model.Feed;

import java.util.List;

public interface SplashView {
    void onFeedLoadFinish(List<Feed> feeds);
}
