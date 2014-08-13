package factory;

import ability.Attack;
import character.Character;
import character.Rogue;

public class RogueFactory extends Factory {

	@Override
	public Character getCharacter(String info)
	{
		Character c = new Rogue(info);
		c.addAbility(new Attack());
		return c;
	}
}
