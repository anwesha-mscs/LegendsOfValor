import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

//abstract class hero to be inheritenced
public abstract class Hero extends Role {

	protected int mana;

	protected static ArrayList<Hero> heroes;

	//strength
	protected int stren;
	
	//agility
	protected int agi;
	
	//dexterity
	protected int dex;
	
	protected int money;
	
	protected int exp;
	
	// the hands that a hero can use
	protected int hand = 2;
	
	protected String type;
	
	protected Weapon weap;
	
	protected Armour armor;

//	private temp =
	
	protected ArrayList<Armour> armorL;
	
	protected ArrayList<Weapon> weaponL;
	
	protected ArrayList<Potion> potionL;
	
	protected ArrayList<Spell> spellL;

	// this class can help to add or remove item
	protected ItemContainer itemContainer;

	protected Scanner scan;

	public Hero(String n, int le, int def,int ma,int st, int ag,int de,int m,int ex){

		super(n, le, def);

		potionL = new ArrayList<>();
		spellL = new ArrayList<>();
		armorL = new ArrayList<>();
		weaponL = new ArrayList<>();

		itemContainer =new ItemContainer(armorL,weaponL,potionL,spellL);

		mana =ma;
		stren = st;
		agi = ag;
		dex =de;
		money = m;
		exp = ex;

		//try to cheat here
		hp*=64;
		money+=1024;
		level =1024;
		stren +=level;

		weap = null;
		armor = null;
		
		scan = new Scanner(System.in);

	}

	//getter and setter Here
		public int getMana() {return mana;}

		public int getStren() {return stren;}

		public int getAgi() {return agi;}

		public int getDex() {return dex;}

		public int getMoney() {return money;}

		public int getExp() {return exp;}

		public int getHand() {return hand;}

		public String getType() {return type;}

		public Weapon getWeap() {return weap;}

		public Armour getArmor() {return armor;}

		public void setMana(int mana) {this.mana = mana;}

		public void setStren(int stren) {this.stren = stren;}

		public void setAgi(int agi) {this.agi = agi;}

		public void setDex(int dex) {this.dex = dex;}

		public void setMoney(int money) {this.money = money;}

		public void setExp(int exp) {this.exp = exp;}

		public void setHand(int hand) {this.hand = hand;}

		public void setWeap(Weapon weap) {this.weap = weap;}

		public void setArmor(Armour armor) {this.armor = armor;}

		public void setType(String type) {this.type = type;}

	public ArrayList<Armour> getArmour()
	{
		return armorL;
	}
	public ArrayList<Weapon> getWeaponry()
	{
		return weaponL;
	}
	public ArrayList<Potion> getPotionL()
	{
		return potionL;
	}
	public ArrayList<Spell> getSpellL()
	{
		return spellL;
	}

	public void setArmour(ArrayList<Armour> armors) {this.armorL = armors;}
	public void setPotionL(ArrayList<Potion> potionL) {this.potionL = potionL;}
	public void setSpellL(ArrayList<Spell> spellL) {this.spellL = spellL;}
	public void setWeaponry(ArrayList<Weapon> weapons) {this.weaponL = weapons;}


	// when hero attack the monster
	public void causeDMG(Monster mon){
		int dmg = 0;
		if (weap != null){
			// weapon will increase the damage
			dmg = (int) ((weap.getDamage() + stren) * 0.08);
		} else{
			dmg = (int) (stren * 0.08);
		}
		mon.loseHP(dmg);
		System.out.println("Hero " + name + " has caused " + dmg + " damage to monster " + mon.getName() + " .");
	}

	// heros can be hurt by monster
	public int loseHP(int dmg){
		int eff = 0;
		Random random = new Random();
		int temp = random.nextInt(10) + 1;

		if (temp < (int) (agi *0.0016)){
			System.out.println(name + " has successfully dodge a attack from the monster!");
			return eff;
		} else{
			if(armor ==null){
				eff = dmg;
			}else {
				eff = (int) (dmg - armor.getReductionRate()*0.04);

			}
			if (eff >= 0){
				hp -= eff;
			}
			// hero been killed
			if(hp <= 0){
				becomeFaint();
				System.out.println("Oh no !!! Hero " + name + " has been eliminated");
			}
		}
		return eff;
	}

	public static 	ArrayList<Hero> connectHeroParty(ArrayList<Hero> he){

		heroes = he;
		return heroes;
	}


	public char oneTurn(){
		// let player choose what to do next
		System.out.println(getDis() +" What do you want to do next?");
		String instruction = "'q' to quit 'h' to display your information 'w' ,'a','s','d', to move 't' to teleport 'r' to recall 'p' to pass";
		char c = Helper.getCharInput(instruction);

		boolean ret = false;

//		if (checkMovementValidity(c)) {
			switch (c){
				case 'h':
					System.out.println(this);

					break;
				case 'q':
					System.out.println("Good bye see you next time!");
					System.exit(-16384);
				case 'r':
					ret = recall();
					break;
				case 't':
					ret = teleport();
					break;
				case 'w':
				case 'a':
				case 's':
				case 'd':
					ret = updateLocation(c);
					break;
				case 'p':
					ret = true;
//			}

		}

		if (ret) {
			return c;
		}else {
			System.out.println("The decision you've made isn't valid ,please try again.");
			return oneTurn();
//						c = Helper.getCharInput(instruction);

		}
//		System.out.println();

		//main loop of the whole game
//		while (true){





//		}

//		return c;
	}

