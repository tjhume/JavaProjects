package builder;

public class God {

    private String damageType;
    private String name;
    private String imageUrl;
    private String type;
    private String pantheon;
    public God(String n, String t, String p, String url){
        if(t.equals("Warrior") || t.equals("Hunter") || t.equals("Assassin")){
            damageType = "P";
        }
        else{
            damageType = "M";
        }
        name = n;
        type = t;
        pantheon = p;
        imageUrl = url;
        level = 1;
    } //Constructor for a god that sets damage type (P or M), name, class, (type) and pantheon.
    //TODO Add other default values to constructor to reduce amount of setters required.

    //Other variables for gods. These are set by setters rather than constructor.
    private int level; //God level
    private int baseHealth;
    private double healthScale;
    private int baseMana;
    private double manaScale;
    private int baseMS; //Base movement speed, does not scale
    private double basicAttackDamage; //Scaling is often a double, so base should be double to avoid converting types.
    private double basicAttackScale;
    private double attackSpeed;
    private double attackSpeedScale;
    private int autoRange = 55; //Initialized to 55 since that is standard for most gods. Does not scale.
    private double power = 0; //Initialized to 0 since that is the starting point for all gods not including passives
    //TODO Make sure this does not scale: private double powerScale;
    private double basePhysicalDef;
    private double physicalDefScale;
    private double baseMagicalDef;
    private double magicalDefScale;
    private double HP5;
    private double MP5;
    private double HP5Scale;
    private double MP5Scale;


    public void PrintInfo(){
        System.out.println(name + " stats: ");
        System.out.println("Health: " + baseHealth);
        System.out.println("Health Scaling: " + healthScale);
        System.out.println("Mana: " + baseMana);
        System.out.println("Mana Scaling: " + manaScale);
        System.out.println("Base Movement Speed: " + baseMS);
        System.out.println("Basic Attack Damage: " + basicAttackDamage);
        System.out.println("Bassic Attack Scaling: " + basicAttackScale);
        System.out.println("Attack Speed: " + attackSpeed);
        System.out.println("Attack Speed Scaling: " + attackSpeedScale);
        System.out.println("Auto Attack Range: " + autoRange);
        System.out.println("Power: " + power);
        System.out.println("Base Physical Defense: " + basePhysicalDef);
        System.out.println("Physical Defense Scaling: " + physicalDefScale);
        System.out.println("Base Magical Defense: " + baseMagicalDef);
        System.out.println("Magical Defense Scaling: " + magicalDefScale);
    }

    //--------------------------------------Getters and setters-------------------------------------------------------//

    //Begin setters
    public void setLevel(int l){
        level = l;
    }

    public void setBaseHealth(int h){
        baseHealth = h;
    }

    public void setHealthScale(double s){
        healthScale = s;
    }

    public void setBaseMana(int m){
        baseMana = m;
    }

    public void setManaScale(double s){
        manaScale = s;
    }

    public void setBaseMS(int m){
        baseMS = m;
    }

    public void setBasicAttackDamage(double b){
        basicAttackDamage = b;
    }

    public void setBasicAttackScale(double s){
        basicAttackScale = s;
    }

    public void setAttackSpeed(double a){
        attackSpeed = a;
    }

    public void setAttackSpeedScale(double s){
        attackSpeedScale = s;
    }

    public void setAutoRange(int r){
        autoRange = r;
    }

    public void setPower(double p){
        power = p;
    }

    public void setBasePhysicalDef(double p){
        basePhysicalDef = p;
    }

    public void setPhysicalDefScale(double s){
        physicalDefScale = s;
    }

    public void setBaseMagicalDef(double m){
        baseMagicalDef = m;
    }

    public void setMagicalDefScale(double s){
        magicalDefScale = s;
    }

    public void setHP5(double h){
        HP5 = h;
    }

    public void setMP5(double m){
        MP5 = m;
    }

    public void setHP5Scale(double h){
        HP5Scale = h;
    }

    public void setMP5Scale(double m){
        MP5Scale = m;
    }

    //Begin getters

    public String getName(){
        return name;
    }

    public String getDamageType(){
        return damageType;
    }

    public double getPower(){
        return power;
    }

    public double getHealth(){
        return baseHealth;
    }

    public double getHealthScale(){
        return healthScale;
    }

    public double getMana(){
        return baseMana;
    }

    public double getManaScale(){
        return manaScale;
    }

    public int getMS(){
        return baseMS;
    }

    public String getURL(){
        return imageUrl;
    }

    public String getPantheon(){
        return pantheon;
    }

    public String getType(){
        return type;
    }

    public double getBasePhysicalDef(){
        return basePhysicalDef;
    }

    public double getBaseMagicalDef(){
        return baseMagicalDef;
    }

    public double getPhysicalDefScale(){
        return physicalDefScale;
    }

    public double getMagicalDefScale(){
        return magicalDefScale;
    }

    public double getHP5(){
        return HP5;
    }

    public double getHP5Scale(){
        return HP5Scale;
    }

    public double getMP5(){
        return MP5;
    }

    public double getMP5Scale(){
        return MP5Scale;
    }
}
