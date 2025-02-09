package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
<<<<<<< HEAD
=======
import org.testng.annotations.Optional;
>>>>>>> 3f3b5208ea33332ed5ab827393f13f6e2d30704c
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoSearch;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {

	DriverFactory df;
	WebDriver driver;
	protected Properties prop;
	protected LoginPage loginpage;
	protected AccountsPage accpage;
	protected SearchResultsPage searchpage;
	protected ProductInfoSearch productinfo;
	protected RegisterPage regpage;
	protected SoftAssert softassert;
	// @BeforeTest
//	public void setUp() {
//		df = new DriverFactory();
//		prop = df.initProp();
//
//		// driver = df.initDriver("chrome");
//		driver = df.initDriver(prop);
//		// creating object of loginpage through const. driver is passed to the loginpage
//		loginpage = new LoginPage(driver);
//
//	}

	@Parameters({"browser"})
	@BeforeTest
<<<<<<< HEAD
	public void setUp(String browserName) {
=======
	public void setUp(@Optional("chrome") String browserName) {
>>>>>>> 3f3b5208ea33332ed5ab827393f13f6e2d30704c
		df = new DriverFactory();
		prop = df.initProp();
		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}
		driver = df.initDriver(prop);
		loginpage = new LoginPage(driver);
		softassert = new SoftAssert();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
