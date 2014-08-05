package ability;
import character.Character;

public abstract class Ability {

	int level;
	
	public int getLevel(){return this.level;}
	
	public abstract void use(Character user, Character target);
	public abstract String getDescription();
}
