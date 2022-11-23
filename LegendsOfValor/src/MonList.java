import java.util.ArrayList;

// the class contains all the monster which can be generated
public class MonList {
	private ArrayList<Monster> MonsterList;

	public MonList() {
		MonsterList = new ArrayList<>();

		// construct the dragon list
		MonsterList.add(new Dragon("Desghidorrah", 3, 300, 400, 0.35));
		MonsterList.add(new Dragon("Chrysophylax", 2, 200, 500, 0.20));
		MonsterList.add(new Dragon("BunsenBurner", 4, 400, 500, 0.45));
		MonsterList.add(new Dragon("Natsunomeryu", 1, 100, 200, 0.10));
		MonsterList.add(new Dragon("TheScaleless", 7, 700, 600, 0.75));
		MonsterList.add(new Dragon("Kas-Ethelinh", 5, 600, 500, 0.60));
		MonsterList.add(new Dragon("Alexstraszan", 10, 1000, 9000, 0.55));
		MonsterList.add(new Dragon("Phaarthurnax", 6, 600, 700, 0.60));
		MonsterList.add(new Dragon("D-Maleficent", 9, 900, 950, 0.85));
		MonsterList.add(new Dragon("TheWeatherbe", 8, 800, 900, 0.80));
		MonsterList.add(new Dragon("Igneel", 6, 600, 400, 0.60));
		MonsterList.add(new Dragon("BlueEyesWhite", 9, 900, 600, 0.75));


		// construct the Exoskeleton list
		MonsterList.add(new Exoskeleton("Cyrrollalee", 7, 700, 800, 0.75));
		MonsterList.add(new Exoskeleton("Brandobaris", 3, 350, 450, 0.30));
		MonsterList.add(new Exoskeleton("BigBad-Wolf", 1, 150, 250, 0.15));
		MonsterList.add(new Exoskeleton("WickedWitch", 2, 250, 350, 0.25));
		MonsterList.add(new Exoskeleton("Aasterinian", 4, 400, 500, 0.45));
		MonsterList.add(new Exoskeleton("Chronepsish", 6, 650, 750, 0.60));
		MonsterList.add(new Exoskeleton("Kiaransalee", 8, 850, 950, 0.85));
		MonsterList.add(new Exoskeleton("St-Shargaas", 5, 550, 650, 0.55));
		MonsterList.add(new Exoskeleton("Merrshaullk", 10, 1000, 900, 0.55));
		MonsterList.add(new Exoskeleton("St-Yeenoghu", 9, 950, 850, 0.90));
		MonsterList.add(new Exoskeleton("DocOck", 6, 600, 600, 0.55));
		MonsterList.add(new Exoskeleton("Exodia", 10, 1000, 1000, 0.50));


		// construct the Spirit list
		MonsterList.add(new Spirit("Andrealphus", 2, 600, 500, 0.40));
		MonsterList.add(new Spirit("ABlinky", 1, 450, 350, 0.35));
		MonsterList.add(new Spirit("Andromalius", 3, 550, 450, 0.25));
		MonsterList.add(new Spirit("Chiang-shih", 4, 700, 600, 0.40));
		MonsterList.add(new Spirit("FallenAngel", 5, 800, 700, 0.50));
		MonsterList.add(new Spirit("Ereshkigall", 6, 950, 450, 0.35));
		MonsterList.add(new Spirit("Melchiresas", 7, 350, 150, 0.75));
		MonsterList.add(new Spirit("Jormunngand", 8, 600, 900, 0.20));
		MonsterList.add(new Spirit("Rakkshasass", 9, 550, 600, 0.35));
		MonsterList.add(new Spirit("Taltecuhtli", 10, 300, 200, 0.50));
		MonsterList.add(new Spirit("Casper", 1, 100, 100, 0.50));
		MonsterList.add(new Spirit("Andrealphus", 2, 600, 500, 0.40));
	}

	public ArrayList<Monster> getMonsterList() {
		return MonsterList;
	}

	@Override
	public String toString() {
		System.out.println("+-------------------------------------------------------------------------------+");
		System.out.println("No |      Name     | Level  |  Damage  |  Defense | Dodge_Chance | Type");
		System.out.println("+-------------------------------------------------------------------------------+");
		for (int i = 0; i < MonsterList.size(); i++) {
			System.out.printf("%-3s %-20s", (i + 1), MonsterList.get(i).getName());
			System.out.printf("%-10s", MonsterList.get(i).getLevel());
			System.out.printf("%-10s", MonsterList.get(i).getDmg());
			System.out.printf("%-10s", MonsterList.get(i).getDef());
			System.out.printf("%-12s", MonsterList.get(i).getDodge());
			System.out.printf("%-14s", MonsterList.get(i).getType());
			System.out.println();

			String.format("%-3s %-20s", MonsterList);
		}
		System.out.println("+-------------------------------------------------------------------------------+");

		return "";
	}
}

