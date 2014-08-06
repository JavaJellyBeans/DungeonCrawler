package dungeonGeneration;

import behaviors.RoomBehavior;
import character.Party;

public class Room {
//	boolean occupied = false;
//	Party occupant;
	RoomBehavior behavior;
	
	public void setBehavior(RoomBehavior behavior) {this.behavior = behavior;}
//	public void setOccupied(Party party) {this.occupant = party; this.occupied = true;}
	
	public RoomBehavior getBehavior() {return this.behavior;}
//	public Party getOccupant() {return this.occupant;}

}
