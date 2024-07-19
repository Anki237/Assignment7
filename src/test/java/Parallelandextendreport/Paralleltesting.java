package Parallelandextendreport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Paralleltesting {
	@Test
	public void t() throws InterruptedException {
		Thread.sleep(3000);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		ExtentHtmlReporter htmlrptr = new ExtentHtmlReporter("extent.html");
		ExtentReports extnt = new ExtentReports();
		extnt.attachReporter(htmlrptr);
		Thread.sleep(3000);
		ExtentTest test = extnt.createTest("This is my first test");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		test.info("i passed the username");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		test.info("i pass the password");
		driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
		test.info("i submit");
		extnt.flush();
		String expected=driver.getTitle();
	      Assert.assertEquals("The Internet", expected);
	      System.out.println("Assertion is passed");
		driver.close();
	}
	@Test
	public void t1() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver2=new FirefoxDriver();
		driver2.get("https://the-internet.herokuapp.com/login");
		ExtentHtmlReporter htmlrptr = new ExtentHtmlReporter("extent.html");
		ExtentReports extnt = new ExtentReports();
		extnt.attachReporter(htmlrptr);
		Thread.sleep(3000);
		ExtentTest test = extnt.createTest("This is my second test");
		driver2.findElement(By.id("username")).sendKeys("tomsmith");
		test.info("i passed the username");
		driver2.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		test.info("i pass the password");
		driver2.findElement(By.cssSelector("[type=\"submit\"]")).click();
		test.info("i submit");
		extnt.flush();
		String expected=driver2.getTitle();
	      Assert.assertEquals("The Internet", expected);
	      System.out.println("Assertion is passed");
	      
		driver2.close();
	}
	@Test
	public void t2() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver3=new EdgeDriver();
		driver3.get("https://the-internet.herokuapp.com/login");
		ExtentHtmlReporter htmlrptr = new ExtentHtmlReporter("extent.html");
		ExtentReports extnt = new ExtentReports();
		extnt.attachReporter(htmlrptr);
		Thread.sleep(3000);
		ExtentTest test = extnt.createTest("This is my third test");
		driver3.findElement(By.id("username")).sendKeys("tomsmith");
		test.info("i passed the username");
		driver3.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		test.info("i pass the password");
		driver3.findElement(By.cssSelector("[type=\"submit\"]")).click();
		test.info("i submit");
		extnt.flush();
		String expected=driver3.getTitle();
	      Assert.assertEquals("The Internet", expected);
	      System.out.println("Assertion is passed");
		driver3.close();
	}

}
