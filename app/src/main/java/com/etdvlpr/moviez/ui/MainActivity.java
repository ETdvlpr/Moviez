package com.etdvlpr.moviez.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.etdvlpr.moviez.BuildConfig;
import com.etdvlpr.moviez.R;
import com.etdvlpr.moviez.model.TMDBResponce;
import com.etdvlpr.moviez.service.TMDBservice;
import com.etdvlpr.moviez.ui.adapter.MovieListAdapter;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycler = findViewById(R.id.main_movies_recycler);
        String apiKey = BuildConfig.TMDB_API_KEY;

        Retrofit retrofit = new Retrofit.Builder().baseUrl(getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create()).build();
        TMDBservice service = retrofit.create(TMDBservice.class);

        Call<TMDBResponce> call = service.getMovieList(BuildConfig.TMDB_API_KEY, "popular");
        try {
            MovieListAdapter adapter = new MovieListAdapter(call.execute().body().results);
            GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
            mRecycler.setLayoutManager(layoutManager);
            mRecycler.setAdapter(adapter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}