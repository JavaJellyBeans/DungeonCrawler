package dungeonGeneration;

import behaviors.RoomBehavior;
import character.Party;

public class Room {
	boolean occupied;
	Party occupant;
	RoomBehavior behavior;
	
	public void setBehavior(RoomBehavior behavior) {
		this.behavior = behavior;
	}

}
