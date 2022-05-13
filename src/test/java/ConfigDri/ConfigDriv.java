package ConfigDri;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigDriv {

    public void configWebDri()
    {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\SeleTesting\\src\\test\\resources\\Driver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://ui.uatwamly.co.za/");


    }
}
