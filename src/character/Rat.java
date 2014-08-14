package character;

public class Rat extends Enemy {

	public Rat() {
		// TODO Auto-generated constructor stub
		super("Giant Rat", 20, 10, 10, 10, 10);
		setLevel(1);
	}

	public Rat(String name, int hp, int atk, int def, int dex, int agi) {
		super(name, hp, atk, def, dex, agi);
		// TODO Auto-generated constructor stub
	}

	public Rat(String name, int level) {
		this();
		setName(name);
		setLevel(level);
		// TODO Auto-generated constructor stub
	}

}
