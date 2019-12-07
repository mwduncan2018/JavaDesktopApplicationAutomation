package com.duncan.appiumdemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class CalculatorDemo {

	//private static WebDriver webDriver;
	private static AppiumDriver<MobileElement> appiumDriver;
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
		cap.setCapability("deviceName", "SAMSUNG-SM-G870A");
		cap.setCapability("udid", "e94dbc73");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "6.0.1");

		cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		appiumDriver = new AppiumDriver<MobileElement>(url, cap);
		
		System.out.println("Application started...");
	}

}
