package pl.edu.pw.mini.zpoif.assignment2.commandos;

import pl.edu.pw.mini.zpoif.assignment2.equipment.Weapon;

public class Kierowca extends KomandosZBeretem{

    protected Commandos.KolorBeretu kolorBeretu;
    protected static boolean pozwolenieNaBron = true;

    public Kierowca() {
        this.kolorBeretu = Commandos.KolorBeretu.CZARNY;
    }

    @Override
    public void eatSomething() {
        if(random.nextInt(10) < 1){
            Suchary suchary = new Suchary();
            suchary.eat();
        }
        else {
            System.out.println("Nie zjem :((");
        }
    }

    @Override
    public void useWeapon(Weapon weapon) {
        if(weapon instanceof Pistolet){
            weapon.use();
        }
        else{
            Weapon nieznanaBron = new Weapon() {
                @Override
                public void use() {
                    System.out.println("Strzelam z nieznanej broni");
                }
            };
            nieznanaBron.use();
        }

    }

    public static class Pistolet extends Weapon{

        @Override
        public void use() {
            if(pozwolenieNaBron) {
                System.out.println("Strzelam z pistoletu");
            }
            else{
                System.out.println("Nie mogę strzelać z pistoletu");
            }
        }
    }
}
