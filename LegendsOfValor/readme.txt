Assignment4
# CS611-4
## Legends of Valor
---------------------------------------------------------------------------
Student Name: Geng Yan
Student Email: yangeng@bu.edu
Student BUID: U92536988

Student Name: Anwesha Saha
Student Email: anwesha@bu.edu
Student BUID: U60561480

## How we picked the Game Structure amongst both our existing structures
--------------------------------------------------------------------------
There were several reasons for why we decided to go with this design over the other that are included in the list below:
1) The alternative had a few restrictions in terms of implementations - specifically during battle that always seemed to favor the Monster.
2) The design we chose was more modular and therefore easier to edit and make changes to.
3) Some parts of design for example the factory patterns was taken from the other design code
4) The original design that we used had hard coded values for the warriors and heroes that is now being read from file directly and passed to the factory class for creation of the appropriate type of object.
5) The alternative structure had a lot of code in the Battle function class that could have been modularized within other classes. This approach uses the Game class to control the behavior of the game.

## Evaluating the Current Implemented Design 
---------------------------------------------------------------------------
The following reasons helped us design the Legends of Valor game with least changes:
1) The code inside each class was modular and related to a particular function
it was not coupled with the game application
2) There were separate classes where the game was written which would
implement and specify the values which were required. The design was implemented such that any role player game could be easily extended
3) There were several classes that could be reused or extended from the Board
Games design we had implemented - and directly from the Heroes and Monsters game as well - MapUnit, Grid, Map, Item, ItemContainer etc

## Files
---------------------------------------------------------------------------
The design implements two factory patterns - for Monsters and for Heroes.
The main control of the game is in the Game class from where command is passed into the required classes like Battle, Monsters, Heroes, MonList, HeroList etc
The Battle class takes care of the entire battle that goes on and considers the list of monsters and heroes involved in the battle
The board cell is divided and classified into three lanes. The letters surrounding each cell denotes the purpose of that cell. For example if a cell is a Koulou cell it is surrounded by the letter 'K' or bush is surrounded by 'B'
The market functionality is implemented entirely in the Market class. This includes functions for buying, selling, displaying of goods and adding and removing from inventor.
The behavior of each of the parties - that is either Hero or Monster is distributed in the individual classes
An object of type Role- can be either a Monster or a Hero.
A Helper class is used to generalize inputs taken from user and to display appropriate messages. In this way, the functions are generalized and need not be written again.


## Key Design Implementations to facilitate the development of additional games
-------------------------------------------------------------------------
1) Used abstract classes (like Game) to enforce the behavior of each game
to enforce that certain common functions are implemented by all the classes
implementing it.
2) Used scope to restrict methods to their classes/subclasses
3) Tried to modularize each function so that each function only performs a
single task.
4) Used inheritance - each character is inherited from a class called Role - this is because the Monsters and the Heroes have a lot of common properties
6) Incorporated polymorphism in the form of method overloading
7) Encapsulated our code by making all variables and methods private at the outset.
8) Tried to reduce coupling - modified our classes to have only one functionality.
That way, the class can be called and/or extended on its own when new uses arise
for it, without causing coupling between different functionalities.
9) Open-Closed design - designed our classes such that they are open to extension
The board map is made out of MapUnit cells which help create the entire structure for the game 
10) Used private variables along with protected ones - this is so access is limited to only the classes requiring it and are closed for modification for others 
11) Cohesion - We tried to keep all the methods and variables related to the same object in the same class to increase cohesion in the code

## How to compile and run
---------------------------------------------------------------------------
#Using Java version 8
#1. Navigate to the directory "LegendsOfValor/src" after unzipping the files
2. Run the following instructions for Mac terminal:
javac Main.java -Xlint
java main

