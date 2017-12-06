package br.com.fiap.placarapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.widget.LinearLayout;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private static final String TAG = "GameActivity";

    private static final int TIME_JOGO = (1000 * 30);
    private static final int TIME_INTERVALO = (1000 * 10);

    private LinearLayout container;
    private PlacarView placarCasa;
    private PlacarView placarVisitante;
    private int tempo;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        container = findViewById(R.id.container);
        placarCasa = findViewById(R.id.placarCasa);
        placarVisitante = findViewById(R.id.placarVisitante);

        if (getIntent() != null) {
            Time timeCasa = (Time) getIntent().getSerializableExtra(Extras.EXTRA_TIME_CASA);
            Time timeVisitante = (Time) getIntent().getSerializableExtra(Extras.EXTRA_TIME_VISITANTE);

            placarCasa.setTime(timeCasa);
            placarVisitante.setTime(timeVisitante);
        }

        tempo = 1;
        handler = new Handler();
        handler.postDelayed(tempoJogo, TIME_JOGO);
    }

    private Runnable tempoJogo = new Runnable() {
        @Override
        public void run() {
            if (tempo == 1) {
                Toast.makeText(GameActivity.this, "Intervalo", Toast.LENGTH_LONG)
                        .show();
                placarCasa.setGolClickable(false);
                placarVisitante.setGolClickable(false);
                handler.postDelayed(intervalo, TIME_INTERVALO);
            } else {
                Toast.makeText(GameActivity.this, "Fim de Jogo", Toast.LENGTH_LONG)
                    .show();
                placarCasa.fimJogo();
                placarVisitante.fimJogo();
            }
            tempo++;
        }
    };

    private Runnable intervalo = new Runnable() {
        @Override
        public void run() {
            Toast.makeText(GameActivity.this, "Começou segundo tempo", Toast.LENGTH_LONG)
                    .show();
            changePlacarPosition();
            placarCasa.setGolClickable(true);
            placarVisitante.setGolClickable(true);
            handler.postDelayed(tempoJogo, TIME_JOGO);
        }
    };

    private void changePlacarPosition() {
        TransitionManager.beginDelayedTransition(container);
        container.removeAllViews();
        container.addView(placarVisitante);
        container.addView(placarCasa);
    }
}
