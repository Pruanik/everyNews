package com.mybanana.everynews.ui.activities;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.mybanana.everynews.R;
import com.mybanana.everynews.app.models.Category;
import com.mybanana.everynews.ui.adapters.MainNewsRecycleAdapter;
import com.mybanana.everynews.app.models.News;
import com.mybanana.everynews.ui.views.MainView;
import com.mybanana.everynews.app.presenters.MainPresenter;

import java.util.List;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    @InjectPresenter
    public MainPresenter presenter;

    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView mainNewsRecyclerView;
    private MainNewsRecycleAdapter mainNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        presenter.onCreate();
    }

    public void init(){
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setOnRefreshListener(swipeRefreshAction);

        mainNewsRecyclerView = (RecyclerView) findViewById(R.id.news_main_recycler_vertical);
        mainNewsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainNewsAdapter = new MainNewsRecycleAdapter(this);
        mainNewsRecyclerView.setAdapter(mainNewsAdapter);
        mainNewsRecyclerView.setHasFixedSize(true);
    }

    public void setCategoriesNewsList(List<News> news){
        mainNewsAdapter.addCategoriesNews(news);
    }

    public void setCategoriesList(List<Category> categories){
        mainNewsAdapter.addCategories(categories);
    }

    public void setTrendingNewsList(List<News> news){
        mainNewsAdapter.addTrendingNews(news);
    }

    public void showProgress(){
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    public void hideProgress(){
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

    public void hideRefreshProgress(){
        swipeRefresh.setRefreshing(false);
    }

    public void showNotification(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    SwipeRefreshLayout.OnRefreshListener swipeRefreshAction = new SwipeRefreshLayout.OnRefreshListener(){
        @Override
        public void onRefresh() {
            presenter.onRefresh();
        }
    };
}