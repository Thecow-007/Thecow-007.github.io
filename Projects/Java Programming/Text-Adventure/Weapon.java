package grade_eleven_culminating;

import java.util.Random;

public class Weapon {
	
	public static enum atk_types{
		SLASH, STAB, THROW, TAUNT
	}
	
	String name = "";
	int SlashDMG = 0;
	int StabDMG = 0;
	int throwDMG = 0;
	int value = 0; // 0-5 (0 being unreachable)
	
	
	public Weapon(String name) {
		this.name = name;
	}
	
	public static int spin_DMG(Weapon w, Game_Map.sels type) {
		int DMG = 0;
		switch(type) {
		case SLASH: DMG = w.SlashDMG; break;
		case STAB: DMG = w.StabDMG; break;
		case THROW: DMG = w.throwDMG; break;
		case TAUNT: DMG = 0; break;
		}
		DMG = (int) (DMG * new Random().nextDouble(0.9, 1.2));
		return DMG;
	}
	public static atk_types selToATk(Game_Map.sels sel) {
		atk_types output = null;
		switch(sel) {
		case SLASH: output = atk_types.SLASH; break;
		case STAB: output = atk_types.STAB; break;
		case THROW: output = atk_types.THROW; break;
		case TAUNT: output = atk_types.TAUNT; break;
		}
		return output;
	}
	
	
}
