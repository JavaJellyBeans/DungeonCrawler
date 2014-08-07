package behaviors;

import effects.PlayerEffect;

public class EmptyBehavior implements RoomBehavior {
	PlayerEffect effect = null;
	
	public EmptyBehavior(PlayerEffect e) {
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
