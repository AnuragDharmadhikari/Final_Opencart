package testCases;

import org.testng.annotations.Test;

import pageObjects.CarInsurancePage;
import pageObjects.Policybazzar_mainpg;
import testBase.BaseClass;

public class TC_03_TestingCarInsuranceErrorMsg extends BaseClass{

	@Test
	public void checkErrMsg() {
		logger.info("**** TC_03_TestingCarInsuranceErrorMsg *****");
		
		logger.info("policybazzar main page ");
		Policybazzar_mainpg pg = new Policybazzar_mainpg(driver);
		pg.carInsuranceBtnClick();
		
		logger.info("CarInsurance main page ");
		CarInsurancePage car = new CarInsurancePage(driver);
		
		car.clickHereBtn();
		car.Search_City_Rto();
		car.click_RTO_Option();
		car.carSearch();
		car.clickcarOptions();
		car.click_fuelType();
		car.car_varient();
		car.clk_CarVarient();
		car.send_name();
		car.enter_mobileNo();
		car.printErrMsgs();

		
		logger.info("**** Finished TC_03_TestingCarInsuranceErrorMsg *****");
		
	}
} 
