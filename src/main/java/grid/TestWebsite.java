package grid;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestWebsite extends BaseClass{

	private static final String DIV_CSS = "//div[@class='w3-bar-block']//a[@class='w3-bar-item w3-button'][contains(text(),'Learn CSS')]";
	private static final String DIV_HTML = "//div[@class='w3-bar w3-left']//a[@class='w3-bar-item w3-button'][contains(text(),'HTML')]";

	@Test
	public void test_01() throws InterruptedException {
		driver.get("https://www.w3schools.com/");
		Thread.sleep(1000);
		driver.findElement(By.xpath(DIV_CSS)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(DIV_HTML)).click();
		Thread.sleep(1000);
	}
	
	@Test
	public void test_02() throws InterruptedException {
		driver.get("https://www.w3schools.com/");
		Thread.sleep(1000);
		driver.findElement(By.xpath(DIV_CSS)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(DIV_HTML)).click();
		Thread.sleep(1000);
	}
}
