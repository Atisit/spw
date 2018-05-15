import java.awt.Color;
import java.awt.Graphics2D;

public class SpaceShip extends Sprite{

	int step = 10;
	
	public SpaceShip(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}

	public void moveX(int direction){
		x += (step * direction);
		if(x < 0 )
			x = 0;
		if(x > 400 - width )
			x = 400 - width;
	}
	public void moveY(int direction1){
		y += (step * direction1);
		if(y < 320)
			y = 320;
		if(y > 600 - height)
			y = 600 - height;
	}

}