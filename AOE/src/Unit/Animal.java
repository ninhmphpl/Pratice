package Unit;

import Action.*;

public class Animal implements Unit{
    private String name;
    private int hp;
    private int speed;
    private double x, y;
    private Action action;

    public Animal(String name, int hp, int speed) {
        this.hp = hp;
        this.name = name;
        this.speed = speed;
        this.x = -1;
        this.y = -1;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public double[] getLocation() {
        return new double[]{x, y};
    }

    public void move(int x, int y){
        if(action != null){
            action.exit();
        }
        action = new MoveAction(this, x, y );
        action.start();

    }

    public void follow(Animal animal){
        if(action != null){
            action.exit();
        }
        action = new FollowAction(this, animal);
        action.start();
    }

}
