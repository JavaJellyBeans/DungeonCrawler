package dungeonGeneration;

import java.util.Random;

import dungeonGeneration.Enumerations.RoomEnum;

public class EnumArray {
	private RoomEnum[][] ara;
	private int size;
	private Coordinate start;
	private Coordinate exit;
	
	public EnumArray(int size) {
		this.size = size;
		this.ara = setWall(size);
		setPath(this.ara);
		do {
			this.start = setEdgeCoordinate(this.ara, RoomEnum.STRT);
			this.exit = setEdgeCoordinate(this.ara, RoomEnum.EXIT);
		} while (start.equals(exit));
	}

	private static RoomEnum[][] setWall(int size) {
		RoomEnum[][] ara = new RoomEnum[size][size];
		for (RoomEnum[] row : ara) {
			for (int i = 0; i < size; i++)
				row[i] = RoomEnum.WALL;
		}
		return ara;
	}
	
	private static void setPath(RoomEnum[][] ara) {
		for (int i = 1; i < ara.length - 1; i++) 
			for (int j = 1; j < ara[i].length - 1; j++)
				ara[i][j] = RoomEnum.PATH;
	}
	
	private static Coordinate setEdgeCoordinate(RoomEnum[][] ara, RoomEnum room) {
		int size = ara.length;
		Coordinate coord = new Coordinate();
		Random r = new Random();
		int num1 = r.nextInt(2); 
		int num2 = r.nextInt(size*2); 
		if (num1 == 0) { 
			if (num2 < size)
				coord = new Coordinate(num2 == 0 ? num2+1 : num2 == size - 1 ? num2-1 : num2 , 1); 
			else
				coord = new Coordinate(num2%size == 0 ? num2%size+1 : num2%size == size -1 ? num2%size-1 : num2%size, size - 2); 
		} else {
			if (num2 < size)
				coord = new Coordinate(1, num2 == 0 ? num2+1 : num2 == size - 1 ? num2-1 : num2-1);
			else
				coord = new Coordinate(size - 2, num2%size == 0 ? num2%size+1 : num2%size == size -1 ? num2%size-1 : num2%size);		
		}
		ara[coord.getY()][coord.getX()] = room;
		return coord;
	}
	
	
	public void printArray() {
		String str = "";
		for (RoomEnum[] row : this.ara) {
			str += "";
			for (RoomEnum room : row) {
				str += " " + room;
			}
			str += "\n";
		}
		System.out.println(str);
	}
	
}
