package com.etdvlpr.moviez.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.etdvlpr.moviez.R;
import com.etdvlpr.moviez.model.Movie;
import com.etdvlpr.moviez.ui.MovieActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder> {
    private List<Movie> movies;

    public MovieListAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View card = LayoutInflater.from(context).inflate(R.layout.card_movie, parent, false);
        return new MovieListViewHolder(card);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListViewHolder holder, int position) {
        holder.bind(movies.get(position));
    }

    public class MovieListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView img;
        public TextView title;

        public MovieListViewHolder(View v) {
            super(v);
            img = v.findViewById(R.id.image_movie_card_thumbnail);
            title = v.findViewById(R.id.text_movie_card_movie_title);
            v.setOnClickListener(this);
        }

        public void bind(Movie movie) {
            Picasso.get().load("http://image.tmdb.org/t/p/w300" + movie.poster_path).placeholder(R.drawable.placeholder).centerCrop().into(img);
            title.setText(movie.title);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), MovieActivity.class);
            intent.putExtra("Movie", movies.get(getAdapterPosition()));
            v.getContext().startActivity(intent);
        }
    }
}
