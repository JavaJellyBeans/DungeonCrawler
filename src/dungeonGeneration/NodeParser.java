package dungeonGeneration;

import dungeonGeneration.Enumerations.*; 

public class NodeParser {
	
	public static Node parseNodes(EnumArray[][] ara) {
		Node curr = new Node();
		Node start = curr;
		Node nextRow = curr;
		Node nextCol = curr;
		RoomFactory factory = RoomFactory.getInstance();
		
		for (int i = 0; i < ara.length; i++) {
			for (int j = 0; j < ara[i].length; j++) {

				curr.setRoom(factory.buildRoom(ara[i][j], i, j));
				
				//setting East & West links
				if (j < ara[i].length - 1){
					
					Node node;
					Node south = nextCol.getS();
					
					if(south == null){
						node = new Node();
					} else {
						node = nextCol.getS();
					}
				
					curr.setE(node);
					node.setW(curr);
					nextCol = nextCol.getE();
				}
				
				//setting North & South links
				if(i < ara.length - 1){
					Node node = new Node();
					curr.setS(node);
					node.setN(curr);
				}
				
				if(ara[i][j] == EnumArray.STRT)
					start = curr;

				curr = curr.getE();
			}
			nextCol = nextRow.getE();
			nextRow = nextRow.getS();
			curr = nextRow;
		}
		return start;
	}
}