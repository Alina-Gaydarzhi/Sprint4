package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    private By cookieButton = By.id("rcc-confirm-button");
    private By orderButtonHeader = By.xpath("//div[2]/button[text()='Заказать']");
    private By orderButtonMiddle = By.xpath("//div[contains(@class, 'Home_FinishButton__')]/button[text()='Заказать']");

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
        WebElement middleButton = driver.findElement(By.xpath("//button[text()='Заказать' and contains(@class, 'Button_Middle__1CSJM')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", middleButton);
    }

    public void clickOrderButtonMiddle() {
        driver.findElement(orderButtonMiddle).click();
    }
}