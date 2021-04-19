import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Dao.WebSiteDaoFileImpl;
import Dto.PoshMarkClosets;

public class ReadURLAndOffer {

	public static void main(String[] args) throws InterruptedException {

		final String ROSTER_FILE = "PoshMarkURLs.txt";
		final String DELIMITER = "::";
		String emailAddress = "your.email@gmail.com";
		String password = "yourPassword";
		Scanner scan = new Scanner(System.in);
		Scanner input = new Scanner(System.in);

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.poshmark.com/login");
		Thread.sleep(3000);

		driver.findElement(By.id("login_form_username_email")).sendKeys(emailAddress);
		Thread.sleep(1000);

		driver.findElement(By.id("login_form_password")).sendKeys(password);
		Thread.sleep(1000);
		System.out.println("hi4");
		driver.findElement(By.className("btn-primary")).click();
		Thread.sleep(1000);

		Scanner sc = null;
		try {
			sc = new Scanner(new BufferedReader(new FileReader("PoshMarkURLs.txt")));

		} catch (FileNotFoundException ex) {
			Logger.getLogger(WebSiteDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
		}

		String currentLine;
		List<String> urlList = new ArrayList<String>();
		System.out.println("hi6");
		while (sc.hasNextLine()) {
			currentLine = sc.nextLine();
			System.out.println(currentLine);
			urlList.add(currentLine);
		}
		sc.close();
		Thread.sleep(3000);
		System.out.println("URL LIST SIZE = " + urlList.size());
		for (int x = 10; x < urlList.size(); x++) {
			driver.get(urlList.get(x));
			System.out.println(x);
			Thread.sleep(1000);
			String checkIfSold = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div/div[3]/div/div/h1"))
					.getText();

			System.out.println(checkIfSold);
			System.out.println(checkIfSold.equals("THIS ITEM IS SOLD!"));


			driver.findElement(By.xpath("//button[@class='btn btn--secondary btn--large m--t--3 col-x24']")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@class='btn btn--secondary']")).click();
			Thread.sleep(1500);

			driver.findElement(By.xpath(
					"/html/body/div[1]/main/div[2]/div/div/div[3]/div[2]/div[5]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/form/div[1]/div"))
					.click();

			//discount % click 1 2 or 3
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"/html/body/div[1]/main/div[2]/div/div/div[3]/div[2]/div[5]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/button[1]"))
					.click();

			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"/html/body/div[1]/main/div[2]/div/div/div[3]/div[2]/div[5]/div[2]/div/div[2]/div[2]/div[2]/div[3]/div/button[2]"))
					.click();

			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"/html/body/div[1]/main/div[2]/div/div/div[3]/div[2]/div[5]/div[2]/div/div[2]/div[1]/div[2]/div[3]/div/button[2]"))
					.click();

			Thread.sleep(2000); 
			driver.findElement(By.xpath(
					"/html/body/div[1]/main/div[2]/div/div/div[3]/div[2]/div[5]/div[2]/div/div[2]/div[2]/div[3]/button"))
					.click();
			
			Thread.sleep(2000);

		}
	}

}
