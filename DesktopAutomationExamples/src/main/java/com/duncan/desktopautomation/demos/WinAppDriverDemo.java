package com.duncan.desktopautomation.demos;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.windows.WindowsDriver;

public class WinAppDriverDemo {

	private static String calcPath = "C:\\Windows\\System32\\calc.exe";
	private static String other = "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App";
	private static WindowsDriver CalcDriver = null;
	private static WebElement CalculatorResult = null;
	private static URL WIN_APP_DRIVER_URL = null;
	
	public static void main(String args[]) throws MalformedURLException {
		WIN_APP_DRIVER_URL = new URL("http://127.0.0.1:4723");		
		System.out.println("START -- " + WIN_APP_DRIVER_URL.toString());
		
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("app", other);
			cap.setCapability("platformName", "Windows");
			cap.setCapability("deviceName", "PC");
			
			CalcDriver = new WindowsDriver(WIN_APP_DRIVER_URL, cap);
			CalcDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			//CalculatorResult = CalcDriver.findElementByAccessibilityId("CalculatorResults");
			//Assert.assertNotNull(CalculatorResult);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("END");
	}

}
