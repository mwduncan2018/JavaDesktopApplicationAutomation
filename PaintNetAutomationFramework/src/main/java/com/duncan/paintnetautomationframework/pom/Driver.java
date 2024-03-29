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

import com.duncan.paintnetautomationframework.utilities.ImageSolution;
import com.duncan.paintnetautomationframework.utilities.SuperRobot;

import org.opencv.core.Point;

public class Driver extends BasePage {

	private static String PAINT_NET_PATH = "D:\\Development Tools\\PaintNet\\PaintDotNet.exe";
	private static String URL = "http://localhost:9999";
	public static WiniumDriver instance = null;

	// For focusing on Paint.Net
	private static String IMG_TITLE_BAR = "Driver\\title_bar\\title_bar_focused.jpg";
	private static By MAIN_WINDOW = By.id("MainForm");

	// Dialog Unsaved Changes
	private static By DIALOG_UNSAVED_CHANGES = By.name("Unsaved Changes");
	private static By DialogUnsavedChanges_DONT_SAVE = By.name("Don't Save");

	public static void start() {
		if (instance == null) {
			try {
				DesktopOptions options = new DesktopOptions();
				options.setApplicationPath(PAINT_NET_PATH);
				instance = new WiniumDriver(new URL(URL), options);

				Thread.sleep(2500);

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
		instance = null;
	}

	public static void shutdownNoSave() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_F);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_F);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_X);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_X);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);

			instance = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void focusOnPaintNet() {
		// OpenCV & Robot
		Point p = new ImageSolution(IMG_TITLE_BAR).getUpperLeftPoint();
		SuperRobot.clickPoint(p);
	}

	public static void maximizeWindow() {
		focusOnPaintNet();
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_SPACE);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_SPACE);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_X);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_X);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.delay(200);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void restoreWindow() {
		focusOnPaintNet();
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_SPACE);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_SPACE);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_R);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_R);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.delay(200);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

}
