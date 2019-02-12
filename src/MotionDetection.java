/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import org.opencv.core.MatOfRect;
import org.opencv.core.Core;
import org.opencv.core.Mat;

import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.videoio.VideoCapture;//for opencv 2,change to import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.core.Point;
public class MotionDetection {
    
    
        static int SENSITIVITY_VALUE = 60;//threshold value of frame
	static int BLUR_SIZE = 10;
	static int WIDTH = 500;          //height and width of windows
	static int HEIGHT = 700;
	static OpenCVWindow drawnWindow;    //window for displying each frame
        

	public static void main(String[] args)
	{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME); //loadind dll file
		CascadeClassifier cascadeClassifier = new CascadeClassifier("C:\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_default.xml");
		
		drawnWindow = new OpenCVWindow(WIDTH,HEIGHT);
		 

                MatOfRect rect = new MatOfRect();
                Scalar renk = new Scalar(0, 255, 0);
	
		while (true)
		{
			VideoCapture camera = new VideoCapture();// capturig each frame
			
                        camera.open(0);
			
				
				Mat currentFrame = new Mat();// first frame and current frame for accomodating each frame
				
				boolean frameSuccess;///to check weather frame is read or not

				
				
				
				while (true)
				{

					frameSuccess = camera.read(currentFrame);
					if (frameSuccess == true)
					{
						Imgproc.resize(currentFrame, currentFrame, new Size(WIDTH,HEIGHT));//resize to window dimension
						cascadeClassifier.detectMultiScale(currentFrame, rect);
                                                for(Rect dik : rect.toArray()){
                                                    Imgproc.line(currentFrame,new Point(50,0),new Point(50,800),new Scalar(0,0,255),2);
                                                    if(dik.area()>50000)
                                                    Imgproc.rectangle(currentFrame, new Point(dik.x, dik.y), new Point(dik.x+ dik.width, dik.y+dik.height), renk);
                                                    
                                                   }
                                                
                                              
                                                drawnWindow.showImage(currentFrame);//show each frame(switch to opencvwindow class)
					
					}else
						break;
					
					
					
				}
				camera.release();
		

		}
	}
}
	
	
		
               
        