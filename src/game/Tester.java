package game;

import dungeonGeneration.Display;

public class Tester {
	
	public static void main(String[] args) {
		Dungeon dungeon = Dungeon.getInstance();
		Display.display(dungeon);
		
		while(!dungeon.getParty().getLocation().equals(dungeon.getMap().getExit())) {
			try{
				Thread.sleep(1000);
			} catch(Exception e) {}
		}

	}

}
