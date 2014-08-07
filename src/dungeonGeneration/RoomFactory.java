package dungeonGeneration;

import java.util.Random;

import character.*;
import dungeonGeneration.Enumerations.EnumArray;
import effects.*;
import game.EnemyLocator;
import behaviors.*;

public class RoomFactory {
	
//	private static RoomFactory uniqueInstance;
//	
//	private RoomFactory() {}
//	
//	public static RoomFactory getInstance() {
//		if (uniqueInstance == null)
//			uniqueInstance = new RoomFactory();
//		return uniqueInstance;
//	}
	
	public static Room buildRoom(EnumArray rm, int y, int x) {
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
					room.setBehavior(new EmptyBehavior(new NullEffect()));
				num = r.nextInt(10);
				if (num < 1) {
					Party p = new Enemy(null, new Coordinate(x,y));
					EnemyLocator.add(p);
					/*room.setOccupied(true);*/
				}
				break;
			case WALL:
				room.setBehavior(new WallBehavior(new NullEffect()));
				break;
			case STRT:
				room.setBehavior(new EmptyBehavior(new NullEffect()));
				break;
			case EXIT:
				room.setBehavior(new EmptyBehavior(new WinGame()));
				break;
		}
		return room;	
	}

}
