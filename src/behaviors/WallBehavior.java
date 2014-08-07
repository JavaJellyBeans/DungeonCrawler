package behaviors;

import effects.PlayerEffect;

public class WallBehavior implements RoomBehavior {
	PlayerEffect effect = null;
	
	public WallBehavior(PlayerEffect e) {
		this.effect = e;
	}
	@Override
	public boolean enterable() {
		return false;
	}

	@Override
	public PlayerEffect getEffect() {
		return this.effect;
	}

}
