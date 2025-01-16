package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.errors.AppError;
import com.qa.opencart.exceptions.BrowserException;

public class DriverFactory {
	Properties prop;
	WebDriver driver;
	OptionsManager optionsManager;
	public static String highlight;

	/****
	 * This function is sued to initialise browser on the basis of param browserName
	 * 
	 * @param browserName
	 * @return
	 */
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver initDriver(Properties prop) {

		String browserName = prop.getProperty("browser");
		System.out.println("browser name is" + browserName);

		optionsManager = new OptionsManager(prop);
		highlight = prop.getProperty(highlight);

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			// driver = new ChromeDriver();
			// to call incognito or headless
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			break;

		case "firefox":
			// driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
			break;

		case "edge":
			// driver = new EdgeDriver();
			tlDriver.set(new EdgeDriver());
			break;

		default:
			System.out.println("please pass the right browser" + browserName);
			throw new BrowserException(AppError.BROWSER_NOT_FOUND);
		}

//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.get(prop.getProperty("url"));
		// driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/account");

//		return driver;

		// driver.manage().deleteAllCookies();
		getDriver().manage().deleteAllCookies();
		// driver.manage().window().maximize();
		getDriver().manage().window().maximize();
//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		// driver.get(prop.getProperty("url"));
		getDriver().get(prop.getProperty("url"));

		// it gives driver
		return getDriver();
	}

	/******
	 * get the local thread copy of the driver
	 * 
	 * @return
	 */
	public static WebDriver getDriver() {
		return tlDriver.get();
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

	public static String getScreenshot(String methodName) {

		// TakesScereenshotAs ts= (TakeScreenshotAs)driver; //driver will be of type
		// TakeScreenshotAs interface
		// just like JavaScriptExecutor driver is of type JSExecutor here

		// take RHS

		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);// temp location
		String path = System.getProperty("user.dir") + "/screenshots/" + methodName + "_" + System.currentTimeMillis()
				+ ".png";
		File destinationFile = new File(path); // creating destination place
		try {
			FileHandler.copy(srcFile, destinationFile); // copying file from destination to source
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
