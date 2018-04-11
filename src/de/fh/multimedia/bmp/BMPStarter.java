package de.fh.multimedia.bmp;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BMPStarter {
	
	
	private static final String BASEPATH = "";
	private static final String INPUTIMAGE = "";
	
	private static final String OUTPUTPATH = "";
	private static final String OUTPUTIMAGE = "";

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
	               arrayRGB[xPixel][yPixel] = image.getRGB(xPixel, yPixel);
	               System.out.print(image.getRGB(xPixel, yPixel)+"\t");	 
	               image.setRGB(xPixel, yPixel, Color.BLACK.getRGB());
	            }
	            System.out.println();
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		File output = new File(OUTPUTPATH+OUTPUTIMAGE);
		try {
			ImageIO.write(image, "bmp", output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
