package com.duncan.paintnetautomationframework.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.WiniumDriver;

public class MenuPage {

	// Top level Menu options
	private static By MenuOption_FILE = By.name("File");
	private static By MenuOption_EDIT = By.name("Edit");
	private static By MenuOption_VIEW = By.name("View");
	private static By MenuOption_IMAGE = By.name("Image");
	private static By MenuOption_LAYERS = By.name("Layers");
	private static By MenuOption_ADJUSTMENTS = By.name("Adjustments");
	private static By MenuOption_EFFECTS = By.name("Effects");

	// Options within the File Drop Down
	private static By FileDropdown_NEW = By.name("New...");
	
	// Options within the New Modal Dialog
	private static By NewModalDialog_OK_BUTTON = By.id("okButton");

	
	
	public static void createNewDrawing() {
		Driver.instance.findElement(MenuOption_FILE).click();
		Driver.instance.findElement(FileDropdown_NEW).click();
		Driver.instance.findElement(NewModalDialog_OK_BUTTON).click();
	}
	
	public static void saveDrawing() {
		
	}
	
	public static void closeDrawing() {
		
	}
	
	
	
	
}
