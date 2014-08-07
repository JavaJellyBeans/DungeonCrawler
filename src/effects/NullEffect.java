package effects;

public class NullEffect implements PlayerEffect {

	@Override
	public int grantEffect() {
		return 0;
	}

	@Override
	public void description() {
		System.out.println("Null Effect");
	}

}
