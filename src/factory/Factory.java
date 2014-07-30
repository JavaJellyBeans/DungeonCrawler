package factory;

import ability.Attack;
import character.Character;

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
		Character c = new Character("Player", 20, 10, 10, 10, 10);
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
		Character c = new Character("Enemy", 20, 10, 10, 10, 10);
		c.addAbility(new Attack());
		
		return c;
	}
}
