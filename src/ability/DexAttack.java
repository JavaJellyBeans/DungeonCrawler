package ability;
import java.util.Random;

import character.Character;

public class DexAttack extends Ability {

	public DexAttack(){this.level = 1; this.helpful = false; this.aoe = false;}
	
	@Override
	public void use(Character user, Character target) {
		// TODO Auto-generated method stub
		System.out.println("DEXTEROUS ATTACK");
		//generate whether or not the attack hit
		Random gen = new Random();
		int hit = gen.nextInt(100-user.getDex())+1;
		
		//if the attack hit
		if(hit < 100 - target.getAgi()) {
			System.out.println("The attack hit!");
			//calculate the damage
			int damage = 10*((int) Math.round((double) user.getDex()/target.getDef()))+(user.getDex()-target.getDef());
			//subtract the damage from the target's hp
			target.setHp(target.getHp()-damage);
			//print message with how much damage was dealt
			System.out.println(user.getName() + " dealt " + damage + " to " + target.getName());
		}
		//otherwise
		else {
			//print message that the attack missed
			System.out.println("The attack missed!");
		}
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Deals damage based on user's DEX.\tBase Damage - 10";
	}
	
	public String toString(){
		return "Dexterous Attack:\t" + getDescription();
	}

}
