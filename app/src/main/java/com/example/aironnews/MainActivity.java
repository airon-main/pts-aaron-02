package com.example.aironnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.res.TypedArray;
import android.view.View;
import android.os.Bundle;
import com.example.aironnews.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ArrayList<News> news = getListNews();

        NewsAdapter adapter = new NewsAdapter(news);
        binding.rvNews.setLayoutManager(new GridLayoutManager(this,1));
        binding.rvNews.setAdapter(adapter);
    }

    private ArrayList<News> getListNews(){
        String[] Name = getResources().getStringArray(R.array.news_name);
        String[] Description = getResources().getStringArray(R.array.news_description);
        String[] Time = getResources().getStringArray(R.array.news_time);
        TypedArray Images = getResources().obtainTypedArray(R.array.news_img);

        ArrayList<News> heroes = new ArrayList<>();

        for (int i = 0; i< Name.length;i++){
            News news = new News();
            news.setName(Name[i]);
            news.setDescription(Description[i]);
            news.setTime(Time[i]);
            news.setImages(Images.getResourceId(i,-1));

            heroes.add(news);
        }
        return heroes;
    }
}