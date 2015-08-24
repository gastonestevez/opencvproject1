import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class Prueba {

	public void run() {

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		VideoCapture camera = new VideoCapture(0);

		if (!camera.isOpened()) {
			System.out.println("Error");
		} else {
			Mat frame = new Mat();
			while (true) {
				if (camera.read(frame)) {
					System.out.println("Frame Obtained");
					System.out.println("Captured Frame Width " + frame.width()
							+ " Height " + frame.height());

					CascadeClassifier faceDetector = new CascadeClassifier(
							getClass().getResource("/lbpcascade_frontalface.xml")
									.getPath());
					
					Mat cuadroDeteccion = frame;
					Imgproc.threshold(cuadroDeteccion, cuadroDeteccion,127,255, Imgproc.THRESH_BINARY);
					
					MatOfRect faceDetections = new MatOfRect();
					faceDetector.detectMultiScale(cuadroDeteccion, faceDetections);
					
					for(Rect rect: faceDetections.toArray()){
						Core.rectangle(	cuadroDeteccion, 
										new Point(rect.x,rect.y), 
										new Point(rect.x+rect.width,rect.y+rect.height),
										new Scalar(0,255,0)	);
					}
					
					Highgui.imwrite("camera.jpg", frame);
					System.out.println("OK");
					Highgui.imwrite("transformada.jpg", cuadroDeteccion);
					break;
				}
			}
		}
		camera.release();
	}

	
}
