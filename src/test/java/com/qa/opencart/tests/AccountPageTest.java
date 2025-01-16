package com.qa.opencart.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.errors.AppError;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void SetUp() {
		accpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	// we need to login first before tesing accountpgae

	@Test
	public void accpageTitleTest() {
		Assert.assertEquals(accpage.getAccountPageTitle(), AppConstant.ACCOUNT_PAGE_TITLE, AppError.TITLE_NOT_FOUND);
	}
	
	
	@Test
	public void accpageURLTest() {
	//	Assert.assertEquals(accpage.getAccountPageurl(), AppError.URL_NOT_FOUND);
		Assert.assertTrue(accpage.getAccountPageurl().contains( AppConstant.ACCOUNT_PAGE_FRACTION_URL), AppError.URL_NOT_FOUND);
	}
	
	@Test
	public void accountPageHeader()
	{
	List<String> accPageHeaderList=	accpage.getAccPageHeaders();
	Assert.assertEquals(accPageHeaderList,AppConstant.ACCOUNT_PAGE_HEADER_LIST);
	}
	
	
	@DataProvider
	public Object[][] getSearchData()
	{
		return new Object[][] {{"macbook" ,3 },{"imac" ,1},{"Airtel",0}};
	}
	
	
	@Test(dataProvider="getSearchData")
	public void searchTest(String searchkey, int resultcount)
	{
		searchpage= accpage.doSearch(searchkey);
		Assert.assertEquals(searchpage.getSearchResultsCount(),resultcount,AppError.RESULTSCOUNT_MISMATCH);
		
	}
	
	
	
	
	
	
}
