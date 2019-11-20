package com.duncan.desktopautomation.demos;

import java.awt.Robot;
import java.awt.event.MouseEvent;

// Robot
// Coordinate interactions are based off your main display
// The "delay" seems to be required for Robot to work
// Run this code with MS Paint maximized

public class RobotDemo {

	private static Robot robot = null;

	public static void main(String[] args) {

		try {
			robot = new Robot();

			robot.mouseMove(30, 200);
			robot.delay(500);
			robot.mouseMove(400, 400);
			robot.delay(500);
			robot.mouseMove(30, 200);
			robot.delay(500);
			robot.mouseMove(400, 400);
			robot.delay(500);

			dragAndDrop(200, 200, 100, 400);

			drawTriangle(400, 400, 500, 500, 300, 500);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		robot.mouseMove(x1, y1);
		robot.delay(500);
		robot.mousePress(MouseEvent.BUTTON1_MASK);
		robot.delay(500);
		robot.mouseMove(x2, y2);
		robot.delay(500);
		robot.mouseMove(x3, y3);
		robot.delay(500);
		robot.mouseMove(x1, y1);
		robot.delay(500);
		robot.mouseRelease(MouseEvent.BUTTON1_MASK);
		robot.delay(200);
	}

	public static void dragAndDrop(int startX, int startY, int endX, int endY) {
		robot.mouseMove(startX, startY);
		robot.delay(500);
		robot.mousePress(MouseEvent.BUTTON1_MASK);
		robot.delay(500);
		robot.mouseMove(endX, endY);
		robot.delay(500);
		robot.mouseRelease(MouseEvent.BUTTON1_MASK);
		robot.delay(200);
	}

	public static void myRobotClick(int x, int y) {
		robot.mouseMove(x, y);
		robot.delay(100);
		robot.mousePress(MouseEvent.BUTTON1_MASK);
		robot.delay(100);
		robot.mouseRelease(MouseEvent.BUTTON1_MASK);
		robot.delay(500);
	}
}
