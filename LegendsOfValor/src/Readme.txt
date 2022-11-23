# CS611 homework 3 

Name & ID
-------------------------------------------------------------------------------------------------
Geng Yan
U92836988

Files
-------------------------------------------------------------------------------------------------
<Armour.java> -- The Armour which can helps to defend and reduce damage
<Grid.java> -- abstract class grid instruct map to create
<Combat.java> -- The combat between heroes and monsters
<Dragon.java> -- A type of Monster who can dodge
<Exoskeleton.java> --  A type of Monster who good at dodge
<MapUnit.java> -- a single unit of the map
<HeroList.java> -- The list of heroes in this game
<Role.java> -- The abstract class for all fightable object in games
<MonList.java> -- The list of Monsters in this game
<Game.java> -- The main process of the game
<Hero.java> -- The hero which player can choose
<Main.java> -- The game initialize here
<Market.java> -- the market which can do trade in the game
<Monster.java> -- the monster the player need to beat down
<Potion.java> -- The potions can use for fight in the game
<Item.java> -- The abstract class for all buyable object in the market
<Spell.java> -- The spells for which can cast in the game
<Spirit.java> -- A type of Monster who bad at dodge
<Weapon.java> -- The weapons heroes can wear in the game
<Map.java> -- store the world map of this game
<Helper.java> -- help the Scanner in to work  to drop some bad input  or check whether the int has go out of bound
<ItemContainer.java> -- help to process all the item 

Notes:
-------------------------------------------------------------------------------------------------
1. The hero attribute is too low and I think it is so boring so I decide to multiple it a lot . Otherwise the hero maybe smash hit by the monster (one attack slain). If you don't like it you can cancel it. Hero:65~Hero:68

2. The Helper I defined can help to interact with the user input. I created it in a whole new class. It can help to decrease code repeat to maintain good OOD design.

3. I defined a class ItemContainer to assist handle item and display item. Market and Hero has it's own ItemContainer. No matter we want to remove spell or weapon we can simply call function ItemContainer.remove(Item e) which fully understand SOLID principle and Embodies the idea of OOD.

How to run:
-------------------------------------------------------------------------------------------------
1. Navigate to the directory after downloading the project
2. Run the following instructions on command line:
	javac Main.java
	java Main
