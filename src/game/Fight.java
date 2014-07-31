package game;

import java.util.ArrayList;
import java.util.Scanner;

import ability.Ability;
import character.CharacterParty;
import character.Party;
import character.Character;

public class Fight {

	private CharacterParty players;
	private CharacterParty enemies;
	
	public Fight()
	{
		players = new CharacterParty();
		enemies = new CharacterParty();
	}
	public Fight(ArrayList<Character> newPlayers, ArrayList<Character> newEnemies)
	{
		this();
		players.addAll(newPlayers);
		enemies.addAll(newEnemies);
	}
	public Fight(Character newPlayer, Character newEnemy)
	{
		this();
		players.add(newPlayer);
		enemies.add(newEnemy);
	}
	public Fight(ArrayList<Character> newPlayers, Character newEnemy)
	{
		this();
		players.addAll(newPlayers);
		enemies.add(newEnemy);
	}
	public Fight(Character newPlayer, ArrayList<Character> newEnemies)
	{
		this();
		players.add(newPlayer);
		enemies.addAll(newEnemies);
	}
	
	public void battle()
	{
		//list the players and enemies and their current/max hp
		do{
		//player characters go down the list taking a turn
		
			//foreach character c in the party
			for(int i = 0; i < players.size(); i++)
			{
				playerTurn(players.get(i));
				if(over())
					break;
			}
		
			if(over())
				break;
		//enemy characters go down the list taking a turn
			
			//foreach character c in the party
				//performEnemyAction
		}while(!over());
		
		if(!players.defeated())
		{
			players.levelUp();
		}
	}
	
	public boolean over()
	{
		if(players.defeated())
		{
			return true;
		}
		else{
			if(enemies.defeated())
			{
				return true;
			}
		}
		return false;
	}
	
	public void playerTurn(Character c)
	{
		//int selection = showActions(c)
		Ability selectedAction = players.showActions(c);
		//selectAction(c, selection)
		Character target = enemies.showTargets();
		//Character target = selectTarget
		//performAction(c, target)
		selectedAction.use(c, target);
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
