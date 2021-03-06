package factory;

import ability.Attack;
import ability.Heal;
import character.Character;
import character.Cleric;
import character.Mage;
import character.NullPlayer;

public class ClericFactory extends Factory {

	@Override
	public Character getCharacter(String info)
	{
		Character c = new Cleric();
		c.addAbility(new Heal());
		return c;
	}
}
