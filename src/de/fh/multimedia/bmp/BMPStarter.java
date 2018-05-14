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
		
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(input);
			//arrayRGB = new int[image.getWidth()][image.getHeight()];
			
			for (int xPixel = 0; xPixel < image.getWidth(); xPixel++)
	        {
	            for (int yPixel = 0; yPixel < image.getHeight(); yPixel++)
	            {
	            	int gray = getGray(new Color(image.getRGB(xPixel, yPixel)));
	            	Color grayCol = new Color(gray,gray,gray);
	               	image.setRGB(xPixel, yPixel, grayCol.getRGB() );
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
	
	private static int getGray(Color col) {
				
		int red = col.getRed();
		int green = col.getGreen();
		int blue = col.getBlue();
		
		return (int)((0.299*red)+(0.587*green)+(0.114*blue));
				
	}
}
