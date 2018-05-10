package game;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class PasswordMenu extends Scenario {
	
	public PasswordMenu(Window gameWindow, String name) {
		
		window = gameWindow;
		scenarioName = name;
		background = new GameImage("src//recursos//sprite//password//password_background.png");
		GameObject selector = new GameObject(150, 300, "src//recursos//sprite//password//select.png", 1, GameObjectType.OTHER);
		this.initializeKeyboard();
		this.initializeObjects();
	}
	
	protected void updateScenario() {
		
		while(nextScenario == null) {
		
			drawObjects();			
			window.update();
		
		
		}
		
	}

	protected void initializeKeyboard() {
		
		if(window != null) {
			sceneKeyboard = window.getKeyboard();
		} else {
			System.out.println("The keyboard needs a window to run. The window cannot be null");
		}
		sceneKeyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY); 
		sceneKeyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY); 
		sceneKeyboard.setBehavior(Keyboard.ENTER_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
	
	}
	
	
	public String runScenario() {
		
		updateScenario();
		System.out.println(nextScenario);
		return nextScenario;
		
	}
	
	private void initializeObjects(){
		
		GameObject letter_a = new GameObject(150, 300, "src//recursos//sprite//password//a.png", 1, GameObjectType.OTHER);
		GameObject letter_b = new GameObject(186, 300, "src//recursos//sprite//password//b.png", 1, GameObjectType.OTHER);
		GameObject letter_c = new GameObject(222, 300, "src//recursos//sprite//password//c.png", 1, GameObjectType.OTHER);
		GameObject letter_d = new GameObject(258, 300, "src//recursos//sprite//password//d.png", 1, GameObjectType.OTHER);
		GameObject letter_e = new GameObject(294, 300, "src//recursos//sprite//password//e.png", 1, GameObjectType.OTHER);
		GameObject letter_f = new GameObject(330, 300, "src//recursos//sprite//password//f.png", 1, GameObjectType.OTHER);
		GameObject letter_g = new GameObject(366, 300, "src//recursos//sprite//password//g.png", 1, GameObjectType.OTHER);
		GameObject letter_h = new GameObject(402, 300, "src//recursos//sprite//password//h.png", 1, GameObjectType.OTHER);
		GameObject letter_i = new GameObject(438, 300, "src//recursos//sprite//password//i.png", 1, GameObjectType.OTHER);
		GameObject letter_j = new GameObject(474, 300, "src//recursos//sprite//password//j.png", 1, GameObjectType.OTHER);
		GameObject letter_k = new GameObject(510, 300, "src//recursos//sprite//password//k.png", 1, GameObjectType.OTHER);
		GameObject letter_l = new GameObject(546, 300, "src//recursos//sprite//password//l.png", 1, GameObjectType.OTHER);
		GameObject letter_m = new GameObject(582, 300, "src//recursos//sprite//password//m.png", 1, GameObjectType.OTHER);
		GameObject letter_n = new GameObject(150, 340, "src//recursos//sprite//password//n.png", 1, GameObjectType.OTHER);
		GameObject letter_o = new GameObject(186, 340, "src//recursos//sprite//password//o.png", 1, GameObjectType.OTHER);
		GameObject letter_p = new GameObject(222, 340, "src//recursos//sprite//password//p.png", 1, GameObjectType.OTHER);
		GameObject letter_q = new GameObject(258, 340, "src//recursos//sprite//password//q.png", 1, GameObjectType.OTHER);
		GameObject letter_r = new GameObject(294, 340, "src//recursos//sprite//password//r.png", 1, GameObjectType.OTHER);
		GameObject letter_s = new GameObject(330, 340, "src//recursos//sprite//password//s.png", 1, GameObjectType.OTHER);
		GameObject letter_t = new GameObject(366, 340, "src//recursos//sprite//password//t.png", 1, GameObjectType.OTHER);
		GameObject letter_u = new GameObject(402, 340, "src//recursos//sprite//password//u.png", 1, GameObjectType.OTHER);
		GameObject letter_v = new GameObject(438, 340, "src//recursos//sprite//password//v.png", 1, GameObjectType.OTHER);
		GameObject letter_w = new GameObject(474, 340, "src//recursos//sprite//password//w.png", 1, GameObjectType.OTHER);
		GameObject letter_x = new GameObject(510, 340, "src//recursos//sprite//password//x.png", 1, GameObjectType.OTHER);
		GameObject letter_y = new GameObject(546, 340, "src//recursos//sprite//password//y.png", 1, GameObjectType.OTHER);
		GameObject letter_z = new GameObject(582, 340, "src//recursos//sprite//password//z.png", 1, GameObjectType.OTHER);
		
		this.addSceneObjects(letter_a);
		this.addSceneObjects(letter_b);
		this.addSceneObjects(letter_c);
		this.addSceneObjects(letter_d);
		this.addSceneObjects(letter_e);
		this.addSceneObjects(letter_f);
		this.addSceneObjects(letter_g);
		this.addSceneObjects(letter_h);
		this.addSceneObjects(letter_i);
		this.addSceneObjects(letter_j);
		this.addSceneObjects(letter_k);
		this.addSceneObjects(letter_l);
		this.addSceneObjects(letter_m);
		this.addSceneObjects(letter_n);
		this.addSceneObjects(letter_o);
		this.addSceneObjects(letter_p);
		this.addSceneObjects(letter_q);
		this.addSceneObjects(letter_r);
		this.addSceneObjects(letter_s);
		this.addSceneObjects(letter_t);
		this.addSceneObjects(letter_u);
		this.addSceneObjects(letter_v);
		this.addSceneObjects(letter_w);
		this.addSceneObjects(letter_x);
		this.addSceneObjects(letter_y);
		this.addSceneObjects(letter_z);
		
	}
	
}
