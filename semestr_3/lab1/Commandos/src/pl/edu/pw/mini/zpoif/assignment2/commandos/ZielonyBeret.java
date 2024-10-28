package pl.edu.pw.mini.zpoif.assignment2.commandos;

import pl.edu.pw.mini.zpoif.assignment2.equipment.Weapon;

public class ZielonyBeret extends KomandosZBeretem{

    protected KolorBeretu kolorBeretu;
    protected int zapasAmunicji;

    public ZielonyBeret() {
        this.kolorBeretu = KolorBeretu.ZIELONY;
        this.zapasAmunicji = 100;
    }


    @Override
    public void eatSomething() {
        Suchary suchary = new Suchary();
        for(int i = 0; i < (int) Math.sqrt(PARAMETR_1); i++) {
            suchary.eat();
        }
    }


    @Override
    public void useWeapon(Weapon weapon) {

        if(weapon instanceof Automat){
            weapon.use();
        }
        else {
            Weapon luk = new Weapon() {
                @Override
                public void use() {
                    System.out.println("łuk użyty");
                }
            };
            luk.use();
        }
    }

    public class Automat extends Weapon{

        @Override
        public void use() {
            if(zapasAmunicji > PARAMETR_3){
                System.out.println("Wystrzelono " + PARAMETR_3 + " razy z automatu");
            }
            zapasAmunicji -= PARAMETR_3;
        }
    }
}
