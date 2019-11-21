package com.duncan.desktopautomation.demos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.duncan.paintnetautomationframework.pom.Driver;

public class PaintNetTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMinimizeWindow() throws InterruptedException {
		Driver.start();
		Thread.sleep(5000);
		Driver.maximizeWindow();
		Thread.sleep(2000);
		Driver.shutdown();
	}

}
