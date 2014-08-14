package factory;

import ability.Attack;
import character.Character;
import character.NullEnemy;
import character.NullPlayer;
import character.Party;
import character.Enemy;
import character.Player;

public class Factory {

	private Factory subFactory;
	public Factory(){}
	
	public Character getCharacter(String info)
	{
		//check character information and send on the info to the correct sub-factory
		String[] parsedInstructions = info.split(" ");
		switch(parsedInstructions[0])
		{
		case "Player":
			return getPlayerCharacter(info);
		case "Enemy":
			return getEnemyCharacter(info);
		}
		return null;
	}
	
	public Character getPlayerCharacter(String info)
	{
		String[] parsedInstructions = info.split(" ");
		if(parsedInstructions[0].compareTo("Player") != 0)
		{	
			System.out.println("Error: Incorrect Player Character creation syntax");
			return null;
		}
		Character c;
		if(parsedInstructions.length == 3)
		{
			//c = new Player(parsedInstructions[1], 20, 10, 10, 10, 10);
			//parse the instructions
			switch(parsedInstructions[2])
			{
			case "Rogue":
				subFactory = new RogueFactory();
				c = subFactory.getCharacter(parsedInstructions[2]);
				break;
			case "Mage":
				subFactory = new MageFactory();
				c = subFactory.getCharacter(parsedInstructions[2]);
				break;
			case "Cleric":
				subFactory = new ClericFactory();
				c = subFactory.getCharacter(parsedInstructions[2]);
				break;
			case "Warrior":
				subFactory = new WarriorFactory();
				c = subFactory.getCharacter(parsedInstructions[2]);
				break;
			default:
				c = new NullPlayer(parsedInstructions[2]);
			}
		}
		else
		{
			System.out.println("Error: Incorrect number of arguments");
			return new NullPlayer("Null Character");
		}
		
		return c;
	}
	
	public Character getEnemyCharacter(String info)
	{		
		String[] parsedInstructions = info.split(" ");
		if(parsedInstructions[0].compareTo("Enemy") != 0)
		{	
			System.out.println("Error: Incorrect Enemy Character creation syntax");
			return null;
		}
		Character c = new NullEnemy("Enemy", 20, 10, 10, 10, 10);
		c.addAbility(new Attack());
		
		return c;
	}

	public Party getEnemyParty(int level) {
		// TODO Auto-generated method stub
		subFactory = new EnemyFactory();
		Party party = subFactory.getEnemyParty(level);
		
		return party;
	}
	
	
}
