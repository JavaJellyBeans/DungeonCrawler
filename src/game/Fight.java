package game;

import java.util.ArrayList;
import character.Party;
import character.Character;

public class Fight {

	ArrayList<Character> players;
	ArrayList<Character> enemies;
	
	public Fight(ArrayList<Character> newPlayers, ArrayList<Character> newEnemies)
	{
		players.addAll(newPlayers);
		enemies.addAll(newEnemies);
	}
	
	public void battle()
	{
		//list the players and enemies and their current/max hp
		
		//player characters go down the list taking a turn
		
			//foreach character c in the party

		
		//enemy characters go down the list taking a turn
			
			//foreach character c in the party
				//performEnemyAction
	}
	
	public int ShowActions(Character unit)
	{
		//shows actions available
		return 0;
	}
	
	public void playerTurn(Character c)
	{
		//int selection = showActions(c)
		//selectAction(c, selection)
		//showTargets();
		//Character target = selectTarget
		//performAction(c, target)
	}
	
	public void enemyTurn(Character c)
	{
		//select opponent based on lowest hp percentage
			//otherwise random
		//select action
			//random
		//performAction(c, target)
	}
}
