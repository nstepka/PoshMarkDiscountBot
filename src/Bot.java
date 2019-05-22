import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.poshmark.com/login");
		Thread.sleep(1000);

		// posh store user email address youemailhere@makemoney.com
		String emailAddress = "mafe.strait@gmail.com";

		driver.findElement(By.id("login_form_username_email")).sendKeys(emailAddress);
		Thread.sleep(1000);
		// login_form_password

		// poshmark password yourpasswordhere
		String password = "M@fe1234";

		driver.findElement(By.id("login_form_password")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.className("btn-primary")).click();
		Thread.sleep(1000);
		// enter your closet your
		String closetURL = "https://poshmark.com/closet/fe_stepka";
		driver.get(closetURL);

		Thread.sleep(1500);
		driver.findElement(By.xpath("//label[contains(text(),'Available')]")).click();
		Thread.sleep(10000);
		
		// I havent figured out how to only find none sold items yet so you
		// have to manually enter how many for sale for now
		int closetSize = 197;

		for (int x = 89; x < closetSize; x++) {
			scrollToButtom(driver);
			List<WebElement> elements = driver.findElements(By.className("tile"));

			//
			System.out.println(x);

			// clicks a item for sale to go to the sale page

			//
			// elements.get(x).findElement(By.xpath("//div[@id='5ca81d31600ebc83eebb1efe']//i[@class='icon
			// inventory-tag sold-tag'][contains(text(),'Sold')]"));

			elements.get(x).click();
			// Thread.sleep(1000);
			// select price drop
			driver.findElement(By.xpath("//a[contains(text(),'Price Drop')]")).click();
			Thread.sleep(1000);
			// select offer to likers
			driver.findElement(By.xpath("//span[contains(text(),'Offer to Likers (Private)')]")).click();
			Thread.sleep(1500);

			// click the calc to bring up discount
			driver.findElement(By.xpath("//i[@id='offer_to_likers_calculator']")).click();
			Thread.sleep(1500);
			WebDriverWait d = new WebDriverWait(driver, 20);
			d.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@class='offer_button'][contains(text(),'10% off')]")))
					.click();

			// click the discount %
			// div[contains(text(),'10% off')]
			// driver.findElement(By.xpath("//div[@class='offer_button'][contains(text(),'10%
			// off')]")).click();
			// driver.findElement(By.xpath("//div[contains(text(),'10% off')]")).click();//
			// 10% discount
			// driver.findElement(By.xpath("//div[@class='offer_button'][contains(text(),'20%
			// off')]")).click();
			// Thread.sleep(1000);

			// click the apply offer button
			driver.findElement(By.xpath("//button[@class='btn blue submit_button']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//span[@id='shipping-discount-selection']")).click();

			// select the discount amount, i selected $1.80
			d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html[1]/body[1]/main[1]/div[2]/form[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]")))
					.click();
			// Thread.sleep(1000);

			// select the submit button
			d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn blue']"))).click();
			Thread.sleep(1000);

			// select the continue button
//			d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn blue'][contains(text(),'Continue')]"))).click();
			driver.findElement(By.xpath("//a[@class='btn blue'][contains(text(),'Continue')]")).click();
			Thread.sleep(700);

			// go back to closet
			driver.get("https://poshmark.com/closet/fe_stepka");

		}

	}

	public static void scrollToButtom(WebDriver driver) throws InterruptedException {
		for (int x = 0; x < 4; x++) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(2000);
		}

	}
}
