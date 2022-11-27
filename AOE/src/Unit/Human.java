package Unit;

public class Human extends Animal{
    private int atk;
    private int def;

    public Human(String name, int hp, int atk, int def, int speed) {
        super(name, hp, speed);
        this.atk = atk;
        this.def = def;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void plusAtk(int amount){
            this.atk += amount;
    }
    public void minusAtk(int amount){
        this.atk -= amount;
        if (atk <= 0){
            atk = 0;
        }
    }

    public void plusDef(int amount){
        this.def += amount;
    }
    public void minusDef(int amount){
        this.def -= amount;
        if (def <= 0){
            def = 0;
        }
    }
}
