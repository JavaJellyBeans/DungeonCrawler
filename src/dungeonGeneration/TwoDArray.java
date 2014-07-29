package dungeonGeneration;

import java.util.Random;

import dungeonGeneration.Enumerations.EnumArray;

public class TwoDArray{
	private EnumArray[][] ara;
	private int size;
	private Coordinate start;
	private Coordinate exit;
	
	public TwoDArray(int size) {
		this.size = size;
		do {
			this.ara = setWall(size);
			setPath(this.ara);
			this.start = setEdgeCoord(this.ara,EnumArray.STRT);
			this.exit = setEdgeCoord(this.ara, EnumArray.EXIT);
		} while (start.equals(exit));
	}
	
	public EnumArray[][] getArray() {return this.ara;}
	public Coordinate getStart() {return this.start;}
	public Coordinate getExit() {return this.exit;}

	private static EnumArray[][] setWall(int size) {
		EnumArray[][] ara = new EnumArray[size][size];
		for (EnumArray[] row : ara) {
			for (int i = 0; i < size; i++)
				row[i] = EnumArray.WALL;
		}
		return ara;
	}
	
	private static void setPath(EnumArray[][] ara) {
		for (int i = 1; i < ara.length - 1; i++) 
			for (int j = 1; j < ara[i].length - 1; j++)
				ara[i][j] =EnumArray.PATH;
	}
	
	private static Coordinate setEdgeCoord(EnumArray[][] ara, EnumArray room) {
		int size = ara.length;
		Random r = new Random();
		int side = r.nextInt(4); 
		int x = 0, y = 0;
		if (side == 0) {x = 0; y = r.nextInt(size-2) + 1;} //random # b/t 1 and size-2 inclusive
		if (side == 1) {y = 0; x = r.nextInt(size-2) + 1;}
		if (side == 2) {y = size-1; x = r.nextInt(size-2) + 1;}
		if (side == 3) {x = size-1; y = r.nextInt(size-2) + 1;}
		Coordinate coord = new Coordinate(x,y);
		ara[coord.getY()][coord.getX()] = room;
		return coord;
	}
	
	
	public void printArray() {
		String str = "";
		for (EnumArray[] row : this.ara) {
			str += "";
			for (EnumArray room : row) {
				str += " " + room;
			}
			str += "\n";
		}
		System.out.println(str);
	}
	
}
