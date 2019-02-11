package com.sattar.nytimessample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sattar.nytimessample.models.articles.ArticleResponse;
import com.sattar.nytimessample.utils.ApiClient;
import com.sattar.nytimessample.utils.ArticlesApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.sattar.nytimessample.utils.Constants.API_ALL_SECTION;
import static com.sattar.nytimessample.utils.Constants.API_LAST_WEEK;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        get();
    }

    void get() {

        ArticlesApiInterface articlesApiInterface = ApiClient.getClient().create
                (ArticlesApiInterface.class);
        articlesApiInterface.getMostViewed(
                API_ALL_SECTION,
                API_LAST_WEEK,
                BuildConfig.ApiKey
        ).enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                Log.e("onResponse", response.body().getResults().size() + "");
            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {
                Log.e("onFailure", t.getLocalizedMessage());

            }
        });
    }
}
