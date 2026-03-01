package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FAQPage {
    private WebDriver driver;

    public FAQPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollLastItemQuestion() {
        WebElement lastItemQuestion = driver.findElement(By.id("accordion__heading-7"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastItemQuestion);
    }

    public void clickItemQuestionIndex(int indexItemQuestion) {
        driver.findElement(By.id("accordion__heading-" + indexItemQuestion)).click();
    }

    public String getTextAnswer(int indexItemQuestion) {
        return driver.findElement(By.id("accordion__panel-" + indexItemQuestion)).getText();
    }
}