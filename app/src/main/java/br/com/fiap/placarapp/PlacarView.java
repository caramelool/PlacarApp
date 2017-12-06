package br.com.fiap.placarapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by lucascaramelo on 06/12/17.
 */

public class PlacarView extends LinearLayout {

    private TextView tvTimeName;
    private TextView tvTimeGol;
    private Button btnGol;

    private Time time;

    public PlacarView(Context context) {
        super(context);
        init();
    }

    public PlacarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PlacarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_placar, this);
        setOrientation(VERTICAL);

        tvTimeName = findViewById(R.id.tvTimeName);
        tvTimeGol = findViewById(R.id.tvTimeGol);
        btnGol = findViewById(R.id.btnGol);
    }

    public void setTime(Time time) {
        this.time = time;
        tvTimeName.setText(time.getName());
        tvTimeGol.setText(String.valueOf(time.getGols()));
        btnGol.setOnClickListener(onGolClickListener);
    }

    private OnClickListener onGolClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            time.gol();
            tvTimeGol.setText(String.valueOf(time.getGols()));
        }
    };
}
