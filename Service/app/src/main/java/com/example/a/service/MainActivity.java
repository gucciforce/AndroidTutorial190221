package com.example.a.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);
        Button btnStop = findViewById(R.id.btnStop);
        btnStop.setOnClickListener(this);
        */
        findViewById(R.id.btnStart).setOnClickListener(this);
        findViewById(R.id.btnStop).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnStart){
            Intent intent = new Intent(this, MyService.class);
            startService(intent);
        }else{
            Intent intent = new Intent(this, MyService.class);
            stopService(intent);
        }
    }
}
