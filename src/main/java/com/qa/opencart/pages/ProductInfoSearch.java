package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.ElementUtil;
import com.qa.opencart.util.TimeUtil;

public class ProductInfoSearch {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By productHeader = By.cssSelector("div#content h1");
	private By productImagesCount = By.xpath("//a[@class='thumbnail']");
	private By productMetadata = By.xpath("(//div[@id='content']/div//ul[@class='list-unstyled'])[1]/li");
	private By pricing = By.xpath("(//div[@id='content']/div//ul[@class='list-unstyled'])[2]/li");

	private Map<String, String> productmap;

	public ProductInfoSearch(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getproductHeader() {
		String header = eleUtil.doGetText(productHeader);
		System.out.println("====header====" + header);
		return header;
	}

	public int getproductImageCount() {
		int imagesCount = eleUtil
				.waitForVisibilityOfElemenetsLocated(productImagesCount, TimeUtil.DEFAULT_LONG_DURATION).size();
		System.out.println(imagesCount);
		return imagesCount;
	}

	

	
	
	
	public void getProductMetaData() {

		productmap = new HashMap<String, String>();

		List<WebElement> metaList = eleUtil.getElements(productMetadata);
		for (WebElement e : metaList) {
			String metaData = e.getText();
			String metarr[] = metaData.split(":");

			String metaKey = metarr[0].trim();
			String metaValue = metarr[1].trim();
			productmap.put(metaKey, metaValue);
		}
		
	}	
		public void getproductPricing()
		{
			
			
			List<WebElement> pricelist= eleUtil.getElements(pricing);
			String productprice=pricelist.get(0).getText();
			String extaxprice= pricelist.get(1).getText().split(":")[1].trim();
			productmap.put("productprice", productprice);
			productmap.put("extaxprice", extaxprice);
		}

		public Map<String, String> getproductInfoMap() {
			// TODO Auto-generated method stub
			productmap= new HashMap<String,String>();
			productmap.put("productHeader", getproductHeader());
			getProductMetaData();
			getproductPricing();
			return productmap;
		}

		

	}

