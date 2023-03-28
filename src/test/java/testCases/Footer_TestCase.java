package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import Resources.BaseClass;
import pageObjectModel.Footer_PageObject;

public class Footer_TestCase extends BaseClass{

	@Test
	public static void verifyFooter()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 
		 WebDriver driver = new ChromeDriver(options);
		 driver.get("https://naveenautomationlabs.com/opencart/");
		
		Footer_PageObject fpo=new Footer_PageObject(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
//Information
		fpo.aboutUsClick().click();
		fpo.deliveryInfoClick().click();
		fpo.privacyPolicyClick().click();
		fpo.termsAndConditionsClick().click();
		
//Customer Service
		fpo.contactUsClick().click();
		fpo.returnsClick().click();
		fpo.siteMapClick().click();
		
//Extras
		fpo.brandClick().click();
		fpo.giftCertificatesClick().click();
		fpo.affiliateClick().click();
		fpo.specialsClick().click();
		
		
		
	}
}
