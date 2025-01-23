package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.errors.AppError;
import com.qa.opencart.exceptions.BrowserException;

public class DriverFactory {
	Properties prop;
	WebDriver driver;

	/****
	 * This function is sued to initialise browser on the basis of param browserName
	 * 
	 * @param browserName
	 * @return
	 */

	public WebDriver initDriver(Properties prop) {

		String browserName= prop.getProperty("browser");
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("please pass the right browser" + browserName);
			throw new BrowserException(AppError.BROWSER_NOT_FOUND);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	//	driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/account");

		return driver;
	}

	public Properties initProp() {
		prop = new Properties();
		// provide the path of config.prop

		try {
			FileInputStream ip = new FileInputStream(AppConstant.CONFIG_FILE_PATH);
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;

	}
}
