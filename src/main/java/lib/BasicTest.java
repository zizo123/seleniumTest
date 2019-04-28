package lib;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class BasicTest {
	WebDriver driver;

	@Test
	public void test() throws InterruptedException, MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\OZ\\Downloads\\Programs\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("username", "Zizo123Magic");
        capabilities.setCapability("accessKey", "0A6F0A43DCE54D94B4FDEAD0D3CB1BFB");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("version", "59.0");
        capabilities.setCapability("name", "4-best-practices");
		driver = new RemoteWebDriver(
				new URL("http://Zizo123Magic:0A6F0A43DCE54D94B4FDEAD0D3CB1BFB@ondemand.saucelabs.com:80/wd/hub"),
				capabilities);
		Thread.sleep(10000);
		driver.get("http://www.rediff.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='signin_info']/a[1]")).click();
		Thread.sleep(5000);
		driver.quit();
	}
}