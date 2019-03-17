package com.gorilla.gorillabook.viewModel;

import com.gorilla.gorillabook.model.Feed;
import com.gorilla.gorillabook.util.FeedsManager;
import com.gorilla.gorillabook.view.FeedsView;

import java.util.List;

public class FeedsViewModel {

    private FeedsView view;

    public FeedsViewModel(FeedsView view) {
        this.view = view;
    }

    public List<Feed> getFeeds(){
        return FeedsManager.getInstance().getFeeds();
    }
}
