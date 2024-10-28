package pl.edu.pw.mini.zpoif.assignment2;

import pl.edu.pw.mini.zpoif.assignment2.commandos.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ZielonyBeret zielonyBeret = new ZielonyBeret();
        Kierowca kierowca = new Kierowca();
        Szpieg szpieg = new Szpieg();
        Snajper snajper = new Snajper();

        List<Commandos> listaKomandosow = new ArrayList<>();
        listaKomandosow.add(zielonyBeret);
        listaKomandosow.add(kierowca);
        listaKomandosow.add(snajper);
        listaKomandosow.add(szpieg);

        Kierowca.Pistolet pistolet = new Kierowca.Pistolet();
        ZielonyBeret.Automat automat = zielonyBeret.new Automat();

        for(Commandos c : listaKomandosow){
            System.out.println(c);
            c.doSomething(pistolet);
            c.doSomething(automat);
        }

    }
}
