package com.duncan.paintnetautomationframework.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Point;

import com.duncan.paintnetautomationframework.utilities.ImageSolution;
import com.duncan.paintnetautomationframework.utilities.SuperRobot;
import com.duncan.paintnetautomationframework.utilities.SuperShape;

public class CanvasPage extends BasePage {

	private static String IMG_DEFAULT_BLANK_CANVAS = "CanvasPage\\default_size_blank_canvas.jpg";

	// Test Images
	private static String IMG_FILE_ICON_TEST = "CanvasPage\\file_icon_test.jpg";

	// Verification Images
	private static String IMG_VERIFY_TRIANGLE = "CanvasPage\\verify_triangle.jpg";
	private static String IMG_VERIFY_TRIANGLE_IS_RED = "CanvasPage\\verify_triangle_is_red.jpg";
	private static String IMG_VERIFY_ACCESS_FILE_ICON = "CanvasPage\\verify_access_file_icon.jpg";
	private static String IMG_VERIFY_EXCEL_FILE_ICON = "CanvasPage\\verify_excel_file_icon.jpg";
	private static String IMG_VERIFY_NOTEPAD_PLUS_PLUS_FILE_ICON = "CanvasPage\\verify_notepad_plus_plus_file_icon.jpg";
	private static String IMG_VERIFY_WORD_FILE_ICON = "CanvasPage\\verify_word_file_icon.jpg";
	private static String IMG_VERIFY_BALTIMORE_ON_MARYLAND_MAP = "CanvasPage\\verify_baltimore_on_maryland_map.jpg";
	private static String IMG_VERIFY_OCEAN_CITY_ON_MARYLAND_MAP = "CanvasPage\\verify_ocean_city_on_maryland_map.jpg";
	private static String IMG_VERIFY_MARYLAND_MAP_WITH_RED_LINE_FROM_BALTIMORE_TO_OCEAN_CITY = "CanvasPage\\verify_maryland_map_with_red_line_from_baltimore_to_ocean_city.jpg";
	
	public static boolean verifyWordFileIcon() {
		if (new ImageSolution(IMG_VERIFY_WORD_FILE_ICON).getCenterPoint() != null) {
			return true;
		}
		return false;
	}

	public static boolean verifyNotepadPlusPlusFileIcon() {
		if (new ImageSolution(IMG_VERIFY_NOTEPAD_PLUS_PLUS_FILE_ICON).getCenterPoint() != null) {
			return true;
		}
		return false;
	}

	public static boolean verifyExcelFileIcon() {
		if (new ImageSolution(IMG_VERIFY_EXCEL_FILE_ICON).getCenterPoint() != null) {
			return true;
		}
		return false;
	}

	public static boolean verifyAccessFileIcon() {
		if (new ImageSolution(IMG_VERIFY_ACCESS_FILE_ICON).getCenterPoint() != null) {
			return true;
		}
		return false;
	}

	public static void drawTriangle() {
		Point p = new ImageSolution(IMG_DEFAULT_BLANK_CANVAS).getCenterPoint();
		List<Point> points = new ArrayList<Point>();
		points.add(p);
		points.add(new Point(p.x + 150, p.y + 150));
		points.add(new Point(p.x - 150, p.y + 150));
		points.add(p);
		SuperShape.draw(points);
	}

	public static boolean verifyTriangle() {
		if (new ImageSolution(IMG_VERIFY_TRIANGLE).getCenterPoint() != null) {
			return true;
		}
		return false;
	}

	public static void paintTheTriangle() {
		Point p = new ImageSolution(IMG_VERIFY_TRIANGLE).getCenterPoint();
		SuperRobot.clickPoint(p);
	}

	public static boolean verifyTriangleIsRed() {
		if (new ImageSolution(IMG_VERIFY_TRIANGLE_IS_RED).getCenterPoint() != null) {
			return true;
		}
		return false;
	}

	public static boolean verifyBaltimoreIsDisplayed() {
		if (new ImageSolution(IMG_VERIFY_BALTIMORE_ON_MARYLAND_MAP).getCenterPoint() != null) {
			return true;
		}
		return false;
	}

	public static boolean verifyOceanCityIsDisplayed() {
		if (new ImageSolution(IMG_VERIFY_OCEAN_CITY_ON_MARYLAND_MAP).getCenterPoint() != null) {
			return true;
		}
		return false;
	}

	public static void drawRedLineFromBaltimoreToOceanCity() {
		ToolbarPage.selectRedColor();
		List<Point> points = new ArrayList<Point>();
		Point baltimore = new ImageSolution(IMG_VERIFY_BALTIMORE_ON_MARYLAND_MAP).getCenterPoint();
		System.out.println("baltimore = " + baltimore.toString());
		
		Point oceanCity = new ImageSolution(IMG_VERIFY_OCEAN_CITY_ON_MARYLAND_MAP).getCenterPoint();
		System.out.println("oceanCity = " + oceanCity.toString());
		
		points.add(baltimore);
		points.add(oceanCity);
		SuperShape.draw(points);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean verifyMarylandMapWithRedLineFromBaltimoreToOceanCity() {
		if (new ImageSolution(IMG_VERIFY_MARYLAND_MAP_WITH_RED_LINE_FROM_BALTIMORE_TO_OCEAN_CITY).getCenterPoint() != null) {
			return true;
		}
		return false;
	}


}
