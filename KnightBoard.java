import java.util.*;
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
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				board[i][j] = new Coordinate(i , j);
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
	public boolean solve(int startingRow, int startingCol) {
		if (!isClear()) {
			throw new IllegalStateException();
		}
		try {
			movesBoard[startingRow][startingCol] = 1;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException();
		}
		return solveHelp(startingRow, startingCol, 2);	
	}
	private boolean solveHelp(int row, int col, int n) {
		if (n > r * c) {
			return true;
		}
		for (Coordinate coor : getMovementRange(row, col))
		try {
			if (movesBoard[row + 1][col + 2] == 0) {
				movesBoard[row + 1][col + 2] = n;
				if (solveHelp(row + 1, col + 2, n + 1)) {
					return true;
				}
				else {
					movesBoard[row + 1][col + 2] = 0;
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			
		}
		try {
			if (movesBoard[row + 1][col - 2] == 0) {
				movesBoard[row + 1][col - 2] = n;
				if (solveHelp(row + 1, col - 2, n + 1)) {
					return true;
				}
				else {
					movesBoard[row + 1][col - 2] = 0;
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (movesBoard[row + 2][col + 1] == 0) {
				movesBoard[row + 2][col + 1] = n;
				if (solveHelp(row + 2, col + 1, n + 1)) {
					return true;
				}
				else {
					movesBoard[row + 2][col + 1] = 0;
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (movesBoard[row + 2][col - 1] == 0) {
				movesBoard[row + 2][col - 1] = n;
				if (solveHelp(row + 2, col - 1, n + 1)) {
					return true;
				}
				else {
					movesBoard[row + 2][col - 1] = 0;
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (movesBoard[row - 1][col + 2] == 0) {
				movesBoard[row - 1][col + 2]  = n;
				if (solveHelp(row - 1, col + 2, n + 1)) {
					return true;
				}
				else {
					movesBoard[row - 1][col + 2] = 0;
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (movesBoard[row - 1][col - 2] == 0) {
				movesBoard[row - 1][col - 2] = n;
				if (solveHelp(row - 1, col - 2, n + 1)) {
					return true;
				}
				else {
					movesBoard[row - 1][col - 2] = 0;
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (movesBoard[row - 2][col + 1] == 0) {
				movesBoard[row - 2][col + 1] = n;
				if (solveHelp(row - 2, col + 1, n + 1)) {
					return true;
				}
				else {
					movesBoard[row - 2][col + 1] = 0;
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (movesBoard[row - 2][col - 1] == 0) {
				movesBoard[row - 2][col - 1] = n;
				if (solveHelp(row - 2, col - 1, n + 1)) {
					return true;
				}
				else {
					movesBoard[row - 2][col - 1] = 0;
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		
		return false;
		
	}
	/**
	 * @throws IllegalStateException when the board contains non-zero values. 
	@throws IllegalArgumentException when either parameter is negative 
	or out of bounds.
	 */
	public int countSolutions(int startingRow, int startingCol) {
		if (!isClear()) {
			throw new IllegalStateException();
		}
		try {
			movesBoard[startingRow][startingCol] = 1;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException();
		}
		int countSolutions = countSolutionsHelp(startingRow, startingCol, 2);
		clearBoard();
		return countSolutions;
	}
	public int countSolutionsHelp(int row, int col, int n) {
		if (n > r * c) {
			return 1;
		}
		int countSolutions = 0;
		try {
			if (movesBoard[row + 1][col + 2] == 0) {
				movesBoard[row + 1][col + 2] = n;
				countSolutions += countSolutionsHelp(row + 1, col + 2, n + 1);
				movesBoard[row + 1][col + 2] = 0;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			
		}
		try {
			if (movesBoard[row + 1][col - 2] == 0) {
				movesBoard[row + 1][col - 2] = n;
				countSolutions += countSolutionsHelp(row + 1, col - 2, n + 1);
				movesBoard[row + 1][col - 2] = 0;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (movesBoard[row + 2][col + 1] == 0) {
				movesBoard[row + 2][col + 1] = n;
				countSolutions += countSolutionsHelp(row + 2, col + 1, n + 1);
				movesBoard[row + 2][col + 1] = 0;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (movesBoard[row + 2][col - 1] == 0) {
				movesBoard[row + 2][col - 1] = n;
				countSolutions += countSolutionsHelp(row + 2, col - 1, n + 1);
				movesBoard[row + 2][col - 1] = 0;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (movesBoard[row - 1][col + 2] == 0) {
				movesBoard[row - 1][col + 2] = n;
				countSolutions += countSolutionsHelp(row - 1, col + 2, n + 1);
				movesBoard[row - 1][col + 2] = 0;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (movesBoard[row - 1][col - 2] == 0) {
				movesBoard[row - 1][col - 2] = n;
				countSolutions += countSolutionsHelp(row - 1, col - 2, n + 1);
				movesBoard[row - 1][col - 2] = 0;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (movesBoard[row - 2][col + 1] == 0) {
				movesBoard[row - 2][col + 1] = n;
				countSolutions += countSolutionsHelp(row - 2, col + 1, n + 1);
				movesBoard[row - 2][col + 1] = 0;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (movesBoard[row - 2][col - 1] == 0) {
				movesBoard[row - 2][col - 1] = n;
				countSolutions += countSolutionsHelp(row - 2, col - 1, n + 1);
				movesBoard[row - 2][col - 1] = 0;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		
		return countSolutions;
	}
	public void clearBoard() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				movesBoard[i][j] = 0;
			}
		}
	}
	private boolean isClear() {
		boolean isEmpty = true;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (movesBoard[i][j] != 0) {
					isEmpty = false;
					break;
				}
			}
		}
		return isEmpty;
	}
	private List<Coordinate> getMovementRange(int row, int col) {
		try {
			Coordinate c = board[row][col];
		}
		catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException();
		}
		ArrayList<Coordinate> neighboringSpaces = new ArrayList<Coordinate>();
		try {
			neighboringSpaces.add(board[row + 1][col + 2]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			
		}
		try {
			neighboringSpaces.add(board[row + 1][col - 2]); 
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			neighboringSpaces.add(board[row + 2][col + 1]); 
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			neighboringSpaces.add(board[row + 2][col - 1]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			neighboringSpaces.add(board[row - 1][col + 2]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			neighboringSpaces.add(board[row - 1][col - 2]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			neighboringSpaces.add(board[row - 2][col + 1]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			neighboringSpaces.add(board[row - 2][col - 1]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		return sortSpaces(neighboringSpaces);
	}
	private List<Coordinate> sortSpaces(List<Coordinate> l) {
		for (int i = 0; i < l.size(); i++) {
			Coordinate min = l.get(i);
			int minIndex = i;
			for (int j = i; j < l.size(); j++) {
				if (l.get(j).compareTo(min) < 0) {
					minIndex = j;
					min = l.get(j);
				}
			}
			Collections.swap(l, minIndex, i);
		}
		return l;
	}
}