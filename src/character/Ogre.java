package character;

import ability.PowerCleave;

public class Ogre extends Enemy {

	public Ogre() {
		// TODO Auto-generated constructor stub
		super("Ogre", 50, 20, 20, 15, 15);
		setLevel(5);
	}

	public Ogre(String name, int hp, int atk, int def, int dex, int agi) {
		super(name, hp, atk, def, dex, agi);
		// TODO Auto-generated constructor stub
	}

	public Ogre(String name, int level) {
		this();
		setName(name);
		setLevel(level);
		// TODO Auto-generated constructor stub
	}

}
