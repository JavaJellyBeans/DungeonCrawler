package DungeonGeneration;

import DungeonGeneration.DungeonEnums.Room;

public class Dungeon {
	private Room[][] dungeon;
	private int size;
	
	public Dungeon(int size) {
		this.size = size;
		this.dungeon = fillDungeon(size);
	}

	private static Room[][] fillDungeon(int size) {
		Room[][] dungeon = new Room[size][size];
		for (Room[] row : dungeon) {
			for (int i = 0; i < size; i++)
				row[i] = Room.WALL;
		}
		return dungeon;
	}
	
}
