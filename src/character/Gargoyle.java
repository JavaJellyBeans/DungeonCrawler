package character;

import ability.PowerCleave;

public class Gargoyle extends Enemy {

	public Gargoyle() {
		// TODO Auto-generated constructor stub
		super("Gargoyle", 60, 25, 25, 20, 20);
		setLevel(7);
		addAbility(new PowerCleave());
	}

	public Gargoyle(String name, int hp, int atk, int def, int dex, int agi) {
		super(name, hp, atk, def, dex, agi);
		// TODO Auto-generated constructor stub
	}

	public Gargoyle(String name, int level) {
		this();
		setName(name);
		setLevel(level);
		// TODO Auto-generated constructor stub
	}

}
