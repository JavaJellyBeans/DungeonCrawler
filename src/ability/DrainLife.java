package ability;
import java.util.Random;

import character.Character;

public class DrainLife extends Ability {

	public DrainLife(){this.level = 0; this.helpful = false; this.aoe = false;}
	
	@Override
	public void use(Character user, Character target) {
		// TODO Auto-generated method stub
		System.out.println("DRAIN LIFE");
		//generate whether or not the attack hit
		Random gen = new Random();
		int hit = gen.nextInt(100-user.getDex())+1;
		
		//if the attack hit
		if(hit < 100 - target.getAgi()) {
			System.out.println("The attack hit!");
			//calculate the damage
			int damage = 10*((int) Math.round((double) user.getLevel()*3/target.getDef())+2%user.getLevel());
			//subtract the damage from the target's hp
			target.setHp(target.getHp()-damage);
			user.setHp(user.getHp() + damage);
			//print message with how much damage was dealt
			System.out.println(user.getName() + " drained " + damage + " from " + target.getName());
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
		return "A sinister attack that deals damage that scales with level and heals the user for the same amount of damage dealt.\tBase Damage - 10";
	}
	
	public String toString(){
		return "Drain Life:\t" + getDescription();
	}

}
