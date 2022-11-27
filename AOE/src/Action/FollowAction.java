package Action;

import Unit.Animal;

public class FollowAction extends Action{
    Animal unit1;
    Animal unit2;

    public FollowAction(Animal unit1, Animal unit2) {
        this.unit1 = unit1;
        this.unit2 = unit2;
    }
    public void follow() throws Exception {
        while(active){
            double[] l1 = unit1.getLocation();
            double[] l2 = unit2.getLocation();
            double x1 = l1[0], y1 = l1[1], x2 = l2[0], y2 = l2[1];
            double u1 = x2 - x1, u2 = y2 - y1;
            double range = Math.sqrt(u1 * u1 + u2 * u2);
            System.out.println(unit1. getName() + ":" + ((int)range));
            if (range > 10) {
                double t = unit1.getSpeed() / range;
                x1 += u1 * t;
                y1 += u2 * t;
                unit1.setLocation(x1, y1);
                System.out.println(unit1.getName() + "Moving..\n");
                sleep(1000);
            }else {
                return;
            }
        }
    }


    @Override
    public void run() {
        try {
            follow();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(unit1.getName() + " : Done");
    }
}
