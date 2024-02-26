package grade_eleven_culminating;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Culminating_Main {
	
	public static void randBuildingGen(Game_Map gm) {
		Random r = new Random();
		for(int i = 0; i < 200; i++) {
			
			String ch = Game_Map.buildings[r.nextInt(5)];
			int x = r.nextInt(0,64);
			int y = r.nextInt(0,32);
			
			String strX = new String("" + x).length() < 2 ? "0" + x : "" + x;
			String strY = new String("" + y).length() < 2 ? "0" + y : "" + y;
			
			gm.gMap.put(strX + strY, ch);
		}
	}
	
	public static Weapon[][] Weapons = Weapon_File_Generator.main();
	public static Weapon[] Swords = Weapons[0];
	public static Weapon[] Axes = Weapons[1];
	public static Weapon[] Spears = Weapons[2];
	
	public static Enemy[][] Enemies = Enemy_Generator.main();
	public static Enemy[] Tier1 = Enemies[0];
	public static Enemy[] Tier2 = Enemies[1];
	public static Enemy[] Tier3 = Enemies[2];
	
	static JFrame gameWindow;
	static JLabel bottomText = new JLabel("");
	static Player p;
	static Game_Map gm = new Game_Map();
	static JLabel topText = new JLabel(gm.mapToString(),SwingConstants.CENTER);
	static JPanel topP = new JPanel();
	
	public static boolean inMap = true;
	public static boolean inBattle = false;
	public static boolean alive = true;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gameWindow = new JFrame();
	    
	    //JPanel midP = new JPanel();
	    JPanel btmP = new JPanel();
	    
	    randBuildingGen(gm);
	    gm.spawnPlayer();
	    
	    
	    JButton btmBtn = new JButton("Enter");
	    JTextField btmTxt = new JTextField("Your Name Here ");
	    
	    
	    topP.add(topText);
	    
	    btmP.add(btmTxt);
	    btmP.add(btmBtn);
	    btmBtn.addActionListener(e -> EnterPressed(btmP,btmTxt,btmBtn, bottomText));
	    
	    
	    gameWindow.add(topP);
	    gameWindow.add(btmP);
	    
	    gameWindow.setLayout(new BoxLayout(gameWindow.getContentPane(),BoxLayout.Y_AXIS));
	    
	    
	    
	    
	    topText.setSize(200, 200);
	    
	    gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    btmP.addKeyListener(new KeyListener() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	        	if(alive) {
	        		if(inMap) {
		            	topText.setText(gm.mapToString());
		            	boolean flag = false;
		            	switch(e.getKeyCode()) {
			            case KeyEvent.VK_W: gm.mv_Up(); break;
			            case KeyEvent.VK_S: gm.mv_Down(); break;
			            case KeyEvent.VK_A: gm.mv_Left(); break;
			            case KeyEvent.VK_D: gm.mv_Right(); break;
			            case KeyEvent.VK_E: gm.use(p); flag = true; break;
			            case KeyEvent.VK_I: gm.inv(p); flag = true; break;
			            default:;
			            }
		            	if(flag) {
		            		topText.setText(gm.topTextToString());
		            	}
		            	else {
		            		topText.setText(gm.mapToString());
		            	}
		            }
		           else if(inBattle){
		        	   	topText.setText(gm.topTextToString());
		            	switch(e.getKeyCode()) {
			            case KeyEvent.VK_W: gm.sel_up(); break;
			            case KeyEvent.VK_D: gm.sel_right(); break;
			            case KeyEvent.VK_A: gm.sel_left(); break;
			            case KeyEvent.VK_S: gm.sel_down(); break;
			            case KeyEvent.VK_E: gm.attack(p); break;
			            }
		            	topText.setText(gm.topTextToString());
			         }
	        	}
	            
	        }
	        @Override
	        public void keyTyped(KeyEvent e) {
	        }
	        @Override
	        public void keyReleased(KeyEvent e) {
	        }
	    });
	    btmP.setFocusable(true);
	    btmP.requestFocusInWindow();
	    
	    gameWindow.setSize(600,650);
	    gameWindow.setLocation(200, 20);
	    gameWindow.setVisible(true);
		
		
	}
	private static void EnterPressed(JPanel jp,JTextField jt,JButton jb, JLabel jl) {
		p = new Player(jt.getText());
		jp.remove(jb);
		jp.remove(jt);
		jp.add(jl);
	    jl.setText(plyrInfo());
	}
	
	public static void updateBotttomTxt() {
		bottomText.setText(plyrInfo());
	}
	
	public static void death() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gameWindow.setVisible(false);
	}
	
	public static String plyrInfo() {
		String output = "<html>Player Name: " + p.name + "|   Current Weapon: " + p.current_weapon.name +"|<br>"
				+ "  Hp: "+ p.hp + "</html>";
		return output;
	}
	
	static JTextField jt = new JTextField("Enter your Weapon:");
	static JButton enter = new JButton("Enter");
	
	
	public static void inventory() {
		topText.setText(gm.topTextToString());
		
		topP.add(jt);
		topP.add(enter);
		
		enter.addActionListener(e -> setWeapon(jt.getText()));
		
	}
	public static void setWeapon(String text) {
			for(int i = 0; i < p.inventory.size(); i++) {
				if(p.inventory.get(i).name.equals(text)) {
					p.current_weapon = p.inventory.get(i);
					updateBotttomTxt();
					break;
				}
			}
			topP.remove(jt);
			topP.remove(enter);
			topText.setText(gm.mapToString());
	}
}
