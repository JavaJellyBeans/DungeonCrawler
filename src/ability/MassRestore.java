package ability;
import java.util.Random;

import character.Character;

public class MassRestore extends Ability {

	public MassRestore(){this.level = 0; this.helpful = true; this.aoe = true;}
	
	@Override
	public void use(Character user, Character target) {
		// TODO Auto-generated method stub
		if(target.getHp() > 0)
		{
		System.out.println("MASS RESTORE");
		int heal = target.getHpmax()*3/10;
		System.out.println(user.getName() + " healed " + target.getName() + " for " + heal + " HP and calmed them down");
		target.setHp(target.getHp() + heal);
		target.setRage(0);
		}
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Heals all allies for 30% of their max hp and removes rage";
	}
	
	public String toString(){
		return "Mass Restore:\t" + getDescription();
	}

}
