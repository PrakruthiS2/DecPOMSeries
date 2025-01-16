package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.errors.AppError;
import com.qa.opencart.pages.AccountsPage;




public class LoginPageTest extends BaseTest {
	
	
	@Test(priority=0)
	public void loginPageTest()
	{
		String acttitle=loginpage.getLoginPageTitle();
		//print assert mesg if actttile is false
	//	Assert.assertEquals(acttitle, "Account Login",AppError.BROWSER_NOT_FOUND);
		Assert.assertEquals(acttitle,AppConstant.LOGIN_PAGE_TITLE, AppError.BROWSER_NOT_FOUND);
	}
	
	@Test(priority=1)
	public void loginPageURLTest()
	{
		String acturl=loginpage.getLoginPageurl();
		System.out.println(acturl);
		//print assert mesg if acturl  doesnt contain text
	//	Assert.assertTrue(acturl.contains("naveenautomationlabs.com"),AppError.URL_NOT_FOUND);
	//	Assert.assertEquals(acturl.contains(AppConstant.LOGIN_PAGE_FRACTION_URL),AppError.URL_NOT_FOUND);
	}
	
	
	@Test(priority=2)
	public void loginPagecheckForgotPwdLinkTest()
	{
		Assert.assertTrue(loginpage.checkforgotpwdLink(), AppError.LINK_NOT_FOUND);
	}
	
	
	@Test(priority=3)	
	public void loginPagedoLoginTest()
	{
	//	String actualtitle=loginpage.doLogin("prakruthisnadig@gmail.com", "prax@123");
		//bcoz clicking on login button return accountpage object and we are storing of type accountpage
		AccountsPage accpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accpage.getAccountPageTitle(), AppConstant.ACCOUNT_PAGE_TITLE,AppError.TITLE_NOT_FOUND);
	}

}
