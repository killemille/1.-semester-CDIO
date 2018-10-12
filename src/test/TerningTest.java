package test;

import spil.Terning;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TerningTest {

    /** @Aurthor Sascha TJ
     * Vi tester hvor mange gange hver sumværdi fra 2-12 fremkommer
     */

    @org.junit.jupiter.api.Test
    void getTerning() {
        Terning test = new Terning();
        Terning test2 = new Terning();

        //Vi opretter et array på 13 istedet for 11, så arraynummeret stemmer overens med sumværdien.
        int[] arr = new int[13];

        //Terningerne bliver kastet 10.000 gange
        for (int i = 0; i < 10000; i++) {
            test.kast();
            test2.kast();
            arr[test.getØjne()+test2.getØjne()]++;

        }
        for(int i : arr) {
            System.out.println(i);
        }

        //Vi tester hvor mange gange hver sumværdi fremkommer,
        // og om det stemmer i overens med den realistiske sandsynlighed.
        //Vi har her sat afvigelsen til 20%

        assertEquals(0, arr[1]);
        assertEquals(278, arr[2], 56);
        assertEquals(556, arr[3], 112);
        assertEquals(833, arr[4], 166);
        assertEquals(1011, arr[5], 222);
        assertEquals(1389, arr[6], 278);
        assertEquals( 1667, arr[7], 334);
        assertEquals(1389, arr[8], 278);
        assertEquals(1011, arr[9], 222);
        assertEquals(833, arr[10], 166);
        assertEquals(556, arr[11], 112);
        assertEquals(278, arr[12], 56);
    }

    
}