import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import org.opencv.core.Mat;


public class MyPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private Image img;
	private Handler handler;

	private Mat matImage;
	
	public MyPanel(Handler h){
		setHandler(h);
	}
	
	public void setImage(Image img){
		this.img = img;
		
		Dimension size = new Dimension(img.getWidth(null),img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
		
	}
	
	public Image getImage(){
		return this.img;
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, null);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void setMatImage(Mat image) {
		this.matImage = image;
	}
	
	public Mat getMatImage(){
		return this.matImage;
	}
	
	

}
