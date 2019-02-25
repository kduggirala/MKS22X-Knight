
public class KnightBoardTest {
	public static void main(String[] args) {
		KnightBoard k = new KnightBoard(5, 5);
		for (Coordinate[] row : k.board) {
			for (Coordinate c : row) {
				System.out.print(c.getPossibleMoves() + " ");
			}
			System.out.println();
		}
	}
}
