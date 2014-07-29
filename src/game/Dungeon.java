package game;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import dungeonGeneration.Display;
import dungeonGeneration.Enumerations.Direction;
import character.Party;
import dungeonGeneration.Map;

public class Dungeon implements ActionListener{
	
	private Map map;
	private Party p1;
	private static Dungeon uniqueInstance;
	
	private Dungeon() {
		map = new Map();
		p1 = new Party(null, map.getStart());
		new Al();
	}
	
	public static Dungeon getInstance() {
		if(uniqueInstance == null)
			uniqueInstance = new Dungeon();
		return uniqueInstance;
	}
	
	public Party getParty() {return this.p1;}
	public Map getMap(){return this.map;}
	
	public class Al extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			final int keycode=e.getKeyCode();
			Thread t = new Thread(new Runnable() {
				
				public void run(){
					if(keycode==KeyEvent.VK_W){
						//p.setDirection(Direction.NORTH);
						if(map.movePlayer(Direction.NORTH))
							p1.move(Direction.NORTH);
					}
					if(keycode==KeyEvent.VK_S){
						//p.setDirection(Direction.SOUTH);
						if(map.movePlayer(Direction.SOUTH))
							p1.move(Direction.SOUTH);
					}
					if(keycode==KeyEvent.VK_A){
						//p.setDirection(Direction.WEST);
						if(map.movePlayer(Direction.WEST))
							p1.move(Direction.WEST);
					}
					if(keycode==KeyEvent.VK_D){
						//p.setDirection(Direction.EAST);
						if(map.movePlayer(Direction.EAST))
							p1.move(Direction.EAST);				
					}
//					if(keycode==KeyEvent.VK_K){
//						//p.addKey();
//						System.out.println(/*"Key cheated in. Player has: " + p.getKeys()*/map.);
//					}
//					if(keycode==KeyEvent.VK_H){
//						//p.increaseHealth();
//						System.out.println("Player gained health!");
//					}
				}
			});
			t.start();	
		}
		
		public void keyReleased(KeyEvent e){
			
		}
		
		public void keyTyped(KeyEvent e){
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Display.display(Dungeon.getInstance());
	}


}
