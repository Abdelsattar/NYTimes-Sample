package com.sattar.nytimessample.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.sattar.nytimessample.BuildConfig;
import com.sattar.nytimessample.models.articles.ArticleResponse;
import com.sattar.nytimessample.utils.ApiClient;
import com.sattar.nytimessample.utils.ArticlesApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created By Sattar 2/11/2019
 */
public class ArticleRepository {


    public LiveData<ArticleResponse> getMostViewArticle(String section, String period) {

        final MutableLiveData<ArticleResponse> liveData = new MutableLiveData<>();
        ArticlesApiInterface articlesApiInterface = ApiClient.getClient().create
                (ArticlesApiInterface.class);
        articlesApiInterface.getMostViewed(
                section,
                period,
                BuildConfig.ApiKey
        ).enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                if (response.isSuccessful())
                    liveData.setValue(response.body());
                else
                    liveData.setValue(new ArticleResponse("ERROR"));
            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {
                Log.e("onFailure", t.getLocalizedMessage());
                liveData.setValue(new ArticleResponse("ERROR"));
            }
        });

        return liveData;

    }
}
