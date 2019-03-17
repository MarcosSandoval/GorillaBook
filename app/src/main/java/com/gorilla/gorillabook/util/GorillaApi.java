package com.gorilla.gorillabook.util;

import com.gorilla.gorillabook.model.Feed;

import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface GorillaApi {

    @GET("/feed")
    Observable<List<Feed>> getTrends();
}
