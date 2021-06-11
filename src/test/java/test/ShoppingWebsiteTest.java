package test;


import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.Dresses;
import pages.HomePage;




public class ShoppingWebsiteTest {
	private static WebDriver driver;

	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();

	}

	@Before
	public void setup() {

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		try {
			driver.get(HomePage.getUrl());
		} catch (TimeoutException e) {

		}
	}

	@AfterClass
	public static void teardown() {
		driver.quit();
	}
 @Test
 public void test() throws InterruptedException {
		HomePage nav = PageFactory.initElements(driver, HomePage.class);
		Dresses add = PageFactory.initElements(driver, Dresses.class);
		
		
		
		nav.navDress();
		Thread.sleep(2000);
		
		add.dress();
		Thread.sleep(2000);
	
		
		
		
 }
}
