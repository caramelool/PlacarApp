package br.com.fiap.placarapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etTimeCasa;
    private EditText etTimeVisitante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTimeCasa = findViewById(R.id.etTimeCasa);
        etTimeVisitante = findViewById(R.id.etTimeVisitante);

        if (savedInstanceState != null) {
            etTimeCasa.setText(savedInstanceState.getString(Extras.EXTRA_TIME_CASA));
            etTimeVisitante.setText(savedInstanceState.getString(Extras.EXTRA_TIME_VISITANTE));
        }
    }

    public void comecarJogo(View view) {
        if (TextUtils.isEmpty(etTimeCasa.getText().toString().trim())) {
            etTimeCasa.requestFocus();
            showToast(getString(R.string.alert_home_empty));
            return;
        }

        if (TextUtils.isEmpty(etTimeVisitante.getText().toString().trim())) {
            etTimeVisitante.requestFocus();
            showToast(getString(R.string.alert_guest_empty));
            return;
        }

        Time timeCasa = new Time(etTimeCasa.getText().toString());
        Time timeVisitante = new Time(etTimeVisitante.getText().toString());

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(Extras.EXTRA_TIME_CASA, timeCasa);
        intent.putExtra(Extras.EXTRA_TIME_VISITANTE, timeVisitante);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        etTimeCasa.setText("");
        etTimeVisitante.setText("");
        etTimeCasa.clearFocus();
        etTimeVisitante.clearFocus();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Extras.EXTRA_TIME_CASA, etTimeCasa.getText().toString());
        outState.putString(Extras.EXTRA_TIME_VISITANTE, etTimeVisitante.getText().toString());
    }

    private boolean isFormValid() {
        if (TextUtils.isEmpty(etTimeCasa.getText().toString().trim())) {
            showToast("Informe o time da casa");
            return false;
        } else if (TextUtils.isEmpty(etTimeVisitante.getText().toString().trim())) {
            showToast("Informe o time visitante");
            return false;
        }
        return true;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
