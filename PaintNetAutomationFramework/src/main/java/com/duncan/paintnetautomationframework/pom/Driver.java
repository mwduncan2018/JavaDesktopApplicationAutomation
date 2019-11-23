package com.duncan.paintnetautomationframework.pom;

import java.net.MalformedURLException;
import java.net.URL;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.opencv.core.Point;

public class Driver extends BasePage {

	private static String PAINT_NET_PATH = "D:\\Development Tools\\PaintNet\\PaintDotNet.exe";
	private static String URL = "http://localhost:9999";
	public static WiniumDriver instance = null;

	// For focusing on Paint.Net
	public static String IMG_TITLE_BAR = IMAGE_FOLDER + "Driver\\title_bar.jpg";
	public static By MAIN_WINDOW = By.id("MainForm");

	public static void start() {
		if (instance == null) {
			try {
				DesktopOptions options = new DesktopOptions();
				options.setApplicationPath(PAINT_NET_PATH);
				instance = new WiniumDriver(new URL(URL), options);

				Thread.sleep(2000);

				// I might need to know about handles later
				String handle = instance.getWindowHandle();
				System.out.println("handle = " + handle);

				focusOnPaintNet();

			} catch (MalformedURLException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void shutdown() {
		instance.close();
	}

	public static void focusOnPaintNet() {
		// OpenCV & Robot
		Point p = new ImageSolution("Driver\\title_bar\\title_bar_focused.jpg").getUpperLeftPoint();
		try {
			Robot robot = new Robot();
			robot.mouseMove((int) p.x, (int) p.y);
			robot.delay(500);
			robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
			robot.delay(100);
			robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
			robot.delay(500);
			robot.mouseMove(0, 0);
			robot.delay(500);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Winium focus is not consistent!
		// instance.findElement(MAIN_WINDOW).click();
	}

	public static void maximizeWindow() {
		focusOnPaintNet();
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.delay(300);
			robot.keyPress(KeyEvent.VK_SPACE);
			robot.delay(300);
			robot.keyRelease(KeyEvent.VK_SPACE);
			robot.delay(300);
			robot.keyPress(KeyEvent.VK_X);
			robot.delay(300);
			robot.keyRelease(KeyEvent.VK_X);
			robot.delay(300);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.delay(300);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

}
