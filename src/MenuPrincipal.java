import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.JFrame;

import org.opencv.core.Mat;

public class MenuPrincipal extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private MyPanel panelOriginal;
	private PanelFiltrado panelFiltrado;
	private PanelBotonera panelBotonera;
	private Handler handler;
	
	public MenuPrincipal(Handler handler){
		setHandler(handler);
		setLayout(new GridLayout(1,3));
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setPanelOriginal(new MyPanel(getHandler()));
		setPanelFiltrado(new PanelFiltrado(getHandler()));
		setPanelBotonera(new PanelBotonera(getHandler()));
		
		getContentPane().add(panelOriginal);
		getContentPane().add(panelFiltrado);
		getContentPane().add(panelBotonera);
		
		setVisible(true);
	}
	

	public void repaintAll(){
		panelOriginal.repaint();
		panelFiltrado.repaint();
		pack();
	}
	
	


	public MyPanel getPanel() {
		return panelOriginal;
	}

	public PanelBotonera getPanelBotonera() {
		return panelBotonera;
	}

	public void setPanelBotonera(PanelBotonera panelBotonera) {
		this.panelBotonera = panelBotonera;
	}

	public PanelFiltrado getPanelFiltrado() {
		return panelFiltrado;
	}

	public void setPanelFiltrado(PanelFiltrado panelFiltrado) {
		this.panelFiltrado = panelFiltrado;
	}

	private void setPanelOriginal(MyPanel myPanel) {
		this.panelOriginal = myPanel;
	}


	public Handler getHandler() {
		return handler;
	}


	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