	public int getLaneOri(){
		return laneOri;
	}



	private boolean teleport() {

		int seq=0;

		for (Hero hero : heroes) {
			if (hero!=this) {
				if (laneCurr!= hero.laneCurr) {
					System.out.print("Do you want to move near" + hero.getDis()+" ? 'y' for yes 'n' for no");

					char r= Helper.getCharInput("'y' for yes 'n' for no");
					if (r=='y') {
						char sec = Helper.getCharInput("Where do you want to move? 'b' for beside 'a' for after");

						if (sec=='b') {
							int beside = (hero.y%3 %2 ==0 ?1:0) + (hero.laneCurr-1) * 3;
//							System.out.println("map:"+map);

							System.out.println("Beside:  "+beside+"y"+ map.grid[beside][hero.x].isHasHero()+" has hero.");
							System.out.println("hero location: "+hero.x +" " + hero.y);
							System.out.println("beside location: "+hero.x +" " + beside);
							System.out.println("my location: "+x +" " + y);
							if(!map.grid[beside][hero.x].isHasHero()){
//								System.out.println("Beside"+hero.getDis()+" there isn't any hero you can teleport");
								System.out.println(getDis()+" try to teleport beside "+hero.getDis());

								return leaveEnter(hero.x,beside);
//								return true;
							}else {
								System.out.println("Teleport failed,there already has hero");
								return false;
							}
						}else {

							System.out.println(getDis()+" try to teleport behind "+hero.getDis());
							return leaveEnter(hero.x+1, hero.y);

						}


//						System.out.println("Where do you want to move? 'b' for beside 'a' for after");
					}
//					return true;
				}
			}
		}


		System.out.println("You didn't choose any hero destination to teleport");
		return false;
	}


	// to be complete
	private boolean leaveEnter(int enterx,int entery){

		try {
			char type= map.grid[enterx][entery].getType();
			if(type=='X'){
				System.out.println("The location you selected is an inaccessible area. You can't enter");
				return false;
			} else if (map.grid[enterx][entery].isHasHero()) {
				System.out.println("There is already a hero there! You can not enter it.");
				return false;
			}

		} catch (Exception e) {
//			throw new RuntimeException(e);
			System.out.println(e.getMessage());
			System.out.println(e);
			System.out.println("The place you want to enter has out of bound!");
			return false;
		}

		System.out.println("Leave enter:");

		System.out.println(getDis()+"Before x y:"+x+y);
		map.grid[x][y].setHasHero(false);
		map.grid[enterx][entery].setHasHero(true);

		x=enterx;
		y=entery;

		laneCurr = y/3 +1;



		System.out.println(getDis()+"after x y: "+x+y);
		return true;
	}

	private boolean recall() {

		System.out.println("Try to recall to "+getDis()+"  home");
		return 	leaveEnter(7,(laneOri-1)*3);

	}

	private boolean checkMovementValidity(char move){


		switch (move){
			case 't':
				for (Hero hero : heroes) {
					if (hero!=this) {
						System.out.println("Lane:"+laneCurr +" "+ hero.laneCurr);
						if (laneCurr!= hero.laneCurr) {
							return true;
						}
					}
//					System.out.println();
					System.out.println("All hero in one lane!  no move available");
				}return false;



		}


		return false;
	}

	private boolean updateLocation(char c) {

		boolean re=false;

		switch (c){
			case 'w':
				re = leaveEnter(x-1,y);
				break;
			case 's':
				re =leaveEnter(x+1,y);
				break;
			case 'a':
				re =leaveEnter(x,y-1);
				break;
			case 'd':
				re =leaveEnter(x,y+1);

		}

		return re;
	}

	// basic levelup here 
	public void levelUp()
	{
		mana = (int) Math.floor(mana*1.2);
		exp -= level*64;
		if(exp < 0){
			exp =0;
		}
	}


	// when the hero receive item or drop item
	public Item recItem(Item e){
		itemContainer.recItem(e);
		return e;
	}
	public Item remoItem(Item e){
		itemContainer.removeItem(e);
		return e;
	}



