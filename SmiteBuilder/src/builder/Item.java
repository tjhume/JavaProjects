package builder;
import java.util.*;
public class Item{

    /*Variables for each stat will exist, but not every variable must be initialized, only those for stats being used.
    This means use only a default constructor. Initialize values with setters.*/

    private String name;
    public Item(String n){
        name = n;
        isKatana = false;
    }

    private String damageTypeRequired; //Options will be M (magical), P(physical), and X (either is allowed).
    private double magicalPower; //Double due to passives that result in decimal power totals.
    private double physicalPower;
    private int physicalPen;
    private int magicalPen;
    private int pen;
    private int health; //TODO Change to double if a passive that results in decimal health is discovered.
    private double moveSpeed; //Double since movement increases by percentages.
    private int physicalDef;
    private int magicalDef;
    private int hp5;
    private int mp5;
    private double attackSpeed;
    private double basicAttackDamage;
    private double magicLS; //LS is lifesteal
    private double physicalLS; //LS is lifesteal
    private double criticalChance;
    private double CCR; //Crowd control reduction
    private double CDR; //Cool down reduction
    private double mana; //Double because of Book of Thoth/Trans
    private int stacks; //Only for stackable items
    private int maxStacks; //Only for stackable items
    private int stackMana; //This is only for Book of Thoth and Trans
    private int tier;
    private boolean isKatana;
    //TODO Figure out a way to calculate power from trans and thoth passives that includes god mana.

    private ArrayList<String> statsUsed = new ArrayList<>(); //ArrayList is returned by getStatsUsed getter.
    private ArrayList<String> restrictingItems = new ArrayList<>(); //If all of these items are built, this item can no longer be built.
    private ArrayList<String> secondaryRestrictingItems = new ArrayList<>(); //Only for tier 1 items and composed of tier 2 items

    public void PrintInfo(){
        System.out.println(name + " stats:");
        int count = 0;
        while(count < statsUsed.size()){
            checkStat(statsUsed.get(count));
            count++;
        }
    }

    //TODO Finish checkStat method for each variable. Consider if stack variables should be included.
    //This method is private, as it is only to be used in the PrintInfo method above.
    private void checkStat(String s){
        if(s.equals("health")){
            System.out.println("Health: " + health);
        }
        else if(s.equals("damageTypeRequired")){
            System.out.println("Damage Type: " + damageTypeRequired);
        }
        else if(s.equals("magicalPower")){
            System.out.println("Magical Power: " + magicalPower);
        }
        else if(s.equals("mp5")){
            System.out.println("MP5: " + mp5);
        }
        else if(s.equals("mana")){
            System.out.println("Mana " + mana);
        }
    }


    //--------------------------------------Getters and setters-------------------------------------------------------//

    //Begin setters
    /*
    NOTE!: When each stat variable is initialized through a setter, it is also added to
    the statsUsed ArrayList. This lets us know what stats are actually used in the item.
    */

    public void setStacks(int amount){
        stacks = amount;
    } //Sets the amount of stacks a stackable item has

    public void setMaxStacks(int max){
        maxStacks = max;
    } //Sets the max stacks a stackable item can have

    public void setStackMana(int MPS){
        stackMana = (stacks * MPS);
    } //Input is the Mana Per Stack (10 for Thoth, 15 for Trans)

    public void setDamageType(String x){
        if((x != "M") && (x != "P") && (x != "X") ){
            damageTypeRequired = "null";
        }
        else{
            damageTypeRequired = x;
        }
    }

    public void setMagicalPower(double m){
        magicalPower = m;
        statsUsed.add("magicalPower");
    }

    public void setPhysicalPower(double p){
        physicalPower = p;
        statsUsed.add("physicalPower");
    }

    public void setPhysicalPen(int p){
        physicalPen = p;
        statsUsed.add("physicalPen");
    }

    public void setMagicalPen(int p){
        magicalPen = p;
        statsUsed.add("magicalPen");
    }

    public void setPen(int p){
        pen = p;
        statsUsed.add("pen");
    }

    public void setHealth(int h){
        health = h;
        statsUsed.add("health");
    }

