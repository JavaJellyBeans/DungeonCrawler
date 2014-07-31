package character;

import java.util.ArrayList;
import java.util.Scanner;

import ability.Ability;

public class CharacterParty {

	ArrayList<Character> party;
	int level;
	
	public CharacterParty()
	{
		party = new ArrayList<Character>();
		level = 0;
	}
	
	public void addCharacter(Character c)
	{
		party.add(c);
	}
	
	public void levelUp()
	{
		level++;
		//foreach(Character c in party)
		//	c.levelUp(level);
	}
	
	public ArrayList<Character> getParty()
	{	return party;	}

	public void addAll(ArrayList<Character> newPlayers) {
		// TODO Auto-generated method stub
		party.addAll(newPlayers);
	}

	public void add(Character newPlayer) {
		// TODO Auto-generated method stub
		party.add(newPlayer);
	}

	public int size() {
		// TODO Auto-generated method stub
		return party.size();
	}

	public Character get(int i) {
		// TODO Auto-generated method stub
		return party.get(i);
	}

	public Ability showActions(Character c) {
		// TODO Auto-generated method stub
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

	public Character showTargets() {
		// TODO Auto-generated method stub
		System.out.println("Select a target: ");
		for(int i = 0; i < party.size(); i++)
		{
			System.out.println("\t"+i+":"+party.get(i).toString());
		}
		System.out.print("Selection: ");
		Scanner kb = new Scanner(System.in);
		int selection = kb.nextInt();
		while(selection >= party.size() || selection < 0)
		{
			System.out.print("Not a valid option. Please try again\nSelection: ");
			selection = kb.nextInt();
		}
		return party.get(selection);
	}

	public boolean defeated() {
		// TODO Auto-generated method stub
		boolean defeated = true;
		for(int i = 0; i < party.size(); i++)
		{
			if(party.get(i).getHp() > 0)
				defeated = false;
		}
		return defeated;
	}
}
