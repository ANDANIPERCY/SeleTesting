package StepDefination;

import com.opencsv.CSVReader;
import gherkin.lexer.Th;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileReader;
import java.util.List;

public class CreateProject {

    WebDriver driver;

    @Given("^navigate to wamly login page$")
    public void navigate_to_wamly_login_page() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\SeleTesting\\src\\test\\resources\\Driver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://ui.uatwamly.co.za/");
        driver.manage().window().fullscreen();

    }

    @When("^user logged in using email as \"([^\"]*)\"$")
    public void user_logged_in_using_email_as_something(String username) throws Throwable {

        driver.manage().window().fullscreen();

        driver.findElement(By.tagName("INPUT")).sendKeys(username);
        driver.findElement(By.tagName("BUTTON")).click();

        driver.findElement(By.xpath("//*[@id=\"pushActionRefuse\"]")).click();

    }

    @Then("^User's enter password as \"([^\"]*)\"$")
    public void users_enter_password_as_something(String password) throws Throwable {
        driver.manage().window().fullscreen();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @And("^click projects , Add New and From Scratch$")
    public void click_projects_add_new_and_from_scratch() throws Throwable {

        driver.manage().window().fullscreen();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/span[1]")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"project-list-form\"]/div[1]/div[1]/div[2]/span[1]")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"alert-dialog-description\"]/div[1]/span[1]/ul[1]/li[1]")).click();

    }

    @And("^fill Settings form \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" ,\"([^\"]*)\" click open project \"([^\"]*)\"$")
    public void fill_settings_form_something_something_something_something_click_open_project_something(String projectname,String department, String projectDescription, String introvideos, String startdate) throws Throwable {

        driver.manage().window().fullscreen();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"Project_Name\"]")).sendKeys(projectname);

        System.out.println("--------------------------------------------------------------");
        WebElement testDropDown = driver.findElement(By.id("department"));
        Select dropdown = new Select(testDropDown);
        System.out.println("--------------------------------------------------------------");
        dropdown.selectByVisibleText(department);
        driver.findElement(By.xpath("//*[@id=\"projectDescription\"]")).sendKeys(projectDescription);
        System.out.println("--------------------------------------------------------------");
        Thread.sleep(1000);
        WebElement introDropDown = driver.findElement(By.id("departmentSelect"));
        Select intodropdown = new Select(introDropDown);
        System.out.println("--------------------------------------------------------------");
        intodropdown.selectByVisibleText(introvideos);
        driver.findElement(By.xpath("//*[@id=\"simple-tabpanel-0\"]/div[1]/p[1]/div[1]/div[5]/div[1]/div[1]/div[1]/span[1]/label[1]/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"startDate\"]")).sendKeys(startdate);
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"NextButton\"]")).click();




    }
    @Then("^click next$")
    public void click_next() throws Throwable {
        driver.manage().window().fullscreen();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"NextButton\"]")).click();


    }
    @And("^Select Available raters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void select_available_raters_something_and_something(String rater1, String rater2) throws Throwable {

        List<WebElement> raters = driver.findElements(By.className("list-group-item"));
        int size = raters.size()-1;

        for (int i=1;i < size;i++)
        {
            String name =driver.findElement(By.xpath("//*[@id=\"simple-tabpanel-2\"]/div[1]/p[1]/div[1]/div[3]/div[1]/div["+i+"]/div[1]")).getText();
            System.out.println(name);
            if(name.contains(rater1) || name.contains(rater2))
            {
                driver.findElement(By.xpath("//*[@id=\"simple-tabpanel-2\"]/div[1]/p[1]/div[1]/div[3]/div[1]/div["+i+"]/div[1]/div[1]/div[1]/span[1]/label[1]/span[1]")).click();

            }


        }
        System.out.println("-------------------------Done With Raters------------------------------");


    }


    @And("^click next To Create New Project$")
    public void click_next_to_create_new_project() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"NextButton\"]")).click();

    }

    @And("^Select \"([^\"]*)\"$")
    public void select_something(String projectquestion) throws Throwable {


        driver.findElement(By.xpath("//*[@id=\"simple-tabpanel-3\"]/div[1]/p[1]/div[1]/ul[1]/li[1]/div[1]")).click();
        Thread.sleep(5000);

        String CSV_PATH = "C:\\Users\\User\\IdeaProjects\\SeleTesting\\src\\test\\resources\\Utils\\projectQuestion.csv";

        CSVReader csvReader;
        String[] csvCell;

        csvReader = new CSVReader(new FileReader(CSV_PATH));
        int x=0;

        while ((csvCell = csvReader.readNext()) != null) {

            String question =csvCell[0];
            String prepTime = csvCell[1];
            String answerTime= csvCell[2];

            driver.findElement(By.xpath("//*[@id=\"question-"+x+"-textarea\"]")).clear();
            driver.findElement(By.xpath("//*[@id=\"question-"+x+"-textarea\"]")).sendKeys(question);
            driver.findElement(By.xpath(" //*[@id=\"preparetime-"+x+"-input\"]")).clear();
            driver.findElement(By.xpath(" //*[@id=\"preparetime-"+x+"-input\"]")).sendKeys(prepTime);
            driver.findElement(By.xpath("//*[@id=\"answertime-"+x+"-input\"]")).clear();
            driver.findElement(By.xpath("//*[@id=\"answertime-"+x+"-input\"]")).sendKeys(answerTime);

            driver.findElement(By.xpath("//*[@id=\"create_question\"]")).click();

            x++;
        }



    }

    @And("^click next to project$")
    public void click_next_to_project() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"NextButton\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"NextButton2\"]")).click();

    }





}