##Demo Output 1: Movement and Monster Encounter
---------------------------------------------------------------------------
+----------------------------------------------------------------------------------------+
No |        Name       | Strength | Agility | Dexterity | Money | Experience | Type
1   Gaerdal_Ironhand      3772      500       600        2378        7         warrior   
2   Sehanine_Monnbow      3772      800       500        3524        8         warrior   
3   Muamman_Duathall      3972      500       750        3570        6         warrior   
4   Flandal_Steelskin     3822      650       700        3524        7         warrior   
5   Undefeated_Yoj        3872      400       700        3524        7         warrior   
6   Eunoia_Cyn            3772      800       600        3524        6         warrior   
7   Parzival              3822      650       700        3524        7         paladin   
8   Sehanine_Moonbow      3822      700       700        3524        7         paladin   
9   Skoraeus_Stonebones   3722      600       350        3524        4         paladin   
10  Garl_Glittergold      3672      500       400        3524        5         paladin   
11  Amaryllis_Astra       3572      500       500        3524        5         paladin   
12  Caliber_Heist         3472      400       400        3524        8         paladin   
13  Rillifane_Rallathil   3822      450       500        3524        9         sorcerer  
14  Segojan_Earthcaller   3872      500       650        3524        5         sorcerer  
15  Reign_Havoc           3872      800       800        3524        8         sorcerer  
16  Reverie_Ashels        3872      700       400        3524        7         sorcerer  
17  Kalabar               3922      400       600        3524        6         sorcerer  
18  Skye_Soar             3772      400       500        3524        5         sorcerer  
+----------------------------------------------------------------------------------------+

Which hero do you want to choose?
2
Clone function activated x: 7 y:0  dis:  1  added: 1 
+----------------------------------------------------------------------------------------+
No |        Name       | Strength | Agility | Dexterity | Money | Experience | Type
1   Gaerdal_Ironhand      3772      500       600        2378        7         warrior   
2   Sehanine_Monnbow      3772      800       500        3524        8         warrior   
3   Muamman_Duathall      3972      500       750        3570        6         warrior   
4   Flandal_Steelskin     3822      650       700        3524        7         warrior   
5   Undefeated_Yoj        3872      400       700        3524        7         warrior   
6   Eunoia_Cyn            3772      800       600        3524        6         warrior   
7   Parzival              3822      650       700        3524        7         paladin   
8   Sehanine_Moonbow      3822      700       700        3524        7         paladin   
9   Skoraeus_Stonebones   3722      600       350        3524        4         paladin   
10  Garl_Glittergold      3672      500       400        3524        5         paladin   
11  Amaryllis_Astra       3572      500       500        3524        5         paladin   
12  Caliber_Heist         3472      400       400        3524        8         paladin   
13  Rillifane_Rallathil   3822      450       500        3524        9         sorcerer  
14  Segojan_Earthcaller   3872      500       650        3524        5         sorcerer  
15  Reign_Havoc           3872      800       800        3524        8         sorcerer  
16  Reverie_Ashels        3872      700       400        3524        7         sorcerer  
17  Kalabar               3922      400       600        3524        6         sorcerer  
18  Skye_Soar             3772      400       500        3524        5         sorcerer  
+----------------------------------------------------------------------------------------+

Which hero do you want to choose?
10
Clone function activated x: 7 y:3  dis:  2  added: 2 
+----------------------------------------------------------------------------------------+
No |        Name       | Strength | Agility | Dexterity | Money | Experience | Type
1   Gaerdal_Ironhand      3772      500       600        2378        7         warrior   
2   Sehanine_Monnbow      3772      800       500        3524        8         warrior   
3   Muamman_Duathall      3972      500       750        3570        6         warrior   
4   Flandal_Steelskin     3822      650       700        3524        7         warrior   
5   Undefeated_Yoj        3872      400       700        3524        7         warrior   
6   Eunoia_Cyn            3772      800       600        3524        6         warrior   
7   Parzival              3822      650       700        3524        7         paladin   
8   Sehanine_Moonbow      3822      700       700        3524        7         paladin   
9   Skoraeus_Stonebones   3722      600       350        3524        4         paladin   
10  Garl_Glittergold      3672      500       400        3524        5         paladin   
11  Amaryllis_Astra       3572      500       500        3524        5         paladin   
12  Caliber_Heist         3472      400       400        3524        8         paladin   
13  Rillifane_Rallathil   3822      450       500        3524        9         sorcerer  
14  Segojan_Earthcaller   3872      500       650        3524        5         sorcerer  
15  Reign_Havoc           3872      800       800        3524        8         sorcerer  
16  Reverie_Ashels        3872      700       400        3524        7         sorcerer  
17  Kalabar               3922      400       600        3524        6         sorcerer  
18  Skye_Soar             3772      400       500        3524        5         sorcerer  
+----------------------------------------------------------------------------------------+

Which hero do you want to choose?
17
Clone function activated x: 7 y:6  dis:  3  added: 3 
Hello there!!! Welcome to " Legends of Valor " 

