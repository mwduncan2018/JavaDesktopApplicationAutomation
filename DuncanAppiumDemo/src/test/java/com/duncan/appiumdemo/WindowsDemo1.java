package com.duncan.appiumdemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class WindowsDemo1 {

	//private static WebDriver webDriver;
	private static AppiumDriver appiumDriver;
	//private static AndroidDriver androidDriver;
	
	public static void main(String[] args) {
		try {
			openCalculator();			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void openCalculator() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "WindowsPC");
		cap.setCapability("platformName", "Windows");

		cap.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		appiumDriver = new AppiumDriver(url, cap);
		
		System.out.println("Application started...");
	}

}
