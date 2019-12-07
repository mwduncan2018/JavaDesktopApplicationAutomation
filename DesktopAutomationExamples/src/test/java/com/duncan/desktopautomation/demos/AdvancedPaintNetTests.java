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
		Driver.maximizeWindow();
	}

	@After
	public void tearDown() throws Exception {
		Driver.shutdownNoSave();
	}

	@Test
	public void drawATriangle_verifyTheTriangle() {
		CanvasPage.drawTriangle();
		assertTrue(CanvasPage.verifyTriangle());
	}

	@Test
	public void drawATriangle_paintTheInsideRed_verifyTheTriangleIsRed() {
		CanvasPage.drawTriangle();
		ToolbarPage.selectRedColor();
		ToolbarPage.selectPaintIcon();
		CanvasPage.paintTheTriangle();
		assertTrue(CanvasPage.verifyTriangleIsRed());
	}
	
	@Test
	public void openAnImageWithWordExcelNotepadAccessFileIcons_verifyEachIcon() {
		MenuPage.openFileIconTestImage();
		assertTrue(CanvasPage.verifyAccessFileIcon());
		assertTrue(CanvasPage.verifyExcelFileIcon());
		assertTrue(CanvasPage.verifyNotepadPlusPlusFileIcon());
		assertTrue(CanvasPage.verifyWordFileIcon());
	}

	@Test
	public void openMarylandMap_verifyBaltimoreIsDisplayed() {
		MenuPage.openFileMarylandMap();
		assertTrue(CanvasPage.verifyBaltimoreIsDisplayed());
	}
	
	@Test
	public void openMarylandMap_verifyOceanCityIsDisplayed() {
		MenuPage.openFileMarylandMap();
		assertTrue(CanvasPage.verifyOceanCityIsDisplayed());
	}
	
	@Test
	public void openMarylandMap_drawRedLineFromBaltimoreToOceanCity_verifyImage() {
		MenuPage.openFileMarylandMap();
		CanvasPage.drawRedLineFromBaltimoreToOceanCity();
		assertTrue(CanvasPage.verifyMarylandMapWithRedLineFromBaltimoreToOceanCity());
	}
	
	
	
	
}




