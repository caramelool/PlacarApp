package br.com.fiap.placarapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }

    public void comecarJogo(View view) {
        if (TextUtils.isEmpty(etTimeCasa.getText().toString().trim())) {
            showToast("Informe o time da casa");
            return;
        }

        if (TextUtils.isEmpty(etTimeVisitante.getText().toString().trim())) {
            showToast("Informe o time visitante");
            return;
        }

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(Common.EXTRA_TIME_CASA, etTimeCasa.getText().toString());
        intent.putExtra(Common.EXTRA_TIME_VISITANTE, etTimeVisitante.getText().toString());
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
