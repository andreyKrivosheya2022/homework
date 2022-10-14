package com.company.players;

import com.company.obstacle.Obstacle;
import com.company.obstacle.Road;
import com.company.obstacle.Wall;

public class Player {

    private String name;
    private double maxDistance, maxHeight, distance = 0.;

    Player(String name, double maxDistance, double maxHeight){
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }

    private void complete(String nameObstacle){
        System.out.printf("Участник %s прешёл препядствие %s на дистанции %.2f\n", name, nameObstacle, distance);
    }

    private void noComplete(String nameObstacle){
        System.out.printf("Участник %s не прешёл препядствие %s на дистанции %.2f.\n[+] Пройдено %.2f", name, nameObstacle, distance, distance);
    }

    public boolean obstacle(Obstacle obst){
        if(obst.isWall())
            return jump(obst);
        else
            return run(obst);
    }

    private boolean run(Obstacle obst){
        if (((Road) obst).overcome(maxDistance)){
            distance += ((Road) obst).getDistance();
            complete("беговая дорожка");
            return true;
        }
        else{
            distance = maxDistance;
            noComplete("беговая дорожка");
            return false;
        }
    }

    private boolean jump(Obstacle obst){
        if (((Wall) obst).overcome(maxHeight)){
            complete("стена");
            return true;
        }
        else{
            noComplete("стена");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
