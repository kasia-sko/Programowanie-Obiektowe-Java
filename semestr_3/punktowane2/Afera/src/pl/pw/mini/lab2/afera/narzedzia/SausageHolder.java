package pl.pw.mini.lab2.afera.narzedzia;

import pl.pw.mini.lab2.afera.wedliny.*;

import java.util.Collections;
import java.util.LinkedList;

public class SausageHolder {

    protected LinkedList<Wedlina> wedliny;

    public SausageHolder(){
        this.wedliny = new LinkedList<>();
        for(int i = 0; i < 100; i++){
            wedliny.add(new Kielbasa());
            wedliny.add(new Poledwica());
            wedliny.add(new SzynkaParmenska());
            wedliny.add(new SzynkaZwykla());
        }
        Collections.shuffle(wedliny);
    }

    public LinkedList<Wedlina> getWedliny() {
        return wedliny;
    }
}
