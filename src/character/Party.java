package character;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ability.Ability;
import java.util.Observable;

import dungeonGeneration.Coordinate;
import dungeonGeneration.Enumerations.Direction;
import dungeonGeneration.Node;

public class Party extends Observable{

	ArrayList<Character> party;
	int level;
	Coordinate coord;
	
	public Party()
	{
		party = new ArrayList<Character>();
		level = 0;
	}
	
	public Party(int level, Coordinate c)
	{
		this();
		this.level = level;
		this.coord = c;
	}
	
	public void addCharacter(Character c)
	{
		party.add(c);
	}
	
	public void levelUp()
	{
		level++;
		for(Iterator<Character> p = party.iterator(); p.hasNext();)
		{
			Character c = p.next();
			c.levelUp(level);
		}
		//foreach(Character c in party)
		//	c.levelUp(level);
	}
	
	public ArrayList<Character> getParty()
	{	return party;	}
	
	public Coordinate getLocation() {return this.coord;}
	public void move(Direction d) {
		int x = coord.getX();
		int y = coord.getY();
		switch(d) {
			case NORTH:
				coord.setY(y-1);
				break;
			case SOUTH:
				coord.setY(y+1);
				break;
			case EAST:
				coord.setX(x+1);
				break;
			case WEST:
				coord.setX(x-1);
				break;
		}
		setChanged();
		notifyObservers();
	}
	
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
	
	public int getLevel(){	return this.level;	}

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
		while(selection >= party.size() || selection < 0 || party.get(selection).getHp() <= 0)
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

	public void showParty() {
		// TODO Auto-generated method stub
		for(Iterator<Character> p = party.iterator(); p.hasNext();)
		{
			Character c = p.next();
			System.out.println(c.toString());
			}
	}
	
	public void printDetail(){
		for(Iterator<Character> p = party.iterator(); p.hasNext();)
		{
			Character c = p.next();
			System.out.println(c.details());
		}
	}
}
