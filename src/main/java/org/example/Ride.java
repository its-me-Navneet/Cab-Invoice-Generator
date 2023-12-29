package org.example;

public class Ride {

    private double dis ;
    private double time ;

    public Ride(double dis, double time) {
        this.dis = dis;
        this.time = time;
    }

    public double getDis() {
        return dis;
    }

    public void setDis(double dis) {
        this.dis = dis;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
