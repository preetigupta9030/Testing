package com.abhishek;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoSingupLogin {

	private Object keys;
	static String aToz = "abcdefghijklmnopqrstuvwxyz";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Abhishek Gupta/Downloads/chromedriver_win32/chromedriver.exe");

		// Instantiate a ChromeDriver class.
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo8-marketplace.cedcommerce.com/2.4.5/advance_starter/pub/");
		driver.manage().window().maximize();
		// Seller Signup

		String user = generateRandom(aToz);
		// Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//a[@id='signup-nav']")).click();
		driver.findElement(By.name("firstname")).sendKeys(user);
		driver.findElement(By.name("lastname")).sendKeys("user");
		driver.findElement(By.name("email")).sendKeys(user + "@gmail.com");
		driver.findElement(By.name("vendor[public_name]")).sendKeys(user);
		driver.findElement(By.name("vendor[shop_url]")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.name("password_confirmation")).sendKeys("Password123");
		driver.findElement(By.xpath("//label[@for='terms']")).click();
		driver.findElement(By.xpath("//button[@id='submit_button_id']")).click();

		// open new tab

		driver.switchTo().newWindow(WindowType.TAB);

		// admin login
		driver.get("https://demo8-marketplace.cedcommerce.com/2.4.5/advance_starter/pub/admin/");
		driver.findElement(By.name("login[username]")).sendKeys("admin");
		driver.findElement(By.name("login[password]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@class='action-login action-primary']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Marketplace']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//li[contains(@data-ui-id,'menu-ced-csmarketplace-manage-vendor')]//li[contains(@role,'menu-item')]"))
				.click();
		driver.findElement(By.xpath("//input[@id='vendorGrid_vendor_filter_email']")).sendKeys(user + "@gmail.com");
		driver.findElement(By.xpath("//button[@class='action-default scalable action-secondary']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[normalize-space()='Approve'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='action-primary action-accept']")).click();
		Thread.sleep(2000);
		// open new tab
		// seller login
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demo8-marketplace.cedcommerce.com/2.4.5/advance_starter/pub/csmarketplace/");
		driver.findElement(By.xpath("//a[@id='Signin-nav']")).click();
		driver.findElement(By.xpath("//input[@name=\"login[username]\"]")).sendKeys("jenny@gmail.com");
		driver.findElement(By.xpath("//input[@name=\"login[password]\"]")).sendKeys("Password123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='send2']")).click();

	}

	/*
	 * This method is for generation of random string
	 */
	private static String generateRandom(String aToZ) {
		Random rand = new Random();
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			int randIndex = rand.nextInt(aToZ.length());
			res.append(aToZ.charAt(randIndex));
		}
		return res.toString();
	}

}
