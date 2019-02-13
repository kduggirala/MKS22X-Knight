
public class KnightBoardTest {
	public static void main(String[] args) {
		KnightBoard k = new KnightBoard(5, 5);
		boolean t = k.solve(1, 2);
		System.out.println(k);
		System.out.println(t);
	}
}
