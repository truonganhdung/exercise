package exercise;
/* Author: truonganhdung
 * Created Date: 11/09/2018
 * Modified Date: ../../2018
 * https://www.guru99.com/verify-tooltip-selenium-webdriver.html
 * */

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class V_I_Tooltip {
	@Test
	public void main() throws Exception {

		String baseUrl = "http://demo.guru99.com/test/tooltip.html";
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		String expectedTooltip = "What's new in 3.2";
		driver.get(baseUrl);

		WebElement download = driver.findElement(By.xpath(".//*[@id='download_now']"));
		Actions builder = new Actions(driver);

		builder.clickAndHold().moveToElement(download);
		builder.moveToElement(download).build().perform();

		WebElement toolTipElement = driver.findElement(By.xpath(".//*[@class='box']/div/a"));
		String actualTooltip = toolTipElement.getText();

		System.out.println("Actual Title of Tool Tip  " + actualTooltip);
		if (actualTooltip.equals(expectedTooltip)) {
			System.out.println("Test Case Passed");
		}

		Thread.sleep(2000);
		driver.close();
	}
}