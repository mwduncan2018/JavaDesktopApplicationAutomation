package com.duncan.desktopautomation.demos;

import org.opencv.core.Core;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class TemplateMatchingDemo {

	public static void main(String[] args) {

		String imageFolderPath = "C:\\dev\\Java\\images\\";
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		Mat screenShot = null;
		Mat template = null;

		// Load image file
		// screenShot = Imgcodecs.imread(imageFolderPath + "Luxery_Screen.jpg");
		// template = Imgcodecs.imread(imageFolderPath + "Luxery_Template.jpg");
		// screenShot = Imgcodecs.imread(imageFolderPath + "screenshot.jpg");
		// template = Imgcodecs.imread(imageFolderPath + "main_form_focused.jpg");
		screenShot = Imgcodecs.imread(imageFolderPath + "_screenshot.jpg");
		template = Imgcodecs.imread(imageFolderPath + "_template.jpg");
		// screenShot = Imgcodecs.imread(imageFolderPath + "screen_big_red_01.jpg");
		// template = Imgcodecs.imread(imageFolderPath + "template_flat_black_01.jpg");

		Mat outputImage = new Mat();
		int matchMethod;
		//matchMethod = Imgproc.TM_CCOEFF; // pretty good
		//matchMethod = Imgproc.TM_CCOEFF_NORMED; // pretty good
		//matchMethod = Imgproc.TM_CCORR;
		matchMethod = Imgproc.TM_CCORR_NORMED; // pretty good
		//matchMethod = Imgproc.TM_SQDIFF;
		//matchMethod = Imgproc.TM_SQDIFF_NORMED;
		

		// Template matching method
		Imgproc.matchTemplate(screenShot, template, outputImage, matchMethod);

		// This gets the upper left point
		MinMaxLocResult mmr = Core.minMaxLoc(outputImage);
		
		System.out.println("================================================================");
		System.out.println("================================================================");
		System.out.println("================================================================");
		System.out.println(mmr.maxLoc.toString());
		System.out.println("================================================================");
		System.out.println("================================================================");
		System.out.println("================================================================");

		Point upperLeftPoint = mmr.maxLoc;

		// Calculate the coordinates for the lower right
		double lowerRightXCoordinate = upperLeftPoint.x + template.cols();
		double lowerRightYCoordinate = upperLeftPoint.y + template.rows();
		// Create the lower right point
		Point lowerRightPoint = new Point(lowerRightXCoordinate, lowerRightYCoordinate);
		// Create the upper right point
		Point upperRightPoint = new Point((upperLeftPoint.x + template.cols()), upperLeftPoint.y);
		// Create the lower left point
		Point lowerLeftPoint = new Point(upperLeftPoint.x, (upperLeftPoint.y + template.rows()));

		// Calculate the center point
		double centerXCoordinate = Math.round((upperRightPoint.x - upperLeftPoint.x) / 2) + upperLeftPoint.x;
		double centerYCoordinate = Math.round((lowerLeftPoint.y - upperLeftPoint.y) / 2) + upperLeftPoint.y;
		Point centerPoint = new Point(centerXCoordinate, centerYCoordinate);

		System.out.println("*******************************************************");
		System.out.println("upperLeft = " + upperLeftPoint.toString());
		System.out.println("*******************************************************");
		System.out.println("upperRight = " + upperRightPoint.toString());
		System.out.println("*******************************************************");
		System.out.println("lowerLeft = " + lowerLeftPoint.toString());
		System.out.println("*******************************************************");
		System.out.println("lowerRight = " + lowerRightPoint.toString());
		System.out.println("*******************************************************");
		System.out.println("center = " + centerPoint.toString());
		System.out.println("*******************************************************");

		// Draw a rectangle where the template was found
		Imgproc.rectangle(screenShot, upperLeftPoint, lowerRightPoint, new Scalar(0, 0, 255));

		Imgcodecs.imwrite(imageFolderPath + "_RESULT.jpg", screenShot);
		System.out.println("Completed.");
	}

}