package stepdefinition;
import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.CreateIssuePage;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;
import java.io.File;
import java.io.IOException;


public class StepDefinitions {

  @Before
  public void beforeCucumberScenario(Scenario scenario) {
    WebDriverFactory.createInstance("Chrome");
  }

  @After
  public void afterCucumberScenario(Scenario scenario) {
    if (scenario.getStatus().toString().contains("FAILED")) {
      try {
        takeScreenshot();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    WebDriverFactory.getDriver().close();
  }

  public void takeScreenshot() throws IOException {
    File scrFile = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
    File trgtFile = new File(System.getProperty("user.dir") + "//screenshots/screenshot.png");
    System.out.println("SAVING Screenshot to " + trgtFile.getAbsolutePath());
    trgtFile.getParentFile().mkdir();
    trgtFile.createNewFile();
    Files.copy(scrFile, trgtFile);
  }

  @Then("^I navigate to Jira Login Page$")
  public void navigateToLoginPage() {
    new LoginPage().navigateTo();
  }

  @Then("^I enter username as \"(.*?)\"$")
  public void enterUserName(String userName) {
    new LoginPage().enterUserName(userName);
  }

  @Then("^I enter password as \"(.*?)\"$")
  public void enterPassword(String password) {
    new LoginPage().enterPassword(password);
  }

  @Then("^I click on the login button$")
  public void clickLoginButton() {
    new LoginPage().clickLogin();
  }

  @When("^I am on the Home Page$")
  public void atTheHomePage() {
    assert new HomePage().onPage();
  }

  @When("^Error message is displayed$")
  public void notAtTheHomePage() {
    assert new LoginPage().isErrorDisplayed();
  }

  @When("^I debug$")
  public void debug() {
    int a = 0;
  }

  @Then("^I click on Create issue button$")
  public void clickCreateButton() {
    new CreateIssuePage().clickIssueCreate();
  }

  @When("^I am on Create issue form$")
  public void isProjectFieldDisplayed() {
    assert new CreateIssuePage().projectFieldDisplayed();
  }

  @Then("^I enter project name as \"(.*?)\"$")
  public void inputProjectName(String project) {
    new CreateIssuePage().editProjectName(project);
  }

  @Then("^I enter issue type as \"(.*?)\"$")
  public void inputIssueType(String project) {
    new CreateIssuePage().editIssueType(project);
  }

  @Then("^I enter summary as \"(.*?)\"$")
  public void inputSummary(String project) {
    new CreateIssuePage().editSummary(project);
  }

  @Then("^I enter reporter name as \"(.*?)\"$")
  public void inputReporter(String reporterName) {
    new CreateIssuePage().editReporter(reporterName);
  }

  @Then("^I enter description as \"(.*?)\"$")
  public void inputText(String descrText) {
    new CreateIssuePage().editText(descrText);
  }

  @Then("^I click on Submit issue button$")
  public void submitIssue() {
    new CreateIssuePage().clickSubmitIssue();
  }

  @When("^I can see a Success popup window$")
  public void isPopupWindowDisplayed() {
    assert new CreateIssuePage().isSuccessPopupDisplayed();
  }
}