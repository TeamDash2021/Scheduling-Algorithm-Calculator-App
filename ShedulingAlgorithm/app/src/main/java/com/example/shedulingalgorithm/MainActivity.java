package com.example.shedulingalgorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button fcfs,sjf,pbs,rra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fcfs = findViewById(R.id.button);
        sjf = findViewById(R.id.sjf);
        pbs = findViewById(R.id.pbs);
        rra = findViewById(R.id.rra);
        fcfs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FirstComeFirstServe.class));
            }
        });
        sjf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ShortestJobFirst.class));
            }
        });
        pbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,PriorityBasedSheduling.class));
            }
        });
        rra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RoundRobin.class));
            }
        });
    }
}