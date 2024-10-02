package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomeInsurancePage;
import pageObjects.Policybazzar_mainpg;
import testBase.BaseClass;

public class TC_04_TestingHomeInsurance extends BaseClass {

	@Test
	public void retrunHomeInsurancePolicy() {

		logger.info("**** Started TC_04_TestingHomeInsurance *****");

		try {
			logger.info("policybazzar main page object created ");
			Policybazzar_mainpg pg = new Policybazzar_mainpg(driver);
			pg.hover_over();
			pg.clickHomeIns();

			logger.info("Home insurance page object created ");
			HomeInsurancePage hip = new HomeInsurancePage(driver);
			hip.enterName();
			hip.enterMobileNo();
			hip.clickQuotesButton();
			hip.selectCityName();
			hip.clickViewPlanBtn();
			hip.enterHouseVlaue();
			hip.enterHouseItemsValue();
			hip.clickPricesBtn();
			hip.insurersPlansList();
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}

		logger.info("**** Finished TC_04_TestingHomeInsurance *****");

	}
}
