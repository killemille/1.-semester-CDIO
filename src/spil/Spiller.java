package spil;
public class Spiller {

    // spiller-klassen oprettes. Hvert spiller-objekt kan have følgende værdier i sig. kan laves private?
    private int score;
    String navn;

    public Spiller(String navn) {

        this.navn = navn;
        score = 0;

    }

    //metode som returnerer spillerens score. Lige nu er score public, og nedenstående bruges ikke.
    public int getScore()
    {

        return score;
    }
    public void setScore(int score){
        this.score=score;

    }



    public String getSpiller(){

        return navn;

    }
    public String toString(){

        return navn;
    }

    public void tilføjScore(int tilføj){

        score = score + tilføj;
    }


}
