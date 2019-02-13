public class KnightBoard {
	private int r;
	private int c;
	private Coordinate[][] board;
	private int[][] movesBoard;
	public KnightBoard(int startingRows,int startingCols) {
		r = startingRows;
		c = startingCols;
		board = new Coordinate[r][c];
		movesBoard = new int[r][c];
		for (int i  = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				board[r][c] = new Coordinate(r , c);
			}
		}
	}

	//Initialize the board to the correct size and make them all 0's 


	public String toString() {
		StringBuffer boardString = new StringBuffer();
	}
	/*blank boards display 0's as underscores 
you get a blank board if you never called solve or 
when there is no solution
	 */ 

	/**
	@throws IllegalStateException when the board contains non-zero values.
	@throws IllegalArgumentException when either parameter is negative 
	or out of bounds.
	 */
	public boolean solve(int startingRow, int startingCol) {}

	/**
	 * @throws IllegalStateException when the board contains non-zero values. 
	@throws IllegalArgumentException when either parameter is negative 
	or out of bounds.
	 */
	public int countSolutions(int startingRow, int startingCol) {}

}