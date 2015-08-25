import java.awt.Graphics;

import tratamiento.imagenes.Camara;


public class PanelFiltrado extends MyPanel{

	private static final long serialVersionUID = 1L;
	
	public PanelFiltrado(Handler h){
		super(h);
	}
	
	@Override
	public void paintComponent(Graphics g){
		getHandler().filtrarCirculos();
		g.drawImage((getHandler().getImagenFiltrada()), 0, 0, null);
	}
	

}
