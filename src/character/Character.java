package character;

import java.util.ArrayList;

import ability.Ability;
import ability.Attack;

public abstract class Character {
	private String name; //name
	private int hp;		//current hp
	private int hpmax;	//max hp
	private int atk;	//attack
	private int def;	//defense
	private int dex;	//dexterity (easier to hit with attacks)
	private int agi;	//agility (easier to dodge enemy attacks)
	private int rage;	//how many turns the character is enraged for
	private int level;
	
	private ArrayList<Ability> abilities;	//usable abilities
	//ArrayList<Equippable> equipped; //equipped items
	
	/**/
	public Character(){
		this.setName("Basic Character");
		hp = 20;
		hpmax = 20;
		atk = 10;
		def = 10;
		dex = 10;
		agi = 10;
		level = 1;
		abilities = new ArrayList<Ability>();
		abilities.add(new Attack());
		rage = 0;
	}
	
	public Character(String newName)
	{
		this();
		setName(newName);
	}
	
	public Character(String name, int hp, int atk, int def, int dex, int agi)
	{
		this.name = name;
		this.hp = this.hpmax = hp;
		this.atk = atk;
		this.def = def;
		this.dex = dex;
		this.agi = agi;
		level = 1;
		abilities = new ArrayList<Ability>();
		rage = 0;
	}
	
	//getters and setters
		public int getHp() {
			return hp;
		}
		public void setHp(int hp) {
			this.hp = hp;
		}
		public int getHpmax() {
			return hpmax;
		}
		public void setHpmax(int hpmax) {
			this.hpmax = hpmax;
		}
		public int getAtk() {
			return atk;
		}
		public void setAtk(int atk) {
			this.atk = atk;
		}
		public int getDef() {
			return def;
		}
		public void setDef(int def) {
			this.def = def;
		}
		public int getDex() {
			return dex;
		}
		public void setDex(int dex) {
			this.dex = dex;
		}
		public int getAgi() {
			return agi;
		}
		public void setAgi(int agi) {
		this.agi = agi;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public ArrayList<Ability> getAbilities() {
			if(this.rage > 0)
			{
				ArrayList<Ability> enraged = new ArrayList<Ability>();
				enraged.add(new Attack());
				return enraged;
			}
			return abilities;
		}
		public void setAbilities(ArrayList<Ability> abilities) {
			this.abilities = abilities;	
		}
		public void addAbility(Ability ability) {
			abilities.add(ability);
		}
	//end getters and setters
		
		public String toString() {
			return this.name + "\t" + this.hp + "/" + this.hpmax + "\tLevel " + this.level;
		}
		public String details(){
			return this.toString() + "\n\tAttack:\t" + this.atk + "\n\tDefense:\t" + this.def + "\n\tAgility:\t" + this.agi + "\n\tDexterity:\t" + this.dex;
		}
		
		public void takeTurn(Party allies, Party enemy){};

		public void setTaunt(int taunt){}
		public boolean isTaunting(){return false;}
		
		public void setRage(int rage)
		{
			if(rage > 0)
				this.rage = rage;
			else if(rage < 0 && this.rage > 0)
				this.rage =- rage;
		}
		public boolean isRaging()
		{	
			if(this.rage > 0)
				return true;
			return false;
		}

		public void levelUp(int level) {
			// TODO Auto-generated method stub
			this.level = level;
			this.hpmax = this.hpmax + (int) Math.ceil(1.0 * level/this.hpmax);
			this.hp = hpmax;
			this.atk = this.atk + (int) Math.ceil(1.0 * level/this.atk);
			this.def = this.def + (int) Math.ceil(1.0 * level/this.def);
			this.agi = this.agi + (int) Math.ceil(1.0 * level/this.agi);
			this.dex = this.dex + (int) Math.ceil(1.0 * level/this.dex);
		}
}

