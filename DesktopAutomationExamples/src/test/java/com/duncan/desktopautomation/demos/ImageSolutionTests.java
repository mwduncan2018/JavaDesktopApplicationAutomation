package com.duncan.desktopautomation.demos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.duncan.paintnetautomationframework.utilities.ImageSolution;

public class ImageSolutionTests {

	@Test
	public void t1() throws InterruptedException {
		Thread.sleep(2000);
		ImageSolution sol = new ImageSolution("CanvasPage\\verify_triangle.jpg");

		System.out.println("=====================");
		System.out.println(sol.getUpperLeftPoint());
		System.out.println(sol.getUpperRightPoint());
		System.out.println(sol.getLowerLeftPoint());
		System.out.println(sol.getLowerRightPoint());
		System.out.println(sol.getCenterPoint());
		System.out.println("=====================");
	}

}
