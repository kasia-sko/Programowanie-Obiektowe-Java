package pw.mini.lab1;

public class Turysta extends Gosc{


    public Turysta() {
        super();
    }

    @Override
    public void nastraszMnie(int moc) {
        if(moc > odpornosc){
            switch (stan) {
                case NORMALNY:
                    stan = Stan.PRZERAZONY;
                    break;
                case PRZERAZONY:
                    stan = Stan.PANIKA;
                    break;
                case PANIKA:
                    break;
            }
        } else if (moc < odpornosc) {
            switch(stan){
                case PANIKA:
                    stan = Stan.PRZERAZONY;
                    break;
                case PRZERAZONY:
                    stan = Stan.NORMALNY;
                    break;
                case NORMALNY:
                    break;
            }

        }
        System.out.println("Aktualny stan: " + stan);

    }
}
