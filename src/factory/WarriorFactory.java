package factory;

import ability.Attack;
import character.Character;
import character.NullPlayer;
import character.Warrior;

public class WarriorFactory extends Factory {

	@Override
	public Character getCharacter(String info)
	{
		Character c = new Warrior(info);
		return c;
	}
}
