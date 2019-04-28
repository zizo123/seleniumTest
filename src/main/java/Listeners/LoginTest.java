package Listeners;

import org.testng.annotations.Test;

public class LoginTest {
	@Test
	public void loginwithEmail() {
		System.out.println("Inside test login with email");
	}

	@Test
	public void loginwithFacebook() {
		System.out.println("Inside test login with Facebook");
		//Assert.assertEquals("testString", "testString1");
	}
}