import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

// the market class try to do transaction with the player
public class Market {

	//item list below
	private ArrayList<Armour> armorL;

	private ArrayList<Potion> potionL;

	private ArrayList<Spell> spellL;
	private ArrayList<Weapon> weaponL;

	private Hero he;

	// this class can help to add or remove item
	protected ItemContainer itemContainer;

	// try to interrupt scan in
	protected Item pass;

	// the current hero who has visited this market

	// constructor
	public Market() {
		armorL = new ArrayList<>();
		weaponL = new ArrayList<>();
		potionL = new ArrayList<>();
		spellL = new ArrayList<>();

		itemContainer =new ItemContainer(armorL,weaponL,potionL,spellL);

		pass = new Potion("Healing_Potion", 250, 1, 100, "Health");
		// add enough stuff to the market

		weaponL.add(new Weapon("Sword", 500, 1, 800, 1));
		weaponL.add(new Weapon("Bow", 300, 2, 500, 2));
		weaponL.add(new Weapon("Scythe", 1000, 6, 1100, 2));
		weaponL.add(new Weapon("Axe", 550, 5, 850, 1));
		weaponL.add(new Weapon("TSwords", 1400, 8, 1600, 2));
		weaponL.add(new Weapon("Dagger", 200, 1, 250, 1));

		spellL.add(new IceSpell("Snow_Cannon", 500, 2, 650, 250));
		spellL.add(new IceSpell("Ice_Blade", 250, 1, 450, 100));
		spellL.add(new IceSpell("Frost_Blizzard", 750, 5, 850, 350));
		spellL.add(new IceSpell("Arctic_Storm", 700, 6, 800, 300));

		spellL.add(new FireSpell("Flame_Tornada", 700, 4, 850, 300));
		spellL.add(new FireSpell("Breath_of_Fire", 350, 1, 450, 100));
		spellL.add(new FireSpell("Heat_Wave", 450, 2, 600, 150));
		spellL.add(new FireSpell("Lava_Comet", 800, 7, 1000, 550));
		spellL.add(new FireSpell("Hell_Storm", 600, 3, 950, 600));

		spellL.add(new LightingSpell("Lighting_Dagger", 400, 1, 500, 150));
		spellL.add(new LightingSpell("Thunder_Blast", 750, 4, 950, 400));
		spellL.add(new LightingSpell("Electric_Arrows", 550, 5, 650, 200));
		spellL.add(new LightingSpell("Spark_Needles", 500, 2, 600, 200));

		potionL.add(new Potion("Healing_Potion", 250, 1, 100, "Health"));
		potionL.add(new Potion("Strength_Potion", 200, 1, 75, "Strength"));
		potionL.add(new Potion("Magic_Potion", 350, 2, 100, "Mana"));
		potionL.add(new Potion("Luck_Elixir", 500, 4, 65, "Agility"));
		potionL.add(new Potion("Mermaid_Tears", 850, 5, 100, "H/M/S/A(the above four)"));
		potionL.add(new Potion("Ambrosia", 1000, 8, 150, "H/M/S/A/Dexterity/Defense"));

		armorL.add(new Armour("Platinum_Sheild", 150, 1, 200));
		armorL.add(new Armour("Breastplate", 350, 3, 600));
		armorL.add(new Armour("Full_Body_Armor", 1000, 8, 1100));
		armorL.add(new Armour("Wizard_Shield", 1200, 10, 1500));
		armorL.add(new Armour("Guradian_Angel", 1000, 10, 1000));
	}


	public Item recItem(Item e){
		itemContainer.recItem(e);
		return e;
	}
	public Item remoItem(Item e){
		itemContainer.removeItem(e);
		return e;
	}

	public boolean checkBuyValidity(Hero hero, Item e){
		if(hero.getMoney() < e.getPrice()){
			System.out.println("Sorry! Your balance is insufficient.Yours: "+hero.getMoney()+" required: "+e.getPrice());
			return false;
		}else if(hero.getLevel() < e.getLevel()){
			System.out.println("Sorry! Your hero's level is too low. Yours: "+hero.getLevel()+" required: "+e.getLevel());
			return false;
		}else{
			hero.recItem(e);
			hero.setMoney(hero.getMoney()-e.getPrice());
			System.out.println(e.name + " has been brought by" + hero.name + " from market");
			remoItem(e);
			return true;
		}
	}

	// switch to the wanted arraylist under the instruction of player
	public ArrayList switchToWanted(char ins,char callEntity){

		ArrayList arrRet=null;
		ItemContainer pointer;

		if(callEntity == 'b'){
			pointer = itemContainer;
		}else {
			pointer = he.itemContainer;
		}
		switch (ins){
			case 'a':
				pointer.armourList();
				arrRet =pointer.armorL;
				break;
			case 'w':
				pointer.weaponList();
				arrRet =pointer.weaponL;
				break;
			case 'p':
				pointer.potionList();
				arrRet =pointer.potionL;
				break;
			case 's':
				pointer.spelList();
				arrRet =pointer.spellL;
				break;

		}return arrRet;
	}

	// heros purchase item in the market
	public Item buy(Hero hero){
		char dec = Helper.getCharInput("What do you want to buy? 'a' for Armour 'w' for Weaponry 'p' for potion 's' for spell");
		ArrayList chosen= switchToWanted(dec,'b');

		if (chosen.isEmpty()) {
			System.out.println("There is nothing to buy, please try again another type.");
		}else {
			int ind = Helper.getIntInput("Choose the item you want to buy using number",chosen.size());

			if (!checkBuyValidity(hero, (Item) chosen.get(ind-1))) {
			}
		}

		enterMaket(hero);
		return pass;
	}

	// heros sell item in the market
	public Item sell(Hero hero){
		char dec = Helper.getCharInput("What do you want to sell? 'a' for Armour 'w' for Weaponry 'p' for potion 's' for spell");
		ArrayList chosen= switchToWanted(dec,'s');

		if (chosen.isEmpty()) {
			System.out.println("There is nothing to sell, please try again another type.");
		}else {
			int ind = Helper.getIntInput("Choose the item you want to sell using number",chosen.size());
			Item sell = (Item) chosen.get(ind-1);
			hero.remoItem(sell);
			hero.setMoney(hero.getMoney()+(sell.getPrice()/2));
			System.out.println(hero.getName() + "has sold " + sell.getName() + " and has received " + sell.getPrice() / 2 + "coins and now has " + hero.getMoney() + " coins now");
			recItem(sell);
		}
		enterMaket(hero);
		return pass;
	}

	// heros walk in the market and make a trade(purchase/sell)
	public char enterMaket(Hero hero){
		he = hero;
		System.out.println("Dear " + hero.getName() + ": Welcome to the market.");
		char dec = Helper.getCharInput("What do you want to do? 'l' to leave 'b' to buy 's' to sell ");

		switch (dec){
			case 'l':
				System.out.println("Good bye, hope you to buy something next time");
				break;
			case 'b':
				buy(hero);
				break;
			case 's':
				sell(hero);
				break;
		}return dec;
	}
}
