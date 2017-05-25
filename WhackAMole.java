// Name : Mihir Patel
// Date : May 21, 2017
// Desc : Implement a 2D "Whack A Mole" game.


import java.util.Random;
import java.util.Scanner;

public class WhackAMole {
	
    // instance variables
    int scores = 0, molesLeft = 0, attemptsLeft = 50;
    char [][] moleGrid = new char [10][10];
    
    // constructor
    public WhackAMole(int numAttempts, int gridDimension) {
        this.attemptsLeft = numAttempts;
        this.moleGrid= new char[gridDimension][gridDimension];
        for (int i = 0; i < gridDimension; i++) {
             for (int j = 0; j < gridDimension; j++) {
                  moleGrid[i][j] = '*';
             }
        }
    }
    
    // given a location, place a mole at that location and return true. Otherwise, return false.
    boolean place (int x, int y) {
        if (moleGrid[x][y] == '*') {
        	moleGrid[x][y] = 'M';
                molesLeft++;
        	return true;
        }
    	return false;
    }
    
    // given a location, take a "whack" at that location. If mole exists there, increment the score and 
    // decrement the number of moles. Otherwise, increment the number of attempts.
    void whack (int x, int y) {
        if (moleGrid[x][y] == 'M') {
        	moleGrid[x][y] = 'W';
        	scores++;
        	molesLeft--;
        }
      	attemptsLeft--;
    }

    // print the mole grid to user (hiding the moles)
    void printGridToUser() {
        int rows = moleGrid.length;
        int cols = moleGrid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (moleGrid[i][j] == 'W') {
                    System.out.print(moleGrid[i][j]);
                }
                else {
                    System.out.print('*');
                }
            }
      	    System.out.println("");
        }
    }
    
    // print the mole grid
    void printGrid() {
    	int rows = moleGrid.length;
    	int cols = moleGrid[0].length;
    	for (int i = 0; i < rows; i++) {
    	    for (int j = 0; j < cols; j++) {
    		System.out.print(moleGrid[i][j]);
       	    }
       	    System.out.println("");
    	}
    }
    
    // set up a grid with moles at random locations.
    void setRandom() { 
    	int count = 0;
    	while (true) {
    		int rand_x =  new Random().nextInt(10);
    	    int rand_y =  new Random().nextInt(10);
    	    
    	    if (moleGrid[rand_x][rand_y] == 1) {
    	    	continue;
    	    }
    	    else {
    	    	moleGrid[rand_x][rand_y] = 1;
    	    	count++;
    	    }
    	    
    	    if (count >= 10) {
    	    	break;
    	    }
    	}
    }
    
    public static void main(String[] args) {

    }

}
