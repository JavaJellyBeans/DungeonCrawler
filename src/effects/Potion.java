package effects;

public class Potion implements PlayerEffect {

	@Override
	public int grantEffect() {
		return 10;
	}

	@Override
	public void description() {
		System.out.println("health potion");
	}

}
