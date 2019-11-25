package com.duncan.mspaint3dautomationframework.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.duncan.mspaint3dautomationframework.pom.Driver;

public class DriverTests {

	@Test
	public void testOpenPaint3d() throws InterruptedException {
		Driver.start();
		Thread.sleep(1500);
		Driver.shutdown();
	}

}
