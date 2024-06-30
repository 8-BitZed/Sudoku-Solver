// Sudoku board to be solved
class Main {
	public static int[][] grid = {
			{ 0, 0, 0, 0, 9, 6, 0, 0, 0 },
			{ 0, 4, 0, 2, 0, 8, 0, 6, 0 },
			{ 0, 0, 0, 7, 5, 0, 8, 0, 2 },
			{ 3, 0, 0, 0, 6, 0, 0, 0, 0 },
			{ 0, 0, 0, 3, 0, 0, 0, 0, 0 },
			{ 0, 0, 9, 0, 0, 5, 6, 3, 0 },
			{ 0, 0, 0, 5, 3, 0, 0, 2, 0 },
			{ 2, 5, 0, 0, 4, 0, 0, 1, 0 },
			{ 6, 1, 0, 0, 0, 0, 4, 0, 0 }
	};

	// Function checking if number "n" is allowed at position "x" and "y"
	static boolean check(int y, int x, int n) {

		// check for n in row
		for (int i = 0; i < 9; i++) {
			if (grid[i][x] == n) {
				return false;
			}
		}

		// check for n in column
		for (int j = 0; j < 9; j++) {
			if (grid[y][j] == n) {
				return false;
			}
		}

		int subrow = (y / 3) * 3;
		int subcolumn = (x / 3) * 3;

		// check if n is in 3x3 square
		for (int k = subrow; k < (subrow + 3); k++) {
			for (int l = subcolumn; l < (subcolumn + 3); l++) {
				if (grid[k][l] == n) {
					return false;
				}
			}
		}

		return true;
	}

	// Function to print grid to terminal
	static void show_grid() {
		for (int[] x : grid) {
			System.out.println();
			for (int c : x) {
				System.out.print(c + " ");
			}
		}
	}

	// Recursive function to check each number at each position backtracking if number is not allowed.
	// starts from top left corner and goes from left to right
	static void solve() {
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				if (grid[y][x] == 0) {
					for (int c = 1; c < 10; c++) {
						if (check(y, x, c)) {
							grid[y][x] = c;
							solve();
							grid[y][x] = 0;
						}
					}
					return;
				}
			}
		}
		System.out.println();
		show_grid();
	}

	public static void main(String[] args) {

		show_grid();

		solve();
	}
}