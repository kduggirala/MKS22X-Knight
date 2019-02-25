import java.util.*;
public class KnightBoard {
	private int r;
	private int c;
	private boolean unsolveable;
	Coordinate[][] board; //This board keeps track of the coordinates and how many possible moves from each one
	private int[][] movesBoard; //This board keeps track of the order of the moves, the board to be printed

	//Initialize the board to the correct size and make them all 0's 
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
		setupBoard();
	}


	private void setupBoard() {
		if (r < 3 || c < 3) {
			unsolveable = true;
		}
		else {
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (i == 0 || i == r - 1) {
						if (j == 0 || j == c - 1) {
							board[i][j].setPossibleMoves(2);
						}
						else if (j == 1 || j == c - 2) {
							board[i][j].setPossibleMoves(3);
						}
						else {
							board[i][j].setPossibleMoves(4);
						}
					}
					else if (i == 1 || i == r - 2) {
						if (j == 0 || j == c - 1) {
							board[i][j].setPossibleMoves(3);
						}
						else if (j == 1 || j == c - 2) {
							board[i][j].setPossibleMoves(4);
						}
						else {
							board[i][j].setPossibleMoves(6);
						}
					}
					else {
						if (j == 0 || j == c - 1) {
							board[i][j].setPossibleMoves(4);
						}
						else if (j == 1 || j == c - 2) {
							board[i][j].setPossibleMoves(6);
						}
						else {
							board[i][j].setPossibleMoves(8);
						}
					}
				}
			}
		}
	}
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
		if (unsolveable) {
			return false;
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
		List<Coordinate> movementRange = getMovementRange(row, col);
		sortSpaces(movementRange);
		for (Coordinate coor : movementRange) {
			addKnight(coor.x(), coor.y(), n);
			if (solveHelp(coor.x(), coor.y(), n + 1)) {
				return true;
			}
			removeKnight(coor.x(), coor.y());
		}
		return false;

	}
	private void addKnight(int row, int col, int n) {
		movesBoard[row][col] = n;
		for (Coordinate coor : getMovementRange(row, col)) {
			coor.decrementPossibleMoves();
		}
	}
	private void removeKnight(int row, int col) {
		movesBoard[row][col] = 0;
		for (Coordinate coor : getMovementRange(row, col)) {
			coor.incrementPossibleMoves();
		}
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
		if (unsolveable) {
			return 0;
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
		List<Coordinate> movementRange = getMovementRange(row, col);
		for (Coordinate coor : movementRange) {
			addKnight(coor.x(), coor.y(), n);
			countSolutions += countSolutionsHelp(coor.x(), coor.y(), n + 1);
			removeKnight(coor.x(), coor.y());
		}
		return countSolutions;
	}
	//sets the board to all zeros
	public void clearBoard() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				movesBoard[i][j] = 0;
			}
		}
	}
	//returns whether the board is all zeros
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
	//returns list of coordinates that are within movement range of the space at row, col
	private List<Coordinate> getMovementRange(int row, int col) {
		try {
			Coordinate c = board[row][col];
		}
		catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException();
		}
		ArrayList<Coordinate> neighboringSpaces = new ArrayList<Coordinate>();
		try {
			if (movesBoard[row + 1][col + 2] == 0) {
				neighboringSpaces.add(board[row + 1][col + 2]);
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			if (movesBoard[row + 1][col - 2] == 0) {
				neighboringSpaces.add(board[row + 1][col - 2]); 
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (movesBoard[row + 2][col + 1] == 0) {
				neighboringSpaces.add(board[row + 2][col + 1]); 
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (movesBoard[row + 2][col - 1] == 0) {
				neighboringSpaces.add(board[row + 2][col - 1]);
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (movesBoard[row - 1][col + 2] == 0) {
				neighboringSpaces.add(board[row - 1][col + 2]);
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (movesBoard[row - 1][col - 2] == 0) {
				neighboringSpaces.add(board[row - 1][col - 2]);
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (movesBoard[row - 2][col + 1] == 0) {
				neighboringSpaces.add(board[row - 2][col + 1]);
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (movesBoard[row - 2][col - 1] == 0) {
				neighboringSpaces.add(board[row - 2][col - 1]);
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
		return neighboringSpaces;
	}
	//sorts spaces with selection sort by number of outgoing moves
	private void sortSpaces(List<Coordinate> l) {
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
	}
}