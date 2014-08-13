package ability;
import character.Character;

public abstract class Ability {

	int level;
	boolean helpful;
	boolean aoe;
	
	public boolean isHelpful(){return this.helpful;}
	public int getLevel(){return this.level;}
	public boolean isAOE(){return this.aoe;}
	
	public abstract void use(Character user, Character target);
	public abstract String getDescription();
}
