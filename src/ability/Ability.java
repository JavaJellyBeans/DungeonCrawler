package ability;
import character.Character;

public abstract class Ability {

	
	public abstract void use(Character user, Character target);
	public abstract String getDescription();
}
