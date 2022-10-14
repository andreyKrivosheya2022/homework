package com.company.obstacle;

public class Obstacle {
    Type type;

    enum Type{
        ROAD,
        WALL
    }

    public boolean isWall(){
        return type == Type.WALL;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

