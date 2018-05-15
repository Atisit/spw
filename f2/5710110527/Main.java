import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args){
		JFrame frame = new JFrame("Space War");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 650);
		frame.getContentPane().setLayout(new BorderLayout());
		
		SpaceShip v = new SpaceShip(180, 490, 50, 50);
		SpaceShip2 v2 = new SpaceShip2(180, 490, 50, 50);
		GamePanel gp = new GamePanel();
		GameEngine engine = new GameEngine(gp, v, v2);
		frame.addKeyListener(engine);
		frame.getContentPane().add(gp, BorderLayout.CENTER);
		frame.setVisible(true);

		engine.start();
	}
}
