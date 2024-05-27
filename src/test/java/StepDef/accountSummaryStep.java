package StepDef;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSummaryPage;
import org.openqa.selenium.WebDriver;
import utility.DriverFactory;

public class accountSummaryStep {
    private WebDriver driver;
    private AccountSummaryPage accountsummarypage;

    public accountSummaryStep(){
        this.driver= DriverFactory.getDriver();
        this.accountsummarypage=new AccountSummaryPage(driver);
    }

    //=======access the mothods from the page object

    @Given("I am on view account summary page")
    public void i_am_on_view_account_summary_page() {
        accountsummarypage.viewAccountSummary();
    }

    @When("I select required account type")
    public void i_select_required_account_type() {
        accountsummarypage.SelectAccount();
    }

    @When("I click on the Go button")
    public void i_click_on_the_go_button() {
        accountsummarypage.clickGoButton();
    }

    @Then("I should get balance details")
    public void i_should_get_balance_details() {
        accountsummarypage.SummaryDetails();
    }

}
