package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarInsurancePage extends BasePage{

	public CarInsurancePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[@class='CarRegDetails_blueTextButton__P1blP blueTextButton fontMedium']")
	WebElement clickHere;
	
	@FindBy(xpath="//input[@class='form-control' and @name='searchTerm']")
	WebElement City_Rto_searchbar;
	
	@FindBy(xpath="//div[@class='options open']//div[1]")
	WebElement dropdown_RTO_Options;
	
	@FindBy(xpath="//input[@placeholder='Search Car Make']")
	WebElement car_searchbar;
	
	@FindBy(xpath="//div[@class='options open']//div[1]")
	WebElement car_search_options;
	
	@FindBy(xpath="//li[normalize-space()='Petrol']")
	WebElement select_fuleType;
	
	@FindBy(xpath="//input[@placeholder='Search Car Vaiants']")
	WebElement carvarient_SearchBox;
	
	@FindBy(xpath="//div[@class='options open']/div[1]")
	WebElement clickCarVarient;
	
	@FindBy(xpath="//input[@placeholder='Full name']")
	WebElement name_Bar;
	
	@FindBy(xpath="//input[@placeholder='Mobile number']")
	WebElement mobile_bar;
	
	@FindBy(xpath="//div[@class='errorMsg']")
	List<WebElement> errMsgs;
	
	@FindBy(xpath="//button[@class='primaryBtnV2 width-100']")
	WebElement FindPlanBtn;
	
	public void clickHereBtn() {
		clickHere.click();
	}
	
	public void Search_City_Rto() {
		City_Rto_searchbar.sendKeys("Pune");
	}
	
	public void click_RTO_Option() {
		dropdown_RTO_Options.click();
	}
	
	public void carSearch() {
		car_searchbar.sendKeys("Honda");
	}
	
	public void clickcarOptions() {
		car_search_options.click();
	}
	
	public void click_fuelType() {
		select_fuleType.click();
	}
	
	public void car_varient() {
		carvarient_SearchBox.sendKeys("2.3 VTi AUTO TRANSMISSION (2254 cc)");
	}
	
	public void clk_CarVarient() {
		clickCarVarient.click();
	}
	
	public void send_name() {
		name_Bar.sendKeys("@");
	}
	
	
	
	public void enter_mobileNo() {
		mobile_bar.sendKeys("Anurag");
	}
	

	
	public void printErrMsgs() {
		for(WebElement x:errMsgs) {
			System.out.println(x.getText()); 
		}
	}
	
	public void clickFindPlan() {
		FindPlanBtn.click();;
	}

}
