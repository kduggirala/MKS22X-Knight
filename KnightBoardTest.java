
public class KnightBoardTest {
	public static void main(String[] args) {
		KnightBoard k = new KnightBoard(5, 5);
		System.out.println(k.countSolutions(1, 1));
		k.solve(0, 0);
		System.out.println(k);
	}
}