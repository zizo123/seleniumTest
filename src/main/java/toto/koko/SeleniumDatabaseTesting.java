package toto.koko;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDatabaseTesting {
	public static void main(String[] args) {
		// Testdata
		String email = "vivamaroc@rediffmail.com";
		String zipcode = "222222";
		String firstname = "Lucky";
		String lastname = "Singh";

		// Input testdata using Selenium 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\OZ\\Downloads\\Programs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://mailing.dollartree.com/user/signup.jsp");
		driver.findElement(By.xpath("//*[@id='emailAddress']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id='zipCode']")).sendKeys(zipcode);
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(firstname);
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(lastname);
		driver.findElement(By.xpath("//*[@id='subscribeForm']/div[2]/input[4]")).click();
		driver.findElement(By.xpath("//*[@id='subscribeForm']/div[3]/input[2]")).click();

		// Connecting to database
		Connection conn = null;
		String url = "jdbc:h2:~/";
		String databaseName = "test";
		String username = "sa";
		String password = "";
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(url + databaseName, username, password);
			// String sqlQuerry = "Select * from signupdetails";
			String sqlQuerry = "Select * from signupdetails ORDER BY id DESC LIMIT 1";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sqlQuerry);
			result.next();
			System.out.println(result.getString("emailaddress"));
			System.out.println(result.getString("zipcode"));
			System.out.println(result.getString("firstname"));
			System.out.println(result.getString("lastname"));// Database Testing
			if (!result.getString("emailaddress").equals(email))
				System.out.println("email ID is stored wrong");
			if (!result.getString("zipcode").equals(zipcode))
				System.out.println("zipcode is stored wrong");
			if (!result.getString("firstname").equals(firstname))
				System.out.println("firstname is stored wrong");
			if (!result.getString("lastname").equals(lastname))
				System.out.println("lastname is stored wrong");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				conn = null;
			}
		}
	}
}