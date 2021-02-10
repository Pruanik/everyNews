package com.mybanana.everynews.ui.activities;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.mybanana.everynews.R;
import com.mybanana.everynews.ui.adapters.NewsRecycleAdapter;
import com.mybanana.everynews.app.models.News;
import com.mybanana.everynews.ui.views.MainView;
import com.mybanana.everynews.app.presenters.MainPresenter;

import java.util.List;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    @InjectPresenter
    public MainPresenter presenter;

    private ProgressBar progressBar;
    private SearchView search;
    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView newsRecycleView;
    private NewsRecycleAdapter newsRecycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        presenter.onCreate();
    }

    public void init(){
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        search = (SearchView) findViewById(R.id.search_bar);
        search.setOnQueryTextListener(searchAction);

        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setOnRefreshListener(swipeRefreshAction);

        newsRecycleView = (RecyclerView) findViewById(R.id.news_recycler);
        newsRecycleView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setNews(List<News> news){
        if(newsRecycleAdapter == null){
            newsRecycleAdapter = new NewsRecycleAdapter();
            newsRecycleView.setAdapter(newsRecycleAdapter);
        }

        newsRecycleAdapter.add(news);
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

    SearchView.OnQueryTextListener searchAction = new SearchView.OnQueryTextListener(){
        @Override
        public boolean onQueryTextSubmit(String query) {
            presenter.onSearch(query);
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };
}