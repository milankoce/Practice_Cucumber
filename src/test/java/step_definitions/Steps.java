package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddCustomerPage;
import pages.LoginPage;


public class Steps extends BaseClass
{

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

    //Customers feature step definitions

    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {

        addCust=new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
    }

    @When("User click on customers Menu")
    public void user_click_on_customers_menu() throws InterruptedException{

        Thread.sleep(3000);
        addCust.clickOnCustomersMenu();

    }

    @When("click on customers Menu Item")
    public void click_on_customers_menu_item() throws InterruptedException {

        Thread.sleep(2000);
        addCust.clickOnCustomersMenuItem();

    }

    @When("click on Add new button")
    public void click_on_add_new_button() throws InterruptedException {

        Thread.sleep(3000);
        addCust.clickOnAddNewButton();

    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {

        Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitle());

    }
    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
        String email=randomstring()+"@gmail.com";
        addCust.setEmailField(email);
        addCust.setPasswordField("test123");
        addCust.setCustomerRolesList("Guests");
        Thread.sleep(3000);
        addCust.setMenagerOfVendorList("Vendor 2");
        addCust.setGender("Male");
        addCust.setFirstNameField("Michael");
        addCust.setLastNameField("Michaelson");
        addCust.setDateOfBirthfield("1/10/1994");
        addCust.setCompanyNamefield("NeonQA");
        addCust.setAdminContentfield("This is for testing...");


    }
    @When("click on Save button")
    public void click_on_save_button() throws InterruptedException {

        addCust.clickOnSave();
        Thread.sleep(3000);

    }
    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msg) {

        Assert.assertTrue (driver.findElement(By.tagName("body")).getText()
                .contains("The new customer has been added successfully."));

    }

}
