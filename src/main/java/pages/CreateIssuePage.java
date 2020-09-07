package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class CreateIssuePage {

  private By createButton = By.id("create_link");
  private By projectField = By.id("project-field");
  private By issueTypeField = By.id("issuetype-field");
  private By summaryInputField = By.id("summary");
  private By reporterField = By.id("reporter-field");
  private By textTab = By.xpath("(//div[@id='description-wiki-edit']//a[contains(text(),'Text')])");
  private By descriptionField = By.id("description");
  private By submitIssue = By.id("create-issue-submit");
  private By successPopup = By.className("aui-message-success");

  public void clickIssueCreate() {
    WebDriverFactory.getDriver().findElement(createButton).click();
  }

  public boolean projectFieldDisplayed() {
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5).getSeconds());
    return wait.until(presenceOfElementLocated(projectField)).isDisplayed();
  }

  public void editProjectName(String project) {
    WebDriverFactory.getDriver().findElement(projectField).click();
    WebDriverFactory.getDriver().findElement(projectField).sendKeys(project);
    WebDriverFactory.getDriver().findElement(projectField).sendKeys(Keys.TAB);
  }

  public void editIssueType(String issue) {
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5).getSeconds());
    wait.until(elementToBeClickable(issueTypeField)).isEnabled();
    WebDriverFactory.getDriver().findElement(issueTypeField).click();
    WebDriverFactory.getDriver().findElement(issueTypeField).sendKeys(issue);
    WebDriverFactory.getDriver().findElement(issueTypeField).sendKeys(Keys.TAB);
  }

  public void editSummary(String summary) {
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5).getSeconds());
    wait.until(elementToBeClickable(summaryInputField)).isEnabled();
    WebDriverFactory.getDriver().findElement(summaryInputField).click();
    WebDriverFactory.getDriver().findElement(summaryInputField).sendKeys(summary);
    WebDriverFactory.getDriver().findElement(summaryInputField).sendKeys(Keys.TAB);
  }

  public void editReporter(String reporterName) {
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5).getSeconds());
    wait.until(elementToBeClickable(reporterField)).isEnabled();
    WebDriverFactory.getDriver().findElement(reporterField).clear();
    WebDriverFactory.getDriver().findElement(reporterField).sendKeys(reporterName);
    WebDriverFactory.getDriver().findElement(reporterField).sendKeys(Keys.TAB);
  }

  public void editText(String descrText) {
    WebDriverFactory.getDriver().findElement(textTab).click();
    WebDriverFactory.getDriver().findElement(descriptionField).click();
    WebDriverFactory.getDriver().findElement(descriptionField).sendKeys(descrText);
  }

  public void clickSubmitIssue() {
    WebDriverFactory.getDriver().findElement(submitIssue).click();
  }

  public boolean isSuccessPopupDisplayed() {
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5).getSeconds());
    return wait.until(presenceOfElementLocated(successPopup)).isDisplayed();
  }
}