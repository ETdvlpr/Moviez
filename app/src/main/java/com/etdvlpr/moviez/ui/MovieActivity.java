package com.etdvlpr.moviez.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.etdvlpr.moviez.R;
import com.etdvlpr.moviez.model.Movie;
import com.squareup.picasso.Picasso;

public class MovieActivity extends AppCompatActivity {
    private ImageView thumbImage;
    private TextView title, overview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_movie);

        String image_base = "http://image.tmdb.org/t/p/";
        String image_size = "w500";

        Movie movie = (Movie) getIntent().getSerializableExtra("Movie");

        thumbImage = findViewById(R.id.image_activity_movie);
        title = findViewById(R.id.text_activity_movie_title);
        overview = findViewById(R.id.text_activity_movie_overview);

        title.setText(movie.title);
        overview.setText(movie.overview);
        Picasso.get().load(image_base + image_size + movie.poster_path).centerCrop().placeholder(R.drawable.placeholder).into(thumbImage);
    }
}
