package com.duncan.desktopautomation.demos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.duncan.paintnetautomationframework.pom.CanvasPage;
import com.duncan.paintnetautomationframework.pom.Driver;
import com.duncan.paintnetautomationframework.pom.MenuPage;
import com.duncan.paintnetautomationframework.pom.ToolbarPage;
public class AdvancedPaintNetTests {

	@Before
	public void setUp() throws Exception {
		Driver.start();
	}

	@After
	public void tearDown() throws Exception {
		Driver.shutdownNoSave();
		Thread.sleep(1500);
	}
	
	@Test
	public void drawATriangle_verifyTheTriangle() {
		Driver.maximizeWindow();
		CanvasPage.drawTriangle();
		assertTrue(CanvasPage.verifyTriangle());
	}

	@Test
	public void drawATriangle_paintTheInsideRed_verifyTheTriangleIsRed() {
		Driver.maximizeWindow();
		CanvasPage.drawTriangle();
		ToolbarPage.selectRedColor();
		ToolbarPage.selectPaintIcon();
		CanvasPage.paintTheTriangle();
		assertTrue(CanvasPage.verifyTriangleIsRed());
	}
	
	@Test
	public void openAnImageWithWordExcelNotepadAccessFileIcons_verifyEachIcon() throws InterruptedException {
		Driver.maximizeWindow();
		MenuPage.openFileIconTestImage();
		Thread.sleep(10000);
		assertTrue(CanvasPage.verifyAccessFileIcon());
		assertTrue(CanvasPage.verifyExcelFileIcon());
		assertTrue(CanvasPage.verifyNotepadPlusPlusFileIcon());
		assertTrue(CanvasPage.verifyWordFileIcon());
	}
	
}
