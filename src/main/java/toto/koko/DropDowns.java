package toto.koko;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDowns {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\OZ\\Downloads\\Programs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://rediff.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//*[@id='signin_info']/a[1]")).click(); //login
		driver.findElement(By.xpath("//a[@title='Create Rediffmail Account']")).click();
		WebElement dropdown = driver.findElement(By.xpath("/html[1]/body[1]/center[1]/form[1]/div[1]/table[2]/tbody[1]/tr[22]/td[3]/select[1]"));
		List<WebElement> option = dropdown.findElements(By.tagName("option"));
		System.out.println(option.size());
		// 32
		/*
		 * List<WebElement> option = driver.findElements(By.tagName("option"));
		 * System.out.println(option.size()); //475
		 */
		String element;
		for (int i = 0; i < option.size(); i++) {
			element = option.get(i).getAttribute("value");
			if (element.equals("25")) {
				option.get(i).click();
			}
		}

	}

}
