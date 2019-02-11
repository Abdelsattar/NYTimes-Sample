package com.sattar.nytimessample.views.Adapteres;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sattar.nytimessample.R;
import com.sattar.nytimessample.models.articles.ResultsItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created By Sattar 2/11/2019
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.NewsViewHolder> {

    private List<ResultsItem> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public MyRecyclerViewAdapter(Context context, List<ResultsItem> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item_article, parent, false);
        return new NewsViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        ResultsItem article = mData.get(position);

        holder.titleView.setText(article.getTitle());
        holder.sectionView.setText(article.getSection());
        holder.authorNameView.setText(article.getSource());
        holder.dateView.setText(article.getPublishedDate());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.title_view)
        TextView titleView;
        @BindView(R.id.section_view)
        TextView sectionView;
        @BindView(R.id.author_name_view)
        TextView authorNameView;
        @BindView(R.id.date_view)
        TextView dateView;

        public NewsViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}