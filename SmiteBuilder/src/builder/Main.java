package builder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.String;
import java.util.ArrayList;


public class Main extends Application {
    private ArrayList<God> godArrayList = new ArrayList<>(); //contains all gods
    private ArrayList<Item> itemArrayList = new ArrayList<>(); //contains all items

    String selectedGod = "";

    //God Initializations
    God Ra = new God("Ra", "Mage", "Egyptian", "ra.png");
    God Agni = new God("Agni","Mage", "Egyptian", "agni.png");
    God Achilles = new God("Achilles", "Warrior", "Greek", "achilles.png");
    God Aphrodite = new God("Aphrodite", "Mage", "Greek", "aphrodite.png");
    God AMC = new God("Ah Muzen Cab", "Hunter", "Mayan", "amc.png");
    God AhPuch = new God("Ah Puch", "Mage", "Mayan", "ahpuch.png");
    God Amaterasu = new God("Amaterasu", "Warrior", "Japanese", "amaterasu.png");
    God Anhur = new God("Anhur", "Hunter", "Egyptian", "anhur.png");
    God Anubis = new God("Anubis", "Mage", "Egyptian", "anubis.png");
    God AoKuang = new God("Ao Kuang", "Mage", "Chinese", "aokuang.png");
    God Apollo = new God("Apollo", "Hunter", "Roman", "apollo.png");
    God Arachne = new God("Arachne", "Assassin", "Greek", "arachne.png");
    God Ares = new God("Ares", "Guardian", "Greek", "ares.png");
    God Artemis = new God("Artemis", "Hunter", "Greek", "artemis.png");
    God Artio = new God("Artio", "Guardian", "Celtic", "artio.png");
    God Athena = new God("Athena", "Guardian", "Greek", "athena.png");
    God Awilix = new God("Awilix", "Assassin", "Mayan", "awilix.png");
    God Bacchus = new God("Bacchus", "Guardian", "Roman", "bacchus.png");
    God Bakasura = new God("Bakasura", "Assassin", "Hindu", "bakasura.png");
    God Bastet = new God("Bastet", "Assassin", "Egyptian", "bastet.png");
    God Bellona = new God("Bellona", "Warrior", "Roman", "bellona.png");
    God Cabrakan = new God("Cabrakan", "Guardian", "Mayan", "cabrakan.png");
    God Camazotz = new God("Camazotz", "Assassin", "Mayan", "camazotz.png");
    God Cerberus = new God("Cerberus", "Guardian", "Greek", "cerberus.png");
    God Cernunnos = new God("Cernunnos", "Hunter", "Celtic", "cernunnos.png");
    God Chaac = new God("Chaac", "Warrior", "Mayan", "chaac.png");
    God Change = new God("Chang'e", "Mage", "Chinese", "change.png");
    God Chiron = new God("Chiron", "Hunter", "Greek", "chiron.png");
    God Chronos = new God("Chronos", "Mage", "Greek", "chronos.png");
    God CuChulainn = new God("Cu Chulainn", "Warrior", "Celtic", "cuchulainn.png");
    God Cupid = new God("Cupid", "Hunter", "Roman", "cupid.png");
    God DaJi = new God("Da Ji", "Assassin", "Chinese", "daji.png");
    God ErlangShen = new God("Erlang Shen", "Warrior", "Chinese", "erlangshen.png");
    God Discordia = new God("Discordia", "Mage", "Roman", "discordia.png");
    God Chernobog = new God("Chernobog", "Hunter", "Slavic", "chernobog.png");
    God Fafnir = new God("Fafnir", "Guardian", "Norse", "fafnir.png");
    God Fenrir = new God("Fenrir", "Assassin", "Norse", "fenrir.png");
    God Freya = new God("Freya", "Mage", "Norse", "freya.png");
    God Ganesha = new God("Ganesha", "Guardian", "Hindu", "ganesha.png");
    God Geb = new God("Geb", "Guardian", "Egyptian", "geb.png");
    God GuanYu = new God("Guan Yu", "Warrior", "Chinese", "guanyu.png");
    God Hachiman = new God("Hachiman", "Hunter", "Japanese", "hachiman.png");
    God Hades = new God("Hades", "Mage", "Greek", "hades.png");
    God HeBo = new God("He Bo", "Mage", "Chinese", "hebo.png");
    God Hel = new God("Hel", "Mage", "Norse", "hel.png");
    God Hercules = new God("Hercules", "Warrior", "Roman", "hercules.png");
    God HouYi = new God("Hou Yi", "Hunter", "Chinese", "houyi.png");
    God HunBatz = new God("Hun Batz", "Assassin", "Mayan", "hunbatz.png");
    God Isis = new God("Isis", "Mage", "Egyptian", "isis.png");
    God Izanami = new God("Izanami", "Hunter", "Japanese", "izanami.png");
    God Janus = new God("Janus", "Mage", "Roman", "janus.png");
    God JingWei = new God("Jing Wei", "Hunter", "Chinese", "jingwei.png");
    God Kali = new God("Kali", "Assassin", "Hindu", "kali.png");
    God Khepri = new God("Khepri", "Guardian", "Egyptian", "khepri.png");
    God Kukulkan = new God("Kukulkan", "Mage", "Mayan", "kukulkan.png");
    God Kumbhakarna = new God("Kumbhakarna", "Guardian", "Hindu", "kumbhakarna.png");
    God Kuzenbo = new God("Kuzenbo", "Guardian", "Japanese", "kuzenbo.png");
    God Loki = new God("Loki", "Assassin", "Norse", "loki.png");
    God Medusa = new God("Medusa", "Hunter", "Greek", "medusa.png");
    God Mercury = new God("Mercury", "Assassin", "Roman", "mercury.png");
    God Morrigan = new God("The Morrigan", "Mage", "Celtic", "morrigan.png");
    God Neith = new God("Neith", "Hunter", "Egyptian", "neith.png");
    God Nemesis = new God("Nemesis", "Assassin", "Greek", "nemesis.png");
    God NeZha = new God("Ne Zha", "Assassin", "Chinese", "nezha.png");
    God Nike = new God("Nike", "Warrior", "Greek", "nike.png");
    God Nox = new God("Nox", "Mage", "Roman", "nox.png");
    God NuWa = new God("Nu Wa", "Mage", "Chinese", "nuwa.png");
    God Odin = new God("Odin", "Warrior", "Norse", "odin.png");
    God Osiris = new God("Osiris", "Warrior", "Egyptian", "osiris.png");
    God Poseidon = new God("Poseidon", "Mage", "Greek", "poseidon.png");
    God Raijin = new God("Raijin", "Mage", "Japanese", "raijin.png");
    God Rama = new God("Rama", "Hunter", "Hindu", "rama.png");
    God Ratatoskr = new God("Ratatoskr", "Assassin", "Norse", "ratatoskr.png");
    God Ravana = new God("Ravana", "Warrior", "Hindu", "ravana.png");
    God Scylla = new God("Scylla", "Mage", "Greek", "scylla.png");
    God Serqet = new God("Serqet", "Assassin", "Egyptian", "serqet.png");
    God Skadi = new God("Skadi", "Hunter", "Norse", "skadi.png");
    God Sobek = new God("Sobek", "Guardian", "Egyptian", "sobek.png");
    God Sol = new God("Sol", "Mage", "Norse", "sol.png");
    God SunWukong = new God("Sun Wukong", "Warrior", "Chinese", "sunwukong.png");
    God Susano = new God("Susano", "Assassin", "Japanese", "susano.png");
    God Sylvanus = new God("Sylvanus", "Guardian", "Roman", "sylvanus.png");
    God Terra = new God("Terra", "Guardian", "Roman", "terra.png");
    God Thanatos = new God("Thanatos", "Assassin", "Greek", "thanatos.png");
    God Thor = new God("Thor", "Assassin", "Norse", "thor.png");
    God Thoth = new God("Thoth", "Mage", "Egyptian", "thoth.png");
    God Tyr = new God("Tyr", "Warrior", "Norse", "tyr.png");
    God Ullr = new God("Ullr", "Hunter", "Norse", "ullr.png");
    God Vamana = new God("Vamana", "Warrior", "Hindu", "vamana.png");
    God Vulcan = new God("Vulcan", "Mage", "Roman", "vulcan.png");
    God Xbalanque = new God("Xbalanque", "Hunter", "Mayan", "xbalanque.png");
    God XingTian = new God("Xing Tian", "Guardian", "Chinese", "xingtian.png");
    God Ymir = new God("Ymir", "Guardian", "Norse", "ymir.png");
    God Zeus = new God("Zeus", "Mage", "Greek", "zeus.png");
    God ZhongKui = new God("Zhong Kui", "Mage", "Chinese", "zhongkui.png");

