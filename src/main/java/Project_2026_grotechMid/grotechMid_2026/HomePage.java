package Project_2026_grotechMid.grotechMid_2026;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	WebDriver driver;
	
	@FindBy(xpath = "(//div[@class='elementor-flip-box__layer__overlay'])[1]")
	WebElement regAppElement;
	
	@FindBy(tagName = "a")
	List<WebElement> linksElements;

	public void regApp()
	{
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		w1.until(ExpectedConditions.visibilityOf(regAppElement));
		
		Actions regHvrActions = new Actions(driver);
		regHvrActions.moveToElement(regAppElement).perform();
		
	}
	
	public void findLinks() throws IOException
	{
		for(WebElement link:linksElements)
		{
			String url = link.getAttribute("href");
			if(url.startsWith("http"))
			{
			try 
				{
					URL uLUrl = new URL(url);
					HttpURLConnection urlConnection = (HttpURLConnection) uLUrl.openConnection();
					urlConnection.setRequestMethod("HEAD");
					urlConnection.connect();
					
					if(urlConnection.getResponseCode()>200)
					{
						System.out.println("Broken Url found: "+url + urlConnection.getResponseCode());
					}
				}
				catch(MalformedURLException e1)
				{
					System.out.println("exception occured" + e1);
				}
			}
			else {
				System.out.println("Skipping url bcz its not http: "+url);
			}
		}
		}
	
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
