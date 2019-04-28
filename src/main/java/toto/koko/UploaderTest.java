package toto.koko;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploaderTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\OZ\\Downloads\\Programs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://tinypic.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//*[@id='the_file']")).sendKeys("C:\\Users\\OZ\\Documents\\yourclaimbadge.txt");
		//AutoIt
		
		  driver.findElement(By.xpath("//*[@id='the_file']")).click();
		  Thread.sleep(1000);
		  Runtime.getRuntime().exec("C:\\Users\\OZ\\Documents\\AutoItScript.exe");
		}
}