    //Item Initializations
    //Tier 3---------------------------------------
    Item BookOfThoth = new Item("Book of Thoth");
    Item Polynomicon = new Item("Polynomicon");
    Item SoulReaver = new Item("Soul Reaver");
    Item BookOfTheDead = new Item("Book of the Dead");
    Item Transcendence = new Item("Transcendence");
    Item HydrasLament = new Item("Hydra's Lament");
    Item TyphonsFang = new Item("Typhon's Fang");
    Item BancroftsTalon = new Item("Bancroft's Talon");
    Item SoulGem = new Item("Soul Gem");
    Item PythagoremsPiece = new Item("Pythagorem's Piece");
    Item WingedBlade = new Item("Winged Blade");
    Item WitchBlade = new Item("Witchblade");
    Item RelicDagger = new Item("Relic Dagger");
    Item ToxicBlade = new Item("Toxic Blade");
    Item WarriorTabi = new Item("Warrior Tabi");
    Item NinjaTabi = new Item("Ninja Tabi");
    Item ReinforcedGreaves = new Item("Reinforced Greaves");
    Item TalariaBoots = new Item("Talaria Boots");
    Item ShoesOfTheMagi = new Item("Shoes of the Magi");
    Item ShoesOfFocus = new Item("Shoes of Focus");
    Item ReinforcedShoes = new Item("Reinforced Shoes");
    Item TravelersShoes = new Item("Traveler's Shoes");
    Item Masamune = new Item("Masamune");
    Item StoneCuttingSword = new Item("Stone Cutting Sword");
    Item Heartseeker = new Item("Heartseeker");
    Item HastenedKatana = new Item("Hastened Katana");

