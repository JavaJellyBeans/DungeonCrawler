package character;

public class Goblin extends Enemy {

	public Goblin() {
		// TODO Auto-generated constructor stub
		super("Goblin", 20, 10, 10, 10, 10);
		setLevel(1);
	}

	public Goblin(String name, int hp, int atk, int def, int dex, int agi) {
		super(name, hp, atk, def, dex, agi);
		// TODO Auto-generated constructor stub
	}

	public Goblin(String name, int level) {
		this();
		setName(name);
		setLevel(level);
		// TODO Auto-generated constructor stub
	}

}
