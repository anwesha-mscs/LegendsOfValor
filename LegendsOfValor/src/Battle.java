import java.util.ArrayList;

public class Battle {
    private ArrayList<Hero> heroList = new ArrayList<>();

    private ArrayList<Monster> monsterList = new ArrayList<>();
    //the lane in which the fight is occurring
    private int lane;
    private int monstersDead = 0;
    private int heroDead = 0;



    private int roundNum = 0;
    private int target = 0;
    private int index = 0;

    public int getRoundNum() {
        return roundNum;
    }

    public void setRoundNum(int roundNum) {
        this.roundNum = roundNum;
    }
    private ArrayList<Hero> deadHeroes = new ArrayList<>();

    public ArrayList<Hero> getHeroList() {
        return heroList;
    }

    public void setHeroList(ArrayList<Hero> heroList) {
        this.heroList = heroList;
    }

    public ArrayList<Monster> getMonsterList() {
        return monsterList;
    }

    public void setMonsterList(ArrayList<Monster> monsterList) {
        this.monsterList = monsterList;
    }

    public int getLane() {
        return lane;
    }

    public void setLane(int lane) {
        this.lane = lane;
    }

    public Battle(){

    }

    public Battle(ArrayList<Monster> monsters, ArrayList<Hero> heroes, int laneOrientation){
        this.lane = laneOrientation;
        this.monsterList = monsters;
        this.heroList = heroes;
        System.out.println("Battle s Herolist added");
    }

    public ArrayList<Hero> fightBattle() {
        roundNum++;
       // while (!checkAllMonstersDeath() || !checkAllHeroesDeath()) {
            System.out.println("Beginning round " + roundNum + " of battle");
            System.out.println(heroList);
            displayMonster();
            heroAttacks();
            if(checkAllMonstersDeath()){
                System.out.println("Success! All monsters in lane " +lane+ " have been defeated!");
            }
            monsterAttacks();
            if(checkAllHeroesDeath()){
                System.out.println("Uh-oh! All heroes in lane " +lane+ " have been defeated!");
                // regenerate the heroes again at nexus
            }
       // }
        return deadHeroes;
    }

    public boolean checkAllMonstersDeath(){
        boolean monstersTerminated = false;
        int die = 0;
        for (int countMon = 0; countMon < monsterList.size(); countMon++) {
            if(monsterList.get(countMon).getwheFaint()){
                die++;
            }
        }
        if(die == monsterList.size()){
            monstersTerminated = true;
            System.out.println("The Monsters you were fighting in lane " +this.lane  +"has been eliminated! You win this battle! \n Congratulations brave heroes!");
            System.out.println("You earn some money and experience and recover some hp and mana");

            displayMonster();
            rewardHero();

        }
        this.monstersDead = die;
        return monstersTerminated;
    }

    public boolean checkAllHeroesDeath(){
        boolean heroesDead = false;
        int die = 0;
        for (int heroCount = 0; heroCount < heroList.size(); heroCount++) {
            if(heroList.get(heroCount).getwheFaint()){
                die++;
                deadHeroes.add(heroList.get(heroCount));
            }
        }
        if(die == heroList.size()){
            heroesDead = true;
            System.out.println(heroList);
            System.out.println("All heroes in this lane have been eliminated! You lose this battle!");
            System.out.println("Do not fret mighty warrior! Enhance your skills and try again!");
        }
        this.heroDead = die;
        return heroesDead;
    }

    private char monsterAttacks(){

        for (int m = 0; m < monsterList.size(); m++){
            if (!monsterList.get(m).getwheFaint()) {
                int monsterTarget = m;
                // get the attack target
                if(!heroList.get(monsterTarget).getwheFaint()){
                    monsterList.get(m).causeDMG(heroList.get(monsterTarget));
                }else{
                    for (int j = 0; j < heroList.size(); j++){
                        if (!heroList.get(j).getwheFaint()) {
                            monsterTarget = j;
                            break;
                        }
                    }
                    monsterList.get(m).causeDMG(heroList.get(monsterTarget));
                }
            }
        }

        return 'm';
    }

