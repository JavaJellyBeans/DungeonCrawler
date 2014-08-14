package character;

public class Orc extends Enemy {

	public Orc() {
		// TODO Auto-generated constructor stub
		super("Orc", 25, 13, 13, 9, 9);
		setLevel(2);
	}

	public Orc(String name, int hp, int atk, int def, int dex, int agi) {
		super(name, hp, atk, def, dex, agi);
		// TODO Auto-generated constructor stub
	}

	public Orc(String name, int level) {
		this();
		setName(name);
		setLevel(level);
		// TODO Auto-generated constructor stub
	}

}
