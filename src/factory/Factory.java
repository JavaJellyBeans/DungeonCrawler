package factory;

import ability.Attack;
import character.Character;
import character.CharacterParty;
import character.Enemy;
import character.Player;

public class Factory {

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
		if(parsedInstructions.length == 2)
			c = new Player(parsedInstructions[1], 20, 10, 10, 10, 10);
		else
			c = new Player("Player", 20, 10, 10, 10, 10);
		c.addAbility(new Attack());
		
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
		Character c = new Enemy("Enemy", 20, 10, 10, 10, 10);
		c.addAbility(new Attack());
		
		return c;
	}

	public CharacterParty getEnemyParty(int level) {
		// TODO Auto-generated method stub
		CharacterParty party = new CharacterParty();
		
		return null;
	}
	
	
}
