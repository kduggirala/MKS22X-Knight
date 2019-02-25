
public class KnightBoardTest {
	public static void main(String[] args) {
		KnightBoard k = new KnightBoard(7, 7);
		for (Coordinate[] row : k.board) {
			for (Coordinate c : row) {
				System.out.print(c.getPossibleMoves() + " ");
			}
			System.out.println();
		}
	}
}
