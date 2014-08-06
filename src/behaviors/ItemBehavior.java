package behaviors;

import effects.PlayerEffect;

public class ItemBehavior implements RoomBehavior {
	private PlayerEffect effect = null;
	
	public ItemBehavior(PlayerEffect effect) {
		this.effect = effect;
	}
	
	@Override
	public boolean enterable() {
		return true;
	}
	
	public void description() {
		effect.description();
	}

}
