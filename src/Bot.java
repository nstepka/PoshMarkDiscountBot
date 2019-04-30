import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bot {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
	

		// you need to start the exe first
		// Create Driver Object.
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.poshmark.com/login");
		Thread.sleep(1000);

		// posh store user email address youemailhere@makemoney.com
		String emailAddress = "youemailhere@makemoney.com";
		driver.findElement(By.id("login_form_username_email")).sendKeys(emailAddress);
		// login_form_password

		// poshmark password yourpasswordhere
		String password = "yourpasswordhere";

		driver.findElement(By.id("login_form_password")).sendKeys(password);
		driver.findElement(By.className("btn-primary")).click();

		// enter your closet your
		String closetURL = "https://poshmark.com/closet/fe_stepka";
		driver.get(closetURL);

		// I havent figured out how to only find none sold items yet so you
		// have to manually enter how many for sale for now
		int closetSize = 201;

		for (int x = 0; x < closetSize; x++) {
			scrollToButtom(driver);
			List<WebElement> elements = driver.findElements(By.className("tile"));
			System.out.println(elements.size());

			// clicks a item for sale to go to the sale page
			elements.get(x).click();
			Thread.sleep(1500);
			// select price drop
			driver.findElement(By.xpath("//a[contains(text(),'Price Drop')]")).click();
			Thread.sleep(1500);
			// select offer to likers
			driver.findElement(By.xpath("//span[contains(text(),'Offer to Likers (Private)')]")).click();
			Thread.sleep(1500);

			// click the calc to bring up discount
			driver.findElement(By.xpath("//i[@id='offer_to_likers_calculator']")).click();
			Thread.sleep(1500);

			// click the discount %
			driver.findElement(By.xpath("//div[contains(text(),'10% off')]")).click();
			Thread.sleep(1500);

			// click the apply offer button
			driver.findElement(By.xpath("//button[@class='btn blue submit_button']")).click();
			Thread.sleep(1500);

			// select the shipping discount
			driver.findElement(By.xpath("//span[@id='shipping-discount-selection']")).click();
			Thread.sleep(1500);

			// select the discount amount, i selected $1.80
			// driver.findElement(By.xpath("//body/main[contains(@class,'experiences-header')]/div[@id='new_offer_bundle']/form[@id='bundle_offer_form']/div[@class='modal-body']/div[@class='offer-container']/div[@class='form-group']/div[@class='seller_shipping_discount_offer']/div[@class='col-form-control']/div[@class='dropdown
			// open']/div[@class='dropdown-menu']/div[1]")).click();
			Thread.sleep(1500);

			// select the submit button
			driver.findElement(By.xpath("//button[@class='btn blue']")).click();
			Thread.sleep(1500);

			// select the continue button
			driver.findElement(By.xpath("//a[@class='btn blue'][contains(text(),'Continue')]")).click();
			Thread.sleep(1500);

			// go back to closet
			driver.get("https://poshmark.com/closet/fe_stepka");

		}

	}

	public static void scrollToButtom(WebDriver driver) throws InterruptedException {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
	}
}