    public void setMS(double m){
        moveSpeed = m;
        statsUsed.add("moveSpeed");
    }

    public void setPhysicalDef(int pd){
        physicalDef = pd;
        statsUsed.add("physicalDef");
    }

    public void setMagicalDef(int md){
        magicalDef = md;
        statsUsed.add("magicalDef");
    }

    public void setHP5(int h){
        hp5 = h;
        statsUsed.add("hp5");
    }

    public void setMp5(int m){
        mp5 = m;
        statsUsed.add("mp5");
    }

    public void setAttackSpeed(double as){
        attackSpeed = as;
        statsUsed.add("attackSpeed");
    }

    public void setBasicAttackDamage(double b){
        basicAttackDamage = b;
        statsUsed.add("basicAttackDamage");
    }

    public void setMagicLS(double m){
        magicLS = m;
        statsUsed.add("magicLS");
    }

    public void setPhysicalLS(double p){
        physicalLS = p;
        statsUsed.add("physicalLS");
    }

    public void setCriticalChance(double c){
        criticalChance = c;
        statsUsed.add("criticalChance");
    }

    public void setCCR(double c){
        CCR = c;
        statsUsed.add("CCR");
    }

    public void setCDR(double c){
        CDR = c;
        statsUsed.add("CDR");
    }

    public void setMana(double m){
        mana = m;
        statsUsed.add("mana");
    }

    public void setTier(int t){
        tier = t;
    }

    public void addRestriction(String r){
        restrictingItems.add(r);
    }

    public void addSecondaryRestriction(String r){
        secondaryRestrictingItems.add(r);
    }

    public void setKatana(boolean x){
        isKatana = x;
    }

    //Begin getters
    public String getName(){
        return name;
    }

    public ArrayList<String> getStatsUsed(){
        return statsUsed;
    } //Used to interact with the statsUsed ArrayList.

    public String getDamageType(){
        return damageTypeRequired;
    }

    public double getMagicalPower(){
        return magicalPower;
    }

    public double getPhysicalPower(){
        return physicalPower;
    }

    public int getPhysicalPen(){
        return physicalPen;
    }

    public int getMagicalPen(){
        return magicalPen;
    }

    public int getPen(){
        return pen;
    }

    public  int getHealth(){
        return health;
    }

    public double getMS(){
        return moveSpeed;
    }

    public int getPhysicalDef(){
        return physicalDef;
    }

    public int getMagicalDef(){
        return magicalDef;
    }

    public int getHP5(){
        return hp5;
    }

    public int getMP5(){
        return mp5;
    }

    public double getAttackSpeed(){
        return attackSpeed;
    }

    public double getBasicAttackDamage(){
        return basicAttackDamage;
    }

    public double getMagicLS(){
        return magicLS;
    }

    public double getPhysicalLS(){
        return physicalLS;
    }

    public double getCriticalChance(){
        return criticalChance;
    }

    public double getCCR(){
        return CCR;
    }

    public double getCDR(){
        return CDR;
    }

    public double getMana(){
        return mana;
    }


    //Other getters

    public boolean isKatana(){
        return isKatana;
    }

    public int getStacks(){
        return stacks;
    }

    public int getMaxStacks(){
        return maxStacks;
    }

    public int getStackMana(){
        return stackMana;
    }

    public int getTier(){
        return tier;
    }

    public ArrayList<String> getRestrictingItems(){
        return restrictingItems;
    }

    public ArrayList<String> getSecondaryRestrictingItems(){
        return secondaryRestrictingItems;
    }

    public boolean usesStat(String s){
        int count = 0;
        while(count < statsUsed.size()){
            if(s.equals(statsUsed.get(count))){
                return true;
            }
            count++;
        }
        return false;
    }

