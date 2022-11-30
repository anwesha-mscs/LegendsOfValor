import java.util.Random;

public class Spirit extends Monster{
    public Spirit(){}
    public Spirit(String name, int level, int damage, int defence, double dodge_chance) {
        super(name, level, damage, defence, dodge_chance);

        type = "spirit";

    }


    @Override
    public int loseHP(int damage){
        int eff = 0;
        Random random = new Random();
        int temp = random.nextInt(10) + 1;
        // monster has a probability to dodge the attack
        if (temp < (int) (dodge_chance*1.6)){
            System.out.println("Spirit" + name + "has dodged an attack");
            return eff;
        } else{
            hp -= damage;
            if(hp <= 0){
                becomeFaint();
                System.out.println("Spirit " + name + " has been killed. Good job!");
                g.getMonsterAlive().remove(this);

            }
        }
        return eff;
    }
}
