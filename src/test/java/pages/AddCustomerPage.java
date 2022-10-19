package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage extends basePage {

    public WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(ldriver,this);
    }

    By customersMenu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
    By customersMenuItem=By.xpath("//li[@class='nav-item']//p[contains(text(), 'Customers')]");
    By addNewButton=By.xpath("//a[@class='btn btn-primary']");
    By emailField=By.id("Email");
    By passwordField=By.id("Password");
    By firstNameField=By.id("FirstName");
    By lastNameField=By.id("LastName");
    By maleGender=By.id("Gender_Male");
    By femaleGender=By.id("Gender_Female");
    By dateOfBirthField=By.xpath("//input[@id='DateOfBirth']");
    By companyNameField=By.id("Company");
    By customerRolesList=By.xpath("//div[@class='input-group-append input-group-required']");
    By listItemAdministrators=By.xpath("//li[contains(text(), 'Administrators')]");
    By listItemRegistered=By.xpath("//li[contains(text(), 'Registered')]");
    By listItemGuests=By.xpath("//li[contains(text(), 'Guests')]");
    By listItemVendors=By.xpath("//li[contains(text(), 'Vendors')]");
    By menagerOfVendorList=By.id("VendorId");
    By adminContentField=By.id("AdminComment");
    By saveButton=By.xpath("//button[@name='save']");

    //Actions Methods

    public String getPageTitle(){
        return ldriver.getTitle();
    }

    public void clickOnCustomersMenu(){
        ldriver.findElement(customersMenu).click();
    }

    public void clickOnCustomersMenuItem(){
        ldriver.findElement(customersMenuItem).click();
    }

    public void clickOnAddNewButton(){
        ldriver.findElement(addNewButton).click();
    }

    public void setEmailField(String email) {
        ldriver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password){
        ldriver.findElement(passwordField).sendKeys(password);
    }

    public void setFirstNameField(String fname){
        ldriver.findElement(firstNameField).sendKeys(fname);
    }

    public void setLastNameField(String lname){
        ldriver.findElement(lastNameField).sendKeys(lname);
    }

    public void setDateOfBirthfield(String dob){
        ldriver.findElement(dateOfBirthField).sendKeys(dob);
    }

    public void setCompanyNamefield(String comname){
        ldriver.findElement(companyNameField).sendKeys(comname);
    }

    public void setAdminContentfield(String content){
        ldriver.findElement(adminContentField).sendKeys(content);
    }

    public void setGender(String gender){

        if (gender.equals("Male")){
            ldriver.findElement(maleGender).click();
        }
        else if (gender.equals("Female")){
            ldriver.findElement(femaleGender).click();
        }
        else{
            ldriver.findElement(maleGender).click(); //Default
        }

    }

    public void setCustomerRolesList(String role) throws InterruptedException{

        if(!role.equals("Vendors"))    //if role is vendors should not delete Register as
        {
            ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[contains(text(),'Registered')]")).click();
        }

        ldriver.findElement(customerRolesList).click();
        WebElement listitem;
        Thread.sleep(3000);

        if (role.equals("Administrators"))
        {
            listitem=ldriver.findElement(listItemAdministrators);
        }
        else if (role.equals("Guests"))
        {
            listitem=ldriver.findElement(listItemGuests);
        }
        else if (role.equals("Registered"))
        {
            listitem=ldriver.findElement(listItemRegistered);
        }
        else if (role.equals("Vendors"))
        {
            listitem=ldriver.findElement(listItemVendors);
        }
        else
        {
            listitem=ldriver.findElement(listItemGuests);
        }

        listitem.click();
        Thread.sleep(3000);

        //JavascriptExecutor js = (JavascriptExecutor) ldriver;
       // js.executeScript("arguments[0].click();",listitem);

    }

    public void setMenagerOfVendorList(String value){

        Select drp=new Select(ldriver.findElement(menagerOfVendorList));
        drp.selectByVisibleText(value);
    }

    public void clickOnSave(){
        ldriver.findElement(saveButton).click();
    }





}
