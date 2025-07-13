package pages;

import baseclass.driverContext;
import constants.constant;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.commonMethods;

import java.util.List;
import java.util.Map;

public class loginPage
{
    commonMethods common =new commonMethods();
    public loginPage() {

        PageFactory.initElements(driverContext.Driver, this);
    }
    private @FindBy(xpath = "//input[@name='username']")
    WebElement username_field;
    private @FindBy(xpath = "//input[@name='password']")
    WebElement password_field;
    private @FindBy(xpath = "//*[@type='submit']")
    WebElement login_button;
    @FindBy(xpath = "(//img[@alt='profile picture'])[1]")
    private WebElement profilePicture;
    private @FindBy(xpath = "//a[text()='Logout']")
    WebElement logout_button;
    public void performLogin(String username, String password) throws InterruptedException {
        Thread.sleep(10000);
        common.enterText(username_field,username);
        common.enterText(password_field,password);
       // username_field.sendKeys(username);
        //password_field.sendKeys(password);
        common.waitUntilWebElementToBeClickable(login_button);
        login_button.click();
    }
    public String getLoginTitle()
    {
        return driverContext.Driver.getTitle();
    }
    public void verifyPageTitle() throws InterruptedException
    {
        Thread.sleep(10000);
        String actualTitle = driverContext.Driver.getCurrentUrl();
        Assert.assertTrue(actualTitle.contains(constant.DASHBOARD_URL),"Page Title does not match expected value");
    }
    public void multipleLogin(DataTable userDetails) throws InterruptedException
    {
        List<Map<String, String>> userDetailsData = userDetails.asMaps(String.class, String.class);
        userDetailsData.get(0).get("username");
        userDetailsData.get(0).get("password");
        userDetailsData.get(1).get("username");
        userDetailsData.get(1).get("password");
        Thread.sleep(10000);
        for(Map<String, String>loginDetails:userDetailsData)
        {
            common.enterText(username_field,loginDetails.get("username"));
            common.enterText(password_field,loginDetails.get("password"));
            common.waitUntilWebElementToBeClickable(login_button);
            common.clickOnAnElement(login_button);
            common.clickOnAnElement(profilePicture);
            common.clickOnAnElement(logout_button);
        }

        // username_field.sendKeys(username);
        //password_field.sendKeys(password);

    }
}
