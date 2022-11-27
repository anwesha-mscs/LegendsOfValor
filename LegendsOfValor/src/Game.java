import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


//the main control of the game
public class Game {
	
	
	//The hero list for initial choose
	private HeroList heroList;

	// contains all the monster which may occur
	private MonList monList;

	// the hero party class which are easier to control
	private HeroParty heroPP;

	//hero party for part 2
	private ArrayList<Hero> heroParty;
	
	//market
	private Market market;
	//map
	private Map map;

	//when a hero encounter a monster
	private Combat combat;

	// Role list which contains of all of the monster and hero
	private ArrayList<Role> roles;

	private Scanner scan;
	private Random random;

	public Game() {
		heroList = new HeroList();
		monList = new MonList();
		heroPP = new HeroParty();

		market = new Market();
		map = new Map(8,setupRoles());
		combat = new Combat(heroPP);
		scan = new Scanner(System.in);
		random = new Random();
	}


	// the main function of the game
	public void init() {
		// briefly explain the rule
		System.out.println("Hello there!!! Welcome to the \" Legends Game \" ");
		System.out.println();

		System.out.println("I believe that you have played game Pokemon Go !!! This game is quite similar to that game but this time it is your heroes rather than your pokenmon to fight with monsters.");
		System.out.println("In this game, you can fight with monster, every time you win the combat you can earn money and the experience ");
		System.out.println("If all the heroes all lose then the GAME IS OVER!!!");

		System.out.println("The money can be used in the market to buy some stuff which are helpful to win the next combat"	);
		System.out.println("You can also sell stuff in the market but only a part of the money will be refund");
		System.out.println("When you wander around on the map there is a probability to encounter the monster. Then you can fight with them");

		System.out.println();
		System.out.println("In the beginning you can choose some heroes to build you team");
		System.out.println("Good luck and have fun!!!");

		map.grid[6][0].setHasHero(true);
		map.grid[6][3].setHasHero(true);
		map.grid[6][6].setHasHero(true);


		map.grid[0][1].setHasMoster(true);
		map.grid[0][4].setHasMoster(true);
		map.grid[0][7].setHasMoster(true);

		System.out.print(map);

		heroParty.get(0).connectMap(map);


		oneTurn();
		// build up the hero team
//		heroPP.init();

		// initialize the whole map
//		map.worldInit();

		// display the world
//		map.printWorld();


	}


	private char oneTurn(){

		for (Hero hero : heroParty) {
			hero.oneTurn();
			System.out.println(map);
		}



		return 'H';
	}


