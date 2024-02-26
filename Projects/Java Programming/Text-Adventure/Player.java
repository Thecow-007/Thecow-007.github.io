package grade_eleven_culminating;

import java.util.ArrayList;


public class Player {
	
	int hp = 200;
	int max_hp = 200;
	
	String name;
	Enemy current_monster;
	
	Weapon current_weapon = Culminating_Main.Weapons[3][0];
	ArrayList<Weapon> inventory = new ArrayList<Weapon>();
	
	public Player(String n){
		name = n;
	}
	
}
