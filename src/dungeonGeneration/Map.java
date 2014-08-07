package dungeonGeneration;

import character.*;
import dungeonGeneration.Enumerations.*;

public class Map {
	private Node ptr; //node corresponding to ara[0][0]
	private TwoDArray ara;
	private final int SIZE = 10;
	private static Map uniqueInstance;
	
	private Map() {
		ara = new TwoDArray(SIZE);
		ptr = NodeParser.parseNodes(ara.getArray());
	}
	
	public static Map getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Map();
		return uniqueInstance;
	}
	
	public Coordinate getStart() {return ara.getStart();}
	public Coordinate getExit() {return ara.getExit();}
	public EnumArray[][] getArray(){return ara.getArray();}
	
	public boolean moveParty(Party p, Direction d) {
		int x = p.getLocation().getX();
		int y = p.getLocation().getY();
		Node temp = ptr;
		
		for(int i = 0; i < x; i++)
			temp = temp.getE();
		for(int j = 0; j < y; j++)
			temp = temp.getS();
		
		boolean newLoc = temp.moveParty(d);
		
		if (p instanceof Player) {
			temp.getRoom().getBehavior().getEffect().description();
		}
		return newLoc;
/*		return 
		Node temp = curr;
		curr = curr.movePlayer(d);
		add Item to Party inventory if ItemBehavior available
		curr.getRoom().getBehavior().getEffect().description();
		return !(temp == curr);*/
	} 
	
	public void reset() {
		uniqueInstance = new Map();
	}
	
}
