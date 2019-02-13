public class KnightBoard {
	private int r;
	private int c;
	private Coordinate[][] board; //This board keeps track of the coordinates and how many possible moves from each one
	private int[][] movesBoard; //This board keeps track of the order of the moves, the board to be printed
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


	/*blank boards display 0's as underscores 
	  you get a blank board if you never called solve or 
	  when there is no solution
	*/ 
	public String toString() {
		StringBuffer boardString = new StringBuffer();
		for (int[] r : movesBoard) {
			for (int i : r) {
			
				if (i < 10) {
					boardString.append(" ");
					if (i == 0) {
						boardString.append("_");
					}
					else {
						boardString.append(i);
					}
				}
				else {
					boardString.append(i);
				}
				boardString.append(" ");
			}
			boardString.append("\n");
		}
		return boardString.toString();
	}
	

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