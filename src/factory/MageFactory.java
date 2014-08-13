package factory;

import ability.Attack;
import character.*;
import character.Character;

public class MageFactory extends Factory {

	@Override
	public Character getCharacter(String info)
	{
		Character c = new Mage();
		c.addAbility(new Attack());
		//c.addAbility(new Fireball());
		return c;
	}
}
