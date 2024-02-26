package grade_eleven_culminating;


public class Weapon_File_Generator {

	public static Weapon[][] main() {
		// TODO Auto-generated method stub
		
		//Swords
		Weapon Training_Sword = new Weapon("Training Sword");
			Training_Sword.SlashDMG = 10;
			Training_Sword.StabDMG = 8;
			Training_Sword.throwDMG = 25;
			Training_Sword.value = 0;
		Weapon Iron_Shortsword = new Weapon("Iron Shortsword");
			Iron_Shortsword.SlashDMG = 30;
			Iron_Shortsword.StabDMG = 25;
			Iron_Shortsword.throwDMG = 45;
			Iron_Shortsword.value = 1;
		Weapon Gold_Cutlass = new Weapon("Gold Cutlass");
			Gold_Cutlass.SlashDMG = 40;
			Gold_Cutlass.StabDMG = 45;
			Gold_Cutlass.throwDMG = 50;
			Gold_Cutlass.value = 2;
		Weapon Gleaming_Broadsword = new Weapon("Gleaming Broadsword");
			Gleaming_Broadsword.SlashDMG = 60;
			Gleaming_Broadsword.StabDMG = 55;
			Gleaming_Broadsword.throwDMG = 70;
			Gleaming_Broadsword.value = 3;
		Weapon Blade_Of_Fury = new Weapon("Blade Of Fury");
			Blade_Of_Fury.SlashDMG = 90;
			Blade_Of_Fury.StabDMG = 120;
			Blade_Of_Fury.throwDMG = 150;
			Blade_Of_Fury.value = 4;
		Weapon The_God_Killer = new Weapon("The God Killer");
			The_God_Killer.SlashDMG = 150;
			The_God_Killer.StabDMG = 160;
			The_God_Killer.throwDMG = 250;
			The_God_Killer.value = 5;
		
		Weapon[] Swords = {Iron_Shortsword,Gold_Cutlass,Gleaming_Broadsword,Blade_Of_Fury,The_God_Killer};
			
		//Axes
		Weapon Rusty_Axe = new Weapon("Rusty Axe");
			Rusty_Axe.SlashDMG = 30;
			Rusty_Axe.StabDMG = 10;
			Rusty_Axe.throwDMG = 60;
			Rusty_Axe.value = 1;
		Weapon War_Axe = new Weapon("War Axe");
			War_Axe.SlashDMG = 50;
			War_Axe.StabDMG = 20;
			War_Axe.throwDMG = 100;
			War_Axe.value = 2;
		Weapon Excecutioners_Axe = new Weapon("Excecutioner's Axe");
			Excecutioners_Axe.SlashDMG = 70;
			Excecutioners_Axe.StabDMG = 35;
			Excecutioners_Axe.throwDMG = 150;
			Excecutioners_Axe.value = 3;
		Weapon Paladins_Axe = new Weapon("Paladin's Axe");
			Paladins_Axe.SlashDMG = 120;
			Paladins_Axe.StabDMG = 50;
			Paladins_Axe.throwDMG = 240;
			Paladins_Axe.value = 4;
		Weapon Time_Cleaver = new Weapon("Time Cleaver");
			Time_Cleaver.SlashDMG = 200;
			Time_Cleaver.StabDMG = 80;
			Time_Cleaver.throwDMG = 350;
			Time_Cleaver.value = 5;
			
		Weapon[] Axes = {Rusty_Axe,War_Axe,Excecutioners_Axe,Paladins_Axe,Time_Cleaver};
			
		//Spears
		Weapon Wooden_Spear = new Weapon("Wooden Spear");
			Wooden_Spear.SlashDMG = 10;
			Wooden_Spear.StabDMG = 25;
			Wooden_Spear.throwDMG = 80;
			Wooden_Spear.value = 1;
		Weapon Polemans_Spear = new Weapon("Poleman's Spear");
			Polemans_Spear.SlashDMG = 25;
			Polemans_Spear.StabDMG = 40;
			Polemans_Spear.throwDMG = 120;
			Polemans_Spear.value = 2;
		Weapon Gold_Spear = new Weapon("Gold Spear");
			Gold_Spear.SlashDMG = 35;
			Gold_Spear.StabDMG = 70;
			Gold_Spear.throwDMG = 160;
			Gold_Spear.value = 3;
		Weapon Dark_Lance = new Weapon("Dark Lance");
			Dark_Lance.SlashDMG = 55;
			Dark_Lance.StabDMG = 120;
			Dark_Lance.throwDMG = 240;
			Dark_Lance.value = 4;
		Weapon Trident_of_the_Sea_God = new Weapon("Trident of the Sea God");
			Trident_of_the_Sea_God.SlashDMG = 70;
			Trident_of_the_Sea_God.StabDMG = 210;
			Trident_of_the_Sea_God.throwDMG = 500;
			Trident_of_the_Sea_God.value = 5;
		
		Weapon[] Spears = {Wooden_Spear,Polemans_Spear,Gold_Spear,Dark_Lance,Trident_of_the_Sea_God};
		
		Weapon[] Specials = {Training_Sword};
		
		Weapon[][] Weapons = {Swords,Axes,Spears,Specials};
		return Weapons;
		
	}

}
