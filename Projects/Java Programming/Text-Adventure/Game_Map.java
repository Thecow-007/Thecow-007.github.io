package grade_eleven_culminating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;



public class Game_Map {
	
	public static String DEFAULT_CHAR = "_";
	public static String Message;
	
	public static ArrayList<Enemy> towerLineUp = new ArrayList<Enemy>();
			
	public static enum hidden{
		ISHIDDEN, ISSEEN
	}
	
	public static enum sels{
		SLASH, STAB, THROW, TAUNT
	}
	static sels current_sel = sels.STAB;
	
	HashMap<String, String> gMap = new HashMap<String, String>();
	HashMap<String,hidden> vis= new HashMap<String, hidden>();
	
	String playerCoords = "3232";
	String current_Building = DEFAULT_CHAR;
	
	public static String[] buildings = {"T", "F", "*", "C", "E"};
	
	public Game_Map() {
		for(int y = 0; y < 33; y++) {
			for(int x = 0; x < 64; x++) {
				String strY = "" + y;
				String strX = "" + x;
				
				if(strY.length() < 2) {
					strY = "0" + strY;
				}
				if(strX.length() < 2) {
					strX = "0" + strX;
				}
				gMap.put(strX + strY, DEFAULT_CHAR);
				vis.put(strX + strY, hidden.ISHIDDEN);
			}
		}
	}
	
	public String mapToString() {
		StringBuilder str = new StringBuilder();
		str.append("<html>");
		for(int y = 0; y < 33; y++) {
			for(int x = 0; x < 64; x++) {
				String strY = "" + y;
				String strX = "" + x;
				
				if(strY.length() < 2) {
					strY = "0" + strY;
				}
				if(strX.length() < 2) {
					strX = "0" + strX;
				}
				if(vis.get(strX + strY) == hidden.ISSEEN) {
					str.append(gMap.get(strX + strY) + " ");
				}
				else {
					str.append(DEFAULT_CHAR + " ");
				}
			}
			str.append("<br>");
		}
		str.append("</html>");
		return str.toString();
	}
	
	public void spawnPlayer() {
		gMap.put(playerCoords, "P");
		vis.put(playerCoords, hidden.ISSEEN);
		vis.put("" + (Integer.parseInt(playerCoords) - 1), hidden.ISSEEN);
		vis.put("" + (Integer.parseInt(playerCoords) + 100), hidden.ISSEEN);
		vis.put("" + (Integer.parseInt(playerCoords) - 100), hidden.ISSEEN);
	}
	
	public void inv(Player p) {
		StringBuilder str = new StringBuilder();
		str.append("<html>");
		
		int x = (p.inventory.size() / 10) + 1;
		for(int i = 0; i <= x; i++) {
			for(int f =0; f < 10; f++) {
				try {
					str.append(p.inventory.get(f).name + ", ");
				}
				catch(Exception e) {
					break;
				}
			}
			str.append("<br>");
		}
		str.append("</html>");
		Message = str.toString();
		Culminating_Main.inventory();
		
		
	}
	
	public void use(Player p) {
		switch(current_Building) {
		case "T": tower(p); break;
		case "F": forge(p); break;
		case "*": chest(p); break;
		case "C": church(p); break;
		case "E": enemy(p, 2); break;
		default: Message = "";
		}
	}
	
	public void mv_Up() {
		if(!(playerCoords.substring(2,4).equals("00"))){
			gMap.put(playerCoords, current_Building);
			playerCoords = yInc(playerCoords, -1);
			current_Building = gMap.get(playerCoords);
			gMap.put(playerCoords, "P");
			
			String Up = yInc(playerCoords, -1);
			String leftSide = xInc(playerCoords, -1);
			String rightSide = xInc(playerCoords, 1);
			
			vis.put(playerCoords, hidden.ISSEEN);
			vis.put(Up, hidden.ISSEEN);
			vis.put(leftSide, hidden.ISSEEN);
			vis.put(rightSide, hidden.ISSEEN);
		}
	}
	
