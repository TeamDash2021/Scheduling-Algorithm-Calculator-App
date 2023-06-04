package com.example.shedulingalgorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShortestJobFirstSolution extends AppCompatActivity {

    TextView p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;

    TextView tTime,wTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shortest_job_first_solution);

        LinearLayout containerLayout = findViewById(R.id.containerLayout);
        containerLayout.removeAllViews();

        ArrayList<ValuesForCalculation> processes = (ArrayList<ValuesForCalculation>) getIntent().getSerializableExtra("valuesForCalculation");

        Collections.sort(processes, Comparator.comparingInt(t -> (int) t.arrivalTime));

        tTime = findViewById(R.id.avgTurnaroundTime);
        wTime = findViewById(R.id.avgWaitingTime);
        ArrayList<TextView> p = new ArrayList<>();
        ArrayList<TextView> a = new ArrayList<>();
        ArrayList<TextView> b = new ArrayList<>();

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

//

        // Create a copy of processes list to track completion status
        ArrayList<ValuesForCalculation> remainingProcesses = new ArrayList<>(processes);

        int currentTime = 0;
        int completedProcesses = 0;
        int n = processes.size();
        double waitingTime = 0;
        double turnaroundTime = 0;
        double totalWaitingTime = 0;
        double totalTurnaroundTime =0;
        double lastval = 0;
        for (int i = 0; i <= n; i++) {
            // Find the process with the shortest burst time among the arrived processes
            double shortestBurstTime = Integer.MAX_VALUE;
            int shortestProcessIndex = -1;

            for (int j = 0; j < remainingProcesses.size(); j++) {
                ValuesForCalculation currentProcess = remainingProcesses.get(j);
                if (currentProcess.arrivalTime <= currentTime && currentProcess.burstTime < shortestBurstTime) {
                    shortestBurstTime = currentProcess.getBurstTime();
                    shortestProcessIndex = j;
                }
            }

            ValuesForCalculation shortestProcess= new ValuesForCalculation();
            if (shortestProcessIndex == -1) {
                // No process is available, increase current time
                currentTime++;
            }

            else {
                shortestProcess = remainingProcesses.get(shortestProcessIndex);
                waitingTime = currentTime - shortestProcess.arrivalTime;
                turnaroundTime = waitingTime + shortestProcess.burstTime;
                totalWaitingTime += waitingTime;
                totalTurnaroundTime += turnaroundTime;
                currentTime += shortestProcess.burstTime;
                remainingProcesses.remove(shortestProcess);
                completedProcesses++;
            }

                p.get(i).setText(shortestProcess.getProcessName());
                a.get(i).setText("" + turnaroundTime);
                b.get(i).setText("" + waitingTime);

                View rectangle = new View(ShortestJobFirstSolution.this);
                rectangle.setBackgroundColor(Color.BLUE);
                int rectangleWidth = (int) getResources().getDimension(R.dimen.rectangle_width);
                int rectangleHeight = (int) getResources().getDimension(R.dimen.rectangle_height);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(rectangleWidth, rectangleHeight);
                layoutParams.setMargins(8, 0, 8, 0);
                rectangle.setLayoutParams(layoutParams);



                double firstvalue;
                if (shortestProcess.arrivalTime - lastval > 0) {
                    firstvalue = shortestProcess.arrivalTime;
                } else {
                    firstvalue = lastval;
                    lastval = shortestProcess.getArrivalTime() + turnaroundTime;
                }

                // Create a TextView for numbering
                TextView numberTextView = new TextView(ShortestJobFirstSolution.this);
                numberTextView.setText("                          " + (shortestProcess.getArrivalTime() + turnaroundTime));
                numberTextView.setTextColor(Color.BLACK);
                numberTextView.setGravity(Gravity.LEFT);
                numberTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

                TextView name = new TextView(ShortestJobFirstSolution.this);
                name.setText(shortestProcess.getProcessName());
                name.setTextColor(Color.GRAY);
                name.setGravity(Gravity.CENTER);
                name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

                // Create a LinearLayout to hold the box and the numbering
                LinearLayout itemLayout = new LinearLayout(ShortestJobFirstSolution.this);
                itemLayout.setOrientation(LinearLayout.VERTICAL);
                itemLayout.setGravity(Gravity.CENTER);
                itemLayout.addView(name);
                itemLayout.addView(rectangle);
                itemLayout.addView(numberTextView);
                // Add the itemLayout to the container layout
                containerLayout.addView(itemLayout);
            }

        double averageWaitingTime = totalWaitingTime / n;
        double averageTurnaroundTime = totalTurnaroundTime / n;

        tTime.setText(""+averageTurnaroundTime);
        wTime.setText(""+averageWaitingTime);
    }
}