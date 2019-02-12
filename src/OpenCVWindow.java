/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Dimension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import javax.swing.JFrame;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;

import org.opencv.imgcodecs.Imgcodecs;
public class OpenCVWindow extends JFrame {
    
    
    
    Sheet sheet;
	int height, width;


	public OpenCVWindow( int length, int breadth)
	{
		width = length;
		height = breadth;
		sheet = new Sheet(breadth,length);
		
		this.setSize(new Dimension(length, breadth));
		this.add(sheet);

		this.setFocusable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setBounds(500,0, width, height);
	}
	


	public void showImage(Mat m)
	{
		MatOfByte matOfByte = new MatOfByte();
		Imgcodecs.imencode(".jpg", m, matOfByte);//encode each frame to .jpg format
		
		byte[] byteArray = matOfByte.toArray();//declare an array to store pixel values
		try
		{

			InputStream in = new ByteArrayInputStream(byteArray);//encoded image is converted to array(pixel values)
			sheet.paintSheet(ImageIO.read(in));//switch to sheet class
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
    
    
    
}
