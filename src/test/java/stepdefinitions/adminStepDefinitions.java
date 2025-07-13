package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.adminPage;

public class adminStepDefinitions
{
    adminPage adminPage=new adminPage();

    @And("the user is redirected to the admin page")
    public void theUserIsRedirectedToTheAdminPage() throws InterruptedException {
        adminPage.navigateToAdminPage();
    }

    @And("the user searches for a username with {string}")
    public void theUserSearchesForAUsernameWith(String arg0)
    {
        adminPage.performUserSearch();
    }

    @Then("the user should see the details of {string}")
    public void theUserShouldSeeTheDetailsOf(String arg0) throws InterruptedException {
        adminPage.verifyRecordFound();
    }
}
