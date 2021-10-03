import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class assignmentselenium {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\qt\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		assignmentselenium.exercise1(driver);
		assignmentselenium.exercise2(driver);
		assignmentselenium.exercise3(driver);
		assignmentselenium.exercise4(driver);
		assignmentselenium.exercisefourpointone(driver);
		assignmentselenium.exercisefourpointtwo(driver);
		assignmentselenium.exercise5(driver);
		assignmentselenium.exercise6(driver);
		assignmentselenium.exercise7(driver);
		assignmentselenium.exercise8(driver);
		assignmentselenium.exercise9(driver);
		

	}
	public static void exercise1(WebDriver driver) throws InterruptedException{
		/*logic for first radio button clicking*/
		driver.findElement(By.cssSelector("input[value='radio1']")).click();
		System.out.println(driver.findElement(By.cssSelector(".radioButton")).isSelected());
		Thread.sleep(3000L);
		/*logic for second radio button clicking*/
		driver.findElement(By.cssSelector("input[value='radio2']")).click();
		System.out.println(driver.findElement(By.cssSelector(".radioButton")).isSelected());
		Thread.sleep(3000L);
		/*logic for third radio button clicking*/
		driver.findElement(By.cssSelector("input[value='radio3']")).click();
		System.out.println(driver.findElement(By.cssSelector(".radioButton")).isSelected());
		Thread.sleep(3000L);
	}
	
	
	public static void exercise2(WebDriver driver) throws InterruptedException{
		/*logic to type united states and find similar list*/
		driver.findElement(By.id("autocomplete")).sendKeys("United States");
		Thread.sleep(2000L);
		/*list to displayed*/
List<WebElement> options= driver.findElements(By.cssSelector("li[class='ui-menu-item'] div" ));
/*for loop to iterate the option and select correct option*/
for(WebElement option :options) {
if(option.getText().equalsIgnoreCase("United States Minor Outlying Islands"))
{
option.click();
break;
}

}
	}
	
	
	public static void exercise3(WebDriver driver) throws InterruptedException{
		driver.findElement(By.id("dropdown-class-example")).click();

		driver.findElement(By.xpath("//option[@value='option1']")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//option[@value='option2']")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//option[@value='option3']")).click();
		Thread.sleep(2000L);
	}
	
	
	public static void exercise4(WebDriver driver) throws InterruptedException{
		{
			driver.findElement(By.id("checkBoxOption1")).click();//click the check box
			System.out.println(	driver.findElement(By.id("checkBoxOption1")).isSelected());// displays the  check box is checked
			driver.findElement(By.id("checkBoxOption1")).click();
			Thread.sleep(2000);
			System.out.println(	driver.findElement(By.id("checkBoxOption1")).isSelected());// displays the check box is unchecked
			
			Thread.sleep(2000);
			
			//second check box
			driver.findElement(By.id("checkBoxOption2")).click();//click the check box
			System.out.println(	driver.findElement(By.id("checkBoxOption2")).isSelected());// displays the  check box is checked
			driver.findElement(By.id("checkBoxOption2")).click();
			Thread.sleep(2000);
			System.out.println(	driver.findElement(By.id("checkBoxOption2")).isSelected());//displays the check box is unchecked

			
			Thread.sleep(2000);
			
			// third check box
			driver.findElement(By.id("checkBoxOption3")).click();//click the check box
			System.out.println(	driver.findElement(By.id("checkBoxOption3")).isSelected());//displays the  check box is checked
			driver.findElement(By.id("checkBoxOption3")).click();
			Thread.sleep(2000);
			System.out.println(	driver.findElement(By.id("checkBoxOption3")).isSelected());//displays the check box is unchecked
		}
		
	}
	public static void exercisefourpointone(WebDriver driver) throws InterruptedException{
		{
			List<WebElement>AllCheckboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
			int size=AllCheckboxes.size();
			System.out.println(size);
			int i;
			for( i=0;i<size;i++)
			{
				AllCheckboxes.get(i).click();
			    System.out.println(AllCheckboxes.get(i).isSelected());
			}
			
		}
	}
	public static void exercisefourpointtwo(WebDriver driver) throws InterruptedException{
		{
			  Thread.sleep(2000);
			  List<WebElement>AllCheckboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
				int size=AllCheckboxes.size();
				System.out.println(size);
				int i;
				for( i=0;i<size;i++)
				{
					AllCheckboxes.get(i).click();
				    System.out.println(AllCheckboxes.get(i).isSelected());
				}
	}
		
}
	public static void exercise5(WebDriver driver) throws InterruptedException{
		driver.findElement(By.id("openwindow")).click();
		/*logic to fetch the driver scope to child id*/
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid]
/*iterator is the method which will fetch all the ids of parent and child window*/
Iterator<String>it = windows.iterator();
/*calling with the iterator object which will grab parent id*/
String parentId = it.next();
/*calling with the iterator object which will grab child id*/
String childId = it.next();
driver.switchTo().window(childId);
driver.close();
Thread.sleep(5000L);

driver.switchTo().window(parentId);

	}
public static void exercise6(WebDriver driver) throws InterruptedException{
	driver.findElement(By.id("opentab")).click();
	Set<String> windows = driver.getWindowHandles();//[parentid,childid]

	Iterator<String>it = windows.iterator();
	/*calling with the iterator object which will grab parent id*/
	String parentId = it.next();
	/*calling with the iterator object which will grab child id*/
	String childId = it.next();
/*it will switch to child window*/
	driver.switchTo().window(childId);
	driver.close();
	Thread.sleep(5000L);
	driver.switchTo().window(parentId);
}

public static void exercise7(WebDriver driver) throws InterruptedException{
	String text="Amulya";
	/*id  of enter name*/
	driver.findElement(By.id("name")).sendKeys(text);
	/*id of alert button*/
	driver.findElement(By.cssSelector("[id='alertbtn']")).click();
	System.out.println(driver.switchTo().alert().getText());
	/*find the alerts in the webpage and accepts any alerts in the browser*/
	driver.switchTo().alert().accept();
}

public static void exercise8(WebDriver driver) throws InterruptedException{
{
		
		JavascriptExecutor js =(JavascriptExecutor)driver;/*creating javascriptExecutor object to tell selinium to run java code*/
		js.executeScript("window.scrollBy(0,600)");/*movement of window which comes down*/
		Thread.sleep(500);
		/*it Verify that  row in the table contains content*/
		WebElement table=driver.findElement(By.id("product"));
		List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th"));
		System.out.println(secondrow.get(0).getText());
		System.out.println(secondrow.get(1).getText());
		System.out.println(secondrow.get(2).getText());
	}
}

public static void exercise9(WebDriver driver) throws InterruptedException{
	JavascriptExecutor js =(JavascriptExecutor)driver;//creating javascriptExecutor object to tell selinium to run java code
	js.executeScript("window.scrollBy(0,500)");
	Thread.sleep(2000L);
	/*create a class action and the pass the driver object*/
	Actions a=new Actions(driver);
	Thread.sleep(2000L);
	a.moveToElement(driver.findElement(By.cssSelector("button[id='mousehover']"))).build().perform();
	a.moveToElement(driver.findElement(By.tagName("a"))).build().perform();

}
}

