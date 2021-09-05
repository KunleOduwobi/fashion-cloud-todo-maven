package FashionCloud.ToDoList;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	@Test
	public void verifyTasks() throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();

		// Go to localhost
		driver.get("http://localhost:8080/");

		// Wait for page to load
		Thread.sleep(10000);

		// Verify that header is displayed
		String Header = driver.findElement(By.xpath("/html/body/div[1]/div[1]/h1")).getText();
		AssertJUnit.assertEquals(Header, "Simple ToDo List 0");
		System.out.println("Expected header found");

		// Add first Item
		driver.findElement(By.xpath("//*[@id=\"todo-form\"]/div/form/div/input")).sendKeys("Item 1");
		driver.findElement(By.xpath("//*[@id=\"todo-form\"]/div/form/button")).click();
		Thread.sleep(2000);

		// Verify first item was added
		String Count = driver.findElement(By.xpath("/html/body/div[1]/div[1]/h1/span")).getText();
		AssertJUnit.assertEquals(Count, "1");
		System.out.println("Item 1 added successfully");

		// Add second Item
		driver.findElement(By.xpath("//*[@id=\"todo-form\"]/div/form/div/input")).sendKeys("Item 2");
		driver.findElement(By.xpath("//*[@id=\"todo-form\"]/div/form/button")).click();
		Thread.sleep(2000);

		// Verify item was added
		Count = driver.findElement(By.xpath("/html/body/div[1]/div[1]/h1/span")).getText();
		AssertJUnit.assertEquals(Count, "2");
		System.out.println("Item 2 added successfully");

		// Remove second item
		driver.findElement(By.xpath("//*[@id=\"todo-list\"]/div/div[2]/label/input")).click();
		Thread.sleep(2000);

		// Verify that 2nd item was removed

		java.util.List<WebElement> Items = driver.findElements(By.xpath("//input[@type='checkbox']"));

		int ItemsSize = Items.size();
		AssertJUnit.assertEquals(ItemsSize, 1);
		System.out.println("Item 2 removed successfully");

		// Remove first item
		driver.findElement(By.xpath("//*[@id=\"todo-list\"]/div/div/label")).click();
		Thread.sleep(2000);

		// Verify that 2nd item was removed
		Count = driver.findElement(By.xpath("/html/body/div[1]/div[1]/h1/span")).getText();
		AssertJUnit.assertEquals(Count, "0");
		System.out.println("Item 1 added successfully");
		System.out.println("Item 1 removed successfully");

		System.out.println("Test Completed!");

		driver.quit();

	}
}
