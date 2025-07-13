package pages;

import baseclass.driverContext;
import constants.constant;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class adminPage
{
    public adminPage() {

        PageFactory.initElements(driverContext.Driver, this);
    }
    private @FindBy(xpath = "//span[text()='Admin']")
    WebElement admin_label;

    private @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and not(@placeholder)]")
    WebElement Username;

    private @FindBy(xpath = "//button[@type='submit']")
    WebElement Search_button;

    private @FindBy(xpath = "//span[text()='(1) Record Found']")
    WebElement record_found_label;
    WebDriverWait wait = new WebDriverWait(driverContext.Driver, Duration.ofSeconds(30) );
    public void navigateToAdminPage() throws InterruptedException {
         Thread.sleep(10000);
        admin_label.click();
    }
    public void performUserSearch()
    {
        wait.until(ExpectedConditions.elementToBeClickable(Username));
        Username.sendKeys("Admin");

        wait.until(ExpectedConditions.elementToBeClickable(Search_button))     ;
    Search_button.click();
    }
    public void verifyRecordFound() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(record_found_label.isDisplayed(),"Admin record not found. Please check the username entered.");
    }
}


