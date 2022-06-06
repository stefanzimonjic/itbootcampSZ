package projectMauntaineer;

import stefan.Main;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        Mauntain mauntain = new Mauntain("Tara", "Serbia", 1500);

        ArrayList<Mauntaineer> mauntaineers = new ArrayList<>();
        mauntaineers.add(new RecreationalMauntaineer(15, "Gojko", "Radovic",
                14, "Ivanjica", 2500));
        mauntaineers.add(new RecreationalMauntaineer(16, "Jovan", "Djordjevic",
                16, "Novi Becej", 3250));
        mauntaineers.add(new RecreationalMauntaineer(17, "Milan", "Milanovic",
                15, "Novi Sad", 4600));

        mauntaineers.add(new Alpinist(18, "Jovan", "Bojic",
                48));
        mauntaineers.add(new Alpinist(19, "Gordana", "Zoric",
                39));
        mauntaineers.add(new Alpinist(20, "Svetlana", "Jocic",
                28));

        int totalMembership = 0;
        for (Mauntaineer mauntaineer : mauntaineers) {
            mauntaineer.print();
            if (mauntaineer.successfulAscent(mauntain)) {
                System.out.println("Uspsan uspon!");
            } else {
                System.out.println("Neuspesan uspon!");
            }
            totalMembership += mauntaineer.membershipCalculation();
        }

        System.out.println(totalMembership);
    }
}
