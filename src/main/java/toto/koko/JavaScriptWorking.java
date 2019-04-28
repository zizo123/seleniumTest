package toto.koko;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptWorking {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\OZ\\Downloads\\Programs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.javascriptkit.com/javatutors/event2.shtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//input[@value='Click me']")).click();
		//((JavascriptExecutor) driver).executeScript("inform()");
		((JavascriptExecutor) driver).executeScript("document.getElementsByName('fd0')[0].click()");
	}
}