package com.qa.opencart.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstant {

	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_PAGE_FRACTION_URL = "route=account/login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String CONFIG_FILE_PATH = "./src/test/resources/config/config.properties";
	public static final String ACCOUNT_PAGE_FRACTION_URL = "route=account/account";
	public static final List<String> ACCOUNT_PAGE_HEADER_LIST = Arrays.asList("My Account", "My Orders",
			"My Affiliate Account", "Newsletter");
	public static final String USER_REGISTER_SUCCESS_MESSG = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "register";

}
