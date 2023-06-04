package com.example.shedulingalgorithm;

import java.io.Serializable;

public class ValuesForCalculation implements Serializable {
    String processName;
    double arrivalTime = 0;
    double burstTime;
    double turnaroundTimeC;
    double waitingTimeC;
    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setBurstTime(double burstTime) {
        this.burstTime = burstTime;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public void setTurnaroundTimeC(double turnaroundTimeC) {
        this.turnaroundTimeC = turnaroundTimeC;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public double getBurstTime() {
        return burstTime;
    }

    public String getProcessName() {
        return processName;
    }
}
