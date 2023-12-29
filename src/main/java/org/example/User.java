package org.example;

import java.util.Objects;

public class User {
    private int noOfRide ;
    private  double totalFair ;
    private double avgFair ;

    public User(int noOfRide, double totalFair, double avgFair) {
        this.noOfRide = noOfRide;
        this.totalFair = totalFair;
        this.avgFair = avgFair;
    }

    public int getNoOfRide() {
        return noOfRide;
    }

    public void setNoOfRide(int noOfRide) {
        this.noOfRide = noOfRide;
    }

    public double getTotalFair() {
        return totalFair;
    }

    public void setTotalFair(double totalFair) {
        this.totalFair = totalFair;
    }

    public double getAvgFair() {
        return avgFair;
    }

    public void setAvgFair(double avgFair) {
        this.avgFair = avgFair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return noOfRide == user.noOfRide && Double.compare(totalFair, user.totalFair) == 0 && Double.compare(avgFair, user.avgFair) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(noOfRide, totalFair, avgFair);
    }
}
