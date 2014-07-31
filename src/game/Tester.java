package game;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import character.Party;
import dungeonGeneration.Display;
import dungeonGeneration.Enumerations.Direction;
import dungeonGeneration.Map;

public class Tester {
	
	public static void main(String[] args) {
		Dungeon dungeon = Dungeon.getInstance();
		Display.display(dungeon);
		Map map = dungeon.getMap();
		Party p1 = dungeon.getParty();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		System.out.println("here");
		try {
		   while (line.equalsIgnoreCase("quit") == false) {
		       line = in.readLine();

				if(line.equalsIgnoreCase("w")){
					//p.setDirection(Direction.NORTH);
					if(map.movePlayer(Direction.NORTH))
						p1.move(Direction.NORTH);
				}
				if(line.equalsIgnoreCase("s")){
					//p.setDirection(Direction.SOUTH);
					if(map.movePlayer(Direction.SOUTH))
						p1.move(Direction.SOUTH);
				}
				if(line.equalsIgnoreCase("a")){
					//p.setDirection(Direction.WEST);
					if(map.movePlayer(Direction.WEST))
						p1.move(Direction.WEST);
				}
				if(line.equalsIgnoreCase("d")){
					//p.setDirection(Direction.EAST);
					if(map.movePlayer(Direction.EAST))
						p1.move(Direction.EAST);				
				}
				
				Display.display(dungeon);
		   }

		   in.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
