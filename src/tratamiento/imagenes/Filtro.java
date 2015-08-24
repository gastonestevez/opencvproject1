package tratamiento.imagenes;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;


public class Filtro {
	
	public Mat threshhold(Mat frame){
		Mat nFrame = frame;
		Imgproc.threshold(frame, nFrame,127,255, Imgproc.THRESH_BINARY);
		return nFrame;
	}
	
	public Mat detectorDeRostros(Mat frame){
		
		CascadeClassifier faceDetector = new CascadeClassifier(
				getClass().getResource("/xml/lbpcascade_frontalface.xml")
						.getPath());
		Mat cuadroDeteccion = frame;
		//Imgproc.threshold(cuadroDeteccion, cuadroDeteccion,127,255, Imgproc.THRESH_BINARY_INV);
		
		MatOfRect faceDetections = new MatOfRect();
		faceDetector.detectMultiScale(cuadroDeteccion, faceDetections);
		
		for(Rect rect: faceDetections.toArray()){
			Core.rectangle(	cuadroDeteccion, 
							new Point(rect.x,rect.y), 
							new Point(rect.x+rect.width,rect.y+rect.height),
							new Scalar(0,255,0)	);
		}
		
		return cuadroDeteccion;
	}
	
	public Mat escalaDeGrises(Mat frame){
		Mat nFrame = frame;
		Imgproc.cvtColor(nFrame, nFrame, Imgproc.COLOR_RGB2GRAY);
		return nFrame;
	}

}
