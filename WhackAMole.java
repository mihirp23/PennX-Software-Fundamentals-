// Name : Mihir Patel
// Date : May 21, 2017
// Desc : Implement a 2D "Whack A Mole" game.


import java.util.Random;
import java.util.Scanner;

public class WhackAMole {
	
	// instance variables
    int scores = 0, molesLeft = 10, attempts = 0;
    int [][] moleGrid = new int [10][10];
    
    // default constructor
    public WhackAMole() {}
    
    // constructor
    public WhackAMole(int numAttempts, int gridDimension) {
        this.attempts = numAttempts;
        this.moleGrid= new int[gridDimension][gridDimension];
    }
    
    // given a location, place a mole at that location and return true. Otherwise, return false.
    boolean place (int x, int y) {
        if (moleGrid[x][y] == 0) {
        	moleGrid[x][y] = 1;
        	return true;
        }
    	return false;
    }
    
    // given a location, take a "whack" at that location. If mole exists there, increment the score and 
    // decrement the number of moles. Otherwise, increment the number of attempts.
    void whack (int x, int y) {
        if (moleGrid[x][y] == 1) {
        	moleGrid[x][y] = 2;
        	scores++;
        	molesLeft--;
        }
        else {
        	attempts++;
        }
    }
    
    // print the mole grid
    void printGrid() {
    	int rows = moleGrid.length;
    	int cols = moleGrid[0].length;
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < cols; j++) {
    			char ch = '*';
    			if (moleGrid[i][j] == 1) {
    				ch = 'M'; //  mole
    			}
    			else if (moleGrid[i][j] == 2) {
    				ch = 'W'; // whacked mole
    			}
    			else {
    				ch = '*';
    			}
    			System.out.print(ch);
    			
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
		
		// set up the game for the user
		System.out.println("Welcome to my game of Whack A Mole!");
		System.out.println("You have 50 attempts...");
		System.out.println("Enter the coordinate to whack a position on the grid.");
		System.out.println("To quit, enter (-1,-1)");
		WhackAMole myGame = new WhackAMole() ;
		myGame.setRandom();
		
		// let the user play...
		int x,y;
		do {
			System.out.print("enter coordinate ");
			Scanner i = new Scanner(System.in);
			x = i.nextInt();
			y = i.nextInt();
			myGame.whack(x, y);
			System.out.println("");
		}  while (x != -1 && y != -1 && myGame.attempts < 50 && myGame.molesLeft > 0);
		
		// display the final info after the game.
		myGame.printGrid();
		System.out.println("Game Over! Thank you for playing...");
		System.out.print("Score : ");
		System.out.print(myGame.scores);
		System.out.println();
		System.out.print("Moles left : ");
		System.out.print(myGame.molesLeft);
  	}

}
