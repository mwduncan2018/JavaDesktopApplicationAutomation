package com.duncan.mspaint3dautomationframework.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TitlebarPageTests {

	@Test
	public void testNavigation() throws InterruptedException {
		Driver.start();
		Thread.sleep(1500);
		TitlebarPage.activate2dShapes();
		Thread.sleep(1500);
		TitlebarPage.activateText();
		Thread.sleep(1500);
		TitlebarPage.activateBrushes();
		Thread.sleep(1500);
		Driver.shutdown();
	}
}
