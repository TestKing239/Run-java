package steps;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Processing_Steps {

	
	 WebDriver d;
	    public WebDriverWait wait;

    
    @Given("User navigation to the todo management website")
    public void userNavigationToTheTodoManagementWebsite() throws Exception {
      //  System.setProperty("webdriver.chrome.driver", "C:\\vishal\\Automation\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "Driver/Chrome Driver/chromedriver-win64/chromedriver.exe");
 
       ChromeOptions options = new ChromeOptions();
options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920,1080");
WebDriver driver = new ChromeDriver(options);
options.addArguments("user-agent=Mozilla/5.0");

	    
        d = new ChromeDriver(options);
        
        d.manage().window().maximize();
        d.navigate().to("https://www.naukri.com/");
    	wait = new WebDriverWait(d, 10);
        System.out.println("1st Step Result Pass :- Web Launch");

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Login']")));
        loginBtn.click();

        // Enter Email ID
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")));
        emailField.sendKeys("abhaytoriya23@gmail.com");

        // Enter Password
        WebElement passwordField =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter your password']")));
        passwordField.sendKeys("Satyam@123");

        // Click Login
        WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Login')]")));
        submitBtn.click();

        
        System.out.println("Login Successful"); 
        
                
        
        

    }
    

      
    @When("Update profile")
    public void updateProfile() {
    	   WebElement ViewProfile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='View profile']")));
    	   ViewProfile.click();

           // Click on 'Edit Profile'
           WebElement editProfile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[contains(@class,'icon edit')]")));
           editProfile.click();
           
           JavascriptExecutor js = (JavascriptExecutor) d;
           js.executeScript("window.scrollBy(0,900);");
           
           WebElement Name_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='name']")));
           Name_field.sendKeys("a");
            
           // Click on Save button
           WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='saveBasicDetailsBtn']")));
           saveBtn.click();

           System.out.println("Profile updated successfully!");
   
    
    }
    

    
//    @When("Search & apply")
//    public void searchApply() {
//    	
//        WebElement Search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'suggestor-box flex-row')]//input)[1]")));
//        Search.click();
//        Search.sendKeys("software testing, qa, ");
//        
//        
//        Select Exprience = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='experienceDD']"))));
//        Exprience.selectByVisibleText("3 year");
//        
//        
//        
//        WebElement SearchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Search']")));
//        SearchButton.click();
//        
//    	
//    	
//    	
//    }
    
    
    

    
}
