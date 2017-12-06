package br.com.fiap.placarapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by lucascaramelo on 06/12/17.
 */

public class PlacarView extends LinearLayout {

    private TextView tvTimeName;
    private TextView tvTimeGol;

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

        tvTimeName = (TextView) findViewById(R.id.tvTimeName);
        tvTimeGol = (TextView) findViewById(R.id.tvTimeGol);
        findViewById(R.id.btnGol).setOnClickListener(onGolClickListener);
    }

    public void setTime(Time time) {
        this.time = time;
        tvTimeName.setText(time.getName());
        tvTimeGol.setText(String.valueOf(time.getGols()));
    }

    private OnClickListener onGolClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            time.gol();
            tvTimeGol.setText(String.valueOf(time.getGols()));
        }
    };
}
