package character;

public abstract class Character {
	private int hp;		//current hp
	private int hpmax;	//max hp
	private int atk;	//attack
	private int def;	//defense
	private int dex;	//dexterity (easier to hit with attacks)
	private int agi;	//agility (easier to dodge enemy attacks)

	
	//ArrayList<Ability> abilities;	//usable abilities
	//ArrayList<Equippable> equipped; //equipped items
	
	
	
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
	//end getters and setters
}