	public void mv_Down() {
		if(!(playerCoords.substring(2,4).equals("32"))){
			gMap.put(playerCoords, current_Building);
			playerCoords = yInc(playerCoords, 1);
			current_Building = gMap.get(playerCoords);
			gMap.put(playerCoords, "P");
			
			String Down = yInc(playerCoords, 1);
			String leftSide = xInc(playerCoords, -1);
			String rightSide = xInc(playerCoords, 1);
			
			vis.put(playerCoords, hidden.ISSEEN);
			vis.put(Down, hidden.ISSEEN);
			vis.put(leftSide, hidden.ISSEEN);
			vis.put(rightSide, hidden.ISSEEN);
		}
	}
	
	public void mv_Left() {
		if(!(playerCoords.substring(0,2).equals("00"))){
			gMap.put(playerCoords, current_Building);
			playerCoords = xInc(playerCoords, -1);
			current_Building = gMap.get(playerCoords);
			gMap.put(playerCoords, "P");
			
			String Up = yInc(playerCoords, -1);
			String leftSide = xInc(playerCoords, -1);
			String Down = yInc(playerCoords, 1);
			
			vis.put(playerCoords, hidden.ISSEEN);
			vis.put(Up, hidden.ISSEEN);
			vis.put(leftSide, hidden.ISSEEN);
			vis.put(Down, hidden.ISSEEN);
		}
	}
	
	public void mv_Right() {
		if(!(playerCoords.substring(0,2).equals("63"))){
			gMap.put(playerCoords, current_Building);
			playerCoords = xInc(playerCoords, 1);
			current_Building = gMap.get(playerCoords);
			gMap.put(playerCoords, "P");
			
			String Up = yInc(playerCoords, -1);
			String Down = yInc(playerCoords, 1);
			String rightSide = xInc(playerCoords, 1);
			
			vis.put(playerCoords, hidden.ISSEEN);
			vis.put(Up, hidden.ISSEEN);
			vis.put(Down, hidden.ISSEEN);
			vis.put(rightSide, hidden.ISSEEN);
		}
	}
	
	public String xInc(String coords, int inc) {
		String x = coords.substring(0,2);
		x = "" + (Integer.parseInt(x) + inc);
		if(x.length() < 2) {
			x = "0" + x;
		}
		String output = x + coords.substring(2,4);
		return output;
	}
	
	public String yInc(String coords, int inc) {
		String y = coords.substring(2,4);
		y = "" + (Integer.parseInt(y) + inc);
		if(y.length() < 2) {
			y = "0" + y;
		}
		String output = coords.substring(0,2) + y;
		return output;
	}
	
	public void sel_up() {
		switch(current_sel) {
		case SLASH: current_sel = sels.STAB; break;
		case TAUNT: current_sel = sels.THROW; break;
		default:;
		}
	}
	
	public void sel_down() {
		switch(current_sel) {
		case STAB: current_sel = sels.SLASH; break;
		case THROW : current_sel = sels.TAUNT; break;
		default:;
		}
	}
	
	public void sel_right() {
		switch(current_sel) {
		case STAB: current_sel = sels.THROW; break;
		case SLASH: current_sel = sels.TAUNT; break;
		default:;
		}
	}
	
	public void sel_left() {
		switch(current_sel) {
		case THROW: current_sel = sels.STAB; break;
		case TAUNT: current_sel = sels.SLASH; break;
		default:;
		}
	}
	
	public String selToString() {
		String output = null;
		switch(current_sel) {
		case STAB: output = Display_Assets.StabSel; break;
		case SLASH: output = Display_Assets.SlashSel; break;
		case THROW: output = Display_Assets.ThrowSel; break;
		case TAUNT: output = Display_Assets.TauntSel; break;
		}
		return output;
	}
	
	//Buildings :)
	
	public void forge(Player p) {
		for(int i = 0; i < 3; i++) {
			if(Culminating_Main.Swords[i] == p.current_weapon) {
				try {
					p.current_weapon = Culminating_Main.Swords[i + 1];
					break;
				}catch(Exception e) {break;}
			}
			if(Culminating_Main.Axes[i] == p.current_weapon) {
				try {
					p.current_weapon = Culminating_Main.Axes[i + 1];
					break;
				}catch(Exception e) {break;}
			}
			if(Culminating_Main.Spears[i] == p.current_weapon) {
				try {
					p.current_weapon = Culminating_Main.Spears[i + 1];
					break;
				}catch(Exception e) {break;}
			}
		}
		//p.current_weapon = .indexOf(current_weapon)
		Message = "<html>You entered a forge a empty cold metal forge, you decide to make use of it. <br>"
				+ "You upgraded your Weapon! it is now: " + p.current_weapon.name;
		Culminating_Main.updateBotttomTxt();
		current_Building = DEFAULT_CHAR;
	}
	
