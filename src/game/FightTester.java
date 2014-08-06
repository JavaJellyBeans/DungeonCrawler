package game;
import character.Character;
import character.CharacterParty;
import factory.Factory;

public class FightTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory f = new Factory();
		CharacterParty player = new CharacterParty();
		player.add(f.getCharacter("Player Player1"));
		player.add(f.getCharacter("Player Player2"));
		player.add(f.getCharacter("Player Player3"));
		
		//for(int i = 0; i < 20; i++)
			//player.levelUp();
		player.printDetail();
		Fight fight = new Fight(player);
		player.printDetail();
	}

}
