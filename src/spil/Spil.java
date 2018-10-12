package spil;
import java.util.Scanner;

public class Spil {

    private static final int Terning_max = 6;

    //de tre nedenstående variable bruges ikke pt
    //public static final int Terning_min = 1;
    //public static final int Max_sum = 12;
    //public static final int Min_sum = 2;

    private static final int Max_points = 40;
    static boolean spilletErSlut = false;
    static boolean s1tur = true;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Indtast navne
        System.out.println("Indtast navn for spiller 1");
        System.out.println("Navn: ");

        //Spillerne-objekterne laves.
        Spiller spiller1 = new Spiller(scanner.nextLine());
        System.out.println("Indtast navn for spiller 2");
        System.out.println("Navn: ");
        Spiller spiller2 = new Spiller(scanner.nextLine());

        Spiller spillerNu = spiller1;

        //while-loop som kører så længe spillernes score er mindre end 40.
        while (spiller1.getScore() < Max_points && spiller2.getScore() < Max_points) {

            //tur/point-system inspireret af https://github.com/petertbdtu/34_del1/blob/master/34_del1/src/cdio1/Terningespil.java
            //tjekker hvem den nuværende spiller er.
            if(s1tur == true){

                spillerNu = spiller1;
            }else{

                spillerNu = spiller2;
            }
            System.out.println("Det er din tur, " + spillerNu.getSpiller() + "!");
            System.out.println("Tryk enter for at kaste terningerne");
            scanner.nextLine();

            Terning terning1 = new Terning();
            Terning terning2 = new Terning();
            terning1.kast();
            terning2.kast();

            // Hvis begge terninger er 1, bliver scoren sat til 0. ellers fortsætter spillet som normalt.
            if (terning1.getØjne() == 1 && terning2.getØjne()==1 ) {
                //Scoren for spilleren der har slået to 1'ere bliver nulstillet.
                spillerNu.setScore(0);

                System.out.println("spil.Terning 1: " + terning1.getØjne());
                System.out.println("spil.Terning 2: " + terning2.getØjne());
                System.out.println("");
                System.out.println("Du slog to 1'ere, din score er nulstillet");
                System.out.println("");


                if (spillerNu.getScore() > Max_points) {

                    spilletErSlut = true;
                } else {
                    s1tur = !s1tur;

                }
            }
            else {

                System.out.println("spil.Terning 1: " + terning1.getØjne());
                System.out.println("spil.Terning 2: " + terning2.getØjne());

                //beregner summen af to terningslag
                int sum = terning1.getØjne() + terning2.getØjne();

                //Tillæg point
                spillerNu.tilføjScore(sum);

                System.out.println("Summen af terningerne er: " + sum);

                //find vinder eller skift tur
                if (spillerNu.getScore() > Max_points) {

                    spilletErSlut = true;


                } else {
                    s1tur = !s1tur;
                }
            }
            System.out.println(spiller1.getSpiller() + " har scoret " + spiller1.getScore() + " points i alt!");
            System.out.println(spiller2.getSpiller() + " har scoret " + spiller2.getScore() + " points i alt!");
            System.out.println();

        }

        System.out.println(spillerNu + " har vundet");
    }

}
