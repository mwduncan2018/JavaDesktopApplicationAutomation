package com.duncan.desktopautomation.demos;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class WiniumDemo {

	public static void main(String[] args) throws IOException, MalformedURLException, InterruptedException {
		
		// Winium.Desktop.Driver.exe must already be running.
		// The code below starts the Winium Driver,
		// but the elements aren't being found.
		// Start the Winium Driver manually for now
		// and figure this out later.
		
		//String[] cmdArray = new String[1];
		//cmdArray[0] = "D:\\Development Tools\\Winium Desktop Driver\\Winium.Desktop.Driver.exe";
		//System.out.println(cmdArray[0]);
		//Process process = Runtime.getRuntime().exec(cmdArray);
		//Thread.sleep(5000);
		
		// Powershell to stop the Winium Driver if it is hanging out there
		// Get-Process (to get the ID)
		// Stop-Process -ID <processId> -Force
		
		DesktopOptions options = new DesktopOptions();
		options.setApplicationPath("C:\\windows\\system32\\calc.exe");
		
		URL remoteAddress = new URL("http://localhost:9999");
		WiniumDriver driver = new WiniumDriver(remoteAddress, options);
		
		driver.findElement(By.id("TogglePaneButton")).click();
		driver.findElement(By.id("Standard")).click();
		
		driver.findElement(By.id("num1Button")).click();
		driver.findElement(By.id("plusButton")).click();
		driver.findElement(By.id("num2Button")).click();
		driver.findElement(By.id("equalButton")).click();
		
	}
}

