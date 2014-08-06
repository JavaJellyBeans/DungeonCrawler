package effects;

public class Poison implements PlayerEffect {

	@Override
	public int grantEffect() {
		return -20;
	}

	@Override
	public void description() {
		System.out.println("poison");

	}

}
