import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.opencv.core.Mat;

import tratamiento.imagenes.Camara;
import tratamiento.imagenes.Filtro;


public class PanelBotonera extends JPanel{

	private static final long serialVersionUID = 1L;
	private JButton botonEscalaGrises;
	private JButton botonDeteccionDeRostros;
	private JButton botonNuevaCaptura;
	private JButton botonStartTimer;
	private Handler handler;
	
	public PanelBotonera(Handler h){
		setHandler(h);
		setLayout(new GridLayout(3,1));
		setBotonDeteccionDeRostros(new JButton("Detectar Rostro"));
		setBotonEscalaGrises(new JButton("Escala de Grises"));
		setBotonNuevaCaptura(new JButton("Nueva Captura"));
		setBotonStartTimer(new JButton("Start Cap!"));
		add(getBotonStartTimer());
		add(getBotonNuevaCaptura());
		add(getBotonDeteccionDeRostros());
		add(getBotonEscalaGrises());
		acciones();
		setVisible(true);
	}

	private void acciones() {
		
		getBotonStartTimer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getHandler().startTimer();
			}
		});

		getBotonDeteccionDeRostros().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getHandler().filtrarDeteccionDeRostros();
			}
		});
		
		getBotonEscalaGrises().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getHandler().filtrarEscalaDeGrises();
			}
		});
		
		getBotonNuevaCaptura().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getHandler().capturaNuevaImagen();
			}
		});
		
	
	}

	public JButton getBotonEscalaGrises() {
		return botonEscalaGrises;
	}

	public void setBotonEscalaGrises(JButton botonEscalaGrises) {
		this.botonEscalaGrises = botonEscalaGrises;
	}

	public JButton getBotonDeteccionDeRostros() {
		return botonDeteccionDeRostros;
	}

	public void setBotonDeteccionDeRostros(JButton botonDeteccionDeRostros) {
		this.botonDeteccionDeRostros = botonDeteccionDeRostros;
	}

	public JButton getBotonNuevaCaptura() {
		return botonNuevaCaptura;
	}

	public void setBotonNuevaCaptura(JButton botonNuevaCaptura) {
		this.botonNuevaCaptura = botonNuevaCaptura;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public JButton getBotonStartTimer() {
		return botonStartTimer;
	}

	public void setBotonStartTimer(JButton botonStartTimer) {
		this.botonStartTimer = botonStartTimer;
	}
	
	
	

}
