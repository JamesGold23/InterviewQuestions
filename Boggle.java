
public class Boggle {
	static int BOARD_DIM;
	static protected int letter_x;
	static protected int letter_y;
	
	public static boolean inBoard(char[][] board, String word) {
		BOARD_DIM = board.length;
		return inBoard(board, word, 0);
	}
	
	protected static boolean inBoard(char[][] board, String word, int i) {
		if (i >= word.length()) {
			return true;
		} else if (i == 0) {
			for (int j = 0; j < BOARD_DIM; j++) {
				for (int k = 0; k < BOARD_DIM; k++) {
					if (board[j][k] == word.charAt(i)) {
						letter_x = j;
						letter_y = k;
						return adjacent(board, word, i, letter_x, letter_y) &&
								inBoard(board, word, i+1);
					}
				}
			}
			return false;
		} else {
			return adjacent(board, word, i, letter_x, letter_y) &&
					inBoard(board, word, i+1);
		}
	}
	
	protected static boolean adjacent(char[][] board, String word, int i, int j, int k) {
		if (i == word.length() - 1) {
			return true;
		} else {
			for (int x = j-1; x <= j+1; x++) {
				for (int y = k-1; y <= k+1; y++) {
					if (x < 0 || x >= BOARD_DIM || y < 0 || y >= BOARD_DIM || (x == j && y == k)) {
						continue;
					} else {
						if (board[x][y] == word.charAt(i+1)) {
							letter_x = x;
							letter_y = y;
							return true;
						}
					}
				}
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		char[][] board = {{'S', 'M', 'E', 'F'}, {'R', 'A', 'T', 'D'}, {'L', 'O', 'N', 'I'}, {'K', 'A', 'F', 'B'}};
		System.out.println(Boggle.inBoard(board, "IBIBIBIB"));
	}
}
