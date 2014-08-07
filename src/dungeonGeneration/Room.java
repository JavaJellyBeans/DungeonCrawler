package dungeonGeneration;

import behaviors.RoomBehavior;
import character.Party;

public class Room {
	RoomBehavior behavior;
	/*boolean occupied = false;*/
	
	public void setBehavior(RoomBehavior behavior) {this.behavior = behavior;}
	/*public void setOccupied(boolean occupied) 	   {this.occupied = occupied;}*/

	
	public RoomBehavior getBehavior() {return behavior;}
	/*public boolean occupied() 		  {return occupied;}*/


}
