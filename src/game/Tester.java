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
		Party player = dungeon.getPlayer();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		
		try {
			
		   while (line.equalsIgnoreCase("quit") == false) {
		       line = in.readLine();

				if(line.equalsIgnoreCase("w")){
					if(map.moveParty(player, Direction.NORTH)) {
						player.move(Direction.NORTH);
						EnemyLocator.moveAll();
					}
				}
				if(line.equalsIgnoreCase("s")){
					if(map.moveParty(player, Direction.SOUTH)) {
						player.move(Direction.SOUTH);
						EnemyLocator.moveAll();
					}
				}
				if(line.equalsIgnoreCase("a")){
					if(map.moveParty(player, Direction.WEST)) {
						player.move(Direction.WEST);
						EnemyLocator.moveAll();
					}
				}
				if(line.equalsIgnoreCase("d")){
					if(map.moveParty(player, Direction.EAST)) {
						player.move(Direction.EAST);	
						EnemyLocator.moveAll();
					}
				}
				
				Display.display(dungeon);
				
		   }

		   in.close();
		   
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			try {in.close();} 
			catch (Exception ex) {}
		}

	}

}
