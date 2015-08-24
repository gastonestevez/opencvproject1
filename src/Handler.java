import org.opencv.core.Core;
import org.opencv.core.Mat;

import bo.ImagenBO;
import tratamiento.imagenes.Camara;


public class Handler {
	
	private MenuPrincipal menu;
	private ImagenBO bo;
	
	public Handler(){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		bo = new ImagenBO();
		setMenu(new MenuPrincipal(this));
		setImagenOriginal(Camara.getSnapshot());
	}
	
	
	private void setImagenOriginal(Mat snapshot) {
		ImagenBO.setMatOriginal(snapshot);
	}


	public void init(){
		getMenu().setVisible(true);
	}

	public MenuPrincipal getMenu() {
		return menu;
	}

	public void setMenu(MenuPrincipal menu) {
		this.menu = menu;
	}
	
}
