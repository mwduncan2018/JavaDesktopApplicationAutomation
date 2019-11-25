package com.duncan.paintnetautomationframework.utilities;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageSolutionDeprecated {

	private String template;
	private String IMAGE_FOLDER = "C:\\dev\\Java\\JavaDesktopApplicationAutomation\\PaintNetAutomationFramework\\src\\main\\resources\\images\\pom\\";

	private Point upperLeftPoint = null;
	private Point upperRightPoint = null;
	private Point lowerLeftPoint = null;
	private Point lowerRightPoint = null;
	private Point centerPoint = null;

	public Point getCenterPoint() {
		return this.centerPoint;
	}
	
	public Point getUpperLeftPoint() {
		return this.upperLeftPoint;
	}

	public Point getUpperRightPoint() {
		return this.upperRightPoint;
	}

	public Point getLowerLeftPoint() {
		return this.lowerLeftPoint;
	}

	public Point getLowerRightPoint() {
		return this.lowerRightPoint;
	}

	public ImageSolutionDeprecated(String template) {
		this.template = IMAGE_FOLDER + template;
		findImage();
	}

	private void takeScreenshot() {
		try {
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage capture = new Robot().createScreenCapture(screenRect);
			ImageIO.write(capture, "jpg", new File(IMAGE_FOLDER + "screenshot.jpg"));
		} catch (IOException | AWTException e) {
			e.printStackTrace();
		}
	}
	
	private void findImage() {
		String SCREENSHOT = IMAGE_FOLDER + "screenshot.jpg";
		takeScreenshot();
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat matTemplate = null;
		Mat matScreenshot = null;

		// Gray scale is probably not needed
		//matTemplate = Imgcodecs.imread(this.template, Imgcodecs.IMREAD_GRAYSCALE);
		//matScreenshot = Imgcodecs.imread(SCREENSHOT, Imgcodecs.IMREAD_GRAYSCALE);
		matTemplate = Imgcodecs.imread(this.template);
		matScreenshot = Imgcodecs.imread(SCREENSHOT);

		Mat outputImage = new Mat();
		int matchMethod;
		// matchMethod = Imgproc.TM_CCOEFF; // pretty good
		matchMethod = Imgproc.TM_CCOEFF_NORMED; // pretty good
		// matchMethod = Imgproc.TM_CCORR;
		// matchMethod = Imgproc.TM_CCORR_NORMED; // pretty good
		// matchMethod = Imgproc.TM_SQDIFF;
		// matchMethod = Imgproc.TM_SQDIFF_NORMED;

		Imgproc.matchTemplate(matScreenshot, matTemplate, outputImage, matchMethod);
		MinMaxLocResult mmr = Core.minMaxLoc(outputImage);

		// Upper left point
		this.upperLeftPoint = mmr.maxLoc;

		// Upper right point
		this.upperRightPoint = new Point(upperLeftPoint.x + matTemplate.cols(), upperLeftPoint.y);

		// Lower left point
		this.lowerLeftPoint = new Point(upperLeftPoint.x, upperLeftPoint.y + matTemplate.rows());

		// Lower right point
		this.lowerRightPoint = new Point(upperLeftPoint.x + matTemplate.cols(), upperLeftPoint.y + matTemplate.rows());

		// Calculate the center point
		double centerXCoordinate = Math.round((upperRightPoint.x - upperLeftPoint.x) / 2) + upperLeftPoint.x;
		double centerYCoordinate = Math.round((lowerLeftPoint.y - upperLeftPoint.y) / 2) + upperLeftPoint.y;
		this.centerPoint = new Point(centerXCoordinate, centerYCoordinate);
		
		// Draw a rectangle where the template was found
		// For debugging purposes!
		Imgproc.rectangle(matScreenshot, upperLeftPoint, lowerRightPoint, new Scalar(0, 0, 255));
		Imgcodecs.imwrite(IMAGE_FOLDER + "result.jpg", matScreenshot);

	}

}
