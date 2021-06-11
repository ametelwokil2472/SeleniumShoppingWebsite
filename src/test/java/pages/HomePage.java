package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	private static final String URL = "http://automationpractice.com/index.php";

	@FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[1]/a[1]")
	private WebElement women;

	@FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")
	private WebElement dress;
	
	@FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[3]/a[1]")
	private WebElement tShirt;

	public static String getUrl() {
		return URL;
	}

	public void navWomen() {
		women.click();
	}

	public void navDress() {
		dress.click();
			}
	public void navtShirt() {
		tShirt.click();
	}
}
