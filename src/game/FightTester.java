package game;
import character.Character;
import factory.Factory;

public class FightTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory f = new Factory();
		Character player = f.getCharacter("Player");
		Character enemy = f.getCharacter("Enemy");
		
		Fight fight = new Fight(player, enemy);
		fight.battle();
	}

}
