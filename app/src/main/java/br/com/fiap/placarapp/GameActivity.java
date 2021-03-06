package br.com.fiap.placarapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private PlacarView placarCasa;
    private PlacarView placarVisitante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        placarCasa = findViewById(R.id.placarCasa);
        placarVisitante = findViewById(R.id.placarVisitante);

        if (getIntent() != null) {
            Time timeCasa = (Time) getIntent().getSerializableExtra(Extras.EXTRA_TIME_CASA);
            Time timeVisitante = (Time) getIntent().getSerializableExtra(Extras.EXTRA_TIME_VISITANTE);

            placarCasa.setTime(timeCasa);
            placarVisitante.setTime(timeVisitante);
        }
    }
}
