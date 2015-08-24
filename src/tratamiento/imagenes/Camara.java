package tratamiento.imagenes;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;


public class Camara {
	
	private static VideoCapture camera;

	private Camara(){
		camera = new VideoCapture(0);			
		
	}
	public static void iniciarCamara(){
		if(camera == null){
			new Camara();
		}
	}
	
	public static Mat getSnapshot(){
		iniciarCamara();
		
		Mat frame = null;
		
		if (!camera.isOpened()) {
			System.out.println("Error");
		} else {
			frame = new Mat();
			while (true) {
				if (camera.read(frame)) {
					System.out.println("Frame Obtained");
					System.out.println("Captured Frame Width " + frame.width()
							+ " Height " + frame.height());
					break;
				}
			}
			
		}
		return frame;
	}
	
	public static void guardarSnapshot(String nombre){
		Highgui.imwrite(nombre, getSnapshot());
	}
}
