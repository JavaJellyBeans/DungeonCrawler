package character;

import java.util.Random;

import ability.Calm;
import ability.Heal;
import ability.MassHeal;
import ability.MassRestore;

public class Cleric extends Player {

	public Cleric() {
		// TODO Auto-generated constructor stub
		super("Cleric", 23, 8, 11, 8, 11);
	}

	public Cleric(String newName) {
		this();
		setName(newName);
		// TODO Auto-generated constructor stub
	}

	public Cleric(String name, int hp, int atk, int def, int dex, int agi) {
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
		this.setHpmax(this.getHpmax() + gen.nextInt(8) + 1);
		this.setHp(this.getHpmax());
		this.setAtk(getAtk() + (int) Math.ceil(this.getLevel()/7)+1);
		this.setDef(getDef() + (int) Math.ceil(this.getLevel()/4)+1);
		this.setAgi(getAgi() + (int) Math.ceil(this.getLevel()/7)+1);
		this.setDex(getDex() + (int) Math.ceil(this.getLevel()/4)+1);
		getNewAbility();
	}

	public void getNewAbility() {
		// TODO Auto-generated method stub
		if(this.getLevel() == 2)
		{
			//calm
			//gets rid of rage
			addAbility(new Calm());
		}
		if(this.getLevel() == 4)
		{
			//mass heal
			addAbility(new MassHeal());
		}
		if(this.getLevel() == 7)
		{
			//mass restore (heal + calm)
			addAbility(new MassRestore());
		}
		if(this.getLevel() == 10)
		{
			//mass revive
		}
	}

}
