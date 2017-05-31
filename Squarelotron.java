import java.util.*;

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

	
	void rotateRight(int numberOfTurns) {

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
		Squarelotron s = new Squarelotron(4);
		s.display();
		Squarelotron t = new Squarelotron(4);
		t = s.mainDiagonalFlip(1);
		t.display();
		
	}

}
