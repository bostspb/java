package lesson08.model;

import lesson08.Tools;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 07.10.2021
 */

public class Enemy {

    private int health;
    private int power;
    private int x;
    private int y;

    private int enemyValueMin = 20;
    private int enemyValueMax = 50;

    private int countEnemies;

    public Enemy(int countEnemies) {
        this.health = Tools.randomValue(enemyValueMin, enemyValueMax);
        this.power = Tools.randomValue(enemyValueMin, enemyValueMax);
        this.countEnemies = countEnemies;
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getHealth(){
        return health;
    }

    public int getPower() {
        return power;
    }

    public void decreaseHealth(int value) {
        this.health -= value;
    }

    public boolean isExistEnemies() {
        return countEnemies > 0;
    }

    public int getCountEnemies() {
        return countEnemies;
    }

    public void killEnemy(){
        --countEnemies;
    }
}