I believe that you have played game Pokemon Go !!! This game is quite similar to that game but this time it is your heroes rather than your pokemon who will fight monsters.
In this game, you can fight monsters to earn money and experience, visit the market and participate in lucrative trades and explore unknown regions. 
If the hero loses during battle, they will be regenerated with some penalty!!
The money earned from battles can be used in the market to buy potions, weapons, armors and enticing spells which are helpful to win the next combat
You can also sell your goods in the market at half the price you bought it for
When you wander around on the map, you will encounter monsters. Stay strong and conquer!
Each hero will start from a fixed place or his own nexus. The aim is to reach the monster's nexus before they reach yours!

In the beginning you can choose 3 heroes to build your team
Good luck and above all remember to have fun!!!
The world of play: 
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  
|       |  |    M4 |  | X X X |  |       |  |    M5 |  | X X X |  |       |  |    M6 |  
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  

P - P - P  P - P - P  I - I - I  C - C - C  B - B - B  I - I - I  B - B - B  P - P - P  
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |  
P - P - P  P - P - P  I - I - I  C - C - C  B - B - B  I - I - I  B - B - B  P - P - P  

K - K - K  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  P - P - P  
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |  
K - K - K  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  P - P - P  

B - B - B  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  B - B - B  C - C - C  
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |  
B - B - B  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  B - B - B  C - C - C  

P - P - P  P - P - P  I - I - I  C - C - C  C - C - C  I - I - I  P - P - P  P - P - P  
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |  
P - P - P  P - P - P  I - I - I  C - C - C  C - C - C  I - I - I  P - P - P  P - P - P  

K - K - K  K - K - K  I - I - I  C - C - C  P - P - P  I - I - I  K - K - K  B - B - B  
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |  
K - K - K  K - K - K  I - I - I  C - C - C  P - P - P  I - I - I  K - K - K  B - B - B  

C - C - C  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  P - P - P  B - B - B  
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |  
C - C - C  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  P - P - P  B - B - B  

n - n - n  n - n - n  I - I - I  n - n - n  n - n - n  I - I - I  n - n - n  n - n - n  
| H1    |  |       |  | X X X |  | H2    |  |       |  | X X X |  | H3    |  |       |  
n - n - n  n - n - n  I - I - I  n - n - n  n - n - n  I - I - I  n - n - n  n - n - n  


after connect map: 
+---+---+---+---+---+---+---+---+
|   | M |   |   | M |   |   | M |
+---+---+---+---+---+---+---+---+
|   |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| H |   |   | H |   |   | H |   |
+---+---+---+---+---+---+---+---+
The world of play: 
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  
|       |  |    M4 |  | X X X |  |       |  |    M5 |  | X X X |  |       |  |    M6 |  
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  

P - P - P  P - P - P  I - I - I  C - C - C  B - B - B  I - I - I  B - B - B  P - P - P  
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |  
P - P - P  P - P - P  I - I - I  C - C - C  B - B - B  I - I - I  B - B - B  P - P - P  

K - K - K  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  P - P - P  
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |  
K - K - K  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  P - P - P  

B - B - B  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  B - B - B  C - C - C  
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |  
B - B - B  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  B - B - B  C - C - C  

P - P - P  P - P - P  I - I - I  C - C - C  C - C - C  I - I - I  P - P - P  P - P - P  
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |  
P - P - P  P - P - P  I - I - I  C - C - C  C - C - C  I - I - I  P - P - P  P - P - P  

K - K - K  K - K - K  I - I - I  C - C - C  P - P - P  I - I - I  K - K - K  B - B - B  
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |  
K - K - K  K - K - K  I - I - I  C - C - C  P - P - P  I - I - I  K - K - K  B - B - B  

C - C - C  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  P - P - P  B - B - B  
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |  
C - C - C  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  P - P - P  B - B - B  

n - n - n  n - n - n  I - I - I  n - n - n  n - n - n  I - I - I  n - n - n  n - n - n  
| H1    |  |       |  | X X X |  | H2    |  |       |  | X X X |  | H3    |  |       |  
n - n - n  n - n - n  I - I - I  n - n - n  n - n - n  I - I - I  n - n - n  n - n - n  



