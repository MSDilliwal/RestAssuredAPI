package genericUtility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author Hp Lap
 *
 */
public class WebDriverUtility 
{
	/**
	 * 1
	 *This method is used to maximize the brwoser page
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver  driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * 2
	 * This method is used to minimize the browser page
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * 3
	 * This method is used to refresh the browser page
	 * @param driver
	 */
	public void refreshThePage(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	/**
	 * 4
	 * This method is used to navigate to previous page 
	 * @param driver
	 */
	public void backToPreviousPage(WebDriver driver)
	{
		driver.navigate().back();
	}
	/**
	 * 5
	 * This method is used to navigate to next page
	 * @param driver
	 */
	public void forwardToNextPage(WebDriver driver)
	{
		driver.navigate().forward();
	}
	/**	
	 * 6
	 * This method is used to wait till the page get loaded
	 * @param driver
	 */
	public void waitTillPageGetsLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Iconstants.implicitlyWaitDuration));
	}
	/**
	 * 7
	 * This method is used to wait till the element to click
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToClick(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Iconstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * 8
	 * This method is used to wait till the element is visible 
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait  wait= new WebDriverWait(driver,Duration.ofSeconds(Iconstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 9
	 * This method is used to wait till the page is loaded
	 * @param driver
	 * @param title
	 */
	public void PageLoadTitle(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Iconstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * 10
	 * This method is used to wait till the page load url
	 * @param driver
	 * @param URL
	 */
	public void pageLoadUrl(WebDriver driver,String URL)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Iconstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.urlContains(URL));
	}
	/**
	 * 11
	 * This method is used to ignore NoSuchElementException 
	 * @param driver
	 */
	public void ignoreNoSuchElementException(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Iconstants.explicitlyWaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * 12
	 * This method is used to wait for alert popup message
	 * @param driver
	 */
	public void waitForAlertMsg(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Iconstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * 13 
	 * This method is used to swith the frame by index value
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * 14
	 * This method is used to switch the frame by id
	 * @param driver
	 * @param id
	 */
	public void switchToFrame(WebDriver driver, String id)
	{
		driver.switchTo().frame(id);
	}
	/**
	 * 15
	 * This method is used to switch the frame by element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * 16
	 * This method is used to switch to main frame
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * 17
	 * This method is used to select element based on index value
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * 18
	 * This method is used to select element based on value
	 * @param element
	 * @param value
	 */
	public void select(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	/**
	 * 19
	 * This method is used to select element based on visible text
	 * @param text
	 * @param element
	 */
	public void select(String text,WebElement element)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * 20
	 * This method is used to get the all the options present inside the dropdown
	 * @param element
	 */
	public void getAllTheOptiondFromDropDown(WebElement element)
	{
		Select select=new Select(element);
		List<WebElement> option = select.getOptions();
		for(WebElement webElement : option)
		{
			String text = webElement.getText();
			System.out.println(text);
		}
	}
	/**
	 * 21
	 * This method is used for mouse hovering
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * 22
	 * This method is used to right click on element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * 23
	 * This method is used to double click on element 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element) 
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	/**
	 * 24
	 * This method is used to click on enter key in the keypad / keyboard
	 * @param driver
	 */
	public void enterKeyClick(WebDriver driver) 
	{
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * 25
	 * This method is used to take screenshot
	 * @param driver
	 * @param ScreenShotName
	 */
	public void takeScreenshot(WebDriver driver,String ScreenShotName)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshots"+ScreenShotName+".PNG");
		try {
			FileUtils.copyFile(src, dst);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * 26
	 * This method is used to customize the waiting times
	 * @param driver
	 */
	public void waitAndClickUsingCustomWait(WebDriver driver)
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(500));
		wait.ignoring(NoSuchElementException.class);
		try 
		{
			wait.wait(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 27
	 * This method is used to customize the wait 
	 * @param element
	 * @param duration
	 * @param pollingTime
	 */
	public void waitAndClick(WebElement element, int duration, long pollingTime)
	{
		int count=0;
		while(count<duration)
		{
			try 
			{
				element.click();
				break;
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
			count++;
		}
	}
	/**
	 * 28
	 * This method is used to switch the window based on title
	 * @param driver
	 * @param actualTitle
	 */
	public void switchToWindow(WebDriver driver, String actualTitle)
	{
		Set<String> set = driver.getWindowHandles();
		for (String string : set) 
		{
			driver.switchTo().window(string);
			String title = driver.getTitle();
			if(title.contains(actualTitle))
			{
				break;
			}
		}
	}
	/**
	 * 29
	 * This method is used to switch the window based on the url
	 * @param actualURL
	 * @param driver
	 */
	public void switchToWindow(String actualURL, WebDriver driver)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String wid= it.next( );
			driver.switchTo().window(wid);
			String Url = driver.getCurrentUrl();
			if(Url.contains(actualURL))
			{
				break;
			}
		}
	}
	/**
	 * 30
	 * This method is used to switch the frame to alert popup message window and click on okay 
	 * @param driver
	 * @param expmsg
	 */
	public void switchToAlertPopUpAndAccept(WebDriver driver, String expmsg)
	{
		Alert al = driver.switchTo().alert();
		if(al.getText().trim().equalsIgnoreCase(expmsg))
		{
			System.out.println("alert message verified");
		}
		else 
		{
			System.out.println("alert message is not verified");	
		}
		al.accept();
	}
	/**
	 * 31
	 * This method is used to switch the frame to alert popup window and click on cancel 
	 * @param expmsg
	 * @param driver
	 */
	public void switchToAlertPopUpAndAccept(String expmsg,WebDriver driver)
	{
		Alert al = driver.switchTo().alert();
		if(al.getText().trim().equalsIgnoreCase(expmsg))
		{
			System.out.println("alert message verified");
		}
		else 
		{
			System.out.println("alert message is not verified");	
		}
		al.dismiss();
	}
}