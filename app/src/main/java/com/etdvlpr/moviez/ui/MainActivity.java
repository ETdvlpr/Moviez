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
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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

        Call<TMDBResponce> call = service.getMovieList("popular", BuildConfig.TMDB_API_KEY);
        call.enqueue(new Callback<TMDBResponce>() {
            @Override
            public void onResponse(Call<TMDBResponce> call, Response<TMDBResponce> response) {
                MovieListAdapter adapter = new MovieListAdapter(response.body().results);
                GridLayoutManager layoutManager = new GridLayoutManager(getBaseContext(), 3);
                mRecycler.setLayoutManager(layoutManager);
                mRecycler.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<TMDBResponce> call, Throwable t) {
                Snackbar.make(mRecycler, "Connection Error.\n" + t.getMessage(), Snackbar.LENGTH_LONG)
                        .show();
            }
        });
    }
}