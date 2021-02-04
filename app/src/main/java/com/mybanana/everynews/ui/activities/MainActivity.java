package com.mybanana.everynews.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mybanana.everynews.R;
import com.mybanana.everynews.adapters.NewsRecycleAdapter;
import com.mybanana.everynews.adapters.items.News;
import com.mybanana.everynews.models.NewsModel;
import com.mybanana.everynews.repository.http.HttpNews;
import com.mybanana.everynews.repository.stub.StubNews;
import com.mybanana.everynews.ui.presenters.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView newsRecycleView;
    private NewsRecycleAdapter newsRecycleAdapter;
    private MainPresenter presenter;

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
        newsRecycleView = (RecyclerView) findViewById(R.id.news_recycler);
        newsRecycleView.setLayoutManager(new LinearLayoutManager(this));

        //StubNews newsRepository = new StubNews();
        HttpNews newsRepository = new HttpNews();
        NewsModel model = new NewsModel(newsRepository);
        presenter = new MainPresenter(this, model);
    }

    public void showNews(List<News> news){
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
}