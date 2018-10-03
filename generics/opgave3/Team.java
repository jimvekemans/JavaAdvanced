package opgave3;

import java.util.ArrayList;

public class Team<T extends Player> {
    String name;
    int played, won, lost, tied;
    ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPlayed() {
        return played;
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

    public ArrayList<T> getMembers() {
        return members;
    }

    void addPlayer(T player) {
        members.add(player);
    }

    int numberOfPlayers() {
        return members.size();
    }

    void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            won++;
            opponent.lost = opponent.lost + 1;
        } else if (ourScore == theirScore) {
            tied++;
            opponent.tied = opponent.tied + 1;
        } else {
            lost++;
            opponent.won = opponent.won + 1;
        }
        played++;
        opponent.played = opponent.played + 1;
    }

    int ranking() {
        return won * 3 + tied;
    }
}
