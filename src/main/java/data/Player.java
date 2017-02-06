package data;

/**
 * Created by WagnerMestrinho on 2/4/17.
 */
public class Player {
        private String playerName;
        private int gamesPlayed;
        private int gamesWon;
        private int gamesLost;


        public Player(){
            gamesPlayed = 0;
            gamesWon = 0;
            gamesLost = 0;
        }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }
}
