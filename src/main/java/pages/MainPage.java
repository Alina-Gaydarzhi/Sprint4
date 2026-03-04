package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    private By cookieButton = By.id("rcc-confirm-button");
    private By orderButtonHeader = By.xpath("//div[contains(@class, 'Header_Header')]//button[text()='Заказать']");
    private By orderButtonMiddle = By.xpath("//div[contains(@class, 'Home_FinishButton__')]/button[text()='Заказать']");
    private By lastQuestionLocator = By.id("accordion__heading-7");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookies() {
        driver.findElement(cookieButton).click();
    }

    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }

    public void scrollToOrderButtonMiddle() {
        WebElement middleButton = driver.findElement(orderButtonMiddle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", middleButton);
    }
    public void clickOrderButtonMiddle() {
        driver.findElement(orderButtonMiddle).click();
    }


    public void scrollLastItemQuestion() {
        WebElement lastItemQuestion = driver.findElement(lastQuestionLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastItemQuestion);
    }

    public void clickQuestion(int indexItemQuestion) {
        By questionLocator = By.id("accordion__heading-" + indexItemQuestion);
        driver.findElement(questionLocator).click();
    }

    public String getTextAnswer(int indexItemQuestion) {
        By answerLocator = By.id("accordion__panel-" + indexItemQuestion);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(answerLocator));
        return driver.findElement(answerLocator).getText();
    }

}