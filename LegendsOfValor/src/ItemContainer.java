import java.util.ArrayList;

//this class is help to process all the item belongs to it's owner
// such as receive and drop specific item
public class ItemContainer implements ItemProcessor{

    protected ArrayList<Armour> armorL;

    protected ArrayList<Weapon> weaponL;

    protected ArrayList<Potion> potionL;

    protected ArrayList<Spell> spellL;

    protected Item pass;


    public ItemContainer(ArrayList<Armour> armorL, ArrayList<Weapon> weaponL, ArrayList<Potion> potionL, ArrayList<Spell> spellL) {
        this.armorL = armorL;
        this.weaponL = weaponL;
        this.potionL = potionL;
        this.spellL = spellL;
    }

    @Override
    public Item recItem(Item e) {

        if(e instanceof Armour){
            armorL.add((Armour) e);
        }else if(e instanceof Weapon){
            weaponL.add((Weapon) e);
        }else if(e instanceof Potion){
            potionL.add((Potion) e);
        }else if(e instanceof Spell){
            spellL.add((Spell) e);
        }
        return pass;
    }

    @Override
    public Item removeItem(Item e) {
        if(e instanceof Armour){
            armorL.remove((Armour) e);
        }else if(e instanceof Weapon){
            weaponL.remove((Weapon) e);
        }else if(e instanceof Potion){
            potionL.remove((Potion) e);
        }else if(e instanceof Spell){
            spellL.remove((Spell) e);
        }

        return pass;
    }

    private Integer fillContent(ArrayList al){

        for (int i = 0; i < al.size(); i++){
            System.out.printf("%-3s",(i+1));
            System.out.println(al.get(i));
        }
        return al.size();
    }


    public Armour armourList(){
        System.out.println( "Armour below");
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("No |      Name     |  Cost  |  Required_Level  |  Damage_Reduction");
        fillContent(armorL);
        System.out.println("+----------------------------------------------------------------+");

        return null;
    }

    // print the potions list
    public Potion potionList(){
        System.out.println("Potion");
        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("No |      Name     |  Cost  |  Required_Level  |  Attribute_Increase    |   Attribute_Affect");

        fillContent(potionL);

        System.out.println("+--------------------------------------------------------------------------------------------+");
        return null;
    }

    // print the weapons list
    public Weapon weaponList(){
        System.out.println( "Weaponry here");
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println("No |      Name     |  Cost  |  Required_Level  |  Damage  |  Required_Hand");

        fillContent(weaponL);

        System.out.println("+------------------------------------------------------------------------+");
        return null;
    }

    // // print the spells list
    public Item spelList(){
        System.out.println( "Spell");
        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.println("No |      Name     |  Cost  |  Required_Level  |  Damage  |  Mana_Cost  |  Type");

        fillContent(spellL);

        System.out.println("+--------------------------------------------------------------------------------+");
        return pass;
    }
}