    //Tier 2---------------------------------------
    Item TalonTrinket = new Item("Talon Trinket");
    Item EnchantedTrinket = new Item("Enchanted Trinket");
    Item BookOfSouls = new Item("Book of Souls");
    Item HydrasStar = new Item("Hydra's Star");
    Item ChargedMorningstar = new Item("Charged Morningstar");
    Item AdventurersBlade = new Item("Adventurer's Blade");
    Item CombatBoots = new Item("Combat Boots");
    Item MagicShoes = new Item("Magic Shoes");
    Item ThousandFoldBlade = new Item("Thousand Fold Blade");

    //Tier 1---------------------------------------
    Item TinyTrinket = new Item("Tiny Trinket");
    Item Spellbook = new Item("Spellbook");
    Item Morningstar = new Item("Morningstar");
    Item AncientBlade = new Item("Ancient Blade");
    Item Boots = new Item("Boots");
    Item Shoes = new Item("Shoes");
    Item Katana = new Item("Katana");

    private static Main instance;

    private Stage stage;

    public Main() {
        instance = this;
    }

    public static Main getInstance() {
        return instance;
    }

    public ArrayList<God> getGodList(){
        return godArrayList;
    }

    public ArrayList<Item> getItemList(){
        return itemArrayList;
    }

    public void setGod(String g){
        selectedGod = g;
    }

    public String getGod(){
        return selectedGod;
    }

    public Item getItem(String i){
        int count = 0;
        while(count < itemArrayList.size()){
            if(itemArrayList.get(count).getName().equals(i)){
                return itemArrayList.get(count);
            }
            count++;
        }
        System.out.println("Item not found");
        return null;
    }

