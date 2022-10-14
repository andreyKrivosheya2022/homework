package com.company.obstacle;

public class Road extends Obstacle{

    private double distance;

    public Road(double distance){
        this.distance = distance;
        type = Type.ROAD;
    }

    public boolean overcome(double maxDistance){
        return maxDistance >= distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

}
