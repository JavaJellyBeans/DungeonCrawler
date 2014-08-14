package character;

import java.util.Random;

import ability.DexAttack;
import ability.ExpertAttack;
import ability.PowerCleave;
import ability.TrickStab;

public class Warrior extends Player {

	public Warrior() {
		// TODO Auto-generated constructor stub
	}

	public Warrior(String newName) {
		super(newName);
		// TODO Auto-generated constructor stub
	}

	public Warrior(String name, int hp, int atk, int def, int dex, int agi) {
		super(name, hp, atk, def, dex, agi);
		// TODO Auto-generated constructor stub
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
		this.setHpmax(this.getHpmax() + gen.nextInt(10) + 1);
		this.setHp(this.getHpmax());
		this.setAtk(getAtk() + (int) Math.ceil(this.getLevel()/4)+1);
		this.setDef(getDef() + (int) Math.ceil(this.getLevel()/5)+1);
		this.setAgi(getAgi() + (int) Math.ceil(this.getLevel()/5)+1);
		this.setDex(getDex() + (int) Math.ceil(this.getLevel()/5)+1);
		getNewAbility();
	}

	public void getNewAbility() {
		// TODO Auto-generated method stub
		if(this.getLevel() == 2)
		{
			//power cleave
			//deals bonus damage based on user's attack
			addAbility(new PowerCleave());
		}
		if(this.getLevel() == 4)
		{
			//dexterous swing
			//deals bonus damage based on user's dex
			addAbility(new DexAttack());
		}
		if(this.getLevel() == 7)
		{
			//trick stab
			//deals damage based on dex vs agi instead of atk vs def
			addAbility(new TrickStab());
		}
		if(this.getLevel() == 10)
		{
			//expert attack
			//deals bonus damage based on level
			addAbility(new ExpertAttack());
		}
	}

}
