package character;

import java.util.Random;

import ability.DrainLife;
import ability.Lightning;
import ability.LightningStorm;
import ability.MassFireball;

public class Mage extends Player {

	public Mage() {
		// TODO Auto-generated constructor stub
		super("Mage", 23, 8, 8, 8, 8);
	}

	public Mage(String newName) {
		this();
		setName(newName);
		// TODO Auto-generated constructor stub
	}

	public Mage(String name, int hp, int atk, int def, int dex, int agi) {
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
		this.setHpmax(this.getHpmax() + gen.nextInt(6) + 1);
		this.setHp(this.getHpmax());
		this.setAtk(getAtk() + (int) Math.ceil(this.getLevel()/7));
		this.setDef(getDef() + (int) Math.ceil(this.getLevel()/7));
		this.setAgi(getAgi() + (int) Math.ceil(this.getLevel()/7));
		this.setDex(getDex() + (int) Math.ceil(this.getLevel()/7));
		getNewAbility();
	}

	@Override
	public void getNewAbility() {
		// TODO Auto-generated method stub
		if(this.getLevel() == 2)
		{
			//lightning strike
			//deals more damage the less hp the opponent has
			addAbility(new Lightning());
		}
		if(this.getLevel() == 4)
		{
			//mass fireball
			//aoe hits everything
			addAbility(new MassFireball());
		}
		if(this.getLevel() == 7)
		{
			//drain life
			//damage + heal
			addAbility(new DrainLife());
		}
		if(this.getLevel() == 10)
		{
			//thunderstorm
			//aoe hits everything
			addAbility(new LightningStorm());
		}
	}
}
