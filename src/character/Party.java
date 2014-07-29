package character;

import java.util.ArrayList;

import dungeonGeneration.Coordinate;
import dungeonGeneration.Enumerations.Direction;

public class Party {
	ArrayList members;
	Coordinate coord;
	
	public Party(ArrayList list, Coordinate start) {
		members = list;
		coord = start;
	}
	
	public Coordinate getLocation() {return this.coord;}
	
	public void move(Direction d) {
		int x = coord.getX();
		int y = coord.getY();
		switch(d) {
			case NORTH:
				coord.setY(y-1);
				break;
			case SOUTH:
				coord.setY(y+1);
				break;
			case EAST:
				coord.setX(x+1);
				break;
			case WEST:
				coord.setX(x-1);
				break;
		}
	}

}
