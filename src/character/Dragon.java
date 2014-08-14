package character;

import ability.Fireball;
import ability.MassFireball;
import ability.PowerCleave;

public class Dragon extends Enemy {

	public Dragon() {
		// TODO Auto-generated constructor stub
		super("Dragon", 100, 45, 45, 45, 45);
		setLevel(15);
		addAbility(new PowerCleave());
		addAbility(new Fireball());
		addAbility(new MassFireball());
	}

	public Dragon(String name, int hp, int atk, int def, int dex, int agi) {
		super(name, hp, atk, def, dex, agi);
		// TODO Auto-generated constructor stub
	}

	public Dragon(String name, int level) {
		this();
		setName(name);
		setLevel(level);
		// TODO Auto-generated constructor stub
	}

}
