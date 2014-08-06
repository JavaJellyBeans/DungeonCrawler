package game;

import java.util.ArrayList;

import character.Party;
import dungeonGeneration.Coordinate;

//Don't forget to call  EnemyPartyList.getInstance().remove(enemy) after a successful fight!

public class EnemyPartyList {
	private static ArrayList<Party> list;
	private static EnemyPartyList uniqueInstance;
	private static Party currEnemy;
	
	private EnemyPartyList() {
		list = new ArrayList();
	}
	
	public static EnemyPartyList getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new EnemyPartyList();
		return uniqueInstance;
	}
	
	public void add(Party p) {
		list.add(p);
	}
	
	public void remove(Party p) {
		list.remove(p);
	}
	
	public Party get(Party p) {
		int index = list.indexOf(p);
		return list.get(index);
	}
	
	public boolean coordMatch(Coordinate player) {
		for (Party enemy: list) {
			if (enemy.getLocation().equals(player))  {
				currEnemy = enemy;
				return true;
			}
		} 
		return false;		
	}
	
	public Party getEnemy() {
		return this.currEnemy;
	}

}
