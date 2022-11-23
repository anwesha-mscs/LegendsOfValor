import java.util.ArrayList;

// all the hero can be chosen to build up a team
public class HeroList {
	private ArrayList<Hero> hl;

	public HeroList()
	{
		hl = new ArrayList<>();

		// construct the paladin list
		hl.add(new Paladin("Parzival", 1, 0, 300, 750, 650, 700, 2500, 7));
		hl.add(new Paladin("Sehanie_Moonbow", 1, 0, 300, 750, 700, 700, 2500, 7));
		hl.add(new Paladin("Skoraeus_Stonebones", 1, 0, 250, 650, 600, 350, 2500, 4));
		hl.add(new Paladin("Garl_Glittergold", 1, 0, 100, 600, 500, 400, 2500, 5));
		hl.add(new Paladin("Amaryllis_Astra", 1, 0, 500, 500, 500, 500, 2500, 5));
		hl.add(new Paladin("Caliber_Heist", 1, 0, 400, 400, 400, 400, 2500, 8));

		// construct the sorcerer list
		hl.add(new Sorcerer("Rillifane_Rallathil", 1, 0, 1300, 750, 450, 500, 2500, 9));
		hl.add(new Sorcerer("Segojan_Earthcaller", 1, 0, 900, 800, 500, 650, 2500, 5));
		hl.add(new Sorcerer("Reign_Havoc", 1, 0, 800, 800, 800, 800, 2500, 8));
		hl.add(new Sorcerer("Reverie_Ashels", 1, 0, 900, 800, 700, 400, 2500, 7));
		hl.add(new Sorcerer("Kalabar", 1, 0, 800, 850, 400, 600, 2500, 6));
		hl.add(new Sorcerer("Skye_Soar", 1, 0, 1000, 700, 400, 500, 2500, 5));

		// construct the warrior list
		hl.add(new Warrior("Gaerdal_Ironhand", 1, 0, 100, 700, 500, 600, 1354, 7));
		hl.add(new Warrior("Sehanine_Monnbow", 1, 0, 600, 700, 800, 500, 2500, 8));
		hl.add(new Warrior("Muamman_Duathall", 1, 0, 300, 900, 500, 750, 2546, 6));
		hl.add(new Warrior("Flandal_Steelskin", 1, 0, 200, 750, 650, 700, 2500, 7));
		hl.add(new Warrior("Undefeated_Yoj", 1, 0, 400, 800, 400, 700, 2500, 7));
		hl.add(new Warrior("Eunoia_Cyn", 1, 0, 400, 700, 800, 600, 2500, 6));
	}

	// get the hero list
	public ArrayList<Hero> getHeroList() {return hl;}

	// print the hero list of the game

	@Override
	public String toString() {
		System.out.println("+----------------------------------------------------------------------------------------+");
		System.out.println("No |        Name       | Strength | Agility | Dexterity | Money | experience | Type");
		for (int i = 0; i < hl.size(); i++){
			System.out.printf("%-3s %-22s",(i+1), hl.get(i).getName());
			System.out.printf("%-10s", hl.get(i).getStren());
			System.out.printf("%-10s", hl.get(i).getAgi());
			System.out.printf("%-11s", hl.get(i).getDex());
			System.out.printf("%-12s", hl.get(i).getMoney());
			System.out.printf("%-10s", hl.get(i).getExp());
			System.out.printf("%-10s", hl.get(i).getType());
			System.out.println();
		}
		System.out.println("+----------------------------------------------------------------------------------------+");


		return "";
	}

}
