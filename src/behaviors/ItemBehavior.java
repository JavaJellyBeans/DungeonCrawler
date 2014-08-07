package behaviors;

import effects.PlayerEffect;

public class ItemBehavior implements RoomBehavior {
	private PlayerEffect effect = null;
	
	public ItemBehavior(PlayerEffect e) {
		this.effect = e;
	}
	
	public void setEffect(PlayerEffect e) {
		this.effect = e;
	}
	
	@Override
	public boolean enterable() {
		return true;
	}
	
	public void description() {
		effect.description();
	}

	@Override
	public PlayerEffect getEffect() {
		return effect;
	}

}
