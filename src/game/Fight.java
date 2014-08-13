package game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ability.Ability;
import character.Party;
import character.Character;
import factory.Factory;

public class Fight {

	private Party players;
	private Party enemies;
	
	private Factory f;
	
	private Fight()
	{
		players = new Party();
		enemies = new Party();
		f = new Factory();
	}
	public Fight(ArrayList<Character> newPlayers, ArrayList<Character> newEnemies)
	{
		this();
		players.addAll(newPlayers);
		enemies.addAll(newEnemies);
		battle();
	}
	public Fight(Character newPlayer, Character newEnemy)
	{
		this();
		players.add(newPlayer);
		enemies.add(newEnemy);
		battle();
	}
	public Fight(ArrayList<Character> newPlayers, Character newEnemy)
	{
		this();
		players.addAll(newPlayers);
		enemies.add(newEnemy);
		battle();
	}
	public Fight(Character newPlayer, ArrayList<Character> newEnemies)
	{
		this();
		players.add(newPlayer);
		enemies.addAll(newEnemies);
		battle();
	}
	public Fight(Party newPlayer)
	{
		this();
		players = newPlayer;
		enemies = f.getEnemyParty(players.getLevel());
		enemies.add(f.getEnemyCharacter("Enemy"));
		enemies.add(f.getEnemyCharacter("Enemy"));
		battle();
	}
	
	public void battle()
	{
		//list the players and enemies and their current/max hp
		do{
		//player characters go down the list taking a turn
		
			//foreach character c in the party
			for(Iterator<Character> party = players.getParty().iterator(); party.hasNext();)
			{
				Character c = party.next();
				c.takeTurn(players, enemies);
				if(over())
					break;
			}
		
			if(over())
				break;
		//enemy characters go down the list taking a turn
			
			//foreach character c in the party
				//performEnemyAction
			for(Iterator<Character> party = enemies.getParty().iterator(); party.hasNext();)
			{
				Character c = party.next();
				c.takeTurn(enemies, players);
				if(over())
					break;
			}
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
}