    private void initializeGods(){
        Ra.setBaseHealth(453);
        Ra.setHealthScale(68);
        Ra.setBaseMana(303);
        Ra.setManaScale(48);
        Ra.setBaseMS(360);
        Ra.setBasicAttackDamage(36);
        Ra.setBasicAttackScale(1.5);
        Ra.setAttackSpeed(0.89);
        Ra.setAttackSpeedScale(.01);
        Ra.setBasePhysicalDef(12.5);
        Ra.setPhysicalDefScale(2.5);
        Ra.setBaseMagicalDef(30.9);
        Ra.setMagicalDefScale(0.9);
        Ra.setHP5(7.48);
        Ra.setHP5Scale(0.48);
        Ra.setMP5(5.24);
        Ra.setMP5Scale(0.44);
        godArrayList.add(Ra);

        Agni.setBaseHealth(431);
        Agni.setHealthScale(71);
        Agni.setBaseMana(300);
        Agni.setManaScale(45);
        Agni.setBaseMS(355);
        Agni.setBasicAttackDamage(36);
        Agni.setBasicAttackScale(1.5);
        Agni.setAttackSpeed(1.01);
        Agni.setAttackSpeedScale(.012);
        Agni.setBasePhysicalDef(13.6);
        Agni.setPhysicalDefScale(2.6);
        Agni.setBaseMagicalDef(30.9);
        Agni.setMagicalDefScale(0.9);
        Agni.setHP5(7.47);
        Agni.setHP5Scale(0.47);
        Agni.setMP5(5.07);
        Agni.setMP5Scale(0.37);
        godArrayList.add(Agni);

        Achilles.setBaseHealth(547);
        Achilles.setHealthScale(82);
        Achilles.setBaseMana(240);
        Achilles.setManaScale(35);
        Achilles.setBaseMS(370);
        Achilles.setBasicAttackDamage(40);
        Achilles.setBasicAttackScale(2);
        Achilles.setAttackSpeed(0.96);
        Achilles.setAttackSpeedScale(0.0125);
        Achilles.setBasePhysicalDef(20);
        Achilles.setPhysicalDefScale(3);
        Achilles.setBaseMagicalDef(30.9);
        Achilles.setMagicalDefScale(0.9);
        Achilles.setHP5(9.75);
        Achilles.setHP5Scale(0.75);
        Achilles.setMP5(5.09);
        Achilles.setMP5Scale(0.39);
        godArrayList.add(Achilles);

        Aphrodite.setBaseHealth(448);
        Aphrodite.setHealthScale(68);
        Aphrodite.setBaseMana(283);
        Aphrodite.setManaScale(43);
        Aphrodite.setBaseMS(355);
        Aphrodite.setBasicAttackDamage(33);
        Aphrodite.setBasicAttackScale(1.45);
        Aphrodite.setAttackSpeed(0.88);
        Aphrodite.setAttackSpeedScale(0.0095);
        Aphrodite.setBasePhysicalDef(11.7);
        Aphrodite.setPhysicalDefScale(2.7);
        Aphrodite.setBaseMagicalDef(30.9);
        Aphrodite.setMagicalDefScale(0.9);
        Aphrodite.setHP5(6.45);
        Aphrodite.setHP5Scale(0.45);
        Aphrodite.setMP5(5.21);
        Aphrodite.setMP5Scale(0.41);
        godArrayList.add(Aphrodite);

        godArrayList.add(AMC);

        godArrayList.add(AhPuch);

        godArrayList.add(Amaterasu);

        godArrayList.add(Anhur);

        godArrayList.add(Anubis);

        godArrayList.add(AoKuang);

        godArrayList.add(Apollo);

        godArrayList.add(Arachne);

        godArrayList.add(Ares);

        godArrayList.add(Artemis);

        godArrayList.add(Artio);

        godArrayList.add(Athena);

        godArrayList.add(Awilix);

        godArrayList.add(Bacchus);

        godArrayList.add(Bakasura);

        godArrayList.add(Bastet);

        godArrayList.add(Bellona);

        godArrayList.add(Cabrakan);

        godArrayList.add(Camazotz);

        godArrayList.add(Cernunnos);

        godArrayList.add(Chaac);

        godArrayList.add(Change);

        godArrayList.add(Chiron);

        godArrayList.add(Chronos);

        godArrayList.add(CuChulainn);

        godArrayList.add(Cupid);

        godArrayList.add(DaJi);

        godArrayList.add(ErlangShen);

        godArrayList.add(Discordia);

        godArrayList.add(Chernobog);

        godArrayList.add(Fafnir);

        godArrayList.add(Fenrir);

        godArrayList.add(Freya);

        godArrayList.add(Ganesha);

        godArrayList.add(Geb);

        godArrayList.add(GuanYu);

        godArrayList.add(Hachiman);

        godArrayList.add(Hades);

        godArrayList.add(HeBo);

        godArrayList.add(Hel);

        godArrayList.add(Hercules);

        godArrayList.add(HouYi);

        godArrayList.add(HunBatz);

        godArrayList.add(Isis);

        godArrayList.add(Izanami);

        godArrayList.add(Janus);

        godArrayList.add(JingWei);

        godArrayList.add(Kali);

        godArrayList.add(Khepri);

        godArrayList.add(Kukulkan);

        godArrayList.add(Kumbhakarna);

        godArrayList.add(Kuzenbo);

        godArrayList.add(Loki);

        godArrayList.add(Medusa);

        godArrayList.add(Mercury);

        godArrayList.add(Morrigan);

        godArrayList.add(Neith);

        godArrayList.add(Nemesis);

        godArrayList.add(NeZha);

        godArrayList.add(Nike);

        godArrayList.add(Nox);

        godArrayList.add(NuWa);

        godArrayList.add(Odin);

        godArrayList.add(Osiris);

        godArrayList.add(Poseidon);

        godArrayList.add(Raijin);

        godArrayList.add(Rama);

        godArrayList.add(Ratatoskr);

        godArrayList.add(Ravana);

        godArrayList.add(Scylla);

        godArrayList.add(Serqet);

        godArrayList.add(Skadi);

        godArrayList.add(Sobek);

        godArrayList.add(Sol);

        godArrayList.add(SunWukong);

        godArrayList.add(Susano);

        godArrayList.add(Sylvanus);

        godArrayList.add(Terra);

        godArrayList.add(Thanatos);

        godArrayList.add(Thor);

        godArrayList.add(Thoth);

        godArrayList.add(Tyr);

        godArrayList.add(Ullr);

        godArrayList.add(Vamana);

        godArrayList.add(Vulcan);

        godArrayList.add(Xbalanque);

        godArrayList.add(XingTian);

        godArrayList.add(Ymir);

        godArrayList.add(Zeus);

        godArrayList.add(ZhongKui);

        godArrayList.add(Cerberus);
    }

