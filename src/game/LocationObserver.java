package game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import character.Party;
import dungeonGeneration.*;

public class LocationObserver implements Observer {
	private static Coordinate start = null;
	private static Coordinate exit = null;
	private static LocationObserver uniqueInstance = null;
	
	private LocationObserver(Map map) {
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
			Party party = (Party)obs;
			if (party.getLocation().equals(exit)) {
				System.out.println("game won!");
			}
				

		}
		
	}

}
