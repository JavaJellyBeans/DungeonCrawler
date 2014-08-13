package character;

import ability.Ability;

public class Rogue extends Player {

	public Rogue()
	{
		super("Rogue", 20, 7, 7, 13, 13);
	}
	
	public Rogue(String newName)
	{
		this();
		setName(newName);
	}
	
	@Override
	public void levelUp(int newLevel)
	{
		/*this.level = level;
		this.hpmax = this.hpmax + (int) Math.ceil(1.0 * level/this.hpmax);
		this.hp = hpmax;
		this.atk = this.atk + (int) Math.ceil(1.0 * level/this.atk);
		this.def = this.def + (int) Math.ceil(1.0 * level/this.def);
		this.agi = this.agi + (int) Math.ceil(1.0 * level/this.agi);
		this.dex = this.dex + (int) Math.ceil(1.0 * level/this.dex);*/
		setLevel(newLevel);
		this.setHpmax(this.getHpmax() + (int) Math.ceil(this.getLevel()/this.getHpmax()));
		this.setAtk(getAtk() + (int) Math.ceil(this.getLevel()/7));
		this.setDef(getDef() + (int) Math.ceil(this.getLevel()/7));
		this.setAgi(getAgi() + (int) Math.ceil(this.getLevel()/2));
		this.setDex(getDex() + (int) Math.ceil(this.getLevel()/2));
		getNewAbility();
	}

	@Override
	public void getNewAbility() {
		// TODO Auto-generated method stub
		if(this.getLevel() == 2)
		{
			//sneak attack
			//deals damage based on dex instead of atk
		}
		if(this.getLevel() == 4)
		{
			//snipe
			//chance to get a critical hit
		}
		if(this.getLevel() == 7)
		{
			//power shot
			//powerful bow shot
		}
		if(this.getLevel() == 10)
		{
			//rage shot
			//little damage, but enrages foe
		}
	}
}
