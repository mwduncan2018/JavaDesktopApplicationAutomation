package com.duncan.mspaint3dautomationframework.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import org.opencv.core.Point;
import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import com.duncan.mspaint3dautomationframework.utilities.ImageSolution;
import com.duncan.mspaint3dautomationframework.utilities.SuperRobot;

public class Driver extends BasePage {

	private static String PAINT_3D_PATH = "C:\\Users\\mwdun\\Desktop\\Paint3dShortcut.lnk";
	private static String URL = "http://localhost:9999";
	public static WiniumDriver instance = null;

	// For focusing on Paint 3D
	private static By TITLE_BAR = By.id("TopBarFocusWrapper");
	// For closing
	private static By CLOSE_WINDOW = By.id("Close");

	public static void start() {
		if (instance == null) {
			try {
				DesktopOptions options = new DesktopOptions();
				options.setApplicationPath(PAINT_3D_PATH);
				instance = new WiniumDriver(new URL(URL), options);

				Thread.sleep(1500);
				String handle = instance.getWindowHandle();
				System.out.println("handle = " + handle);

				focusOnPaint3d();
			} catch (MalformedURLException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void focusOnPaint3d() {

	}

	public static void shutdown() {
		instance.findElement(CLOSE_WINDOW).click();
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
			System.out.println(e.getMessage());
		}
	}

	public static void maximizeWindow() {
		focusOnPaint3d();
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
		focusOnPaint3d();
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
