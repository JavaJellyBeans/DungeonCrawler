package effects;

public class WinGame implements PlayerEffect {

	@Override
	public int grantEffect() {
		this.description();
		return -1;
	}

	@Override
	public void description() {
		System.out.println("You won!");
	}

}
