package com.duncan.mspaint3dautomationframework.pom;

import org.openqa.selenium.By;

public class TitlebarPage {

	private static By BRUSHES_ICON = By.name("Brushes");
	private static By SHAPES_2D_ICON = By.name("2D Shapes");
	private static By SHAPES_3D_ICON = By.name("3D Shapes");
	private static By STICKERS_ICON = By.name("Stickers");
	private static By TEXT_ICON = By.name("Text");
	private static By EFFECTS_ICON = By.name("Effects");
	private static By CANVAS_ICON = By.name("Canvas");
	private static By LIBRARY_3D_ICON = By.name("3D Library");
	
	public static void activateBrushes() {
		Driver.instance.findElement(BRUSHES_ICON).click();
	}
	
	public static void activate2dShapes() {
		Driver.instance.findElement(SHAPES_2D_ICON).click();
	}
	
	public static void activateText() {
		Driver.instance.findElement(TEXT_ICON).click();
	}
}
