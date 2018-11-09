package exercise;
/* Author: truonganhdung
 * Created Date: 11/09/2018
 * Modified Date: ../../2018
 * https://www.guru99.com/flash-testing-selenium.html
 * */

import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import Flash.FlashObjectWebDriver;

public class V_II_Flash {
	@Test
	public void main() throws InterruptedException {
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "myFlashMovie");
		
		driver.get("http://demo.guru99.com/test/flash-testing.html");
		
		Thread.sleep(2000);
		flashApp.callFlashObject("Play");
		
		Thread.sleep(2000);
		flashApp.callFlashObject("StopPlay");
		
		Thread.sleep(2000);
		flashApp.callFlashObject("SetVariable", "/:message", "Flash testing using selenium Webdriver");
		
		System.out.println(flashApp.callFlashObject("GetVariable", "/:message"));
		
		driver.close();
	}
}