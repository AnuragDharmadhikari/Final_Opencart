package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CarInsurancePage;
import pageObjects.Policybazzar_mainpg;
import testBase.BaseClass;

public class TC_03_TestingCarInsuranceErrorMsg extends BaseClass {

	@Test
	public void checkErrMsg() {
		logger.info("**** TC_03_TestingCarInsuranceErrorMsg *****");

		try {
			logger.info("policybazzar main page ");
			Policybazzar_mainpg pg = new Policybazzar_mainpg(driver);
			pg.carInsuranceBtnClick();

			logger.info("CarInsurance main page ");
			CarInsurancePage car = new CarInsurancePage(driver);

			car.clickHereBtn();
			car.Search_City_Rto(p.getProperty("RTO_City"));
			car.click_RTO_Option();
			car.carSearch(p.getProperty("CarBrand"));
			car.clickcarOptions();
			car.click_fuelType();
			car.car_varient(p.getProperty("Car_Varient"));
			car.clk_CarVarient();
			car.send_name(p.getProperty("Name"));
			car.enter_mobileNo(p.getProperty("MobileNo"));
			car.printErrMsgs();
		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}

		logger.info("**** Finished TC_03_TestingCarInsuranceErrorMsg *****");

	}
}
