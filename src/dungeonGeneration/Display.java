package dungeonGeneration;

import game.Dungeon;
import game.EnemyLocator;
import character.Party;
import dungeonGeneration.Enumerations.EnumArray;

public class Display {
	
	public static void display(Dungeon d) {
		EnumArray[][] ara = d.getMap().getArray();
		Coordinate partyLoc = d.getPlayer().getLocation();
	
	    StringBuilder sb = new StringBuilder();
	    	
	    	for (int i = 0; i< ara.length; i++) {
	    	    for (int j = 0; j< ara[i].length; j++) {
	    	    	if (partyLoc.equals(j,i))
	    	    		sb.append(" P ");
	    	    	else if (EnemyLocator.encounter(new Coordinate(j,i)))
	    	    		sb.append(" X ");
	    	    	else {
		    	    	switch (ara[i][j]) {
		    	    	case WALL:
		    	    		sb.append(" * "); break;
		    	    	case PATH:
		    	    		sb.append("   "); break;
		    	    	case STRT:
		    	    		sb.append(" S "); break;
		    	    	case EXIT:
		    	    		sb.append(" E "); break;
		    	    	}
	    	    	}
	    	    }
	    	    sb.append("\n");
	        }
	    	
	    	System.out.println(sb.toString());
	}

}
