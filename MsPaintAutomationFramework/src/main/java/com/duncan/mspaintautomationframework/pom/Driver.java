package com.duncan.mspaintautomationframework.pom;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class Driver {

	private static String MS_PAINT_PATH = "D:\\Development Tools\\PaintNet\\PaintDotNet.exe";
	private static String URL = "http://localhost:9999";
	public static WiniumDriver instance = null;

	public static void start() {
		if (instance == null) {
			try {
				DesktopOptions options = new DesktopOptions();
				options.setApplicationPath(MS_PAINT_PATH);
				instance = new WiniumDriver(new URL(URL), options);
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public static void shutdown() {
		instance.close();
	}
}