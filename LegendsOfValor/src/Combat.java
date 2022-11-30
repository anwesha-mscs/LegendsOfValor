import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

// when hero encounter a monster a combat happen
public class Combat {
	// hero party contain heroes
	private HeroParty heroParty;
	private ArrayList<Hero> heroes;


	// the hero which are currently moving
	private int ind;

	// the monster which are being hit
	private int tar;

	//monster list
	private ArrayList<Monster> monsterL;

	// contains all the monster which may occur
	private MonList monList;
	private int roundNum;

	private Random random;
	private Scanner scan;

	public Combat(HeroParty hp)
	{
		heroParty = hp;
		heroes = hp.getHeroParty();
		monsterL = new ArrayList<>();
		monList = new MonList();
		roundNum = 0;
		random = new Random();
		scan = new Scanner(System.in);

	}

	// the main function of battle
	public void fight(){
		prepareMonsters();
		oneTurn();
	}


	public boolean checkAce(){
		boolean Ace = false;
		int die = 0;
		for (int ace = 0; ace < heroes.size(); ace++) {
			if(heroes.get(ace).getwheFaint()){
				die++;
			}
		}
		if(die == heroes.size()){
			Ace = true;
			System.out.println(heroParty);
			System.out.println("All heros has been eliminated! You lose!");
			System.out.println("Good luck next time");

			System.exit(-65536);
		}
		return Ace;
	}

	// simple one turn here Hero Atk Mons Atk
	private int oneTurn(){
		roundNum++;

		System.out.println(heroParty);
		displayMonster();

		heroAttacks();
		if (checkPesticide()) {
			System.out.println("checked!!!");
			return roundNum;
		}monsterAttacks();
		checkAce();



		oneTurn();
		return roundNum;
	}

	// one hero attacks after choice
	private char doAtk(char atk){

		switch (atk) {
			// hero decided to attack
			case 'a':
				System.out.println("Hero " + heroes.get(ind).getName() + " decided to attack!");
				heroes.get(ind).causeDMG(monsterL.get(tar));
				break;
			// hero decided to change weapon
			case 'w':
				System.out.println("Hero " + heroes.get(ind).getName() + " decided to change weapon!");
				heroes.get(ind).changeCurrWeapon();
				break;
			// hero decided to change armor
			case 'r':
				System.out.println("Hero " + heroes.get(ind).getName() + " decided to change armor!");
				heroes.get(ind).changeCurrArmor();
				break;
			// hero decided to use a potion
			case 'p':
				System.out.println("Hero " + heroes.get(ind).getName() + " decided to use a potion!");
				heroes.get(ind).usePotion();
				break;
			// hero decided to cast a spell
			case 's':
				System.out.println("Hero " + heroes.get(ind).getName() + " decided to cast a spell!");
				heroes.get(ind).useSpell(monsterL.get(tar));
				break;

		}
		return atk;
	}

	// monster attack
	private char monsterAttacks(){

		for (int m = 0; m < monsterL.size(); m++){
			if (!monsterL.get(m).getwheFaint()) {
				int monsterTarget = m;
				// get the attack target
				if(!heroes.get(monsterTarget).getwheFaint()){
//					System.out.println("~~~~~~~~~upper");
					monsterL.get(m).causeDMG(heroes.get(monsterTarget));
				}else{
					for (int j = 0; j < heroes.size(); j++){
						if (!heroes.get(j).getwheFaint()) {
							monsterTarget = j;
							break;
						}
					}
					monsterL.get(m).causeDMG(heroes.get(monsterTarget));
				}
			}
		}

		return 'm';
	}

	// all the heroes attack
	private char heroAttacks(){

		tar = ind;
		if (!monsterL.get(ind).getwheFaint()){
			tar = ind;
		}else{
			for (int i = 0; i < monsterL.size(); i++){
				if (!monsterL.get(i).getwheFaint()) {
					tar = i;
					break;
				}
			}
		}

		for (int i = 0; i < heroes.size(); i++){
			if(!heroes.get(i).getwheFaint()){
//				action(i);
				ind=i;
				System.out.println("Dear " + heroes.get(ind).getName()+" What do you want to do?");
				System.out.println();
				String instr = "press 'a' to attack 'w' to change weapon 'r' to change armor 'p' to use potion 's' to cast a spell";


				char atk = Helper.getCharInput(instr);
				doAtk(atk);
			}
		}return 'g';
	}

	public Hero rewardHero(){

		for (Hero he : heroes) {
			he.setMoney(he.getMoney()+he.getLevel()*100);
//			he.setExperience(he.getExperience() + 64* he.level);
			he.setWheFaint(false);
			if (he.getHp()<1) {
				he.setHp((int) ((Math.abs(he.getHp())+200)*32));

			}else {
				he.setHp((int) (Math.abs(he.getHp())*1.6));
			}
			he.setMana((int) ((Math.abs(he.getMana())+200)*1.6));
			he.setHp(he.getHp()%32768);

//			if(he.getExperience() >= (he.getLevel()*10)){
//				he.levelUp();
//			}
		}

		return heroes.get(0);
	}

	public boolean checkPesticide(){
		boolean pest = false;
		int die = 0;
		for (int ace = 0; ace < monsterL.size(); ace++) {
			if(monsterL.get(ace).getwheFaint()){
				die++;
			}
		}
		if(die == heroes.size()){
			pest = true;
			System.out.println("All Monster has been eliminated! You win in this battle!");
			System.out.println("You earn some money and experience and recover some hp mana");

			displayMonster();
			rewardHero();

		}return pest;
	}


	public Monster prepareMonsters(){
		monsterL.clear();
		while (monsterL.size() < heroes.size()){
			int i = random.nextInt(monList.getMonsterList().size());
			monsterL.add(monList.getMonsterList().get(i));
		}
		System.out.println("\\\\\\\\\\ monster party reset !!!");
		System.out.println(monsterL);
		return monsterL.get(0);
	}
	// This function is in charge of showing monster's information
	public ArrayList displayMonster(){
		System.out.println("Monster Information");
		System.out.println("+-------------------------------------------------------------------------------------------+");
		System.out.println("No |        Name     | HP | Level  |  Damage  |  Defense | Dodge_Chance | Type | Status");
		//No |      Name     | HP | Level  |  Damage  |  Defense | Dodge_Chance | Type | Status
		//1    Andromalius         -20       3         550       450       0.25      spirit    3
		for (int i = 0; i < monsterL.size(); i++){
			System.out.printf("%-5s",(i+1));
			System.out.println(monsterL.get(i));
		}
		System.out.println("+------------------------------------------------------------------------------------------+" );
		return monsterL;
	}

}
