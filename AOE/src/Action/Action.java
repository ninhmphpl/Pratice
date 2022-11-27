package Action;

public class Action extends Thread{
    boolean active = true;
    public void exit(){
        active = false;
    }
}
