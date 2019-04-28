package toto.koko;

import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstLoginAttempt {

	static String passwordEncoded = "dGVzdA==";
	
	public static void main(String... str) {
		//CollectionUtils.emptyIfNull(null);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\OZ\\Downloads\\Programs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rediff.com/");

		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='signin_info']/a[1]")).click();//login page
		
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys("");//login

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(getDecodedPassword());//pass
		
		driver.findElement(By.xpath("//input[@title='Sign in']")).click();//submit button

	}
	public static String getDecodedPassword() {	
		return new String(Base64.getDecoder().decode(passwordEncoded.getBytes()));
	}
}
