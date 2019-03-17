package com.gorilla.gorillabook.viewModel;

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
}
