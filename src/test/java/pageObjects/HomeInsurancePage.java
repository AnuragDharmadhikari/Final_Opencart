package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeInsurancePage extends BasePage {

	JavascriptExecutor js = (JavascriptExecutor) driver;

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

	@FindBy(xpath = "//span[normalize-space()='Pune']")
	WebElement enterCity;

	@FindBy(xpath = "//div[@class='proceedBtn btnHIStep2 loader']")
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
		name.sendKeys("Ram");
	}

	public void enterMobileNo() {
		mobile.sendKeys("9087612543");
	}

	public void clickQuotesButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(freeQuotesBtn));
		js.executeScript("arguments[0].click();", freeQuotesBtn);
	}

	public void selectCityName() {
		js.executeScript("arguments[0].click();", enterCity);

	}

	public void clickViewPlanBtn() {
		js.executeScript("arguments[0].click();", clickViewPlans);
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

	public void insurersPlansList() {
		for (WebElement ls : insurersPlans) {
			System.out.println(ls.getText());
		}
	}
}
