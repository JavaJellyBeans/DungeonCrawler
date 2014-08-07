package behaviors;

import effects.PlayerEffect;

public class ExitBehavior implements RoomBehavior {
	PlayerEffect effect = null;
	
	public ExitBehavior(PlayerEffect e) {
		this.effect = e;
	}
	@Override
	public boolean enterable() {
		return true;
	}

	@Override
	public PlayerEffect getEffect() {
		return this.effect;
	}

}
