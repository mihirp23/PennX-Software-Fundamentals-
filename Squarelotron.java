
public class Squarelotron {
    int [][] squarelotron = new int [3][3];
	int size;
	
	/* fills the 2-dimensional array with the numbers 1 to n squared, in order.
	 It also sets the size instance variable to be n. */
	public Squarelotron(int n) {
        this.squarelotron = new int[n][n];
		int count = 1;
		for (int i = 0; i < n; i++) {
        	    for (int j = 0; j < n; j++ ){
        	     	squarelotron[i][j] = count;
        		count++;
        	    }
                }
		this.size = n;
        }
	
	/* This method performs the Upside-Down Flip of the squarelotron, 
	 and returns the new squarelotron. 
	 The original squarelotron is not modified */
	public Squarelotron upsideDown(int ring) {
		
		return null;
	}
	
	/*This method performs the Main Diagonal Flip of the squarelotron,
	and returns the new squarelotron. 
	The original squarelotron is not  modified */
	public Squarelotron mainDiagonal(int ring) {
		
		return null;
	}
	
	/*The argument numberOfTurns indicates the number of times the entire 
	squarelotron should be rotated 90° clockwise. Any integer, 
	including zero and negative integers, is allowable as the argument.
	A value of -1 indicates a 90° counterclockwise rotation. 
	This method modifies the internal representation of the squarelotron;
	it does not create a new squarelotron.*/
	void rotateRight(int numberOfTurns){
		
		
	}
	
}