Hero 1 You are now standing in a nexus. You can now buy and sell goods in the market.
Dear Muamman_Duathall: Welcome to the market.
What do you want to do? 'l' to leave 'b' to buy 's' to sell 
l
Good bye! Return to the market soon to explore our collection of exciting goods!
zz
Hero 1 What do you want to do next?
'q' to quit 'h' to display your information 'w' ,'a','s','d', to move 't' to teleport 'r' to recall 'p' to pass
w
Hero 2 You are now standing in a nexus. You can now buy and sell goods in the market.
Dear Amaryllis_Astra: Welcome to the market.
What do you want to do? 'l' to leave 'b' to buy 's' to sell 
l
Good bye! Return to the market soon to explore our collection of exciting goods!
zz
Hero 2 What do you want to do next?
'q' to quit 'h' to display your information 'w' ,'a','s','d', to move 't' to teleport 'r' to recall 'p' to pass
w
Hero 3 You are now standing in a nexus. You can now buy and sell goods in the market.
Dear Skye_Soar: Welcome to the market.
What do you want to do? 'l' to leave 'b' to buy 's' to sell 
l
Good bye! Return to the market soon to explore our collection of exciting goods!
zz
Hero 3 What do you want to do next?
'q' to quit 'h' to display your information 'w' ,'a','s','d', to move 't' to teleport 'r' to recall 'p' to pass
w
It is now time for the monsters to play!
Rakkshasass will play his turn
Leave enter:
Monster or Hero Map: 
It is now time for the monsters to play!
BlueEyesWhite will play his turn

##Demo Output 2: Fighting/Change Armor/Change Weapon/ Drink Potion
---------------------------------------------------------------------------
Battle size:3
Battle detail:[Battle between [[H1 ,  and   M4 ,M7 ,  ]], Battle between [[H2 ,  and   M5 ,M8 ,  ]], Battle between [[H3 ,  and   M6 ,M9 ,  ]]]
Beginning round 2 of battle
[H1                     4850      1024      300       3600      500       826       3570      6         warrior   false     ]
Hero Information
+-------------------------------------------------------------------------------------------+
No |        Name     | HP | Level  |  Damage  |  Defense | Dodge_Chance | Type | Status
1    H1                     4850      1024      300       3600      500       826       3570      6         warrior   false     
+------------------------------------------------------------------------------------------+
/////////////////////
Monster Information
+-------------------------------------------------------------------------------------------+
No |        Name     | HP | Level  |  Damage  |  Defense | Dodge_Chance | Type | Status
1    M4               612     9   550       600       0.0       spirit          9         
2    M7               1000    10  1000      900       0.0       exoskeleton     10        
+------------------------------------------------------------------------------------------+
Dear H1 What do you want to do?
press 'a' to attack 'w' to change weapon 'r' to change armor 'p' to use potion 's' to cast a spell
r
Hero H1 decided to change armor!
You must own a armour first to be able to equip it
Hero Information
+-------------------------------------------------------------------------------------------+
No |        Name     | HP | Level  |  Damage  |  Defense | Dodge_Chance | Type | Status
1    H1                     4850      1024      300       3600      500       826       3570      6         warrior   false     
+------------------------------------------------------------------------------------------+
/////////////////////
Monster Information
+-------------------------------------------------------------------------------------------+
No |        Name     | HP | Level  |  Damage  |  Defense | Dodge_Chance | Type | Status
1    M4               612     9   550       600       0.0       spirit          9         
2    M7               1000    10  1000      900       0.0       exoskeleton     10        
+------------------------------------------------------------------------------------------+

Monster Rakkshasass attacked hero Muamman_Duathall and caused 550 damage.
Monster Merrshaullk attacked hero Muamman_Duathall and caused 1000 damage.
Beginning round 2 of battle
[H2                     4600      1024      500       3572      500       500       3524      5         paladin   false     ]
Hero Information
+-------------------------------------------------------------------------------------------+
No |        Name     | HP | Level  |  Damage  |  Defense | Dodge_Chance | Type | Status
1    H2                     4600      1024      500       3572      500       500       3524      5         paladin   false     
+------------------------------------------------------------------------------------------+
/////////////////////
Monster Information
+-------------------------------------------------------------------------------------------+
No |        Name     | HP | Level  |  Damage  |  Defense | Dodge_Chance | Type | Status
1    M5               615     9   900       600       0.0       dragon          9         
2    M8               900     9   900       600       0.0       dragon          9         
+------------------------------------------------------------------------------------------+
Dear H2 What do you want to do?
press 'a' to attack 'w' to change weapon 'r' to change armor 'p' to use potion 's' to cast a spell

