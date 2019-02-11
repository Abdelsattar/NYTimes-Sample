package com.sattar.nytimessample.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.sattar.nytimessample.R;
import com.sattar.nytimessample.models.articles.ResultsItem;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sattar.nytimessample.utils.Constants.KEY_NEWS_DETAILS;

public class NewsDetailsActivity extends AppCompatActivity {

    @BindView(R.id.imgMedia)
    ImageView imgMedia;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtSection)
    TextView txtSection;
    @BindView(R.id.txtAuthorName)
    TextView txtAuthorName;
    @BindView(R.id.txtDate)
    TextView txtDate;
    @BindView(R.id.txtSource)
    TextView txtSource;
    @BindView(R.id.txtAbstract)
    TextView txtAbstract;
    @BindView(R.id.txtKeyWords)
    TextView txtKeyWords;
    @BindView(R.id.txtUrl)
    TextView txtUrl;

    ResultsItem resultsItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this);

        resultsItem = getIntent().getParcelableExtra(KEY_NEWS_DETAILS);
        if (resultsItem != null)
            initView();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    void initView() {
        txtSection.setText(resultsItem.getSection());
        txtAuthorName.setText(resultsItem.getByline());
        txtDate.setText(resultsItem.getPublishedDate());
        txtSource.setText(resultsItem.getSource());
        txtAbstract.setText(resultsItem.getAbstractStr());
        txtKeyWords.setText(resultsItem.getAdxKeywords());
        txtUrl.setText(resultsItem.getUrl());
        txtTitle.setText(resultsItem.getTitle());

        if (resultsItem != null && resultsItem.getMedia() != null
                && !resultsItem.getMedia().isEmpty()) {

            try {
                Picasso.get()
                        .load(resultsItem.getMedia().get(0).getMediaMetadata().get(0).getUrl())
                        .error(R.drawable.img_default)
                        .placeholder(R.drawable.img_default)
                        .into(imgMedia);

            } catch (Exception e) {
                e.printStackTrace();
                Picasso.get()
                        .load(R.drawable.img_default)
                        .into(imgMedia);
            }

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
