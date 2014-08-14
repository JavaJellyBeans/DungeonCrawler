package game;

import character.*;
import dungeonGeneration.Map;

public class Dungeon {
	
	private Map map;
	private Party player;
	private LocationObserver obs;
	private static Dungeon uniqueInstance;
	
	private Dungeon() {
		map = Map.getInstance();
		player = new PlayerParty(null, map.getStart());
		obs = LocationObserver.getInstance();
		player.addObserver(obs);
	}
	
	public static Dungeon getInstance() {
		if(uniqueInstance == null)
			uniqueInstance = new Dungeon();
		return uniqueInstance;
	}
	
	public Party getPlayer() {return this.player;}
	public Map getMap(){return this.map;}
	
	public void reset() {
		EnemyLocator.reset();
		map.reset();
		obs.reset();
		uniqueInstance = new Dungeon();
	}


}