##Demo Output 3: Market Buy and Sell
---------------------------------------------------------------------------

Hero 1 You are now standing in a nexus. You can now buy and sell goods in the market.
Dear Muamman_Duathall: Welcome to the market.
What do you want to do? 'l' to leave 'b' to buy 's' to sell 
b
What do you want to buy? 'a' for Armour 'w' for Weaponry 'p' for potion 's' for spell
a
Armour below
+----------------------------------------------------------------+
No |      Name     |  Cost  |  Required_Level  |  Damage_Reduction
1  Platinum_Sheild     150       1         200       
2  Breastplate         350       3         600       
3  Full_Body_Armor     1000      8         1100      
4  Wizard_Shield       1200      10        1500      
5  Guradian_Angel      1000      10        1000      
+----------------------------------------------------------------+
Choose the item you want to buy by entering the corresponding number
2
Congratulations! Breastplate has been bought byMuamman_Duathall from market
Dear Muamman_Duathall: Welcome to the market.
What do you want to do? 'l' to leave 'b' to buy 's' to sell 
b
What do you want to buy? 'a' for Armour 'w' for Weaponry 'p' for potion 's' for spell
w
Weaponry here
+------------------------------------------------------------------------+
No |      Name     |  Cost  |  Required_Level  |  Damage  |  Required_Hand
1  Sword               500       1         800       1           
2  Bow                 300       2         500       2           
3  Scythe              1000      6         1100      2           
4  Axe                 550       5         850       1           
5  TSwords             1400      8         1600      2           
6  Dagger              200       1         250       1           
+------------------------------------------------------------------------+
Choose the item you want to buy by entering the corresponding number
4
Congratulations! Axe has been bought byMuamman_Duathall from market
Dear Muamman_Duathall: Welcome to the market.
What do you want to do? 'l' to leave 'b' to buy 's' to sell 
b
What do you want to buy? 'a' for Armour 'w' for Weaponry 'p' for potion 's' for spell
p
Potion
+--------------------------------------------------------------------------------------------+
No |      Name     |  Cost  |  Required_Level  |  Attribute_Increase    |   Attribute_Affect
1  Healing_Potion      250       1         100       Health    
2  Strength_Potion     200       1         75        Strength  
3  Magic_Potion        350       2         100       Mana      
4  Luck_Elixir         500       4         65        Agility   
5  Mermaid_Tears       850       5         100       H/M/S/A(the above four)
6  Ambrosia            1000      8         150       H/M/S/A/Dexterity/Defense
+--------------------------------------------------------------------------------------------+
Choose the item you want to buy by entering the corresponding number
5
Congratulations! Mermaid_Tears has been bought byMuamman_Duathall from market
Dear Muamman_Duathall: Welcome to the market.
What do you want to do? 'l' to leave 'b' to buy 's' to sell 
b
What do you want to buy? 'a' for Armour 'w' for Weaponry 'p' for potion 's' for spell
s
Spell
+--------------------------------------------------------------------------------+
No |      Name     |  Cost  |  Required_Level  |  Damage  |  Mana_Cost  |  Type
1  Snow_Cannon         500       2         0         250       ice       
2  Ice_Blade           250       1         0         100       ice       
3  Frost_Blizzard      750       5         0         350       ice       
4  Arctic_Storm        700       6         0         300       ice       
5  Flame_Tornada       700       4         0         300       fire      
6  Breath_of_Fire      350       1         0         100       fire      
7  Heat_Wave           450       2         0         150       fire      
8  Lava_Comet          800       7         0         550       fire      
9  Hell_Storm          600       3         0         600       fire      
10 Lighting_Dagger     400       1         0         150       lighting  
11 Thunder_Blast       750       4         0         400       lighting  
12 Electric_Arrows     550       5         0         200       lighting  
13 Spark_Needles       500       2         0         200       lighting  
+--------------------------------------------------------------------------------+
Choose the item you want to buy by entering the corresponding number
6
Congratulations! Breath_of_Fire has been bought byMuamman_Duathall from market
Dear Muamman_Duathall: Welcome to the market.
What do you want to do? 'l' to leave 'b' to buy 's' to sell 
l
Good bye! Return to the market soon to explore our collection of exciting goods!
zz
Hero 1 What do you want to do next?
'q' to quit 'h' to display your information 'w' ,'a','s','d', to move 't' to teleport 'r' to recall 'p' to pass

