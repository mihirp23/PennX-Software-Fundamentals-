// Name : Mihir Patel
// Date : May 31, 2017
// Desc : Manipulate squarelotron.

public class Squarelotron {
	int[][] squarelotron = new int[3][3];
	int size;

	
	public Squarelotron(int n) {
		this.squarelotron = new int[n][n];
		int count = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				squarelotron[i][j] = count;
				count++;
			}
		}
		this.size = n;
	}

	// This method performs the Upside-Down Flip of the squarelotron,
	// and returns the new squarelotron.
	public Squarelotron upsideDownFlip(int ring) {

		Squarelotron t = new Squarelotron(this.size);
		ring = ring - 1;
		int i = ring;
		while (i <= this.size - 1 - ring) {
			if (i == ring || i == this.size - 1 - ring) {
				int j = ring;
				while (j <= this.size - 1 - ring) {
					t.squarelotron[i][j] = this.squarelotron[this.size - 1 - i][j];
					j++;

				}
			} else {
				t.squarelotron[i][ring] = this.squarelotron[this.size - 1 - ring - i][ring];
				t.squarelotron[i][this.size - 1 - ring] = this.squarelotron[this.size - 1 - ring - i][this.size - 1
						- ring];
			}
			i++;
		}
		return t;

	}

	// This method performs the Main Diagonal Flip of the squarelotron,
	// and returns the new squarelotron. 
	public Squarelotron mainDiagonalFlip(int ring) {
		Squarelotron t = new Squarelotron(this.size);
		ring--;
		int i = ring;
		while (i <= this.size - 1 - ring) {
			if (i == ring) {
				int j = ring;
				while (j <= this.size - 1 - ring) {
					if (j == 0) {
						j++;
						continue;
					}
					t.squarelotron[i][j] = this.squarelotron[j][i];
					t.squarelotron[j][i] = this.squarelotron[i][j];
					j++;
				}
			} else {
				t.squarelotron[i][this.size - 1 - ring] = this.squarelotron[this.size - 1 - ring][i];
				t.squarelotron[this.size - 1 - ring][i] = this.squarelotron[i][this.size - 1 - ring];

			}
			i++;
		}

		return t;

	}

	
	// The argument numberOfTurns indicates the number of times the entire squarelotron 
	// should be rotated 90 degrees clockwise. Any integer, including zero and negative integers, 
	// is allowable as the argument. A value of -1 indicates a 90 degrees counterclockwise
	// rotation. This method modifies the internal representation of the squarelotron
	void rotateRight(int numberOfTurns) {

		if (numberOfTurns > 0) {
			numberOfTurns = numberOfTurns % 4;
		} else if (numberOfTurns < 0) {
			numberOfTurns = (4 + numberOfTurns) % numberOfTurns;
		}

		if (numberOfTurns == 0) {
			return; // no need to rotate
		}

		Squarelotron t = new Squarelotron(this.size);

		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {

				int pos_i, pos_j;
				if (numberOfTurns == 1) {
					pos_i = j;
					pos_j = this.size - 1 - i;
				} else if (numberOfTurns == 2) {
					pos_i = this.size - 1 - i;
					pos_j = this.size - 1 - j;
				} else {
					pos_i = this.size - 1 - j;
					pos_j = i;
				}
				t.squarelotron[pos_i][pos_j] = this.squarelotron[i][j];
			}

		}

		this.squarelotron = t.squarelotron;

	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		final Squarelotron t = (Squarelotron) obj;
		if (this.size != t.size) {
			return false;
		}
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (this.squarelotron[i][j] != t.squarelotron[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	// display the squarelotron
	public void display() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				System.out.print(this.squarelotron[i][j]);
				System.out.print("   |");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		Squarelotron t = new Squarelotron(3);
		
		t.display();
		t.rotateRight(1);
		t.display();
	}

}
