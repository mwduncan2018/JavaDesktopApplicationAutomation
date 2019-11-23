package com.duncan.paintnetautomationframework.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.WiniumDriver;

public class MenuPage extends BasePage {

	// File Dropdown
	private static By FILE = By.name("File");
	private static By FileDropdown_NEW = By.name("New...");
	private static By FileDropdown_NewModalDialog_OK_BUTTON = By.id("okButton");
	private static By FileDropdown_SAVE_AS = By.name("Save As...");
	private static By FileDropdown_UnsavedChangesDialog_DONT_SAVE = By.name("Don't Save");
	
	private By EDIT = By.name("Edit");
	private By VIEW = By.name("View");
	private By IMAGE = By.name("Image");
	private By LAYERS = By.name("Layers");
	private By ADJUSTMENTS = By.name("Adjustments");
	private By EFFECTS = By.name("Effects");

	public static void createNew() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F);
			robot.keyRelease(KeyEvent.VK_F);
			robot.keyPress(KeyEvent.VK_N);
			robot.keyRelease(KeyEvent.VK_N);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		// Winium
		//Driver.instance.findElement(FILE).click();
		//Driver.instance.findElement(FileDropdown_NEW).click();
		//Driver.instance.findElement(FileDropdown_NewModalDialog_OK_BUTTON).click();
	}

	public static void save() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F);
			robot.keyRelease(KeyEvent.VK_F);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_ALT);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveAs() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F);
			robot.keyRelease(KeyEvent.VK_F);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_ALT);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeDrawing() {
		
		
		
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_W);
			robot.keyRelease(KeyEvent.VK_W);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
			
		} catch (AWTException e) {
			e.printStackTrace();
		}		
	}

	public static void exitApplication() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F);
			robot.keyRelease(KeyEvent.VK_F);
			robot.keyPress(KeyEvent.VK_X);
			robot.keyRelease(KeyEvent.VK_X);
			robot.keyRelease(KeyEvent.VK_ALT);
		} catch (AWTException e) {
			e.printStackTrace();
		}		
	}
	
}
