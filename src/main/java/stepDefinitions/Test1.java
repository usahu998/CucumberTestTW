package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static generic.IAutoConstant.CHROME_KEY;
import static generic.IAutoConstant.CHROME_VALUE;

public class Test1 {

    WebDriver driver;


//    @Given("^user is already on Login Page$")
//    public void user_already_on_login_page(){
//        System.setProperty(CHROME_KEY, CHROME_VALUE);
//
//        driver = new ChromeDriver();
//        driver.get("https://www.freecrm.com/index.html");
//    }

    @When("^I am on x page$")
    public void i_am_on_x_page() throws Throwable{
        System.out.println("go to the page");
       // public void user_already_on_login_page(){
//            System.setProperty(CHROME_KEY, CHROME_VALUE);
//            driver = new ChromeDriver();
//            driver.get("https://www.freecrm.com/index.html");
    }

    @Then("^I see that element$")
    public void  i_see_that_element() throws Throwable{
        System.out.println("see that element");
    }
}
