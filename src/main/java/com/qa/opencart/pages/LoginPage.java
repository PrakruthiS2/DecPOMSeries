package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.TimeUtil;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.util.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// in every page class= page objects + page actions

	By emailId = By.xpath("//input[@id='input-email']");
	By pwd = By.xpath("//input[@id='input-password']");
	By loginbutton = By.xpath("//input[@value='Login']");
	By forgotpwdlink = By.linkText("Forgotten Password");
	private By Register=By.linkText("Register");
	
	// 2. creating const of each page so that whenever object of theis page is
	// created, and driver is passed

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. page actions

	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleToBe(AppConstant.ACCOUNT_PAGE_TITLE, 5);
		return title;
	}

	public String getLoginPageurl() {
//		String url = driver.getCurrentUrl();
//		return url;
		String url = eleUtil.waitForURLContains(AppConstant.LOGIN_PAGE_FRACTION_URL, 5);
		return url;
	}

	public boolean checkforgotpwdLink() {
		// return driver.findElement(forgotpwdlink).isDisplayed();

		return eleUtil.doIsDisplayed(forgotpwdlink);
	}

	public AccountsPage doLogin(String username, String password) {

		// driver.findElement(emailId).sendKeys(username);
		eleUtil.doSendKeys(emailId, username, 3);
		// driver.findElement(pwd).sendKeys(password);
		eleUtil.doSendKeys(pwd, password, 3);
		// driver.findElement(loginbutton).click();
		eleUtil.doClick(loginbutton, 2);

		String title = driver.getTitle();
		System.out.println("account page title" + title);
		// tdd, to create test class for Account page, returning the object of account
		// page
		// based on the behaviour of the test class, we are writing code, we need to
		// test account page class, hence return object of account oage
		return new AccountsPage(driver);
	}

	public RegisterPage navigateToRegister() {
		// TODO Auto-generated method stub
		eleUtil.doClick(Register,TimeUtil.DEFAULT_SHORT_DURATION);
		return new RegisterPage(driver);
	}

}
