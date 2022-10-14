package com.company;

import com.company.obstacle.Obstacle;
import com.company.obstacle.Road;
import com.company.obstacle.Wall;
import com.company.players.Cat;
import com.company.players.Person;
import com.company.players.Player;
import com.company.players.Robot;

public class Main {

    public static void main(String[] args) {
        Player[] players = {new Cat("Барсик", 100., 0.),
                new Person("Никита", 50., 10.),
                new Robot("Омега", 1000., 100.)};

        Obstacle[] obstacles = {new Road(10.),
                new Wall(10.),
                new Road(75.)};

        for (Player player : players){
            for (Obstacle obstacle : obstacles){
                if (!player.obstacle(obstacle)) break;
            }
            System.out.print("\n\n\n");
        }
    }
}
