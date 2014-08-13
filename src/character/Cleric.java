package character;

import java.util.Random;

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
		this.setAtk(getAtk() + (int) Math.ceil(this.getLevel()/7));
		this.setDef(getDef() + (int) Math.ceil(this.getLevel()/4));
		this.setAgi(getAgi() + (int) Math.ceil(this.getLevel()/7));
		this.setDex(getDex() + (int) Math.ceil(this.getLevel()/4));
		getNewAbility();
	}

	@Override
	public void getNewAbility() {
		// TODO Auto-generated method stub
		if(this.getLevel() == 2)
		{
			//calm
			//gets rid of rage
		}
		if(this.getLevel() == 4)
		{
			//mass heal
		}
		if(this.getLevel() == 7)
		{
			//mass restore (heal + calm)
		}
		if(this.getLevel() == 10)
		{
			//revive
		}
	}

}
