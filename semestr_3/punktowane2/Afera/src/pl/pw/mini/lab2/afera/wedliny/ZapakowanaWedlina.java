package pl.pw.mini.lab2.afera.wedliny;

import java.time.LocalDate;

public class ZapakowanaWedlina extends Wedlina{

    protected LocalDate dataPrzydatnosci;
    protected boolean szczelneOpakowanie;
    protected LocalDateGenerator localDateGenerator = () -> {
        LocalDate now = LocalDate.now();
        LocalDate date = now.plusDays(random.nextInt(141)-70);
        return date;
    };

    public ZapakowanaWedlina(){
        super();
        this.dataPrzydatnosci = localDateGenerator.generateLocalDate();
        if(random.nextInt(10) < 6){
            this.szczelneOpakowanie = true;
        }
        else {
            this.szczelneOpakowanie = false;
        }
    }

    public LocalDateGenerator getLocalDateGenerator() {
        return localDateGenerator;
    }

    @FunctionalInterface
    interface LocalDateGenerator{
        LocalDate generateLocalDate();
    }

    public LocalDate getDataPrzydatnosci() {
        return dataPrzydatnosci;
    }

    public boolean isSzczelneOpakowanie() {
        return szczelneOpakowanie;
    }

    public void setDataPrzydatnosci(LocalDate dataPrzydatnosci) {
        this.dataPrzydatnosci = dataPrzydatnosci;
    }
}
