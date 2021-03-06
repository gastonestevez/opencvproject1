package dao;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import org.opencv.core.Mat;

public class ImagenDao {
	private Mat imagenOriginal;
	private Mat imagenFiltrada;
	

	
	public Image toBufferedImage(Mat m){
		int type = BufferedImage.TYPE_BYTE_GRAY;
		
		if(m.channels()>1){
			type = BufferedImage.TYPE_3BYTE_BGR;
		}
		
		// Transfer bytes from Mat to BufferedImage
	      int bufferSize = m.channels()*m.cols()*m.rows();
	      byte [] b = new byte[bufferSize];
	      m.get(0,0,b); // get all the pixels
	      BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
	      final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
	      System.arraycopy(b, 0, targetPixels, 0, b.length);
	      return image;
	}



	public Mat getImagenOriginal() {
		return imagenOriginal;
	}



	public void setImagenOriginal(Mat imagenOriginal) {
		this.imagenOriginal = imagenOriginal;
	}



	public Mat getImagenFiltrada() {
		return imagenFiltrada;
	}



	public void setImagenFiltrada(Mat imagenFiltrada) {
		this.imagenFiltrada = imagenFiltrada;
	}
	
	
}
