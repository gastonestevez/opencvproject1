import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.opencv.core.Core;
import org.opencv.core.Mat;

import bo.ImagenBO;
import tratamiento.imagenes.Camara;
import tratamiento.imagenes.Filtro;


public class Handler {
	
	private MenuPrincipal menu;
	private ImagenBO bo;
	private Filtro f;
	public Handler(){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		f = new Filtro();
		bo = new ImagenBO();
		setMenu(new MenuPrincipal(this));
		setImagenOriginal(Camara.getSnapshot());
		getMenu().getPanel().setImage(bo.transformarMat(bo.getMatOriginal()));
		getMenu().repaintAll();
		
		new ThreadFrame(this).start();
		
		
	}
	
	public Mat getImagenOriginal(){
		return bo.getMatOriginal();
	}
	
	public void setImagenOriginal(Mat snapshot) {
		bo.setMatOriginal(snapshot);
	}

	public Image transformarMat( Mat snapshot){
		return bo.transformarMat(snapshot);
	}
	
	public void setImagenFiltrada(Mat snapshot){
		bo.setMatFiltrada(snapshot);
	}
	
	public Image getImagenFiltrada(){
		return bo.transformarMat((bo.getMatFiltrada()));
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

	public void commitImagen() {
		getMenu().getPanelFiltrado().setImage(getImagenFiltrada());
		getMenu().repaintAll();
	}
	
	public void capturaNuevaImagen(){
		setImagenOriginal(Camara.getSnapshot());
		getMenu().getPanel().setImage(transformarMat(getImagenOriginal()));
		getMenu().repaintAll();
	}

	public void filtrarDeteccionDeRostros() {
		setImagenFiltrada(f.detectorDeRostros(getImagenOriginal()));
		commitImagen();
	}

	public void filtrarEscalaDeGrises() {
		setImagenFiltrada(f.escalaDeGrises(getImagenOriginal()));
		commitImagen();
	}
	
}
