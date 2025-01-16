package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.ElementUtil;
import com.qa.opencart.util.TimeUtil;

public class SearchResultsPage {

	private WebDriver driver;

	private By searchResult = By.cssSelector("div.product-thumb");

	private ElementUtil eleUtil;

	public SearchResultsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	public int getSearchResultsCount() {

		List<WebElement> resultsList = eleUtil.waitForVisibilityOfElemenetsLocated(searchResult,TimeUtil.DEFAULT_LONG_DURATION);
		int resultsCount = resultsList.size();
		System.out.println("product list" + resultsCount);
		return resultsCount;
	}

	public ProductInfoSearch selectProduct(String productName) {

		eleUtil.doClick(By.linkText(productName));
		return new ProductInfoSearch(driver); // to land to next page, create object of page class
	}
}
