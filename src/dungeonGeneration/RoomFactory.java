package dungeonGeneration;

import java.util.Random;

import character.Party;
import dungeonGeneration.Enumerations.EnumArray;
import effects.*;
import game.EnemyPartyList;
import behaviors.*;

public class RoomFactory {
	
	private static RoomFactory uniqueInstance;
	
	private RoomFactory() {}
	
	public static RoomFactory getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new RoomFactory();
		return uniqueInstance;
	}
	
	public Room buildRoom(EnumArray rm, int y, int x) {
		Room room = new Room();
		switch(rm) {
			case PATH:
				Random r = new Random();
				int num = r.nextInt(10);  
				if (num < 2)
					room.setBehavior(new ItemBehavior(new Potion()));
				else if (num < 4)
					room.setBehavior(new ItemBehavior(new Poison()));
				else
					room.setBehavior(new EmptyBehavior());
				num = r.nextInt(10);
				if (num < 1) {
					Party p = new Party(null, new Coordinate(x,y));
					EnemyPartyList.getInstance().add(p);
//					room.setOccupied(p);
				}
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
