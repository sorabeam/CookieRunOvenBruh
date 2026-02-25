package Beam.Cookies;

import javafx.scene.image.ImageView;

public abstract class Cookie {

    protected ImageView cookie;
    int id;
    int hp;
    int score = 0;

    String Bid;
    String Sid;
    String name;
    String desc;

    public Cookie(int id,String name,int hp, String desc) {
        this.id = id;
        this.hp = hp;
        Bid = "B" + id;
        Sid = "S" + id;
        this.name = name;
        this.desc = desc;
    }

    public int get_Id() { return id; }
    public int get_Hp() { return hp; }
    public String get_Bid() { return Bid; }
    public String get_Sid() { return Sid; }
    public String get_Name() { return name; }
    public String get_Desc() { return desc; }
    public int get_Score() {return score;}

    public void setScore(int score) {
        this.score = score;
    }

    public abstract void useSkill();

    public void takeDamage(int damage){
        hp -= damage;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void heal(int healunit){
        hp += healunit;
    }

    public void die(){

    }
}
