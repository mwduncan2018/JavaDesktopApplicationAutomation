package com.duncan.paintnetautomationframework.pom;

import java.awt.Robot;
import java.awt.event.MouseEvent;

import org.opencv.core.Point;

import com.duncan.paintnetautomationframework.utilities.ImageSolution;
import com.duncan.paintnetautomationframework.utilities.SuperRobot;

public class ToolbarPage {

	private static String IMG_SELECT_RED_COLOR = "ToolbarPage\\select_red_color.jpg";
	private static String IMG_SELECT_PAINT_ICON = "ToolbarPage\\select_paint_icon.jpg";

	public static void selectRedColor() {
		Point p = new ImageSolution(IMG_SELECT_RED_COLOR).getLowerLeftPoint();
		SuperRobot.clickPoint(p);
	}

	public static void selectPaintIcon() {
		Point p = new ImageSolution(IMG_SELECT_PAINT_ICON).getLowerLeftPoint();
		SuperRobot.clickPoint(p);
	}

}
