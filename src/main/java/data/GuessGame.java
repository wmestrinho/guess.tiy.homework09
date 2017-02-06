package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by WagnerMestrinho on 2/5/17.
 */
public class GuessGame {
    private int target;
    private int minimun;
    private int maximun;
    private int tries;
    private String scoreBoard;
    private boolean finished = false;
    private String message;
    private int guesses;
    private String playerName;

    public GuessGame() {
        Properties prop = new Properties();
        try {
            InputStream file = new FileInputStream(Constants.PROPERTIES_FILENAME);
            prop.load(file);
            file.close();
        } catch (IOException io) {
            io.printStackTrace();

        }
        this.target = Integer.parseInt(prop.getProperty(Constants.TARGET));
        this.tries = Integer.parseInt(prop.getProperty(Constants.MAX_NUMBER_OF_TRIES));
        this.minimun = Integer.parseInt(prop.getProperty(Constants.MIN_VALUE));
        this.maximun = Integer.parseInt(prop.getProperty(Constants.MAX_VALUE));
        this.scoreBoard = prop.getProperty(Constants.PLAYER_FILENAME);
        this.guesses = 0;
    }
    public void play(int guessNum,Player player, HighScore highScore) {
        this.guesses++;
        highScore.setFilePath(this.scoreBoard);
        if (this.guesses > this.tries) {
            this.message = "MAX_NO_OF_TRIES";
            finished = true;
            player.setGamesLost(player.getGamesLost()+1);
        } else {
            if (guessNum < this.minimun || guessNum > this.maximun) {
                this.message = "OUT_OF_RANGE";
                finished = true;
                player.setGamesLost(player.getGamesLost()+1);
            } else {
                if (guessNum < this.target) {
                    this.message = "LOW";
                    finished = false;
                } else {
                    if (guessNum > this.target) {
                        this.message = "HIGH";
                        finished = false;
                    } else {
                        this.message = "MATCH";
                        finished = true;
                        player.setGamesWon(player.getGamesWon() + 1);
                        highScore.setHighScore(this.guesses);
                        highScore.setAsHighScore();


                    }
                }
            }
        }
    }



}
