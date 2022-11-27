package Action;

import Unit.Animal;

public class MoveAction extends Action {
    Animal animal;
    double x2, y2;

    public MoveAction(Animal animal, double x, double y) {
        this.animal = animal;
        this.x2 = x;
        this.y2 = y;
    }
    public void move() throws Exception {
        while (active){
            double[] locationUnit = animal.getLocation();
            double x1 = locationUnit[0];
            double y1 = locationUnit[1];
            float speed = animal.getSpeed();
            double u1 = x2 - x1;
            double u2 = y2 - y1;
            double range = Math.sqrt(Math.pow(u1, 2) + Math.pow(u2, 2));
            System.out.println(animal.getName() + ":" + ((int)range) + "(" + x2 + "," + y2 + ")");
            if (range > 10) {
                double t = speed / range;
                x1 += u1*t;
                y1 += u2*t;
                animal.setLocation(x1,y1);
                System.out.println(animal.getName() + "Moving");
                sleep(1000);
            }else break;

        }
    }


    @Override
    public void run() {
        try {
            move();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(animal.getName() + " : Done");
    }


}
