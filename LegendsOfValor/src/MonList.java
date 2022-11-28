import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// the class contains all the monster which can be generated
public class MonList {
	private ArrayList<Monster> MonsterList = new ArrayList<>();

	public MonList() {
		ArrayList<String> filenames = new ArrayList<>();
		filenames.add("Dragons.csv");
		filenames.add("Exoskeletons.csv");
		filenames.add("Spirits.csv");
		for (int fileCount = 0; fileCount < filenames.size(); fileCount++) {
			int count = 0;
			ArrayList<Monster> monsters = new ArrayList<>();
			try (BufferedReader br = new BufferedReader(new FileReader("Resources/" + filenames.get(fileCount)))) {
				String line;
				while ((line = br.readLine()) != null) {
					if (count == 0) {
						count += 1;
						continue;
					}
					List<String> eachLineData = Arrays.asList(line.split(","));
					Monster monster = MonsterFactory.getMonster(filenames.get(fileCount), eachLineData.get(0), Integer.parseInt(eachLineData.get(1)), Integer.parseInt(eachLineData.get(2)), Integer.parseInt(eachLineData.get(3)), Integer.parseInt(eachLineData.get(4)));
					monsters.add(monster);
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			MonsterList.addAll(monsters);
		}
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

			//String.format("%-3s %-20s", MonsterList);
		}
		System.out.println("+-------------------------------------------------------------------------------+");

		return "";
	}
}

