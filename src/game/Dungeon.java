package game;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import dungeonGeneration.Display;
import dungeonGeneration.Enumerations.Direction;
import character.Party;
import dungeonGeneration.Map;

public class Dungeon {
	
	private Map map;
	private Party p1;
	private LocationObserver obs;
	private static Dungeon uniqueInstance;
	
	private Dungeon() {
		map = new Map();
		p1 = new Party(null, map.getStart());
		obs = LocationObserver.getInstance(map);
		p1.addObserver(obs);
	}
	
	public static Dungeon getInstance() {
		if(uniqueInstance == null)
			uniqueInstance = new Dungeon();
		return uniqueInstance;
	}
	
	public Party getParty() {return this.p1;}
	public Map getMap(){return this.map;}


}
