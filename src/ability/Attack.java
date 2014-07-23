package ability;
import character.Character;

public class Attack implements Ability {

	public Attack(){}
	@Override
	public void use(Character user, Character target) {
		// TODO Auto-generated method stub
		
		//generate whether or not the attack hit
		//if the attack hit
			//calculate the damage
			//subtract the damage from the target's hp
			//print message with how much damage was dealt
		//otherwise
			//print message that the attack missed
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "A basic attack.\n\tBase Damage - 10";
	}

}
