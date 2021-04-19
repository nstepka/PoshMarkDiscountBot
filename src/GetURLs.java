import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Dao.WebSiteDao;
import Dao.WebSiteDaoFileImpl;
import Dto.PoshMarkClosets;

public class CreateURLFile {

	public static void main(String[] args) throws InterruptedException {

		final String ROSTER_FILE = "PoshMarkURLs.txt";
		final String DELIMITER = "::";

		Scanner scan = new Scanner(System.in);
		Scanner input = new Scanner(System.in);

		WebSiteDao dao = null;
		PoshMarkClosets poshMarkCloset = new PoshMarkClosets();
		List<String> urlList = new ArrayList();
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// put in your closest url, make sure only to select available items
		String closetURL = "https://poshmark.com/closet/YOUR_CLOSER_HERE?sort_by=price_desc&availability=available";
		driver.get(closetURL);
		Thread.sleep(2000);
		
		//PUT IN YOUR CLOSET SIZE
		int closetSize = 240;
		int pageCounter = 0;
		scrollToButtom(driver, 5);
		WebElement element = driver.findElement(By.tagName("header"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

		for (int x = 1; x <= closetSize; x++) {

			String currentURL = driver
					.findElement(By.xpath(
							"/html/body/div[1]/main/div[2]/div/div[2]/div/div/section/div[2]/div[" + x + "]/div/a[1]"))
					.getAttribute("href");
			System.out.print(currentURL);
			urlList.add(currentURL);
			System.out.println("\nsize of list = " + urlList.size());

		}

		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("PoshMarkURLs.txt"));
		} catch (IOException ex) {
			Logger.getLogger(WebSiteDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
		}

		for (String currentWebsite : urlList) {
			out.println(currentWebsite);

			out.flush();

		}
		out.close();

	}

	public static void scrollToButtom(WebDriver driver, int pageCounter) throws InterruptedException {
		for (int x = 0; x < pageCounter; x++) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(2000);
		}

	}

}
