package grade_eleven_culminating;

import java.util.Random;

public class Enemy {
	
	enum types{
		FLYING, SMALL, LARGE
	}
	
	int atk = 0;
	int tier = 0; // 1-3, 0 is unreachable
	int luck = 0;
	int hp = 0;
	int rage = 0;
	Weapon.atk_types strength;
	
	String name;
	public Enemy(String n){
		name = n;
	}
	
	public int rollDMG(Enemy e) {
		Random r = new Random();
		int DMG = (int) (e.atk * (1 +  (r.nextInt(0,100)) / 100 * (luck / 100)));
		return DMG;
	}
	
	public static void dmgTaken(int DMG, Enemy e, Weapon.atk_types type) {
		Random r = new Random();
		if(type == e.strength) {
			DMG = (int) (DMG * 0.70);
		}
		if(type == Weapon.atk_types.TAUNT) {
			e.rage += r.nextInt(0,40);
		}
		e.hp -= DMG + (e.rage / 100);
	}
	
	
}
