package StepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepdef {

    WebDriver driver;

    @Given("^navigate to wamly page$")
    public void navigate_to_wamly_page() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\SeleTesting\\src\\test\\resources\\Driver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://ui.uatwamly.co.za/");

    }

    @When("^user logged in using username as \"([^\"]*)\"$")
    public void user_logged_in_using_username_as_something(String username) throws Throwable {

        driver.manage().window().maximize();

        driver.findElement(By.tagName("INPUT")).sendKeys(username);
        driver.findElement(By.tagName("BUTTON")).click();

    }

    @Then("^User enter password as \"([^\"]*)\"$")
    public void user_enter_password_as_something(String password) throws Throwable {

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }


}
