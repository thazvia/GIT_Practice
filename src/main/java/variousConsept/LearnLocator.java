package variousConsept;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnLocator {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://objectspy.space/");
	}

	@Test
	public void testLocator() throws InterruptedException {
		// using name
		// to fill up name/password/username ext
		driver.findElement(By.name("firstname")).sendKeys("sana");
		//driver.findElement(By.name("lastname")).sendKeys("edalath");
		driver.findElement(By.name("Password")).sendKeys("abc123");
		// using id
		// fill radio button or select from lots of option
		driver.findElement(By.id("sex-1")).click();
		// driver.findElement(By.id("exp-2")).click();

		// using css
		
		// TagName#Value Note: (#) represents ID

		driver.findElement(By.cssSelector("input#exp-2")).click();

		// TagName[attribute = ‘value’]
		//driver.findElement(By.cssSelector("input[value= 'Automation Tester']")).click();
		driver.findElement(By.cssSelector("input[type='checkbox'][value='Automation Tester']")).click();
		
		// using class
		// upload file//use robot class in case the element node is not"input"
		driver.findElement(By.className("input-file"))
				.sendKeys("C:\\Users\\thazv\\eclipse-workspace\\Assignments\\bin\\assignment1\\Assignment1.class");
		// using linkText
		// to click on a link
		// driver.findElement(By.linkText("OS-API Product FrontEnd")).click();

		// using partialLinkText
		//driver.findElement(By.partialLinkText("Backend")).click();
		
		//xpath
		//absalute
		
	   driver.findElement(By.xpath("html/body/div/div[2]/div[2]/form/div[10]/input")).sendKeys("selenium fun");
	   
	   driver.findElement(By.xpath("//input[@name='lastname']")).clear();
		//relative path
	   driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("selenium");
	   
	   //more than one attribute
	   driver.findElement(By.xpath("//input[@type='checkbox' and @name='tool' and @id='tool-2']")).click();
	   //click on link on new page
	  driver.findElement(By.xpath("//strong[text()='Link Test : New Page']")).click();
	   //Tag[contains(text(), ‘Value’)]//different method
         driver.findElement(By.xpath("//strong[contains(text(),'Link Test : New Page')]")).click();
         driver.findElement(By.xpath("//strong[text()='Link Test : Page Change']")).click();
         
         
	   
	   
		Thread.sleep(3000);

	}

	//@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}