package factory;

import java.util.Random;

import character.Character;
import character.Dragon;
import character.Enemy;
import character.Gargoyle;
import character.Goblin;
import character.NullEnemy;
import character.Ogre;
import character.Orc;
import character.Party;
import character.Rat;
import character.Spider;
import character.Zombie;

public class EnemyFactory extends Factory {

	public EnemyFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Party getEnemyParty(int level)
	{
		Party party = new Party();
		Random gen = new Random();
		
		if(level == 1)
		{
			if(gen.nextInt(2) == 0)
				party.add(new Goblin());
			else
				party.add(new Rat());
		}
		else if(level == 2)
		{
			if(gen.nextInt(2) == 0)
				party.add(new Orc());
			else
				party.add(new Zombie());
		}
		else if(level == 3)
		{
			party.add(new Spider());
		}
		else if(level == 5)
		{
			party.add(new Ogre());
		}
		else if(level == 7)
		{
			party.add(new Gargoyle());
		}
		else if(level == 15)
		{
			party.add(new Dragon());
		}
		else
		{
			do{
				int enemy = gen.nextInt(level)+1;
				party.addAll(getEnemyParty(enemy));
				level = level - enemy;
			}while(level != 0);
		}
		return party;
	}
}
