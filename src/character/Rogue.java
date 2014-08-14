package character;

import java.util.Random;

import ability.Ability;
import ability.PowerShot;
import ability.RageShot;
import ability.SneakAttack;
import ability.Snipe;

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
		Random gen = new Random();
		this.setHpmax(this.getHpmax() + gen.nextInt(8) + 1);
		this.setHp(this.getHpmax());
		this.setAtk(getAtk() + (int) Math.ceil(this.getLevel()/7)+1);
		this.setDef(getDef() + (int) Math.ceil(this.getLevel()/7)+1);
		this.setAgi(getAgi() + (int) Math.ceil(this.getLevel()/4)+1);
		this.setDex(getDex() + (int) Math.ceil(this.getLevel()/4)+1);
		getNewAbility();
	}

	@Override
	public void getNewAbility() {
		// TODO Auto-generated method stub
		if(this.getLevel() == 2)
		{
			//sneak attack
			//deals damage based on dex instead of atk
			addAbility(new SneakAttack());
		}
		if(this.getLevel() == 4)
		{
			//snipe
			//chance to get a critical hit
			addAbility(new Snipe());
		}
		if(this.getLevel() == 7)
		{
			//power shot
			//deals damage based on dex and attack
			addAbility(new PowerShot());
		}
		if(this.getLevel() == 10)
		{
			//rage shot
			//little damage, but enrages foe
			addAbility(new RageShot());
		}
	}
}
