package spil;
import java.util.Random;

public class Terning {

    private int øjne;
    //random-metoden er hentet fra https://www.geeksforgeeks.org/java-util-random-nextint-java
Random ran = new Random();
    //spil.Terning-objekterne laves.

    public void kast(){

        øjne = ran.nextInt(6)+1;
    }

    public int getØjne() {
        return øjne;
    }

}

