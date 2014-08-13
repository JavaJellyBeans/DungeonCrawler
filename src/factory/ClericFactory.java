package factory;

import character.Character;
import character.NullPlayer;

public class ClericFactory extends Factory {

	@Override
	public Character getCharacter(String info)
	{
		return new NullPlayer(info);
	}
}
