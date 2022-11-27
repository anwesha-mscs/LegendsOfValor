public class MonsterFactory {
    public static Monster getMonster(String monsterType, String name, int level, int damage, int defense, int dodge_chance){
        if(monsterType == null){
            return null;
        }
        if(monsterType.equalsIgnoreCase("Dragons.csv")){
            return new Dragon(name, level, damage, defense, dodge_chance);

        } else if(monsterType.equalsIgnoreCase("Exoskeletons.csv")){
            return new Exoskeleton(name, level, damage, defense, dodge_chance);

        } else if(monsterType.equalsIgnoreCase("Spirits.csv")){
            return new Spirit(name, level, damage, defense, dodge_chance);
        }

        return null;
    }
}
