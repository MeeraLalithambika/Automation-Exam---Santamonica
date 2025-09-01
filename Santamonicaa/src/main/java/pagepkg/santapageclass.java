package pagepkg;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class santapageclass {

	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"menu-item-1128\"]/a")
	WebElement course;
	
	@FindBy(xpath = "//*[@id=\"menu-item-567\"]/a")
	WebElement study;
	
	@FindBy(xpath = "//*[@id=\"menu-item-1004\"]/a")
	WebElement germany;
	
	@FindBy(xpath = "//*[@id=\"logo-img\"]")
	WebElement santalogo;
	
	@FindBy(xpath = "//*[@id=\"masthead\"]/div[1]/div/div/div/div/div[2]/div[2]/div/a")
	WebElement contact;
	
	@FindBy(xpath = "//*[@id=\"masthead\"]/div[1]/div/div/div/div/div[2]/div[2]/div/div/a[3]")
	WebElement office;
	
	@FindBy(name="cname")
	WebElement name;
	
	@FindBy(name="cemail")
	WebElement email;
	
	@FindBy(name="cphonenumber")
	WebElement phno;
	
	@FindBy(name="csubject")
	WebElement subject;
	
	@FindBy(name="textarea-96")
	WebElement message;
	
	
	public santapageclass(WebDriver driver) {
  
    this.driver = driver;
    PageFactory.initElements(driver, this);
		
	}

	public void title()
	{
		String a = driver.getTitle();
		System.out.println("TITLE : " +a);
	}
	
	public void findCourse() throws IOException
	{
		String originalWindow = driver.getWindowHandle();
		
		course.click();
		
		for (String handle : driver.getWindowHandles()) 
			
			if (!handle.equals(originalWindow)) 
			{	
		        driver.switchTo().window(handle);
		        break;
			}
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\HP\\Desktop\\New folder\\santa.png"));
		
		
		String c = driver.getPageSource();
		
		if(c.contains("Search Program"))
		{
			System.out.println("Search Program Text is present");
		}
		else
		{
			System.out.println("Search Program Text is not present");
		}
		
		driver.close();

		
		driver.switchTo().window(originalWindow);
	}
	
	public void hover()
	{
		Actions act = new Actions(driver);
		act.moveToElement(study).perform();
		germany.click();
	}
	
	public void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void contactUs()
	{
		
		
		Actions act = new Actions(driver);
		act.moveToElement(contact).perform();
		office.click();
		
		name.sendKeys("Abc");
		email.sendKeys("abc@yopmail.com");
		phno.sendKeys("1234567890");
		subject.sendKeys("Enquiry");
		message.sendKeys("Hi");
		
		
	}

	
}
