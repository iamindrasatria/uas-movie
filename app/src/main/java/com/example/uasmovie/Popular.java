package com.example.uasmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.uasmovie.Adapter.MovieAdapter;
import com.example.uasmovie.Rest.ApiClient;
import com.example.uasmovie.Rest.ApiInterface;
import com.example.uasmovie.model.Response;
import com.example.uasmovie.model.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class Popular extends AppCompatActivity {


    private MovieAdapter adapter;
    String API_KEY = "8585934da5a1982f5ed99da4d0776793";
    String LANGUAGE = "en-US";
    String CATEGORY="popular";
    int PAGE = 1;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);
        recyclerView = findViewById(R.id.RvMovie);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AmbilData();
    }

    private void AmbilData() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Response> call=apiInterface.getMovie(CATEGORY, API_KEY, LANGUAGE, PAGE);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                List<Result> mlist = response.body().getResults();
                adapter=new MovieAdapter(Popular.this, mlist);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }
}