    private char heroAttacks(){
        //make this user selected input. hard coded for now
            for (int i = 0; i < monsterList.size(); i++){
                if (!monsterList.get(i).getwheFaint()) {
                    target = i;
                    break;
                }
            }


        for (int i = 0; i < heroList.size(); i++){
            if(!heroList.get(i).getwheFaint()){
                index=i;
//                System.out.println("Dear " + heroList.get(index).getName()+" What do you want to do?");
                System.out.println("Dear H" + heroList.get(index).getDis()+" What do you want to do?");
                String instr = "press 'a' to attack 'w' to change weapon 'r' to change armor 'p' to use potion 's' to cast a spell";
                char atk = Helper.getCharInput(instr);
                doAtk(atk);
            }
        }return 'g';
    }

    private char doAtk(char atk){

        switch (atk) {
            // hero decided to attack
            case 'a':
                System.out.println("Hero H" + heroList.get(index).getDis() + " decided to attack!");
                heroList.get(index).causeDMG(monsterList.get(target));
                break;
            // hero decided to change weapon
            case 'w':
                System.out.println("Hero H" + heroList.get(index).getDis() + " decided to change weapon!");
                heroList.get(index).changeCurrWeapon();
                break;
            // hero decided to change armor
            case 'r':
                System.out.println("Hero H" + heroList.get(index).getDis() + " decided to change armor!");
                heroList.get(index).changeCurrArmor();
                break;
            // hero decided to use a potion
            case 'p':
                System.out.println("Hero H" + heroList.get(index).getDis() + " decided to use a potion!");
                heroList.get(index).usePotion();
                break;
            // hero decided to cast a spell
            case 's':
                System.out.println("Hero H" + heroList.get(index).getDis() + " decided to cast a spell!");
                heroList.get(index).useSpell(monsterList.get(target));
                break;

        }
        return atk;
    }

    public Hero rewardHero(){

        for (Hero hero : heroList) {
            hero.setMoney(hero.getMoney()+hero.getLevel()*100);
            hero.setExp(hero.getExp() + 64* hero.level);
            hero.setWheFaint(false);
            if (hero.getHp()<1) {
                hero.setHp((int) ((Math.abs(hero.getHp())+200)*32));

            }else {
                hero.setHp((int) (Math.abs(hero.getHp())*1.6));
            }
            hero.setMana((int) ((Math.abs(hero.getMana())+200)*1.6));
            hero.setHp(hero.getHp()%32768);

            if(hero.getExp() >= (hero.getLevel()*10)){
                hero.levelUp();
            }
        }

        return heroList.get(0);
    }

    public ArrayList displayMonster(){
        System.out.println("Hero Information");
        System.out.println("+-------------------------------------------------------------------------------------------+");
        System.out.println("No |        Name     | HP | Level  |  Damage  |  Defense | Dodge_Chance | Type | Status");
        //No |      Name     | HP | Level  |  Damage  |  Defense | Dodge_Chance | Type | Status
        //1    Andromalius         -20       3         550       450       0.25      spirit    3
        for (int i = 0; i < heroList.size(); i++){
            System.out.printf("%-5s",(i+1));
            System.out.println(heroList.get(i));
        }
        System.out.println("+------------------------------------------------------------------------------------------+" );

        System.out.println("/////////////////////");

        System.out.println("Monster Information");
        System.out.println("+-------------------------------------------------------------------------------------------+");
        System.out.println("No |        Name     | HP | Level  |  Damage  |  Defense | Dodge_Chance | Type | Status");
        //No |      Name     | HP | Level  |  Damage  |  Defense | Dodge_Chance | Type | Status
        //1    Andromalius         -20       3         550       450       0.25      spirit    3
        for (int i = 0; i < monsterList.size(); i++){
            System.out.printf("%-5s",(i+1));
            System.out.println(monsterList.get(i));
        }
        System.out.println("+------------------------------------------------------------------------------------------+" );
        return monsterList;
    }

    @Override
    public String toString() {

        String r= "Battle between [[";

        for (Hero h : heroList) {
            r+= "H";
            r+= h.getDis();
            r+= " ,";
        }

        r+="  and   ";

        for (Monster m : monsterList) {

            r+= "M";
            r+= m.getDis();
            r+= " ,";

        }

        r+="  ]]";


        return r;
    }
}
