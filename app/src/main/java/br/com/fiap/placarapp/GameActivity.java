package br.com.fiap.placarapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private TextView tvTimeCasa;
    private TextView tvTimeVisitante;
    private TextView tvTimeCasaGol;
    private TextView tvTimeVisitanteGol;

    private Time timeCasa;
    private Time timeVisitante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvTimeCasa = findViewById(R.id.tvTimeCasa);
        tvTimeCasaGol = findViewById(R.id.tvTimeCasaGol);
        tvTimeVisitante = findViewById(R.id.tvTimeVisitante);
        tvTimeVisitanteGol = findViewById(R.id.tvTimeVisitanteGol);

        if (getIntent() != null) {
            timeCasa = new Time(getIntent().getStringExtra(Common.EXTRA_TIME_CASA));
            timeVisitante = new Time(getIntent().getStringExtra(Common.EXTRA_TIME_VISITANTE));

            tvTimeCasa.setText(timeCasa.getName());
            tvTimeCasaGol.setText(String.valueOf(timeCasa.getGols()));
            tvTimeVisitante.setText(timeVisitante.getName());
            tvTimeVisitanteGol.setText(String.valueOf(timeVisitante.getGols()));
        }
    }

    public void golCasa(View v) {
        timeCasa.gol();
        tvTimeCasaGol.setText(String.valueOf(timeCasa.getGols()));
    }

    public void golVisitante(View v) {
        timeVisitante.gol();
        tvTimeVisitanteGol.setText(String.valueOf(timeVisitante.getGols()));
    }
}
