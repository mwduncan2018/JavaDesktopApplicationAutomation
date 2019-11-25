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

	public static boolean verifyWordFileIcon() {
		Driver.focusOnPaintNet();
		if (new ImageSolution(IMG_VERIFY_WORD_FILE_ICON).getCenterPoint() != null) {
			return true;
		}
		return false;
	}

	public static boolean verifyNotepadPlusPlusFileIcon() {
		Driver.focusOnPaintNet();
		if (new ImageSolution(IMG_VERIFY_NOTEPAD_PLUS_PLUS_FILE_ICON).getCenterPoint() != null) {
			return true;
		}
		return false;
	}

	public static boolean verifyExcelFileIcon() {
		Driver.focusOnPaintNet();
		if (new ImageSolution(IMG_VERIFY_EXCEL_FILE_ICON).getCenterPoint() != null) {
			return true;
		}
		return false;
	}

	public static boolean verifyAccessFileIcon() {
		Driver.focusOnPaintNet();
		if (new ImageSolution(IMG_VERIFY_ACCESS_FILE_ICON).getCenterPoint() != null) {
			return true;
		}
		return false;
	}

	
	public static void drawTriangle() {
		Driver.focusOnPaintNet();
		Point p = new ImageSolution(IMG_DEFAULT_BLANK_CANVAS).getCenterPoint();

		List<Point> points = new ArrayList<Point>();
		points.add(p);
		points.add(new Point(p.x + 150, p.y + 150));
		points.add(new Point(p.x - 150, p.y + 150));
		points.add(p);
		SuperShape.draw(points);
	}

	public static boolean verifyTriangle() {
		Driver.focusOnPaintNet();
		if (new ImageSolution(IMG_VERIFY_TRIANGLE).getCenterPoint() != null) {
			return true;
		}
		return false;
	}

	public static void paintTheTriangle() {
		Driver.focusOnPaintNet();
		Point p = new ImageSolution(IMG_VERIFY_TRIANGLE).getCenterPoint();
		SuperRobot.clickPoint(p);
	}

	public static boolean verifyTriangleIsRed() {
		Driver.focusOnPaintNet();
		if (new ImageSolution(IMG_VERIFY_TRIANGLE_IS_RED).getCenterPoint() != null) {
			return true;
		}
		return false;
	}

}
