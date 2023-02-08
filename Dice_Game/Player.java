package Dice_Game;

/**
 * a class to represent the player and computer in a dice game
 * @author  Yash Patel  , july 05 2021
 */


public class Player {
    private String playerName;

    private String computerName;


    /**
     *
     * @param playerName  Name of the player
     * @param computerName Name of the Computer player
     */


    public Player( String playerName, String computerName) {
        this.playerName = playerName;
        this.computerName = computerName;

    }

    public String getUserName() {
        return playerName;
    }

    public void setUserName(String userName) {
        this.playerName = userName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getComputerName() {
        return computerName;
    }

}
