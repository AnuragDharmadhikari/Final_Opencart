package pageObjects;
 
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import utilities.ExcelUtility;
 
public class HomeInsurancePage extends BasePage {
 
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
	public HomeInsurancePage(WebDriver driver) {
		super(driver);//Invoking the BasePage Constructor
	}
 
	//Located all the webElements necessary.
	@FindBy(xpath = "//input[@id='homename_hi']")
	WebElement name;
 
	@FindBy(xpath = "//input[@id='homemobile_hi']")
	WebElement mobile;
 
	@FindBy(xpath = "//div[text()='View Free Quotes']")
	WebElement freeQuotesBtn;
 
	@FindBy(xpath="//label[@for='home-insurance']")
	WebElement selectHomeInsPln;
 
	@FindBy(xpath="//div[@class='proceedBtn btnHIStep2 loader']")
	WebElement clickViewPlans;
 
	@FindBy(xpath = "//input[@id='StructureValue']")
	WebElement houseValue;
 
	@FindBy(xpath = "//input[@id='ContentValue']")
	WebElement houseItemsValue;
 
	@FindBy(xpath = "//button[normalize-space()='View Prices']")
	WebElement viewPricesBtn;
 
	@FindBy(xpath = "//div[@class=' insurers-plan']")
	List<WebElement> insurersPlans;
 
	
	//Added all the action methods necessary.
	public void enterName() {
		name.sendKeys("Kunal");
	}
 
	public void enterMobileNo() {
		mobile.sendKeys("9087612543");
	}
 
	public void clickQuotesButton() {
		wait.until(ExpectedConditions.elementToBeClickable(freeQuotesBtn));
		js.executeScript("arguments[0].click();", freeQuotesBtn);
	}
 
	public void selectHomeIns() {
		selectHomeInsPln.click();
	}
 
	public void clickViewPlanBtn() throws InterruptedException {
//		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(clickViewPlans));
		js.executeScript("arguments[0].click();", clickViewPlans);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='View Prices']")));
	}
 
	public void enterHouseVlaue() {
		houseValue.sendKeys("5000000");
	}
 
	public void enterHouseItemsValue() {
		houseItemsValue.sendKeys("500000");
	}
 
	public void clickPricesBtn() {
		viewPricesBtn.click();
	}
 
	public  void insurersPlansListForExcel() throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String path = "C:\\Users\\2355163\\eclipse-workspace\\FinalProject\\testData\\Home"+timeStamp+".xlsx";
		ExcelUtility eu=new ExcelUtility(path);
		eu.createExcelFile(insurersPlans);
	}
}