package com.example.uasmovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnNP, btnPopular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNP = findViewById(R.id.btn_nowplaying);
        btnNP.setOnClickListener(this);

        btnPopular = findViewById(R.id.btn_popular);
        btnPopular.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_nowplaying){
            Intent pindahIntent = new Intent(MainActivity.this, NowPlaying.class);
            startActivity(pindahIntent);
        }
        if(view.getId()==R.id.btn_popular){
            Intent pindahIntent = new Intent(MainActivity.this, Popular.class);
            startActivity(pindahIntent);
        }
    }
}