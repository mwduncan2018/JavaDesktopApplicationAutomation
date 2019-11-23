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

import com.duncan.paintnetautomationframework.pom.Driver;
import com.duncan.paintnetautomationframework.pom.ImageSolution;
import com.duncan.paintnetautomationframework.pom.MenuPage;

public class PaintNetTests {

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
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMaximizeWindow() throws InterruptedException {
		Driver.maximizeWindow();
	}

	@Test
	@Ignore
	public void testCloseDrawing() throws InterruptedException {
		MenuPage.closeDrawing();
	}

	@Test
	public void testImageSolutionClass() throws InterruptedException, AWTException, IOException {
		// C:\dev\Java\JavaDesktopApplicationAutomation\PaintNetAutomationFramework\src\main\resources\images\pom
		ImageSolution imageSolution = new ImageSolution("Driver\\title_bar\\title_bar_focused.jpg");
	
		System.out.println("upperleft   = " + imageSolution.getUpperLeftPoint().toString());
		System.out.println("upperright  = " + imageSolution.getUpperRightPoint().toString());
		System.out.println("lowerleft   = " + imageSolution.getLowerLeftPoint().toString());
		System.out.println("lowerright  = " + imageSolution.getLowerRightPoint().toString());
		System.out.println("center      = " + imageSolution.getCenterPoint().toString());
	}


}
