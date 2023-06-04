package com.example.shedulingalgorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class RoundRobin extends AppCompatActivity {

    EditText numberOfProcesses,quantumNumber;
    EditText p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    Button solve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_robin);

        numberOfProcesses = findViewById(R.id.nofprocesses);
        quantumNumber = findViewById(R.id.qnumber);
        solve = findViewById(R.id.solve);
        String v = numberOfProcesses.getText().toString();

        ArrayList<EditText> p = new ArrayList<>();
        ArrayList<EditText> a = new ArrayList<>();
        ArrayList<EditText> b = new ArrayList<>();
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        p4 = findViewById(R.id.p4);
        p5 = findViewById(R.id.p5);
        p6 = findViewById(R.id.p6);
        p7 = findViewById(R.id.p7);
        p8 = findViewById(R.id.p8);
        p9 = findViewById(R.id.p9);
        p10 = findViewById(R.id.p10);
        p11 = findViewById(R.id.p11);
        p12 = findViewById(R.id.p12);
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        p.add(p6);
        p.add(p7);
        p.add(p8);
        p.add(p9);
        p.add(p10);
        p.add(p11);
        p.add(p12);

        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        a5 = findViewById(R.id.a5);
        a6 = findViewById(R.id.a6);
        a7 = findViewById(R.id.a7);
        a8 = findViewById(R.id.a8);
        a9 = findViewById(R.id.a9);
        a10 = findViewById(R.id.a10);
        a11 = findViewById(R.id.a11);
        a12 = findViewById(R.id.a12);
        a.add(a1);
        a.add(a2);
        a.add(a3);
        a.add(a4);
        a.add(a5);
        a.add(a6);
        a.add(a7);
        a.add(a8);
        a.add(a9);
        a.add(a10);
        a.add(a11);
        a.add(a12);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b10 = findViewById(R.id.b10);
        b11 = findViewById(R.id.b11);
        b12 = findViewById(R.id.b12);
        b.add(b1);
        b.add(b2);
        b.add(b3);
        b.add(b4);
        b.add(b5);
        b.add(b6);
        b.add(b7);
        b.add(b8);
        b.add(b9);
        b.add(b10);
        b.add(b11);
        b.add(b12);

        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(RoundRobin.this, "chalra", Toast.LENGTH_SHORT).show();
                String v = numberOfProcesses.getText().toString();
                String quantumN="";
                if(quantumNumber.getText().toString().trim().isEmpty())
                {
                    quantumNumber.setError("this can't be empty");
                }
                else {
                    quantumN = quantumNumber.getText().toString();
                }
                int nofp = 0;
                if(numberOfProcesses.getText().toString().trim().isEmpty())
                {
                    numberOfProcesses.setError("these can't be empty");
                }
                else {
                    nofp = Integer.parseInt(v);
                }
                ArrayList<ValuesForCalculation> values = new ArrayList<>();
                int count =0;
                for(int i =0;i<nofp;i++)
                {
                    ValuesForCalculation vd = new ValuesForCalculation();
                    if(p.get(i).getText().toString().trim().isEmpty())
                    {
                        p.get(i).setError("this can't be empty");
                        count++;
                    }
                    else {
                        vd.setProcessName(p.get(i).getText().toString());
                    }
                    if(b.get(i).getText().toString().trim().isEmpty())
                    {
                        b.get(i).setError("this can't be empty");
                        count++;
                    }
                    else {
                        vd.setBurstTime(Double.parseDouble(b.get(i).getText().toString()));
                    }
                    if(a.get(i).getText().toString().trim().isEmpty())
                    {
                        vd.setArrivalTime(0);
                    }
                    else {
                        vd.setArrivalTime(Double.parseDouble(a.get(i).getText().toString()));
                    }

                    values.add(vd);
                }
                if(numberOfProcesses.getText().toString().trim().isEmpty() == false && count==0){
                    Intent intent = new Intent(RoundRobin.this,RoundRobinSolution.class);
                    intent.putExtra("quantumNumber",quantumN);
                    intent.putExtra("valuesForCalculation", values);
                    startActivity(intent);
                }
            }
        });

    }
}