package dungeonGeneration;

import dungeonGeneration.Enumerations.*;

public class Map {
	private Node curr; //party location
	private TwoDArray ara;
	private final int SIZE = 10;
	
	public Map() {
		ara = new TwoDArray(SIZE);
		curr = NodeParser.parseNodes(ara.getArray());
	}
	
	public Coordinate getStart() {return ara.getStart();}
	public Coordinate getExit() {return ara.getExit();}
	public EnumArray[][] getArray(){return ara.getArray();}
	
	public boolean movePlayer(Direction d) {
		Node temp = curr;
		curr = curr.movePlayer(d);
		return !(temp == curr);
	}
	
}
