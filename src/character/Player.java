package character;

public class Player extends Character {

	private int taunt;
	
	public Player() {
		// TODO Auto-generated constructor stub
	}

	public Player(String newName) {
		super(newName);
		this.taunt = 0;
		// TODO Auto-generated constructor stub
	}

	public Player(String name, int hp, int atk, int def, int dex, int agi) {
		super(name, hp, atk, def, dex, agi);
		this.taunt = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setTaunt(int taunt) {
		// TODO Auto-generated method stub
		if(taunt > 0)
			this.taunt = taunt;
		else if(taunt < 0 && this.taunt > 0)
			this.taunt =- taunt;
	}

	@Override
	public boolean isTaunting() {
		// TODO Auto-generated method stub
		if(taunt > 0)
			return true;
		return false;
	}

}
