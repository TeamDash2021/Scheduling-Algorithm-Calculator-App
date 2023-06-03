package com.example.shedulingalgorithm;

import java.io.Serializable;

public class ValuesForCalculationBasedOnPriorities implements Serializable {
    String processName;
    double arrivalTime = 0;
    double burstTime;
    double priority;

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setBurstTime(double burstTime) {
        this.burstTime = burstTime;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public void setPriority(double priority) {
        this.priority = priority;
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

    public double getPriority() {
        return priority;
    }
}
