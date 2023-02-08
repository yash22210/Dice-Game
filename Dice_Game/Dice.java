package Dice_Game;

import java.util.Random;

/**
 * a class to roll the dice  for dice Game
 * @author Yash Patel, july 05 2021
 */


public class Dice {
    private int Max_ROLLS;   // the maximum number of roll
    private double rolls = 0; // the number of count for dice rolled


    /**
     *
     * @param max_ROLLS Assign the maximum rolls
     */
    public Dice (int max_ROLLS) {
        this.Max_ROLLS = max_ROLLS;

    }


    /**
     * Roll the dice
     * @param dice the player dice number
     * @return return the player dice number using random numbers between the range 1-6
     */
    public int roll(int dice) {
        Random rand = new Random();
        // the number of rolls to be added (0.5 because the dice is rolled twice (Player dice, Computer dice) )
        rolls += 0.5;
        dice = rand.nextInt(6) + 1;
        return  dice;
    }

    public double getRolls() {
        return rolls;
    }

    public int getMax_ROLLS() {
        return Max_ROLLS;
    }

    public void reset()
    {
        rolls = 0;
    }
    public int rollsAvailable()
    {
        return (int) (getMax_ROLLS() - rolls);
    }
}
