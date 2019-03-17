package com.gorilla.gorillabook.util;

import com.gorilla.gorillabook.model.Feed;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {

    private static ApiAdapter mInstance;
    GorillaApi api;

    public static ApiAdapter getInstance(){

        if(mInstance ==  null){
            mInstance = new ApiAdapter();
        }
        return mInstance;
    }

    private ApiAdapter() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gl-endpoint.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api =  retrofit.create(GorillaApi.class);
    }

    public Observable<List<Feed>> getFeeds(){
        return api.getTrends();
    }
}