	// heros can change their weapon
	public void changeCurrWeapon(){
		if (weaponL.size() == 0){
			System.out.println("You must own a weapon first and then wear a weapon");
		}else{
			System.out.println("Here is your weapon list , choose one to equip");

			System.out.println("+-------------------------------------------------------------------------------+");
			System.out.println("    Name     | Price  |  Level  |  Damage | Required_Hands");
			System.out.println("+-------------------------------------------------------------------------------+");
			// show all weapon
			for (Weapon w: weaponL){
				System.out.println(w);
			}
			System.out.println("+-------------------------------------------------------------------------------+");

			System.out.println("Choose the weapon you want using number ");
			int num = scan.nextInt();
			if(hand < weaponL.get(num-1).getHaNe()){
				System.out.println("Sorry! Your hand number are too low to equip it");
			}else {
				weap = weaponL.get(num-1);
				System.out.println("Successfully change ! Your current weapon is " + weap.getName() + " now!");
			}
		}
	}

	// heros can change their armor
	public void changeCurrArmor(){
		if (armorL.size() == 0){
			System.out.println("You must own a armor first and then to use it");
		}else{
			System.out.println("Here is your armor list. Choose one to equip.");
			System.out.println("+--------------------------------------------------------+");
			System.out.println("    Name     | Price  |  Level  |  Damage_Reduction ");
			System.out.println("+--------------------------------------------------------+");
			for (Armour a: armorL){
				System.out.println(a);
			}
			System.out.println("+----------------------------------------------------------+");

			System.out.println("Choose the armor you want using number");
			int num = scan.nextInt();
			armor = armorL.get(num-1);
			System.out.println("Successfully change !Your current armor is " + armor.getName() + " now!");
		}
	}

	// heros can use a potion
	public void usePotion(){
		if (potionL.size() == 0){
			System.out.println("You must own a potion first and then to use it");
		}else{
			System.out.println("Here is your potion list. Choose one to use.");

			System.out.println("+-----------------------------------------------------------------------+");
			System.out.println("    Name     | Price  |  Level  |  Increased_Value | Increased_Attribute ");
			System.out.println("+-----------------------------------------------------------------------+");
			// print the potion inventory of the hero
			for (Potion p: potionL){
				System.out.println(p);
			}

			System.out.println("+-----------------------------------------------------------------------+");

			System.out.println("Choose the potion you want using number");
			int num = scan.nextInt();

			// deal with the effect of the potion
			if (potionL.get(num-1).getAttr().contains("Health")) {
				hp += potionL.get(num-1).getVal();
			}
			if (potionL.get(num-1).getAttr().contains("Strength")) {
				stren += potionL.get(num-1).getVal();
			}
			if (potionL.get(num-1).getAttr().contains("Mana")) {
				mana += potionL.get(num-1).getVal();
			}
			if (potionL.get(num-1).getAttr().contains("Agility")) {
				agi += potionL.get(num-1).getVal();
			}
			if (potionL.get(num-1).getAttr().contains("Dexterity")) {
				dex += potionL.get(num-1).getVal();
			}
			if (potionL.get(num-1).getAttr().contains("Defense")) {
				def += potionL.get(num-1).getVal();
			}

			System.out.println("Successfully use! Your " + potionL.get(num-1).getName() + " potion has come into effect!");
			potionL.remove(potionL.get(num-1));
		}
	}

	// heros can cast a spell
	public void useSpell(Monster mon) {
		if (spellL.size() == 0) {
			System.out.println("You must own a spell first and then to use it");
		} else {
			System.out.println("Here is your spell list. Choose one to use.");
			System.out.println("+--------------------------------------------------------------+");
			System.out.println("    Name     | Price  |  Level  |  Damage | Mana_Cost | Type");
			System.out.println("+--------------------------------------------------------------+");
			// print the spell inventory of the hero
			for (Spell s : spellL) {
				System.out.println(s);
			}
			System.out.println("+---------------------------------------------------------------+");
			System.out.println("Choose the spell you want using number");
			int num = scan.nextInt();
			if (spellL.get(num-1).getManaCost() > mana){
				System.out.println("You don't have enough mana to use the spell");
			}else{
				mana -= spellL.get(num-1).getManaCost();

				if (spellL.get(num-1).getType().equals("fire")){
					mon.setDmg((int)(mon.getDmg()*0.8));
				}
				else if(spellL.get(num-1).getType().equals("ice"))
					mon.setDef((int)(mon.getDef()*0.8));
				else
					mon.setDodge((int)(mon.getDodge()*0.8));

				int eff = (int) (spellL.get(num-1).getDamage()*(1 + dex / 10000));
				mon.loseHP(eff);
				System.out.println("Successfully use!!! You have used spell " + spellL.get(num-1).getName() + " to monster " + mon.getName() + " !");
				spellL.remove(spellL.get(num-1));
			}
		}
	}

	@Override
	public String toString() {


		String concate="";
		concate+=String.format("%-22s",getName());
		concate+=String.format("%-10s",getHp());
		concate+=String.format("%-10s",getLevel());
		concate+=String.format("%-10s",getMana());
		concate+=String.format("%-10s", getStren());
		concate+=String.format("%-10s", getAgi());
		concate+=String.format("%-10s", getDex());
		concate+=String.format("%-10s",getMoney());
		concate+=String.format("%-10s",getExp());
		concate+=String.format("%-10s",getType());
		concate+=String.format("%-10s", getwheFaint());


		return concate;
	}
}


