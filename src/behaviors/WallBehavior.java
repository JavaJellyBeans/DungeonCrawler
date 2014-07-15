package behaviors;

public class WallBehavior implements RoomBehavior {

	@Override
	public boolean enterable() {
		return false;
	}

}
