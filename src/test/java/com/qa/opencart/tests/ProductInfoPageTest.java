package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.errors.AppError;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void productInfoPageSetup() {
		accpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@DataProvider
	public Object[][] getproductData() {
		return new Object[][] { { "macbook", "MacBook Pro" }, { "imac", "iMac" }, { "canon", "Canon EOS 5D" } };
	}

	@Test(dataProvider = "getproductData")
	public void productHeaderTest(String searchkey, String productName) {
		searchpage = accpage.doSearch(searchkey);
		productinfo = searchpage.selectProduct(productName);
		Assert.assertEquals(productinfo.getproductHeader(), productName, AppError.HEADER_NOTFOUND);
	}

	@DataProvider
	public Object[][] getProductImagesData() {
		return new Object[][] { { "iMac", "iMac", 3 }, { "samsung", "Samsung SyncMaster 941BW", 1 },
				{ "canon", "Canon EOS 5D", 3 } };

	}

	@Test(dataProvider = "getProductImagesData")
	public void productImagesCountTest(String searchkey, String productName, int imagesCount) {
		searchpage = accpage.doSearch(searchkey);
		productinfo = searchpage.selectProduct(productName);
		Assert.assertEquals(productinfo.getproductImageCount(), imagesCount, AppError.IMAGES_NOTMATCHED);
	}

	
	
	
	//hashmap stoes value in key and value, doesnt maintain in any index
	
	//if needed in the same order then use LinkedHAshMap
	
	//if need in aplhabetically order in keys use tree map
	@Test
	public void productInfoTest() {
		searchpage = accpage.doSearch("macbook");
		productinfo = searchpage.selectProduct("MacBook Pro");
		Map<String, String> productInfo = productinfo.getproductInfoMap();
		System.out.println("=============Product Details======");
		System.out.println(productInfo);
	//Hasr assertion can be used having single assertion
		Assert.assertEquals(productInfo.get("Product Code"),"Product 18");
		
		//soft assertion used when having multiple assertion points
		
		softassert.assertEquals(productInfo.get("Product Code"),"Product 18");
		softassert.assertEquals(productInfo.get("Brand"),"Apple");
		softassert.assertEquals(productInfo.get("productprice"),"$2,000.00");
		softassert.assertAll(); // after assert all test execution is failed
	}

}
