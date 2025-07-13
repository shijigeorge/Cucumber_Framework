package stepdefinitions;



import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.loginPage;

public class loginValidations
{
    loginPage lP = new loginPage();
    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {

        Assert.assertTrue(lP.getLoginTitle().equalsIgnoreCase("OrangeHRM"),"Login page title is not as expected");
    }

    @When("the user tries to login the application with {string} and {string}")
    public void theUserTriesToLoginTheApplicationWithAnd(String username, String password) throws InterruptedException {
        lP.performLogin(username, password);
    }

    @Then("the user should successfully login to the application")
    public void theUserShouldSuccessfullyLoginToTheApplication() throws InterruptedException {
        lP.verifyPageTitle();
    }


    @When("the user tries to login the application with following credentials")
    public void theUserTriesToLoginTheApplicationWithFollowingCredentials(DataTable userDetails) throws InterruptedException {
        lP.multipleLogin(userDetails);

    }
}
