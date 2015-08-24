package bo;

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
	
	
	public ImagenDao getImagenManager() {
		return imagenManager;
	}
	public void setImagenManager(ImagenDao imagenManager) {
		this.imagenManager = imagenManager;
	}
	
	
}
