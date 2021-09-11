package task;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Prac {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		JavascriptExecutor obj=(JavascriptExecutor)driver;
		WebElement user = driver.findElement(By.id("username"));
		WebElement pass = driver.findElement(By.id("password"));
		obj.executeScript("arguments[0].setAttribute('value','avinashadactin')",user);
		obj.executeScript("arguments[0].setAttribute('value','password')", pass);
	    driver.findElement(By.id("login")).click();
		WebElement loc = driver.findElement(By.id("location"));
		Select s =new Select(loc);
		s.selectByVisibleText("New York");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\task1.png");
		FileUtils.copyFile(src, dest);
		System.out.println("task completed");
		driver.close();
	}

}
