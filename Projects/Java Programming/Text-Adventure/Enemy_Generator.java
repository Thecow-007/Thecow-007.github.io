package grade_eleven_culminating;

public class Enemy_Generator {

	public static Enemy[][] main() {
		// TODO Auto-generated method stub
		
		Enemy goblin = new Enemy("Goblin");
			goblin.atk = 25;
			goblin.tier = 1;
			goblin.luck = 10;
			goblin.hp = 80;
			goblin.strength = Weapon.atk_types.THROW;
		Enemy troll = new Enemy("Troll");
			troll.atk = 20;
			troll.tier = 1;
			troll.luck = 30;
			troll.hp = 90;
			troll.strength = Weapon.atk_types.SLASH;
		Enemy floating_head = new Enemy("Floating Head");
			floating_head.atk = 15;
			floating_head.tier = 1;
			floating_head.luck = 50;
			floating_head.hp = 70;
			floating_head.strength = Weapon.atk_types.STAB;
		Enemy[] Tier1 = {goblin, troll, floating_head};	
		
		Enemy headless_swordsman = new Enemy("Headless Swordsman");
			headless_swordsman.atk = 45;
			headless_swordsman.tier = 2;
			headless_swordsman.luck = 10;
			headless_swordsman.hp = 200;
			headless_swordsman.strength = Weapon.atk_types.THROW;
		Enemy giant = new Enemy("Giant");
			giant.atk = 40;
			giant.tier = 2;
			giant.luck = 30;
			giant.hp = 240;
			giant.strength = Weapon.atk_types.SLASH;
		Enemy banshee = new Enemy("Banshee");
			banshee.atk = 35;
			banshee.tier = 2;
			banshee.luck = 50;
			banshee.hp = 180;
			banshee.strength = Weapon.atk_types.STAB;
		Enemy[] Tier2 = {headless_swordsman, giant, banshee};
			
		Enemy the_dark_magician = new Enemy("The Dark Magician");
			the_dark_magician.atk = 45;
			the_dark_magician.tier = 3;
			the_dark_magician.luck = 20;
			the_dark_magician.hp = 400;
			the_dark_magician.strength = Weapon.atk_types.THROW;
		Enemy stone_golem = new Enemy("Stone Golem");
			stone_golem.atk = 40;
			stone_golem.tier = 3;
			stone_golem.luck = 40;
			stone_golem.hp = 440;
			stone_golem.strength = Weapon.atk_types.SLASH;
		Enemy dragon = new Enemy("Dragon");
			dragon.atk  = 35;
			dragon.tier = 3;
			dragon.luck = 70;
			dragon.hp = 370;
			dragon.strength = Weapon.atk_types.STAB;
		Enemy[] Tier3 = {the_dark_magician, stone_golem, dragon};
		Enemy[][] enemies = {Tier1, Tier2, Tier3};
		return enemies;
	
	}

}
