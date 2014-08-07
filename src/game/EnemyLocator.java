package game;

import java.util.ArrayList;
import java.util.Random;

import character.Party;
import dungeonGeneration.Coordinate;
import dungeonGeneration.Enumerations.Direction;
import dungeonGeneration.Map;

//Don't forget to call  EnemyPartyList.getInstance().remove(enemy) after a successful fight!

public class EnemyLocator {
	private static ArrayList<Party> list = new ArrayList();
	private static Party encounteredEnemy;
	
	public static void add(Party p) {
		list.add(p);
	}
	
	public static void remove(Party p) {
		list.remove(p);
	}
	
	public static Party get(Party p) {
		int index = list.indexOf(p);
		return list.get(index);
	}
	
	public static boolean encounter(Coordinate player) {
		for (Party enemy : list) {
			if (enemy.getLocation().equals(player))  {
				encounteredEnemy = enemy;
				return true;
			}
		} 
		return false;		
	}
	
	public static Party getEncounter() {
		/*make new Characters here*/
		return encounteredEnemy;
	}
	
	public static void reset() {
		list = new ArrayList();
	}
	
	public static void moveAll() {
		Map map = Map.getInstance();
		Random rand = new Random();
		int num = 0;
		
		for (Party enemy : list) {
			num = rand.nextInt(10);
			
			if(num == 0 && map.moveParty(enemy, Direction.NORTH))
				enemy.move(Direction.NORTH);

			else if(num == 1 && map.moveParty(enemy, Direction.SOUTH))
				enemy.move(Direction.SOUTH);

			else if(num == 2 && map.moveParty(enemy, Direction.WEST))
				enemy.move(Direction.WEST);

			else if(num == 3 && map.moveParty(enemy, Direction.EAST))
				enemy.move(Direction.EAST);				

		}
	}

}
