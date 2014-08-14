package ability;
import java.util.Random;

import character.Character;

public class Heal extends Ability {

	public Heal(){this.level = 0; this.helpful = true; this.aoe = false;}
	
	@Override
	public void use(Character user, Character target) {
		// TODO Auto-generated method stub
		System.out.println("HEAL");
		int heal = target.getHpmax()*3/5;
		System.out.println(user.getName() + " healed " + target.getName() + " for " + heal + " HP");
		target.setHp(target.getHp() + heal);
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Heals an ally for 60% of its max hp";
	}
	
	public String toString(){
		return "Heal:\t" + getDescription();
	}

}
