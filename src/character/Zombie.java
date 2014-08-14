package character;

public class Zombie extends Enemy {

	public Zombie() {
		// TODO Auto-generated constructor stub
		super("Zombie", 20, 17, 12, 5, 5);
		setLevel(2);
	}

	public Zombie(String name, int hp, int atk, int def, int dex, int agi) {
		super(name, hp, atk, def, dex, agi);
		// TODO Auto-generated constructor stub
	}

	public Zombie(String name, int level) {
		this();
		setName(name);
		setLevel(level);
		// TODO Auto-generated constructor stub
	}

}