    private void initializeItems(){
        BookOfThoth.setDamageType("M");
        BookOfThoth.setMagicalPower(100);
        BookOfThoth.setMana(125);
        BookOfThoth.setMp5(15);
        BookOfThoth.setMaxStacks(75);
        BookOfThoth.setStacks(75);
        BookOfThoth.setStackMana(10);
        BookOfThoth.setTier(3);
        itemArrayList.add(BookOfThoth);

        Polynomicon.setDamageType("M");
        Polynomicon.setMagicalPower(75);
        Polynomicon.setMana(300);
        Polynomicon.setMagicLS(.12);
        Polynomicon.setTier(3);
        itemArrayList.add(Polynomicon);

        SoulReaver.setDamageType("M");
        SoulReaver.setMagicalPower(130);
        SoulReaver.setMana(300);
        SoulReaver.setTier(3);
        itemArrayList.add(SoulReaver);

        BookOfTheDead.setDamageType("M");
        BookOfTheDead.setMagicalPower(100);
        BookOfTheDead.setHealth(200);
        BookOfTheDead.setMana(200);
        BookOfTheDead.setTier(3);
        itemArrayList.add(BookOfTheDead);

        BookOfSouls.setDamageType("M");
        BookOfSouls.setMagicalPower(65);
        BookOfSouls.setMana(125);
        BookOfSouls.addRestriction("Book of Thoth");
        BookOfSouls.addRestriction("Polynomicon");
        BookOfSouls.addRestriction("Soul Reaver");
        BookOfSouls.addRestriction("Book of the Dead");
        BookOfSouls.setTier(2);
        itemArrayList.add(BookOfSouls);

        Spellbook.setDamageType("M");
        Spellbook.setMagicalPower(20);
        Spellbook.setMana(75);
        Spellbook.addRestriction("Book of Thoth");
        Spellbook.addRestriction("Polynomicon");
        Spellbook.addRestriction("Soul Reaver");
        Spellbook.addRestriction("Book of the Dead");
        Spellbook.addSecondaryRestriction("Book of Souls");
        Spellbook.setTier(1);
        itemArrayList.add(Spellbook);

        Transcendence.setDamageType("P");
        Transcendence.setPhysicalPower(35);
        Transcendence.setMana(300);
        Transcendence.setMp5(6);
        Transcendence.setCDR(0.10);
        Transcendence.setMaxStacks(50);
        Transcendence.setStacks(50);
        Transcendence.setTier(3);
        itemArrayList.add(Transcendence);

        HydrasLament.setDamageType("P");
        HydrasLament.setPhysicalPower(40);
        HydrasLament.setCDR(.10);
        HydrasLament.setTier(3);
        itemArrayList.add(HydrasLament);

        HydrasStar.setDamageType("P");
        HydrasStar.setPhysicalPower(20);
        HydrasStar.setCDR(.05);
        HydrasStar.setTier(2);
        HydrasStar.addRestriction("Hydra's Lament");
        itemArrayList.add(HydrasStar);

        ChargedMorningstar.setDamageType("P");
        ChargedMorningstar.setPhysicalPower(20);
        ChargedMorningstar.setMana(150);
        ChargedMorningstar.setMp5(4);
        ChargedMorningstar.setTier(2);
        ChargedMorningstar.addRestriction("Transcendence");
        itemArrayList.add(ChargedMorningstar);

        Morningstar.setDamageType("P");
        Morningstar.setPhysicalPower(10);
        Morningstar.setTier(1);
        Morningstar.addRestriction("Transcendence");
        Morningstar.addRestriction("Hydra's Lament");
        Morningstar.addSecondaryRestriction("Charged Morningstar");
        Morningstar.addSecondaryRestriction("Hydra's Star");
        itemArrayList.add(Morningstar);

        TinyTrinket.setDamageType("M");
        TinyTrinket.setMagicalPower(20);
        TinyTrinket.setMagicLS(.06);
        TinyTrinket.setTier(1);
        TinyTrinket.addRestriction("Typhon's Fang");
        TinyTrinket.addRestriction("Bancroft's Talon");
        TinyTrinket.addRestriction("Soul Gem");
        TinyTrinket.addRestriction("Pythagorem's Piece");
        TinyTrinket.addSecondaryRestriction("Talon Trinket");
        TinyTrinket.addSecondaryRestriction("Enchanted Trinket");
        itemArrayList.add(TinyTrinket);

        TalonTrinket.setDamageType("M");
        TalonTrinket.setMagicalPower(60);
        TalonTrinket.setMana(100);
        TalonTrinket.setMagicLS(.08);
        TalonTrinket.setTier(2);
        TalonTrinket.addRestriction("Typhon's Fang");
        TalonTrinket.addRestriction("Bancroft's Talon");
        itemArrayList.add(TalonTrinket);

        TyphonsFang.setDamageType("M");
        TyphonsFang.setMagicalPower(100);
        TyphonsFang.setMana(200);
        TyphonsFang.setMagicLS(.10);
        TyphonsFang.setTier(3);
        itemArrayList.add(TyphonsFang);

        BancroftsTalon.setDamageType("M");
        BancroftsTalon.setMagicalPower(100);
        BancroftsTalon.setMagicLS(.15);
        BancroftsTalon.setMana(150);
        BancroftsTalon.setTier(3);
        itemArrayList.add(BancroftsTalon);

        EnchantedTrinket.setDamageType("M");
        EnchantedTrinket.setMagicalPower(30);
        EnchantedTrinket.setHealth(100);
        EnchantedTrinket.setMagicLS(.12);
        EnchantedTrinket.setTier(2);
        EnchantedTrinket.addRestriction("Soul Gem");
        EnchantedTrinket.addRestriction("Pythagorem's Piece");
        itemArrayList.add(EnchantedTrinket);

        SoulGem.setDamageType("M");
        SoulGem.setMagicalPower(65);
        SoulGem.setHealth(150);
        SoulGem.setMagicLS(.12);
        SoulGem.setCDR(.10);
        SoulGem.setTier(3);
        itemArrayList.add(SoulGem);

        PythagoremsPiece.setDamageType("M");
        PythagoremsPiece.setMagicalPower(40);
        PythagoremsPiece.setHealth(200);
        PythagoremsPiece.setMagicLS(.12);
        PythagoremsPiece.setCDR(0.10);
        PythagoremsPiece.setTier(3);
        itemArrayList.add(PythagoremsPiece);

        WingedBlade.setDamageType("X");
        WingedBlade.setHealth(300);
        WingedBlade.setCCR(.20);
        WingedBlade.setMS(.10);
        WingedBlade.setTier(3);
        itemArrayList.add(WingedBlade);

        WitchBlade.setDamageType("X");
        WitchBlade.setHealth(200);
        WitchBlade.setCDR(0.10);
        WitchBlade.setAttackSpeed(0.20);
        WitchBlade.setMS(0.10);
        WitchBlade.setTier(3);
        itemArrayList.add(WitchBlade);

        RelicDagger.setDamageType("X");
        RelicDagger.setHealth(300);
        RelicDagger.setCDR(0.10);
        RelicDagger.setMS(0.10);
        RelicDagger.setTier(3);
        itemArrayList.add(RelicDagger);

        ToxicBlade.setDamageType("X");
        ToxicBlade.setHealth(100);
        ToxicBlade.setPen(15);
        ToxicBlade.setAttackSpeed(0.20);
        ToxicBlade.setMS(0.10);
        ToxicBlade.setTier(3);
        itemArrayList.add(ToxicBlade);

        AdventurersBlade.setDamageType("X");
        AdventurersBlade.setHealth(100);
        AdventurersBlade.setMS(0.10);
        AdventurersBlade.setTier(2);
        AdventurersBlade.addRestriction("Winged Blade");
        AdventurersBlade.addRestriction("Witchblade");
        AdventurersBlade.addRestriction("Relic Dagger");
        AdventurersBlade.addRestriction("Toxic Blade");
        itemArrayList.add(AdventurersBlade);

        AncientBlade.setDamageType("X");
        AncientBlade.setHealth(50);
        AncientBlade.setMS(0.05);
        AncientBlade.setTier(1);
        AncientBlade.addRestriction("Winged Blade");
        AncientBlade.addRestriction("Witchblade");
        AncientBlade.addRestriction("Relic Dagger");
        AncientBlade.addRestriction("Toxic Blade");
        AncientBlade.addSecondaryRestriction("Adventurer's Blade");
        itemArrayList.add(AncientBlade);

        Boots.setDamageType("P");
        Boots.setMS(0.06);
        Boots.setTier(1);
        Boots.addRestriction("Warrior Tabi");
        Boots.addRestriction("Ninja Tabi");
        Boots.addRestriction("Reinforced Greaves");
        Boots.addRestriction("Talaria Boots");
        Boots.addSecondaryRestriction("Combat Boots");
        itemArrayList.add(Boots);

        CombatBoots.setDamageType("P");
        CombatBoots.setPhysicalPower(10);
        CombatBoots.setMS(0.12);
        CombatBoots.setTier(2);
        CombatBoots.addRestriction("Warrior Tabi");
        CombatBoots.addRestriction("Ninja Tabi");
        CombatBoots.addRestriction("Reinforced Greaves");
        CombatBoots.addRestriction("Talaria Boots");
        itemArrayList.add(CombatBoots);

        WarriorTabi.setDamageType("P");
        WarriorTabi.setPhysicalPower(40);
        WarriorTabi.setMS(0.18);
        WarriorTabi.setTier(3);
        itemArrayList.add(WarriorTabi);

        NinjaTabi.setDamageType("P");
        NinjaTabi.setPhysicalPower(20);
        NinjaTabi.setMana(100);
        NinjaTabi.setAttackSpeed(0.20);
        NinjaTabi.setMS(0.18);
        NinjaTabi.setTier(3);
        itemArrayList.add(NinjaTabi);

        ReinforcedGreaves.setDamageType("P");
        ReinforcedGreaves.setPhysicalPower(10);
        ReinforcedGreaves.setHealth(75);
        ReinforcedGreaves.setCCR(0.20);
        ReinforcedGreaves.setMS(0.18);
        ReinforcedGreaves.setTier(3);
        itemArrayList.add(ReinforcedGreaves);

        TalariaBoots.setDamageType("P");
        TalariaBoots.setPhysicalPower(10);
        TalariaBoots.setMp5(15);
        TalariaBoots.setMS(0.25);
        TalariaBoots.setTier(3);
        itemArrayList.add(TalariaBoots);

        ShoesOfTheMagi.setDamageType("M");
        ShoesOfTheMagi.setMagicalPower(55);
        ShoesOfTheMagi.setMagicalPen(10);
        ShoesOfTheMagi.setMS(0.18);
        ShoesOfTheMagi.setTier(3);
        itemArrayList.add(ShoesOfTheMagi);

        ShoesOfFocus.setDamageType("M");
        ShoesOfFocus.setMagicalPower(55);
        ShoesOfFocus.setMana(250);
        ShoesOfFocus.setCDR(0.10);
        ShoesOfFocus.setMS(0.18);
        ShoesOfFocus.setTier(3);
        itemArrayList.add(ShoesOfFocus);

        ReinforcedShoes.setDamageType("M");
        ReinforcedShoes.setMagicalPower(20);
        ReinforcedShoes.setHealth(75);
        ReinforcedShoes.setCCR(0.20);
        ReinforcedShoes.setMS(0.18);
        ReinforcedShoes.setTier(3);
        itemArrayList.add(ReinforcedShoes);

        TravelersShoes.setDamageType("M");
        TravelersShoes.setMagicalPower(20);
        TravelersShoes.setMp5(15);
        TravelersShoes.setMS(0.25);
        TravelersShoes.setTier(3);
        itemArrayList.add(TravelersShoes);

        MagicShoes.setDamageType("M");
        MagicShoes.setMagicalPower(20);
        MagicShoes.setMS(0.12);
        MagicShoes.setTier(2);
        MagicShoes.addRestriction("Shoes of the Magi");
        MagicShoes.addRestriction("Shoes of Focus");
        MagicShoes.addRestriction("Traveler's Shoes");
        MagicShoes.addRestriction("Reinforced Shoes");
        itemArrayList.add(MagicShoes);

        Shoes.setDamageType("M");
        Shoes.setMS(0.06);
        Shoes.setTier(1);
        Shoes.addRestriction("Shoes of the Magi");
        Shoes.addRestriction("Shoes of Focus");
        Shoes.addRestriction("Traveler's Shoes");
        Shoes.addRestriction("Reinforced Shoes");
        Shoes.addSecondaryRestriction("Magic Shoes");
        itemArrayList.add(Shoes);

        Katana.setDamageType("P");
        Katana.setPhysicalPower(10);
        Katana.setMS(0.05);
        Katana.setTier(1);
        Katana.addRestriction("Stone Cutting Sword");
        Katana.addRestriction("Masamune");
        Katana.addRestriction("Heartseeker");
        Katana.addRestriction("Hastened Katana");
        Katana.addSecondaryRestriction("Thousand Fold Blade");
        Katana.setKatana(true);
        itemArrayList.add(Katana);

        ThousandFoldBlade.setDamageType("P");
        ThousandFoldBlade.setPhysicalPower(20);
        ThousandFoldBlade.setMS(0.08);
        ThousandFoldBlade.setTier(2);
        ThousandFoldBlade.addRestriction("Stone Cutting Sword");
        ThousandFoldBlade.addRestriction("Masamune");
        ThousandFoldBlade.addRestriction("Heartseeker");
        ThousandFoldBlade.addRestriction("Hastened Katana");
        ThousandFoldBlade.setKatana(true);
        itemArrayList.add(ThousandFoldBlade);

        Masamune.setDamageType("P");
        Masamune.setPhysicalPower(50);
        Masamune.setHealth(100);
        Masamune.setMS(0.10);
        Masamune.setTier(3);
        Masamune.setKatana(true);
        itemArrayList.add(Masamune);

        StoneCuttingSword.setDamageType("P");
        StoneCuttingSword.setPhysicalPower(50);
        StoneCuttingSword.setMS(0.10);
        StoneCuttingSword.setTier(3);
        StoneCuttingSword.setKatana(true);
        itemArrayList.add(StoneCuttingSword);

        Heartseeker.setDamageType("P");
        Heartseeker.setPhysicalPower(30);
        Heartseeker.setPhysicalPen(10);
        Heartseeker.setMS(0.10);
        Heartseeker.setTier(3);
        Heartseeker.setKatana(true);
        itemArrayList.add(Heartseeker);

        HastenedKatana.setDamageType("P");
        HastenedKatana.setPhysicalPower(25);
        HastenedKatana.setAttackSpeed(0.25);
        HastenedKatana.setMS(0.10);
        HastenedKatana.setTier(3);
        HastenedKatana.setKatana(true);
        itemArrayList.add(HastenedKatana);
    }

    @Override
    public void start(Stage stage) throws Exception {
        initializeGods();
        initializeItems();
        this.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.setTitle("Smite Builder");
        //stage.getIcons().add(new Image("images/recipeBook.png"));
        stage.show();
    }

    public void resize(double w, double h){
        stage.setWidth(w);
        stage.setHeight(h);
    }

    public static void main (String[]args){
        launch(args);
    }
}