package DungeonGeneration;

import DungeonGeneration.DungeonEnums.Room;

public class Dungeon {
	private Room[][] dungeon;
	private int size;
	
	public Dungeon(int size) {
		this.size = size;
		this.dungeon = fillDungeon(size);
		carveDungeon(this.dungeon);
	}

	private static Room[][] fillDungeon(int size) {
		Room[][] dungeon = new Room[size][size];
		for (Room[] row : dungeon) {
			for (int i = 0; i < size; i++)
				row[i] = Room.WALL;
		}
		return dungeon;
	}
	
	private static void carveDungeon(Room[][] dungeon) {
		for (int i = 1; i < dungeon.length - 1; i++) 
			for (int j = 1; j < dungeon[i].length - 1; j++)
				dungeon[i][j] = Room.PATH;
	}
	
	public void printDungeon() {
		String str = "";
		for (Room[] row : this.dungeon) {
			str += "";
			for (Room room : row) {
				str += " " + room;
			}
			str += "\n";
		}
		System.out.println(str);
	}
	
}
