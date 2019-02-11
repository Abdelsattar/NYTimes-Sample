package com.sattar.nytimessample.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sattar.nytimessample.R;
import com.sattar.nytimessample.models.articles.ArticleResponse;
import com.sattar.nytimessample.models.articles.ResultsItem;
import com.sattar.nytimessample.viewmodels.MainActivityViewModel;
import com.sattar.nytimessample.views.Adapteres.MyRecyclerViewAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sattar.nytimessample.utils.Constants.API_OK_STATUS;
import static com.sattar.nytimessample.utils.Constants.KEY_NEWS_DETAILS;

public class MainActivity extends AppCompatActivity {


    MainActivityViewModel mViewModel;
    private MyRecyclerViewAdapter adapter;

    @BindView(R.id.rvArticles)
    RecyclerView rvArticles;
    @BindView(R.id.progress_circular)
    ProgressBar progressCircular;
    @BindView(R.id.txtError)
    TextView txtError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    void initView() {
        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mViewModel.getMostViewedArticlesLastWeek().observe(this, new Observer<ArticleResponse>() {
            @Override
            public void onChanged(@Nullable ArticleResponse articleResponse) {

                if (articleResponse != null && API_OK_STATUS.equals(articleResponse.getStatus())) {
                    progressCircular.setVisibility(View.GONE);
                    setupRecyclerView(articleResponse.getResults());

                } else {
                    txtError.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    void setupRecyclerView(final List<ResultsItem> results) {

        rvArticles.setVisibility(View.VISIBLE);
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvArticles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, results);
        adapter.setClickListener(new MyRecyclerViewAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(MainActivity.this, NewsDetailsActivity.class)
                        .putExtra(KEY_NEWS_DETAILS, results.get(position)));
            }
        });
        recyclerView.setAdapter(adapter);
    }

}
