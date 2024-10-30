package pl.edu.pw.mini.zpoif.assignment2.commandos;
import pl.edu.pw.mini.zpoif.assignment2.equipment.Jedzenie;
import pl.edu.pw.mini.zpoif.assignment2.equipment.Weapon;


public class Snajper extends KomandosZBeretem{

    protected KolorBeretu kolorBeretu;

    public Snajper(){
        this.kolorBeretu = KolorBeretu.SZARY;
    }

    @Override
    public void eatSomething() {
        if(random.nextBoolean()){
            Czekolada czekolada = new Czekolada();
            czekolada.eat();
        }
        else {
            class Kawa extends Jedzenie {
                @Override
                public void eat() {
                    System.out.println("Kawa");
                }
            }
            Kawa kawa = new Kawa();
            kawa.eat();
        }
    }

    @Override
    public void useWeapon(Weapon weapon) {
        if(weapon instanceof KarabinSnajperski){
            weapon.use();
        }
        else if(random.nextInt(10) > 7){
            class RozszerzonyKarabinSnajperski extends KarabinSnajperski {
                @Override
                public void use() {
                    System.out.println("Używam rozszerzonego karabinu");
                }
            }
            RozszerzonyKarabinSnajperski rozszerzonyKarabinSnajperski = new RozszerzonyKarabinSnajperski();
            rozszerzonyKarabinSnajperski.use();
        }

    }

    private static class KarabinSnajperski extends Weapon{

        @Override
        public void use() {
            System.out.println(SNIPER_RIFFLE_SOUND);
        }
    }

    private static class Czekolada extends Jedzenie {

        private final static int liczbaKalorii = 550;

        public void eat(){
            for(int i = 0; i< PARAMETR_1; i++){
            System.out.println("Mlask mlask " + liczbaKalorii);
            System.out.println();
        }
        }
    }
}
