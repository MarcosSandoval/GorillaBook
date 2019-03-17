package com.gorilla.gorillabook.viewModel;

import com.gorilla.gorillabook.model.Feed;
import com.gorilla.gorillabook.util.ApiAdapter;
import com.gorilla.gorillabook.util.FeedsManager;
import com.gorilla.gorillabook.view.SplashView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SplashViewModel {

    private SplashView view;


    public SplashViewModel(SplashView myView) {
        view = myView;
    }

    public void getFeeds(){
        ApiAdapter.getInstance().getFeeds().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Feed>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Feed> feeds) {
                        FeedsManager.getInstance().setFeeds(feeds);
                        view.onFeedLoadFinish();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
