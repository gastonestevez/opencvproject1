package bo;

import java.awt.Image;

import org.opencv.core.Mat;

import dao.ImagenDao;

public class ImagenBO {

	private ImagenDao imagenManager;
	
	public ImagenBO(){
		setImagenManager(new ImagenDao());
	}
	
	public void actualizarImagenFiltrada(){
		
	}

	public void setMatOriginal(Mat snapshot) {
		getImagenManager().setImagenOriginal(snapshot);
	}
	
	public Mat getMatOriginal(){
		return getImagenManager().getImagenOriginal();
	}
	
	public void setMatFiltrada(Mat snapshot){
		getImagenManager().setImagenFiltrada(snapshot);
	}
	
	public Mat getMatFiltrada(){
		return getImagenManager().getImagenFiltrada();
	}
	
	public ImagenDao getImagenManager() {
		return imagenManager;
	}
	
	public void setImagenManager(ImagenDao imagenManager) {
		this.imagenManager = imagenManager;
	}

	public Image transformarMat(Mat matFiltrada) {
		return getImagenManager().toBufferedImage(matFiltrada);
	}
	
	
}
