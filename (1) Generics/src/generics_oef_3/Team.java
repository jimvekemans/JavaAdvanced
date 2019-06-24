package generics_oef_3;

/* Maak nu een klasse Team. Voorzie de volgende eigenschappen:
    - name,
    - played (=aantal wedstrijden gespeeld),
    - won (= aantal wedstrijden gewonnen),
    - lost (= aantal wedstrijden verloren),
    - tied (=aantal wedstrijden gelijkgespeeld)
    - members (lijst van spelers, gebruik hiervoor een ArrayList).
   Voorzie enkel getters.

   In de constructor geef je enkel een naam mee voor het team.

   Voorzie de methode addPlayer om een speler aan het team toe voegen
   een methode numberOfPlayers om te vragen hoeveel spelers er in het team zitten.

   Kan je spelers met een verschillend type (bv. BaseballPlayer en SoccerPlayer) in één team toevoegen?
   Test uit! Zorg ervoor dat dit niet (meer) mogelijk is.

   Voorzie de methode matchResult(Team opponent, int ourScore, int theirScore).
   Deze methode zorgt ervoor dat voor het Team waarvoor de methode wordt aangeroepen en de opponent het aantal
   gespeelde, gewonnen, verloren en gelijkspel wedstrijden wordt opgehoogd afhankelijk van de waarden van ourScore en theirScore.

   Kan je bovenstaande methode aanroepen voor een team van volleybalspelers tegen een team van baseballspelers?
   Los dit eventueel op, zodat dat niet langer mogelijk is.

   Voeg tenslotte een methode ranking() toe.
   Deze geeft een geheel getal terug waarbij het team 3 punten krijgt voor elke gewonnen wedstrijd en 1 punt voor geen wedstrijd met gelijkspel.
*/


import java.util.ArrayList;
import java.util.List;

public class Team <T extends Player> {
    private String name;
    private int Played, won, lost, tied;
    private List<T> members;

    public Team(String name) {
        this.name = name;
        members = new ArrayList<>();
    }

    public void addPlayer(T player){
        members.add(player);
    }

    public int numberOfPlayers(){
        return members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore){
        if(ourScore > theirScore) won++;
        if(theirScore > ourScore) lost++;
        if(ourScore == theirScore) tied++;
    }

    public int ranking(){
        return won * 3 + tied;
    }

    public String getName() {
        return name;
    }

    public int getPlayed() {
        return Played;
    }

    public int getWon() {
        return won;
    }

    public int getLost() {
        return lost;
    }

    public int getTied() {
        return tied;
    }

    public List<T> getMembers() {
        return members;
    }
}
