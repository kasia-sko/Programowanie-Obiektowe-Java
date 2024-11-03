package pl.pw.mini.lab2.afera;

import pl.pw.mini.lab2.afera.narzedzia.SausageFreshmaker;
import pl.pw.mini.lab2.afera.narzedzia.SausageHolder;
import pl.pw.mini.lab2.afera.narzedzia.SausageReviewer;

public class Main {

    public static void main(String[] args) {

        SausageHolder sausageHolder = new SausageHolder();
        SausageReviewer sausageReviewer = new SausageReviewer(sausageHolder);

        sausageReviewer.printLessThanAvg();
        sausageReviewer.printTheWorstHams();

        SausageFreshmaker sausageFreshmaker = new SausageFreshmaker(sausageReviewer);

        sausageFreshmaker.upgradeSausages();
        sausageFreshmaker.upgradeHams();
        sausageFreshmaker.upgradeDates();
    }
}
