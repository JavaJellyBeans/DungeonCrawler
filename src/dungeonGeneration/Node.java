package dungeonGeneration;

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
	

}
