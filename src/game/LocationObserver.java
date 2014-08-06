package game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import character.Party;
import dungeonGeneration.*;

//Observe's Player's Location relative to dungeon elements
public class LocationObserver implements Observer {
	private static Map map;
	private static Coordinate start = null;
	private static Coordinate exit = null;
	private static LocationObserver uniqueInstance = null;
	
	private LocationObserver(Map map) {
		this.map = map;
		start = map.getStart();
		exit = map.getExit();
	}
	
	public static LocationObserver getInstance(Map map) {
		if (uniqueInstance == null)
			uniqueInstance = new LocationObserver(map);
		return uniqueInstance;
	}

	public void update(Observable obs, Object arg) {
		if (obs instanceof Party) {
			Party player = (Party)obs;
			Coordinate coord = player.getLocation();
			if(EnemyPartyList.getInstance().coordMatch(coord)) {
				Party enemy = EnemyPartyList.getInstance().getEnemy();
				System.out.println("There's a fight!");
				//Fight.fight(player, enemy);
			}
			if (coord.equals(exit)) {
				System.out.println("game won!");
			}
			if (coord.equals(start)) {
				System.out.println("Can't turn back now!");
			}

		}
		
	}

}
