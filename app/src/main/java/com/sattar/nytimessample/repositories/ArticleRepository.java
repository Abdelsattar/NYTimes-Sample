package com.sattar.nytimessample.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.sattar.nytimessample.BuildConfig;
import com.sattar.nytimessample.models.articles.ArticleResponse;
import com.sattar.nytimessample.utils.ApiClient;
import com.sattar.nytimessample.utils.ArticlesApiInterface;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created By Sattar 2/11/2019
 */
public class ArticleRepository {


    public LiveData<ArticleResponse> getMostViewArticle(String section, String period) {

        final MutableLiveData<ArticleResponse> liveData = new MutableLiveData<>();
        ArticlesApiInterface articlesApiInterface = ApiClient.getClient().create
                (ArticlesApiInterface.class);
        
        articlesApiInterface
                .getMostViewed(
                        section,
                        period,
                        BuildConfig.ApiKey
                ).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArticleResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArticleResponse articleResponse) {
                        liveData.setValue(articleResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        liveData.setValue(new ArticleResponse("ERROR"));
                    }

                    @Override
                    public void onComplete() {
                        Log.i("Article", "Completed");

                    }
                });


        return liveData;

    }
}
