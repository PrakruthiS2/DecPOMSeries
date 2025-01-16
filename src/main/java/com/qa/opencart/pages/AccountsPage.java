package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.util.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	By logout = By.linkText("Logout");
//	By headers= By.cssSelector("div#content h2");
	By headers = By.xpath("//div[@id='content']/h2");
	By search = By.name("search");
	By searchicon = By.xpath("//div[@id='search']//button");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getAccountPageTitle() {
		// String title = driver.getTitle();
		String title = eleUtil.waitForTitleToBe(AppConstant.ACCOUNT_PAGE_TITLE, 5);
		return title;
	}

	public String getAccountPageurl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public boolean isLogOutLinkExist() {
		// return driver.findElement(logout).isDisplayed();
		return eleUtil.isElementDisplayed(logout);

	}

	public List<String> getAccPageHeaders() {
		List<WebElement> headerVallist = eleUtil.waitForVisibilityOfElemenetsLocated(headers, 5);
		List<String> headerslist = new ArrayList<String>();

		for (WebElement e : headerVallist) {
			String text = e.getText();
			headerslist.add(text);
		}

		return headerslist;
	}

	public boolean isSearchExist() {
		// return driver.findElement(search).isDisplayed();
		return eleUtil.doIsDisplayed(search);
	}

	public SearchResultsPage doSearch(String searchkey) {

		if (isSearchExist()) {
			// driver.findElement(search).sendKeys(searchkey);
			eleUtil.getElement(search).clear();
			eleUtil.doSendKeys(search, searchkey, 10);
			eleUtil.doClick(searchicon, 5);
			// driver.findElement(searchicon).click();
			return new SearchResultsPage(driver);

		} else {
			System.out.println("search field not present");
			return null;
		}

	}

}
