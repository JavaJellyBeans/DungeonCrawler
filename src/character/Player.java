package character;

import java.util.ArrayList;
import java.util.Scanner;

import ability.Ability;

public abstract class Player extends Character {

	private int taunt;
	
	public Player() {
		// TODO Auto-generated constructor stub
	}

	public Player(String newName) {
		super(newName);
		this.taunt = 0;
		// TODO Auto-generated constructor stub
	}

	public Player(String name, int hp, int atk, int def, int dex, int agi) {
		super(name, hp, atk, def, dex, agi);
		this.taunt = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setTaunt(int taunt) {
		// TODO Auto-generated method stub
		if(taunt > 0)
			this.taunt = taunt;
		else if(taunt < 0 && this.taunt > 0)
			this.taunt =- taunt;
	}

	@Override
	public boolean isTaunting() {
		// TODO Auto-generated method stub
		if(taunt > 0)
			return true;
		return false;
	}
	
	@Override
	public void takeTurn(Party allies, Party enemy)
	{
		allies.showParty();
		enemy.showParty();
		setTaunt(-1);
		Ability selectedAction = showActions();
		Character target;
		if(selectedAction.isAOE())
		{
			if(selectedAction.isHelpful())
			{
				for(int i = 0; i < allies.size(); i++)
					selectedAction.use(this, allies.get(i));
			}
			else
			{
				for(int i = 0; i < enemy.size(); i++)
					selectedAction.use(this, enemy.get(i));
			}
		}
		else
		{
			if(selectedAction.isHelpful())
				target = allies.showTargets();
			else
				target = enemy.showTargets();
			selectedAction.use(this, target);
		}
		setRage(-1);
	}

	private Ability showActions() {
		// TODO Auto-generated method stub
		//shows actions available
		ArrayList<Ability> actions = this.getAbilities();
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
	
	public abstract void getNewAbility();
}
