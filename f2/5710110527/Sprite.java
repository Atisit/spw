import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpaceShip extends Sprite{

	int step = 8;
	
	BufferedImage player;

	public SpaceShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		try{
			player = ImageIO.read(new File("../5710110527/image/pilot.png"));
		}
		catch(IOException d){
			System.out.println("can't bufferimage");
		}
		
	}

	@Override
	public void draw(Graphics2D g) {

		g.drawImage(player,x,y,width,height,null);
		
	}

	public void move(int direction){
		x += (step * direction);
		if(x < 0)
			x = 0;
		if(x > 400 - width)
			x = 400 - width;
	}

}
