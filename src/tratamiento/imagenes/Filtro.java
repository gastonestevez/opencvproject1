package tratamiento.imagenes;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
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
	
	public Mat detectorDeCirculos(Mat frame){
		Mat destination = new Mat(frame.rows(), frame.cols(), frame.type());

        Imgproc.cvtColor(frame, destination, Imgproc.COLOR_RGB2GRAY);

        //Imgproc.GaussianBlur(destination, destination, new Size(3,3),0,0); 


        Mat circles = new Mat();
        Imgproc.HoughCircles(destination, circles, Imgproc.CV_HOUGH_GRADIENT, 1, 20, 10, 20, 7, 13);

        int radius;
        Point pt;
        for (int x = 0; x < circles.cols(); x++) {
	        double vCircle[] = circles.get(0,x);
	
	        if (vCircle == null)
	            break;
	
	        pt = new Point(Math.round(vCircle[0]), Math.round(vCircle[1]));
	        radius = (int)Math.round(vCircle[2]);
	
	        // draw the found circle
	        Core.circle(destination, pt, radius, new Scalar(0,255,255), 3);
	        Core.circle(destination, pt, 3, new Scalar(255,255,255), 3);
        }
        
        return destination;
	}
	
	public Mat escalaDeGrises(Mat frame){
		Mat nFrame = frame;
		Imgproc.cvtColor(nFrame, nFrame, Imgproc.COLOR_RGB2GRAY);
		return nFrame;
	}

}
