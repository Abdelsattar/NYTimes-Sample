package com.sattar.nytimessample.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.sattar.nytimessample.models.articles.ArticleResponse;
import com.sattar.nytimessample.repositories.ArticleRepository;

import static com.sattar.nytimessample.utils.Constants.API_ALL_SECTION;
import static com.sattar.nytimessample.utils.Constants.API_LAST_WEEK;

/**
 * Created By Sattar 2/11/2019
 */
public class MainActivityViewModel extends ViewModel {

    ArticleRepository articleRepository;

    public  MainActivityViewModel() {
        articleRepository = new ArticleRepository();
    }

    public LiveData<ArticleResponse> getMostViewedArticlesLastWeek() {
        return articleRepository.getMostViewArticle(
                API_ALL_SECTION,
                API_LAST_WEEK);
    }
}
