package factory;

import character.*;
import character.Character;

public class MageFactory extends Factory {

	@Override
	public Character getCharacter(String info)
	{
		return new NullPlayer(info);
	}
}
