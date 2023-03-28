package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import Resources.BaseClass;
import Resources.CommonUtilities;
import pageObjectModel.MainMenu_PageObject;

public class MainMenu_TestCase extends BaseClass {

	@Test
	public static void verifyMainMenu() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 WebDriver driver = new ChromeDriver(options);
		 driver.get("https://naveenautomationlabs.com/opencart/");
		 
		MainMenu_PageObject mp=new MainMenu_PageObject(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
//Mouseover to Desktop
		CommonUtilities.mouseOverHandle(mp.desktopMenuClick(),driver);
		mp.desktopShowAllClick().click();    //click on desktop :show all
		mp.desktopAddtoWishlistClick().click(); //added product to wishList
		
//Mouseover to Laptop
		CommonUtilities.mouseOverHandle(mp.laptopMenuClick(),driver);  
		mp.laptopShowAllClick().click();
		mp.laptopListViewClick().click();
		CommonUtilities.handleDropDown(mp.laptopSortByClick(),3);
		CommonUtilities.handleDropDown(mp.laptopShowByClick(),1);
		mp.laptopCompareAddClick().click();
		mp.laptopCompareProductClick().click();
		
//Mouseover to Component
		CommonUtilities.mouseOverHandle(mp.componentMenuClick(),driver); 
		mp.componentOptionClick().click();
		mp.componentGridClick().click();
		
//Mouseover to Mp3Player
		CommonUtilities.mouseOverHandle(mp.mp3playerMenuClick(),driver);
		mp.mp3OptionClick().click();
		
		
		
	}
	
}
