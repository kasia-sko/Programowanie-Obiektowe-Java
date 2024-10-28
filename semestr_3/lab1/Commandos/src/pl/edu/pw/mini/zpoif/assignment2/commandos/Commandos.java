package pl.edu.pw.mini.zpoif.assignment2.commandos;

import pl.edu.pw.mini.zpoif.assignment2.equipment.Weapon;

import java.util.Random;

public abstract class Commandos {

    protected static final int PARAMETR_1 = 15;
    protected static final int PARAMETR_2 = 30;
    protected static final int PARAMETR_3 = 4;
    protected static String SNIPER_RIFFLE_SOUND = "bzbzbzbzbbz";

    protected static Random random = new Random();


    protected enum KolorBeretu {ZIELONY, CZARNY, SZARY};

    public abstract void eatSomething();

    public abstract void useWeapon(Weapon weapon);

    public void doSomething(Weapon weapon){
        eatSomething();
        useWeapon(weapon);
    }
}
