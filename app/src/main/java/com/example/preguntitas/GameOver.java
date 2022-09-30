package com.example.preguntitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {

    TextView tvGScore;
    Button btnGReiniciar, btnGMenu, btnGPodio;
    String Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        conectar();

        Bundle pInfo = getIntent().getExtras();
        if(pInfo != null){
            Score = pInfo.getString("Over");
            tvGScore.setText(Score);
        }

        btnGMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(I);
            }
        });

        btnGPodio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), ScoreR.class);
                startActivity(I);
            }
        });

        btnGReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), Game.class);
                I.putExtra("Name", Nombre());
                startActivity(I);
            }
        });
    }

    private void conectar() {
        tvGScore = findViewById(R.id.tvGScore);
        btnGReiniciar = findViewById(R.id.btnGReiniciar);
        btnGPodio = findViewById(R.id.btnGPodio);
        btnGMenu = findViewById(R.id.btnGMenu);
    }

    public String Nombre(){
        Bundle pInfo = getIntent().getExtras();
        return  pInfo.getString("Name");
    }
}