	private ArrayList<Role> setupRoles(){
		roles = new ArrayList<>();
		heroParty= new ArrayList<>();
		Hero.connectHeroParty(heroParty);


		Role hero =  heroList.getHeroList().get(2);
		hero.readyToDisplay(6,0);
		roles.add(hero);
		heroParty.add((Hero) hero);
		hero =  heroList.getHeroList().get(4);
		hero.readyToDisplay(6,3);
		roles.add(hero);
		heroParty.add((Hero) hero);
		hero =  heroList.getHeroList().get(16);
		hero.readyToDisplay(6,6);
		roles.add(hero);
		heroParty.add((Hero) hero);



//		hero.connectMap(map);




		Role monster = monList.getMonsterList().get(4);
		monster.readyToDisplay(0,1);
		roles.add(monster);
		monster = monList.getMonsterList().get(16);
		monster.readyToDisplay(0,4);
		roles.add(monster);
		monster = monList.getMonsterList().get(2);
		monster.readyToDisplay(0,7);
		roles.add(monster);


		return roles;






	}

	
	// This function is in charge of the team movement
	public int updateLocation(char dir){
		String direction = String.valueOf(dir);

		// go upwards
		if (direction.equals("W") || direction.equals("w")) {
			//first to check whether the place is movable
//			if (map.getxCord() == 0  || map.grid[map.getxCord() - 1][map.getyCord()].getType() == 'X') {
//				System.out.println("The place you choose can not enter! Please try another place!");
//			} else {
//				 the case when step in a market
//					if (map.grid[map.getxCord() - 1][map.getyCord()].getType() == 'M') {
//					map.grid[map.getxCord()][map.getyCord()].setType(' ');
//					map.grid[map.getxCord() - 1][map.getyCord()].setType('T');
//						map.setxCord(map.getxCord() - 1);
//
//						for (Hero he: heroPP.getHeroParty()) {
//							market.enterMaket(he);
//						};
//				}//normally move here
//				else if (map.grid[map.getxCord() - 1][map.getyCord()].getType() == ' ') {
//					map.grid[map.getxCord()][map.getyCord()].setType(' ');
//					map.grid[map.getxCord() - 1][map.getyCord()].setType('T');
//					map.setxCord(map.getxCord() - 1);
//
//					call encounterMonster function to decide whether start a fight
//					if (encounterMonster()) {
//						combat.fight();
//						
//					}
//				}
//			}
		}

		// go leftwards
		else if (direction.equals("A") || direction.equals("a")) {
//			if (map.getyCord() == 0 || map.grid[map.getxCord()][map.getyCord() - 1].getType() == 'X') {
//				System.out.println("The place you choose can not enter! Please try another place!");
//			} else {
//					if (map.grid[map.getxCord()][map.getyCord() - 1].getType() == 'M') {
//					map.grid[map.getxCord()][map.getyCord()].setType(' ');
//					map.grid[map.getxCord()][map.getyCord() - 1].setType('T');
//					map.setyCord(map.getyCord()-1);
//						for (Hero he: heroPP.getHeroParty()) {
//						market.enterMaket(he);
//				};

//					}
//				else if (map.grid[map.getxCord()][map.getyCord() - 1].getType() == ' ') {
//					map.grid[map.getxCord()][map.getyCord()].setType(' ');
//					map.grid[map.getxCord()][map.getyCord() - 1].setType('T');
//					map.setyCord(map.getyCord() - 1);
//
//					if (encounterMonster()) {
//						combat.fight();
//						
//					}
//				}
//			}
		}

		// go downwards
		else if (direction.equals("S") || direction.equals("s")) {
//			if (map.getxCord() == (map.getSize() - 1) || map.grid[map.getxCord() + 1][map.getyCord()].getType() == 'X') {
//				System.out.println("The place you choose can not enter! Please try another place!");
//			} else {
//					if (map.grid[map.getxCord() + 1][map.getyCord()].getType() == 'M') {
//					map.grid[map.getxCord()][map.getyCord()].setType(' ');
//					map.grid[map.getxCord() + 1][map.getyCord()].setType('T');
//					map.setxCord(map.getxCord()+1);
//						for (Hero he: heroPP.getHeroParty()) {
//						market.enterMaket(he);
//				};
//
//
//					}
//				else if (map.grid[map.getxCord() + 1][map.getyCord()].getType() == ' ') {
//					map.grid[map.getxCord()][map.getyCord()].setType(' ');
//					map.grid[map.getxCord() + 1][map.getyCord()].setType('T');
//					map.setxCord(map.getxCord() + 1);
//
//					if (encounterMonster()) {
//						combat.fight();
//					}
//				}
//			}
		}

		// go rightwards
		else if (direction.equals("D") || direction.equals("d")) {
//			if (map.getyCord() == (map.getSize() - 1) || map.grid[map.getxCord()][map.getyCord() + 1].getType() == 'X') {
//				System.out.println("The place you choose can not enter! Please try another place!");
//			} else {
//				if (map.grid[map.getxCord()][map.getyCord() + 1].getType() == 'X') {
//					System.out.println("Inaccessible area! Please try another direction.");
//				}
//				else if (map.grid[map.getxCord()][map.getyCord() + 1].getType() == 'M') {
//					map.grid[map.getxCord()][map.getyCord()].setType(' ');
//					map.grid[map.getxCord()][map.getyCord() + 1].setType('T');
//					map.setyCord(map.getyCord() + 1);
//					for (Hero he: heroPP.getHeroParty()) {
//						market.enterMaket(he);
//				};
//
//				}else if (map.grid[map.getxCord()][map.getyCord() + 1].getType() == ' ') {
//					map.grid[map.getxCord()][map.getyCord()].setType(' ');
//					map.grid[map.getxCord()][map.getyCord() + 1].setType('T');
//					map.setyCord(map.getyCord() + 1);
//
//					if (encounterMonster()) {
//						combat.fight();
//					}
//				}
//			}
		}
//		map.printWorld();
		System.out.print(map);
		map.resetIdioticGrid();

		return 0;
	}
	
	
	// to randomly decide whether the hero has encounter a monster
	// Here you can change the probability to encounter a monster prob = threshold/bound
	//monprob
	private boolean encounterMonster(){
		int bound = 128;
		int r = random.nextInt(bound);
		int threshold = 96;
		if (r<threshold){
			return true;
			
		}else{
			return false;
		}
	}

}

