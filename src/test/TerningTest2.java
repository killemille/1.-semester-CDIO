package test;

import org.junit.jupiter.api.Test;
import spil.Terning;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TerningTest2 {

    /** @Aurthor Sascha TJ
     * Vi tester hvor mange gange et hvilket som helst par fremkommer.
     */

    @Test
    void kast() {
        Terning test = new Terning();
        Terning test2 = new Terning();

        // Vi definerer at vi starter med at have 0 par
        int par = 0;

        //Vi kaster terningerne 10.000 gange.
        for (int i = 0; i < 10000; i++){
            test.kast();
            test2.kast();

        // Vi definer hver terning som x og y
            int x = test.getØjne();
            int y = test2.getØjne();

        // Hvis x og y (terningerne) er lig med hinanden tæller testen at der er slået et par.
            if (x == y){
                par++;

            }

        }

        System.out.println(par);

        // Vi tester hvor mange gange et par fremkommer, iforhold til den realistiske sandsynlighed.
        // Vi har sat afvigelsen til 10%
        assertEquals(1667, par,167);
    }

}