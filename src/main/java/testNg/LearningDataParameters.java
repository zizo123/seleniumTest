package testNg;

import org.testng.annotations.Test;

public class LearningDataParameters {
	@Test(dataProviderClass = TestDataFile.class, dataProvider = "data")
	public void registerUser(String firstname, String lastname, String email, String password) {
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(email);
		System.out.println(password);
	}

	@Test(dataProviderClass = TestDataFile.class, dataProvider = "data")
	public void LoginUser(String email, String password) {
		System.out.println(email);
		System.out.println(password);
	}
}