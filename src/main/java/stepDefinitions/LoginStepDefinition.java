package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static generic.IAutoConstant.CHROME_KEY;
import static generic.IAutoConstant.CHROME_VALUE;

public class LoginStepDefinition {
    WebDriver driver;


    @Given("^user is already on Login Page$")
    public void user_already_on_login_page() {
        System.setProperty(CHROME_KEY, CHROME_VALUE);

        driver = new ChromeDriver();
        driver.get("https://www.freecrm.com/index.html");
    }


    @When("^title of login page is Free CRM$")
    public void title_of_login_page_is_free_CRM() {
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Free CRM #1 cloud software for any business large or small", title);
    }

    @Then("^click on login$")
    public void click_on_login() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Log In')]/..")).click();
    }
//span[contains(text(),'Log In')]/..
    //Reg Exp:
    //1. \"([^\"]*)\"
    //2. \"(.*)\"

    @Then("^user enters \"(.*)\" and \"(.*)\"$")
    public void user_enters_username_and_password(String username, String password) throws InterruptedException {
        Thread.sleep(7000);
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @Then("^user clicks on login button$")
    public void user_clicks_on_login_button() {
        WebElement loginBtn =
                driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginBtn);
    }


    @Then("^user is on home page$")
    public void user_is_on_hopme_page() {
        String title = driver.getTitle();
        System.out.println("Home Page title ::" + title);
        Assert.assertEquals("Cogmento CRM", title);
    }

    @Then("^Close the browser$")
    public void close_the_browser() {
        driver.quit();
    }

}