    public String getStat(int x){
        if(statsUsed.size() < x + 1){
            return "null";
        }
        String stat = statsUsed.get(x);
        if(stat.equals("magicalPower")){
            return ("+" +roundWhole(magicalPower) + " Magical Power");
        }
        else if(stat.equals("physicalPower")){
            return ("+" + roundWhole(physicalPower) + " Physical Power");
        }
        else if(stat.equals("physicalPen")){
            return ("+" + physicalPen + " Physical Penetration");
        }
        else if(stat.equals("magicalPen")){
            return ("+" + magicalPen + " Magical Penetration");
        }
        else if(stat.equals("pen")){
            return("+" + pen + " Penetration");
        }
        else if(stat.equals("health")){ ;
            return ("+" + roundWhole(health) + " Health");
        }
        else if(stat.equals("mana")){
            return ("+" + roundWhole(mana) + " Mana");
        }
        else if(stat.equals("moveSpeed")){
            String str = String.valueOf(moveSpeed);
            int index = str.indexOf(".");
            str = str.substring(index + 1, str.length());
            if (String.valueOf(str.charAt(0)).equals("0")) {
                str = str.substring(1, str.length());
            }
            if(str.length() == 1 && (str.equals("1") || str.equals("2"))){
                str = str + "0";
            }
            return ("+" + str + "% Movement Speed");
        }
        else if(stat.equals("physicalDef")){
            return ("+" + physicalDef + " Physical Defense");
        }
        else if(stat.equals("magicalDef")){
            return ("+" + magicalDef + " Magical Defense");
        }
        else if(stat.equals("hp5")){
            return ("+" + hp5 + " HP5");
        }
        else if(stat.equals("mp5")){
            return ("+" + mp5 + " MP5");
        }
        else if(stat.equals("attackSpeed")){
            String str = String.valueOf(attackSpeed);
            int index = str.indexOf(".");
            str = str.substring(index + 1, str.length());
            if (String.valueOf(str.charAt(0)).equals("0")) {
                str = str.substring(1, str.length());
            }
            if(str.length() == 1 && (str.equals("1") || str.equals("2"))){
                str = str + "0";
            }
            return ("+" + str + "% Attack Speed");
        }
        else if(stat.equals("basicAttackDamage")){
            return ("+" + basicAttackDamage + " Basic Attack Damage");
        }
        else if(stat.equals("magicLS")) {
            String str = String.valueOf(magicLS);
            int index = str.indexOf(".");
            str = str.substring(index + 1, str.length());
            if (String.valueOf(str.charAt(0)).equals("0")) {
                str = str.substring(1, str.length());
            }
            if(str.length() == 1 && (str.equals("1") || str.equals("2"))){
                str = str + "0";
            }
            return ("+" + str + "% Magical Lifesteal");
        }
        else if(stat.equals("physicalLS")){
            String str = String.valueOf(physicalLS);
            int index = str.indexOf(".");
            str = str.substring(index + 1, str.length());
            if (String.valueOf(str.charAt(0)).equals("0")) {
                str = str.substring(1, str.length());
            }
            return ("+" + str + "% Physical Lifesteal");
        }
        else if(stat.equals("criticalChance")){
            String str = String.valueOf(criticalChance);
            int index = str.indexOf(".");
            str = str.substring(index + 1, str.length());
            if (String.valueOf(str.charAt(0)).equals("0")) {
                str = str.substring(1, str.length());
            }
            return ("+" + str + "% Critical Chance");
        }
        else if(stat.equals("CCR")){
            String str = String.valueOf(CCR);
            int index = str.indexOf(".");
            str = str.substring(index + 1, str.length());
            if (String.valueOf(str.charAt(0)).equals("0")) {
                str = str.substring(1, str.length());
            }
            if(str.length() == 1 && (str.equals("1") || str.equals("2"))){
                str = str + "0";
            }
            return ("+" + str + "% Crowd Control Reduction");
        }
        else if(stat.equals("CDR")){
            String str = String.valueOf(CDR);
            int index = str.indexOf(".");
            str = str.substring(index + 1, str.length());
            if (String.valueOf(str.charAt(0)).equals("0")) {
                str = str.substring(1, str.length());
            }
            if(str.length() == 1 && (str.equals("1") || str.equals("2"))){
                str = str + "0";
            }
            return ("+" + str + "% Cooldown Reduction");
        }
        else{
            return "Typo somewhere.";
        }
    }



    private String roundWhole(double v){
        String rounded = String.valueOf(Math.rint(v));
        int index = rounded.indexOf(".");
        rounded = rounded.substring(0, index);
        return rounded;
    }
}