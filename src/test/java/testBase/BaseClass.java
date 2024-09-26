package testBase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger; 

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups = { "Master", "Sanity", "Regression", "datadriven" }) 
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException
	{
		
		//loading properties file
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
	
		//loading log4j file
		logger=LogManager.getLogger(this.getClass());//Log4j
		
		// Launching browser based on condition
		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
		    DesiredCapabilities capabilities = new DesiredCapabilities();

		    // OS
		    if (os.equalsIgnoreCase("windows")) {
		        capabilities.setPlatform(Platform.WIN11);
		    } else if (os.equalsIgnoreCase("mac")) {
		        capabilities.setPlatform(Platform.MAC);
		    } else {
		        System.out.println("No matching OS");
		        return;
		    }

		    // Browser
		    switch (br.toLowerCase()) {
		        case "chrome":
		            WebDriverManager.chromedriver().setup();
		            capabilities.setBrowserName("chrome");
		            break;
		        case "edge":
		            WebDriverManager.edgedriver().setup();
		            capabilities.setBrowserName("MicrosoftEdge");
		            break;
		        default:
		            System.out.println("No matching browser");
		            return;
		    }

		    try {
		        URI uri = new URI("http://localhost:4444/wd/hub");
		        driver = new RemoteWebDriver(uri.toURL(), capabilities);
		    } catch (URISyntaxException e) {
		        e.printStackTrace();
		    }
		}
		
				
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{

			switch(br.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver(); break;
			case "edge" : driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name.."); return;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("projURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups = { "Master", "Sanity", "Regression", "datadriven" })
	public void tearDown()
	{
		if (driver != null) {
            driver.quit();
        }
	}
	

	public String randomString() {
	    RandomStringGenerator generator = new RandomStringGenerator.Builder()
	            .withinRange('a', 'z')
	            .build();
	    return generator.generate(5);
	}
	
	public String randomNumber() {
	    RandomStringGenerator generator = new RandomStringGenerator.Builder()
	            .withinRange('0', '9')
	            .build();
	    return generator.generate(10);
	}
	
	public String randomAlphaNumeric() {
	    RandomStringGenerator alphaGenerator = new RandomStringGenerator.Builder()
	            .withinRange('a', 'z')
	            .build();
	    RandomStringGenerator numericGenerator = new RandomStringGenerator.Builder()
	            .withinRange('0', '9')
	            .build();
	    return alphaGenerator.generate(3) + "@" + numericGenerator.generate(3);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
}
