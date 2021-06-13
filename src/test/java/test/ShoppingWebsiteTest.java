package test;


import static org.junit.Assert.assertTrue;


import org.junit.After;

import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Dresses;
import pages.HomePage;
import pages.TShirt;
import pages.Women;

public class ShoppingWebsiteTest {
	
	private WebDriver driver;
	private WebElement search;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
	}

	// 1
	@Test
	public void lookForItem() throws InterruptedException {

		String item = "Hijab";

		HomePage homePage = new HomePage(driver);
		driver.get(HomePage.getUrl());

		Dresses dressespage = new Dresses(driver);
		TShirt tshirtspage = new TShirt(driver);
		Women womenpage = new Women(driver);

		dressespage.dresses();
		dressespage.searchItem(item);
		Thread.sleep(5000);

		womenpage.women();
		womenpage.searchItem(item);
		Thread.sleep(5000);

		tshirtspage.tshirt();
		tshirtspage.searchItem(item);
		Thread.sleep(5000);

		WebElement target1 = dressespage.searchAssert(item);
		WebElement target2 = womenpage.searchAssert(item);
		WebElement target3 = tshirtspage.searchAssert(item);

		String resultText1 = target1.getText();
		String resultText2 = target2.getText();
		String resultText3 = target3.getText();

		Boolean res1 = resultText1.contains("No results were found for your search ");
		Boolean res2 = resultText2.contains("No results were found for your search ");
		Boolean res3 = resultText3.contains("No results were found for your search ");

		assertTrue(res1);
		assertTrue(res2);
		assertTrue(res3);
		Thread.sleep(5000);
	}


	@After
	public void tearDown() {
		driver.close();
	}
}
