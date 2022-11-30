import java.util.Random;

public class Dragon extends Monster{
    public Dragon() {
        super();
    }
    public Dragon(String name, int level, int base_damage, int defence, double dodge_chance) {
        super(name, level, base_damage, defence, dodge_chance);
        type = "dragon";
    }

@Override
    public int loseHP(int damage){
        int eff = 0;
        Random random = new Random();
        int temp = random.nextInt(10) + 1;
        // monster has a probability to dodge the attack
        if (temp < (int) (dodge_chance*0.16)){
            System.out.println("Dragon" + name + "has dodged an attack");
            return eff;
        } else{
            hp -= damage;
            if(hp <= 0){
                becomeFaint();
                System.out.println("Dragon " + name + " has been killed. Good job!");
                g.getMonsterAlive().remove(this);

            }
        }
        return eff;
    }
}
