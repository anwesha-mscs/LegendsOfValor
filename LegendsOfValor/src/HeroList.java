import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// all the hero can be chosen to build up a team
public class HeroList {
	private ArrayList<Hero> hl = new ArrayList<Hero>();

	public HeroList() {
		//parsing a CSV file into BufferedReader class constructor

		ArrayList<String> filenames = new ArrayList<String>();
		filenames.add("Warriors.csv");
		filenames.add("Paladins.csv");
		filenames.add("Sorcerers.csv");
		for (int fileCount = 0; fileCount < filenames.size(); fileCount++) {
			int count = 0;
			ArrayList<Hero> heroes = new ArrayList<Hero>();
			try (BufferedReader br = new BufferedReader(new FileReader("Resources/" + filenames.get(fileCount)))) {
				String line;
				while ((line = br.readLine()) != null) {
					if (count == 0) {
						count += 1;
						continue;
					}
					List<String> eachLineData = Arrays.asList(line.split(","));
					Hero hero = HeroFactory.getHero(filenames.get(fileCount), eachLineData.get(0), Integer.parseInt(eachLineData.get(1)), Integer.parseInt(eachLineData.get(2)), Integer.parseInt(eachLineData.get(3)), Integer.parseInt(eachLineData.get(4)), Integer.parseInt(eachLineData.get(5)), Integer.parseInt(eachLineData.get(6)));
					heroes.add(hero);
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			hl.addAll(heroes);

		}
	}

	// get the hero list
	public ArrayList<Hero> getHeroList() {
			return hl;
		}

	// print the hero list of the game
	@Override
	public String toString() {
		System.out.println("+----------------------------------------------------------------------------------------+");
		System.out.println("No |        Name       | Strength | Agility | Dexterity | Money | Experience | Type");
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
