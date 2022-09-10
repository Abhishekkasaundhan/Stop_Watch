package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    private boolean IsRun = false;
    private long POS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                Chronometer chmeter = findViewById(R.id.customchmeter);
                Button btnStart = findViewById(R.id.btns);
                Button btnPause = findViewById(R.id.btnp);
                Button btnReset = findViewById(R.id.btnr);

                chmeter.setFormat("00:%s");
                chmeter.setBase(SystemClock.elapsedRealtime());

                btnStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!IsRun) {
                            chmeter.setBase(SystemClock.elapsedRealtime() - POS);
                            chmeter.start();
                            IsRun = true;
                        }
                    }
                });

                btnPause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (IsRun) {
                            chmeter.stop();
                            POS = SystemClock.elapsedRealtime() - chmeter.getBase();
                            IsRun = false;
                        }
                    }
                });

                btnReset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        chmeter.setBase(SystemClock.elapsedRealtime());
                        chmeter.stop();
                        POS = 0;
                        IsRun = false;
                    }
                });
    }
}