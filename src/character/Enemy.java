package character;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import ability.Ability;
import ability.Attack;

public class Enemy extends Character {

	private int level;
	
	public Enemy() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Enemy(String name, int hp, int atk, int def, int dex, int agi) {
		super(name, hp, atk, def, dex, agi);
		// TODO Auto-generated constructor stub
	}
	
	public Enemy(String name, int level)
	{
		super(name);
		
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	@Override
	public void takeTurn(Party allies, Party enemy) {
		// TODO Auto-generated method stub
		//depending on character level, determine the skill and target
		if(this.getHp() > 0)
		{
			Character target = getTarget(enemy);
			Ability use = getAbility(enemy);
			use.use(this, target);
			setRage(-1);
		}
	}

	private Ability getAbility(Party cp) {
		// TODO Auto-generated method stub
		if(this.isRaging())
		{
			return new Attack();
		}
		if(level <= 4)
		{
			//choose ability at random
			Random gen = new Random();
			return getAbilities().get(gen.nextInt(getAbilities().size()));
		}
		if(level > 4 && level <= 8)
		{
			//choose most recently acquired ability
			return getAbilities().get(getAbilities().size());
		}
		if(level > 8)
		{
			//choose highest level ability
			Ability use = null;
			for(Iterator<Ability> ab = getAbilities().iterator(); ab.hasNext();)
			{
				Ability a = ab.next();
				if(use != null && use.getLevel() < a.getLevel())
					use = a;
				if(use == null)
					use = a;
			}
			return use;
		}
		return null;
	}

	private Character getTarget(Party cp) {
		// TODO Auto-generated method stub
		for(Iterator<Character> party = cp.getParty().iterator(); party.hasNext();)
		{
			Character c = party.next();
			if(c.isTaunting())
				return c;
		}
		if(level <= 3)
		{
			//choose one at random
			Random gen = new Random();
			return cp.get(gen.nextInt(cp.getParty().size()));
		}
		if(level > 4 && level <= 8)
		{
			//pick character with lowest hp %
			Character c = cp.get(0);
			double hpcent = (double) c.getHp()/c.getHpmax();
			for(int i = 1; i < cp.getParty().size(); i++)
			{
				double temp = (double) cp.get(i).getHp()/cp.get(i).getHpmax();
				if((hpcent > 0.0 && temp < hpcent && temp != 0.0) || hpcent == 0.0)
				{
					c = cp.get(i);
					hpcent = temp;
				}
			}
			return c;
		}
		if(level > 8)
		{
			//pick character with lowest hp
			int temp = 1000000;
			Character target = null;;
			for(Iterator<Character> party = cp.getParty().iterator(); party.hasNext();)
			{
				Character c = party.next();
				if(c.getHp() < temp)
				{
					temp = c.getHp();
					target = c;
				}
			}
			return target;
		}
		return null;
	}

	
}
