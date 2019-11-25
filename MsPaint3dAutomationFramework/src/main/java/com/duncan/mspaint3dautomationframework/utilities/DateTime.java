package com.duncan.mspaint3dautomationframework.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

	public static String now() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	
}
