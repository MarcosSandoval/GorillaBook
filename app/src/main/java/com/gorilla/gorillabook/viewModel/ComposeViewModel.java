package com.gorilla.gorillabook.viewModel;

import com.gorilla.gorillabook.model.Feed;
import com.gorilla.gorillabook.util.FeedsManager;
import com.gorilla.gorillabook.view.ComposeView;

public class ComposeViewModel {

    private ComposeView view;
    private int sizeLimit = 150;

    public ComposeViewModel(ComposeView view) {
        this.view = view;
    }

    public void validatePostSize(int currentSize){
        String message = Integer.toString(currentSize).concat("/").concat(Integer.toString(sizeLimit));
        view.updateCounterMessage(message);
    }

    public void addNewPost(String post){

        Feed feed = new Feed(1, "Marcos Sandoval", post, 1254441, null);

        FeedsManager.getInstance().getFeeds().add(0, feed);
        view.compositionComplete();

    }
}
