import java.util.Random;

public class Exoskeleton extends Monster{
    public Exoskeleton(String na, int lev, int da, int def, double dod) {
        super(na, lev, da, def, dod);

        type = "exoskeleton";

    }


    @Override
    public int loseHP(int damage){
        int eff = 0;
        Random random = new Random();
        int temp = random.nextInt(10) + 1;
        // monster has a probability to dodge the attack
        if (temp < (int) (dodge*8)){
            System.out.println("Exoskeleton" + name + "has dodged an attack");
            return eff;
        } else{
            hp -= damage;
            if(hp <= 0){
                becomeFaint();
                System.out.println("Exoskeleton " + name + " has been killed. Good job!");
            }
        }
        return eff;
    }
}
