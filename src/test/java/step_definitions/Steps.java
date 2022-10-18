package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;


public class Steps {

      public WebDriver driver;
      public LoginPage lp;

    @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() {
        driver=new ChromeDriver();
        lp=new LoginPage(driver);

    }

    @When("User opens ULR {string}")
    public void user_opens_ulr(String url) {driver.get(url);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @When("Click on Login")
    public void click_on_login() {
        lp.clickLogin();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {

        if (driver.getPageSource().contains("Login was unsuccessful.")) {
            driver.close();
            Assert.assertTrue(false);
        } else {
            Assert.assertEquals(title,driver.getTitle());
        }


    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        lp.clickLogout();
        Thread.sleep(3000);

    }

    @Then("close browser")
    public void close_browser() {
        driver.close();
    }


}
