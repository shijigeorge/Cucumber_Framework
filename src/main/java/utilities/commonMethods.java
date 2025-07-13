package utilities;

import baseclass.driverContext;
import constants.constant;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class commonMethods
{
    WebDriverWait wait=new WebDriverWait(driverContext.Driver, Duration.ofSeconds(30));
    public void verifyPageTitle(String expectedTitle)
    {

        String actualTitle = driverContext.Driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),"Page Title does not match expected value");
    }

    public void enterText(WebElement element, String textToSend)
    {
        try
        {
            waitUntilWebElementToBeClickable(element);
            element.clear();
            element.sendKeys(textToSend);
        } catch (NoSuchElementException | TimeoutException e)
        {
            System.out.println("Unable to send keys to WebElement, Exception: " + e.getMessage());
        }
    }
    public void waitUntilWebElementToBeClickable(WebElement element)
    {
        try
        {
           wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (NoSuchElementException | TimeoutException e)
        {

            System.out.println("WebElement is NOT visible, Exception: " + e.getMessage());
        }
    }
    public void clickOnAnElement(WebElement element)
    {
        try {
            waitUntilWebElementToBeClickable(element);
            element.click();
        }
        catch (NoSuchElementException | TimeoutException e)
        {

            System.out.println("WebElement is NOT visible, Exception: " + e.getMessage());
        }

    }
}
