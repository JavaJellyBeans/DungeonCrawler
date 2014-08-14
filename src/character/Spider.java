package character;

public class Spider extends Enemy {

	public Spider() {
		// TODO Auto-generated constructor stub
		super("Giant Spider", 30, 20, 20, 15, 15);
		setLevel(3);
	}

	public Spider(String name, int hp, int atk, int def, int dex, int agi) {
		super(name, hp, atk, def, dex, agi);
		// TODO Auto-generated constructor stub
	}

	public Spider(String name, int level) {
		this();
		setName(name);
		setLevel(level);
		// TODO Auto-generated constructor stub
	}

}
