/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Graphics;


import java.awt.image.BufferedImage;

import javax.swing.JPanel;


public class Sheet extends JPanel {
  
    BufferedImage image;
	int width, height;

	public Sheet( int h, int w)
	{
		width = w;
		height = h;

		setSize(w, h);
	}

	public void paintSheet(BufferedImage img)
	{
		image = img;
		repaint();
	}

	public void paintComponent(Graphics g)// paintcomponent methode is automatically called when repaint() is called
	{
		g.drawImage(image, 0, 0, width, height, this);
	}
    
    
    
    
}
