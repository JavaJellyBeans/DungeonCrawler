package dungeonGeneration;

import dungeonGeneration.Enumerations.Direction;

public class Node {
	Node n, s, e, w;
	Room room;
	
	/*setters*/
	public void setN(Node n) {this.n = n;}
	public void setS(Node s) {this.s = s;}
	public void setE(Node e) {this.e = e;}
	public void setW(Node w) {this.w = w;}
	public void setRoom(Room room) {this.room = room;}
	
	/*getters*/
	public Node getN() {return n;}
	public Node getS() {return s;}
	public Node getE() {return e;}
	public Node getW() {return w;}
	public Room getRoom() {return room;}
	
	public Node movePlayer(Direction d) {
		Node node = null;
		switch(d) {
			case SOUTH:
				node = this.s; break;
			case NORTH:
				node = this.n; break;
			case EAST:
				node = this.e; break;
			case WEST:
				node = this.w; break;
		}
		if (node.getRoom().getBehavior().enterable())
			return node;
		else return this;
	}
	

}
