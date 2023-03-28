package testCases;



import java.time.Duration;

import org.testng.annotations.Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Resources.BaseClass;
import Resources.CommonUtilities;
import Resources.Constant;
import pageObjectModel.AddToCart_Product_PageObject;

public class AddToCart_Product_TestCase extends BaseClass {
	
	@Test
	public static void VerifyAddToCartProduct() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		
		 options.addArguments("--remote-allow-origins=*");
	 
		 WebDriver driver = new ChromeDriver(options);
		 
		 driver.get("https://naveenautomationlabs.com/opencart/");
		 
		AddToCart_Product_PageObject mp = new AddToCart_Product_PageObject(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		mp.searchEnter().sendKeys(Constant.search); //search text enter(iphone)
		mp.searchBtnClick().click();  //search button click
		mp.addtocartClick().click();  //add to cart click
		
		//For 1st product price
		String price1 =mp.priceCheck().getText();
		double d1=CommonUtilities.productPriceHandle(price1);
		
		mp.searchEnter().clear();  //to clear previous entered text
		
		mp.searchEnter().sendKeys(Constant.search1); //search text enter(samsung)
		mp.searchBtnClick().click();  //search button click
		mp.addtocartClick().click();  //add to cart click
		
		//For 2nd product price
		String price2 =mp.priceCheck().getText();
		double d2=CommonUtilities.productPriceHandle(price2);

		//total price of products
		double add=d1+d2;
		String actualPriceconvert=Double.toString(add); //convert double to string for adding $
		String actualPrice=("$"+actualPriceconvert);
		System.out.println("Actual Addition of price:"+actualPrice);
		Thread.sleep(2000);

		mp.totalItemBtnClick().click(); //Total item click
		String expectedPriceCart=mp.expectedTotalPriceCheck().getText();
		double d3=CommonUtilities.productPriceHandle(expectedPriceCart);//Expected Price from cart
		String expectedPriceConvert=Double.toString(d3); //convert expected price into double
		String expectedPrice=("$"+expectedPriceConvert);
		
		System.out.println("Expected addition :"+expectedPrice);
		if(actualPrice.equals(expectedPrice))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		}

}
