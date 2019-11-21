package com.duncan.paintnetautomationframework.pom;

import java.net.MalformedURLException;
import java.net.URL;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class Driver {

	private static String PAINT_NET_PATH = "D:\\Development Tools\\PaintNet\\PaintDotNet.exe";
	private static String URL = "http://localhost:9999";
	public static WiniumDriver instance = null;

	public static void start() {
		if (instance == null) {
			try {
				DesktopOptions options = new DesktopOptions();
				options.setApplicationPath(PAINT_NET_PATH);
				instance = new WiniumDriver(new URL(URL), options);
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void shutdown() {
		instance.close();
	}

	public static void maximizeWindow() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_SPACE);
			robot.keyRelease(KeyEvent.VK_SPACE);
			robot.keyPress(KeyEvent.VK_X);
			robot.keyRelease(KeyEvent.VK_X);
			robot.keyRelease(KeyEvent.VK_ALT);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
}
