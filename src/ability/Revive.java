package ability;
import java.util.Random;

import character.Character;

public class Revive extends Ability {

	public Revive(){this.level = 0; this.helpful = true; this.aoe = true;}
	
	@Override
	public void use(Character user, Character target) {
		// TODO Auto-generated method stub

		System.out.println("REVIVE");
		if(target.getHp() > 0){
			int heal = target.getHpmax()*3/10;
			System.out.println(user.getName() + " healed " + target.getName() + " for " + heal + " HP and calmed them down");
			target.setHp(target.getHp() + heal);
			target.setRage(0);
		}
		else if(target.getHp() <= 0)
		{
			System.out.println(user.getName() + " revived " + target.getName());
			target.setHp(target.getHpmax()/2);
			target.setRage(0);
		}
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Heals all allies for 30% of their max hp and revives fallen ones to 50% of their max hp";
	}
	
	public String toString(){
		return "Revive:\t" + getDescription();
	}

}
