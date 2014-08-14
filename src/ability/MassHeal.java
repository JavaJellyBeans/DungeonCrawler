package ability;
import java.util.Random;

import character.Character;

public class MassHeal extends Ability {

	public MassHeal(){this.level = 0; this.helpful = true; this.aoe = true;}
	
	@Override
	public void use(Character user, Character target) {
		// TODO Auto-generated method stub
		System.out.println("HEAL");
		int heal = target.getHpmax()*2/5;
		System.out.println(user.getName() + " healed " + target.getName() + " for " + heal + " HP");
		target.setHp(target.getHp() + heal);
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Heals all allies for 40% of their max hp";
	}
	
	public String toString(){
		return "MassHeal:\t" + getDescription();
	}

}
