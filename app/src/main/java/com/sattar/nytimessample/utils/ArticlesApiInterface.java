package com.sattar.nytimessample.utils;

import com.sattar.nytimessample.models.articles.ArticleResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created By Sattar 2/11/2019
 */
public interface ArticlesApiInterface {

//    http://api.nytimes.com/svc/mostpopular/v2/
//    @GET("mostviewed/{section}/{period}.json")
//    Call<ArticleResponse> getMostViewed(
//            @Path("section") String section,
//            @Path("period") String period,
//            @Query("api-key") String apiKey
//    );

    @GET("mostviewed/{section}/{period}.json")
    Observable<ArticleResponse> getMostViewed(
            @Path("section") String section,
            @Path("period") String period,
            @Query("api-key") String apiKey
    );
}
