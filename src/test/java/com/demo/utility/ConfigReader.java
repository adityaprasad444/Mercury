package com.demo.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public FileInputStream fis;
	public Properties p;
	public ConfigReader() {
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//test//properties//base.properties");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		p= new Properties();
		try {

			p.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public String geturl() {

		return p.getProperty("url");

	}

	public String getScreenshotpath() {

		return p.getProperty("ScreenshotUploadPath");
	}

	public String FromEmail() {

		return p.getProperty("FromEmail");
	}
	public String Password() {

		return p.getProperty("Password");
	}
}
