package com.company.obstacle;

public class Wall extends Obstacle{

    private double height;

    public Wall(double height) {
        this.height = height;
        type = Type.WALL;
    }

    public boolean overcome(double maxHeight){
        return height <= maxHeight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
