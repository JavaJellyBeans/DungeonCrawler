package ability;
import character.Character;

public interface Ability {

	
	public void use(Character user, Character target);
	public String getDescription();
}
