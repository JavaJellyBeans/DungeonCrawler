package game;

import java.util.ArrayList;
import java.util.Scanner;

import ability.Ability;
import character.Party;
import character.Character;

public class Fight {

	private ArrayList<Character> players;
	private ArrayList<Character> enemies;
	
	public Fight()
	{
		players = new ArrayList<Character>();
		enemies = new ArrayList<Character>();
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
				if(!notOver())
					break;
			}
		
			if(!notOver())
				break;
		//enemy characters go down the list taking a turn
			
			//foreach character c in the party
				//performEnemyAction
		}while(notOver());
	}
	
	public boolean notOver()
	{
		boolean alive = false;
		for(int i = 0; i < players.size(); i++)
		{
			if(players.get(i).getHp() > 0)
				alive = true;
		}
		if(!alive)
			return false;
		alive = false;
		for(int i = 0; i < enemies.size(); i++)
		{
			if(enemies.get(i).getHp() > 0)
				alive = true;
		}
		return alive;
	}
	public Ability showActions(Character c)
	{
		//shows actions available
		ArrayList<Ability> actions = c.getAbilities();
		System.out.println("Available Actions:\n");
		for(int i = 0; i < actions.size(); i++)
		{
			System.out.println("\t"+i+":"+actions.get(i).toString());
		}
		System.out.print("Selection: ");
		Scanner kb = new Scanner(System.in);
		int selection = kb.nextInt();
		while(selection >= actions.size() || selection < 0)
		{
			System.out.print("Not a valid option. Please try again\nSelection: ");
			selection = kb.nextInt();
		}
		
		return actions.get(selection);
	}
	
	public void playerTurn(Character c)
	{
		//int selection = showActions(c)
		Ability selectedAction = showActions(c);
		//selectAction(c, selection)
		Character target = showTargets();
		//Character target = selectTarget
		//performAction(c, target)
		selectedAction.use(c, target);
	}
	
	private Character showTargets() {
		// TODO Auto-generated method stub
		System.out.println("Select a target: ");
		for(int i = 0; i < enemies.size(); i++)
		{
			System.out.println("\t"+i+":"+enemies.get(i).toString());
		}		System.out.print("Selection: ");
		Scanner kb = new Scanner(System.in);
		int selection = kb.nextInt();
		while(selection >= enemies.size() || selection < 0)
		{
			System.out.print("Not a valid option. Please try again\nSelection: ");
			selection = kb.nextInt();
		}
		
		return enemies.get(selection);
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
