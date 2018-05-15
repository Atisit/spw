import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Iterator;

public class GameEngine implements KeyListener, GameReporter{
		GamePanel gp;

		private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		private SpaceShip v;	
		private SpaceShip2 v2;	
		private Timer timer;
		private int count=0;
		private long score = 0;
		private double difficulty = 0.1;

		public GameEngine(GamePanel gp, SpaceShip v, SpaceShip2 v2) {
			this.gp = gp;
			this.v = v;		
			this.v2 = v2;	
			gp.sprites.add(v);
			gp.sprites.add(v2);
			timer = new Timer(100, new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent arg0) {
					process();
				}
				

			});
			timer.setRepeats(true);

		}

		public void start(){
			timer.start();
		}

		private void generateEnemy(){
			Enemy e = new Enemy((int)(Math.random()*300), 30);
			gp.sprites.add(e);
			enemies.add(e);
		}

		private void process(){
			count = count + 1;
			if(count % 2 == 0){
				difficulty = difficulty + 0.005;
			}
			if((Math.random()* 5) < difficulty){
				generateEnemy();
			}

			Iterator<Enemy> e_iter = enemies.iterator();
			while(e_iter.hasNext()){
				Enemy e = e_iter.next();
				e.proceed();
			
				if(!e.isAlive()){
					e_iter.remove();
					gp.sprites.remove(e);
					score += 100;
				}
			}
		
			gp.updateGameUI(this);

			Rectangle2D.Double vr = v.getRectangle();
			Rectangle2D.Double vr2 = v2.getRectangle();
			Rectangle2D.Double er;
			for(Enemy e : enemies){
				er = e.getRectangle();
				if(er.intersects(vr)){
					die();
					return;
				}
				else if(er.intersects(vr2)){
					die();
					return;
				}
			}

		}

	public void die(){
		timer.stop();
	}

	void controlVehicle(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				v.move(-1);
				break;
			case KeyEvent.VK_RIGHT:
				v.move(1);
				break;
			case KeyEvent.VK_Z:
				v2.move(-1);
				break;
			case KeyEvent.VK_X:
				v2.move(1);
				break;				
			
		}
	}
	
	public long getScore(){
		return score;
	}
	public int getCount(){
		return count;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		controlVehicle(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//do nothing
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//do nothing		
	}
	
}