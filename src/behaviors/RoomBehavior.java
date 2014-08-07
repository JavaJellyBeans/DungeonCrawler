package behaviors;

import effects.PlayerEffect;

public interface RoomBehavior {
	
	public boolean enterable();
	
	public PlayerEffect getEffect();

}
