package dungeonGeneration;

public class Coordinate {
	Integer x;
	Integer y;
	
	public Coordinate() {
		this.x = null;
		this.y = null;
	}
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {return x;}
	public int getY() {return y;}
	
	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	public void setCoordinate(Coordinate coord) {
		this.x = coord.getX();
		this.y = coord.getY();
	}
	
	public boolean equals(Coordinate c) {
		if (this.x == c.getX())
			return this.y == c.getY();
		return false;
	}
	public boolean equals(int x, int y) {
		if (this.x == x)
			return this.y == y;
		return false;
	}
	
	
}
