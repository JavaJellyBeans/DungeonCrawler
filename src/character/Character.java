package character;

import java.util.ArrayList;

import ability.Ability;
import ability.Attack;

public /*abstract*/ class Character {
	private String name; //name
	private int hp;		//current hp
	private int hpmax;	//max hp
	private int atk;	//attack
	private int def;	//defense
	private int dex;	//dexterity (easier to hit with attacks)
	private int agi;	//agility (easier to dodge enemy attacks)

	
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
		abilities = new ArrayList<Ability>();
		abilities.add(new Attack());
	}
	
	public Character(String name, int hp, int atk, int def, int dex, int agi)
	{
		this.name = name;
		this.hp = this.hpmax = hp;
		this.atk = atk;
		this.def = def;
		this.dex = dex;
		this.agi = agi;
		abilities = new ArrayList<Ability>();
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
			return this.name + "\t" + this.hp + "/" + this.hpmax;
		}
}

