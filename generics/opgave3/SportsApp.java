package opgave3;

public class SportsApp {
    static Team<SoccerPlayer> soccerPlayerTeam = new Team<>("Germany");
    static Team<BaseballPlayer> baseballPlayerTeam = new Team<>("Smashy bois");
    static Team<VolleyballPlayer> volleyballPlayerTeam = new Team<>("Bouncy bois");

    public static void main(String[] args) {
        Team<SoccerPlayer> otherSoccerTeam = new Team<>("Brazil");
        //soccerPlayerTeam.addPlayer(new BaseballPlayer("Bobby"));
        soccerPlayerTeam.addPlayer(new SoccerPlayer("Billy"));
        otherSoccerTeam.addPlayer(new SoccerPlayer("Benny"));
        soccerPlayerTeam.matchResult(otherSoccerTeam, 7, 1);
        //otherSoccerTeam.matchResult(volleyballPlayerTeam,13,20);
        System.out.println("Germany ranking:" + soccerPlayerTeam.ranking());
        System.out.println("Germany ranking:" + otherSoccerTeam.ranking());
    }
}
