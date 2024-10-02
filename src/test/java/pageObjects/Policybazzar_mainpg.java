package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Policybazzar_mainpg extends BasePage {

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public Policybazzar_mainpg(WebDriver driver) {
		super(driver);//Invoking the BasePage Constructor
	}

	//Located all the webElements necessary.
	@FindBy(xpath = "//a[normalize-space()='Insurance Products']")
	WebElement InsuranceDrpdown;

	@FindBy(xpath = "/html/body/div[4]/div[2]/div/ul/li[2]/div/div/div[3]//a[contains(@onclick,'Health Insurance') and @itemprop='url']")
	List<WebElement> ListOfInsurances;

	@FindBy(xpath = "//div[@class='prd-block car']//div[@class='shadowHandlerBox']")
	WebElement carInsuranceBtn;

	@FindBy(xpath = "//div[@class='ruby-col-3']//span[@itemprop='name'][normalize-space()='Home Insurance']")
	WebElement clickHomeIns;

	
	//Added all the action methods necessary.
	public void hover_over() {
		Actions act = new Actions(driver);
		act.moveToElement(InsuranceDrpdown).perform();
	}

	public void printHealthInsuranceList() {

		for (WebElement x : ListOfInsurances) {
			System.out.println(x.getText());
		}
	}

	public void carInsuranceBtnClick() {
		carInsuranceBtn.click();
	}

	public void clickHomeIns() {
		js.executeScript("arguments[0].click();", clickHomeIns);

	}

}
