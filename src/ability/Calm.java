package ability;
import java.util.Random;

import character.Character;

public class Calm extends Ability {

	public Calm(){this.level = 0; this.helpful = true; this.aoe = false;}
	
	@Override
	public void use(Character user, Character target) {
		// TODO Auto-generated method stub
		System.out.println("CALM");
		System.out.println(user.getName() + " calmed " + target.getName());
		target.setRage(0);
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Calms an ally, removing their rage.";
	}
	
	public String toString(){
		return "Calm:\t" + getDescription();
	}

}
