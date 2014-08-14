package game;

import java.util.Observable;
import java.util.Observer;
import character.*;
import dungeonGeneration.*;

//Observe's Player's Location relative to dungeon elements
public class LocationObserver implements Observer {
	private static Map map;
//	private static Coordinate start = null;
//	private static Coordinate exit = null;
	private static LocationObserver uniqueInstance = null;
	
	private LocationObserver() {
		map = Map.getInstance();
//		start = map.getStart();
//		exit = map.getExit();
	}
	
	public static LocationObserver getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new LocationObserver();
		return uniqueInstance;
	}

	public void update(Observable obs, Object arg) {
		if (obs instanceof PlayerParty) {
			Party player = (PlayerParty)obs;
			Coordinate coord = player.getLocation();
			if(EnemyLocator.encounter(coord)) {
				Party enemy = EnemyLocator.getEncounter();
				System.out.println("There's a fight!");
				//Fight.fight(player, enemy);
			}
			if (coord.equals(map.getExit())) {
				System.out.println("game won!");
				
			}
			if (coord.equals(map.getStart())) {
				System.out.println("Can't turn back now!");
			}

		}
		
	}
	
	public void reset() {
		uniqueInstance = new LocationObserver();
	}

}
