package dungeonGeneration;

import dungeonGeneration.Enumerations.RoomEnum;
import behaviors.*;

public class RoomFactory {
	
	private static RoomFactory uniqueInstance;
	
	private RoomFactory() {}
	
	public static RoomFactory getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new RoomFactory();
		return uniqueInstance;
	}
	
	public Room buildRoom(RoomEnum rm) {
		Room room = new Room();
		switch(rm) {
			case PATH:
				room.setBehavior(new EmptyBehavior());
				break;
			case WALL:
				room.setBehavior(new WallBehavior());
				break;
			case STRT:
				room.setBehavior(new EmptyBehavior());
				break;
			case EXIT:
				room.setBehavior(new EmptyBehavior());
				break;
		}
		return room;	
	}

}
