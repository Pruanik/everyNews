package com.mybanana.everynews.repository.stub;

import com.mybanana.everynews.adapters.items.News;
import com.mybanana.everynews.repository.BaseNewsRepository;

import java.util.ArrayList;
import java.util.List;

public class StubNews implements BaseNewsRepository {
    @Override
    public List<News> getNews() {
        ArrayList<News> news = new ArrayList<>();

        news.add(new News("NN", "NNNN", "NNNNNN", "NNNNNNNN", "NNNNNNNNNN", "NNNNNNNNNNNN", "NNNNNNNNNNNNNN"));
        news.add(new News("NN1", "NNNN1", "NNNNNN1", "NNNNNNNN1", "NNNNNNNNNN1", "NNNNNNNNNNNN1", "NNNNNNNNNNNNNN1"));
        news.add(new News("NN2", "NNNN2", "NNNNNN2", "NNNNNNNN2", "NNNNNNNNNN2", "NNNNNNNNNNNN2", "NNNNNNNNNNNNNN2"));
        return news;
    }
}