package com.example.uasmovie.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.uasmovie.R;
import com.example.uasmovie.model.Result;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private Context context;
    private List<Result> resultList;

    public MovieAdapter(Context context, List<Result> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view=inflater.inflate(R.layout.activity_item_movie, parent, false);
        MovieAdapter.MyViewHolder viewHolder = new MovieAdapter.MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(resultList.get(position).getTitle());
        holder.tvDesk.setText(resultList.get(position).getOverview());
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500/"+resultList.get(position).getPosterPath())
                .into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle, tvDesk;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster=itemView.findViewById(R.id.imgMovie);
            tvTitle=itemView.findViewById(R.id.tvJudul);
            tvDesk = itemView.findViewById(R.id.tvDes);
        }
    }
}
