package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Policybazzar_mainpg;
import testBase.BaseClass;

public class TC_01_ListOfHealthInsurances extends BaseClass{

	@Test
	public void HealthInsListPrint() {
		
		logger.info("**** Starting TC_01_ListOfHealthInsurances *****");
		
		try {
			
			//Policybazzar page
			Policybazzar_mainpg pg = new Policybazzar_mainpg(driver);
			pg.hover_over();
			pg.printHealthInsuranceList();
			
		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		
		logger.info("**** TC_01_ListOfHealthInsurances *****");
	}
}
