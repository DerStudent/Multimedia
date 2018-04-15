package de.fh.multimedia.bmp;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BMPStarter {
	
	
	private static final String BASEPATH = "D:\\Projekte\\Multimedia\\Bilder\\";
	private static final String INPUTIMAGE = "Image.bmp";
	
	private static final String OUTPUTPATH = "D:\\Projekte\\Multimedia\\Bilder\\";
	private static final String OUTPUTIMAGE = "ImageNew.bmp";
	
	private static final int COLOR = Color.BLACK.getRGB();

	public static void main(String[] args) {
		
		File input = new File(BASEPATH+INPUTIMAGE);
		
		int arrayRGB[][];
		
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(input);
			arrayRGB = new int[image.getWidth()][image.getHeight()];
			
			for (int xPixel = 0; xPixel < image.getWidth(); xPixel++)
	        {
	            for (int yPixel = 0; yPixel < image.getHeight(); yPixel++)
	            {
	            	int rgbCode = image.getRGB(xPixel, yPixel);
	            	arrayRGB[xPixel][yPixel] = rgbCode;
	               	System.out.print(rgbCode); 
	               	image.setRGB(xPixel, yPixel, COLOR);
	            }
	            System.out.println();
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		File output = new File(OUTPUTPATH+OUTPUTIMAGE);
		try {
			ImageIO.write(image, "bmp", output);
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
	}
}