	public void chest(Player p) {
		chest(p, 0);
	}
	
	public void chest(Player p, int tier) {
		Random r = new Random();
		Weapon w = null;
		int upper = tier + 3;
		switch(r.nextInt(3)) {
		case 0: w = Culminating_Main.Swords[r.nextInt(upper)]; break;
		case 1: w = Culminating_Main.Axes[r.nextInt(upper)]; break;
		case 2: w = Culminating_Main.Spears[r.nextInt(upper)]; break;
		}
		p.inventory.add(w);
		Message = "<html>You find a Chest lying in the wasteland, curious, you open it.<br>"
				+ "You found a " + w.name +"!<br>"
				+ "It has been added to your Inventory";
		Culminating_Main.updateBotttomTxt();
		current_Building = DEFAULT_CHAR;
	}
	
	public void church(Player p) {
		Message = "You found a church!, hp restored!";
		p.hp = p.max_hp;
		current_Building = DEFAULT_CHAR;
		Culminating_Main.updateBotttomTxt();
	}
	
	public void enemy(Player p, int maxTier) {
		int tier = new Random().nextInt(maxTier);
		Enemy monster = Culminating_Main.Enemies[tier][new Random().nextInt(3)];
		
		p.current_monster = monster;
		Message = "Monster Name: " + monster.name + " 		Monster Hp:" + monster.hp;
		Culminating_Main.inMap = false;
		Culminating_Main.inBattle = true;
	}
	
	public void tower(Player p) {
		Culminating_Main.inBattle = true;
		Culminating_Main.inMap = false;
		
		towerLineUp.add(Culminating_Main.Enemies[0][new Random().nextInt(3)]);
		towerLineUp.add(Culminating_Main.Enemies[1][new Random().nextInt(3)]);
		towerLineUp.add(Culminating_Main.Enemies[2][new Random().nextInt(3)]);
		
		attack(p);
	}
	
	public String topTextToString() {
		String output = "<html>" + Message + "\n" + selToString() + "</html>";
		return output;
	}
	
	public void attack(Player p) {
		if(towerLineUp.size() > 0) {
			p.current_monster = towerLineUp.get(0);
		}
		int plyr_DMG = Weapon.spin_DMG(p.current_weapon, current_sel);
		Enemy.dmgTaken(plyr_DMG, p.current_monster, Weapon.selToATk(current_sel));
		Message = "Monster Name: " + p.current_monster.name + " 		Monster Hp:" + p.current_monster.hp;
		if(p.current_monster.hp <= 0) {
			Message = "You beat " + p.current_monster.name + "! ";
			if(towerLineUp.size() > 0) {
				towerLineUp.remove(0);
				if(towerLineUp.size() == 0) {
					chest(p, 2);
				}
				else {
					attack(p);	
				}
			}
			else {
				Culminating_Main.inBattle = false;
				Culminating_Main.inMap = true;
				current_Building = DEFAULT_CHAR;
			}
			
		}
		else {
			if(current_sel == sels.THROW) {
				if(new Random().nextInt(2) == 1) {
					try {
						System.out.println("This printed");
						Message = Message + "<br> You lost your weapon";
						p.current_weapon = p.inventory.get(0);
					}
					catch(Exception e) {
						Message = Message + "<br> You lost your weapon";
						p.current_weapon = Culminating_Main.Weapons[3][0];
					}
				}
			}
				
				
			int monster_DMG = p.current_monster.rollDMG(p.current_monster);
			p.hp -= monster_DMG;
			if(p.hp <= 0) {
				Message = "You died to: " + p.current_monster.name + "! They did: " +monster_DMG+ " to you <br> GAME OVER!";
				Culminating_Main.alive = false;
				
			}
			else{
				Message = "Monster Name: " + p.current_monster.name + "|  Monster Hp:" + p.current_monster.hp
						+ "|<br> The " + p.current_monster.name + " dealt " + monster_DMG + " to you." ;
			}
			
			Culminating_Main.updateBotttomTxt();
		}
			
	}
	
	

	
	
}
	
