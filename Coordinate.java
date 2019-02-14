
public class Coordinate implements Comparable<Coordinate> {
	private final int x;
	private final int y;
	private int possibleMoves;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void setPossibleMoves(int p) {
		possibleMoves = p;
	}
	public int getPossibleMoves() {
		return possibleMoves;
	}
	public void decrementPossibleMoves() {
		possibleMoves--;
	}
	public void incrementPossibleMoves() {
		possibleMoves++;
	}
	public int x() {
		return x;
	}
	public int y() {
		return y;
	}
	public int compareTo(Coordinate otherC) {
		return (int) Math.signum(possibleMoves - otherC.getPossibleMoves());
	}
}
