package com.example.aironnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.aironnews.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("description");
        int image = intent.getIntExtra("image",R.drawable.news_picture_1);

        binding.newsPoster.setImageResource(image);
        binding.newsName.setText(name);
        binding.newsDescription.setText(description);
    }
}