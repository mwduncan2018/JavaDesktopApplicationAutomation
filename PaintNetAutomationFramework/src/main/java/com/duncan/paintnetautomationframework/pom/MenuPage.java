package com.duncan.paintnetautomationframework.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.winium.WiniumDriver;

import com.duncan.paintnetautomationframework.utilities.DateTime;
import com.duncan.paintnetautomationframework.utilities.SuperRobot;

public class MenuPage extends BasePage {

	// File Dropdown
	private static By FILE = By.name("File");
	private static By FileDropdown_NEW = By.name("New...");
	private static By FileDropdown_NewModalDialog_OK_BUTTON = By.id("okButton");
	private static By FileDropdown_SAVE_AS = By.name("Save As...");
	private static By FileDropdown_UnsavedChangesDialog_DONT_SAVE = By.name("Don't Save");

	// Save As Dialog
	private static By DIALOG_SAVE_AS = By.name("Save As");
	private static By DialogSaveAs_FILE_NAME_INPUT_FIELD = By.name("File name:");

	private By EDIT = By.name("Edit");
	private By VIEW = By.name("View");
	private By IMAGE = By.name("Image");
	private By LAYERS = By.name("Layers");
	private By ADJUSTMENTS = By.name("Adjustments");
	private By EFFECTS = By.name("Effects");

	public static void save() {
		// Driver.focusOnPaintNet();
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_F);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_F);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_S);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_S);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.delay(200);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void saveAs(String filename) {
		// Driver.focusOnPaintNet();
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_F);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_F);
			robot.keyPress(KeyEvent.VK_A);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_A);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.delay(2000);
			robot.keyPress(KeyEvent.VK_DELETE);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_DELETE);
			robot.delay(2000);

			Driver.instance.findElement(DIALOG_SAVE_AS).click();
			Driver.instance.findElement(DialogSaveAs_FILE_NAME_INPUT_FIELD).click();
			SuperRobot.sendKeys(filename + "_" + DateTime.now() + ".jpg");

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(100);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(100);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void createNewDrawing() {
		// Driver.focusOnPaintNet();
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_F);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_F);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_N);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_N);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		// Winium
		// Driver.instance.findElement(FILE).click();
		// Driver.instance.findElement(FileDropdown_NEW).click();
		// Driver.instance.findElement(FileDropdown_NewModalDialog_OK_BUTTON).click();
	}

	public static void closeDrawing() {
		// Driver.focusOnPaintNet();
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_W);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_W);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(200);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void exitApplication() {
		// Driver.focusOnPaintNet();
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
			Driver.instance = null;
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void openFileIconTestImage() {
		openFile("C:\\dev\\Java\\JavaDesktopApplicationAutomation\\PaintNetAutomationFramework\\src\\main\\resources\\images\\pom\\CanvasPage\\file_icon_test.jpg");
	}

	public static void openFileMarylandMap() {
		openFile("C:\\dev\\Java\\JavaDesktopApplicationAutomation\\PaintNetAutomationFramework\\src\\main\\resources\\images\\pom\\CanvasPage\\maryland_map.jpg");
	}

	private static void openFile(String file) {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_F);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_F);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_O);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_O);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.delay(200);
			SuperRobot.sendKeys(file);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(200);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
		} catch (AWTException e) {
			e.printStackTrace();
		}		
	}
}
