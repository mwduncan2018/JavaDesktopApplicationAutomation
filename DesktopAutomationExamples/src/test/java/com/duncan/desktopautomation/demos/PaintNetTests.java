package com.duncan.desktopautomation.demos;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.duncan.paintnetautomationframework.pom.CanvasPage;
import com.duncan.paintnetautomationframework.pom.Driver;
import com.duncan.paintnetautomationframework.pom.MenuPage;
import com.duncan.paintnetautomationframework.utilities.ImageSolution;

public class PaintNetTests {
	// C:\dev\Java\JavaDesktopApplicationAutomation\PaintNetAutomationFramework\src\main\resources\images\pom

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Driver.start();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Driver.shutdown();
	}

	@Before
	public void setUp() throws Exception {
		MenuPage.createNewDrawing();
	}

	@After
	public void tearDown() throws Exception {
		MenuPage.closeDrawing();
	}

	@Test
	@Ignore
	public void testExitApplication() throws InterruptedException {
		MenuPage.exitApplication();
		Thread.sleep(1500);
		Driver.start();
	}

	@Test
	public void testMaximizeWindow() {
		Driver.maximizeWindow();
	}

	@Test
	public void testRestoreWindow() {
		Driver.restoreWindow();
	}

	@Test
	public void testImageSolutionClass() {
		ImageSolution imageSolution = new ImageSolution("Driver\\title_bar\\title_bar_focused.jpg");
		System.out.println("upperleft   = " + imageSolution.getUpperLeftPoint().toString());
		System.out.println("upperright  = " + imageSolution.getUpperRightPoint().toString());
		System.out.println("lowerleft   = " + imageSolution.getLowerLeftPoint().toString());
		System.out.println("lowerright  = " + imageSolution.getLowerRightPoint().toString());
		System.out.println("center      = " + imageSolution.getCenterPoint().toString());
	}

	@Test
	public void testSaveAs() {
		MenuPage.saveAs("PaintNetTests_testSaveAs");
	}

}
