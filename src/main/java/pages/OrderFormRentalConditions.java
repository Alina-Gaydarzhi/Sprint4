package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class OrderFormRentalConditions {
private WebDriver driver;

private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
private By rentalPeriodField = By.className("Dropdown-control");
private By blackCheckbox = By.id("black");
private By greyCheckbox = By.id("grey");
private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
private By orderButton = By.xpath(".//button[text()='Заказать' and contains(@class, 'Button_Middle__1CSJM')]");
private By orederModal = By.xpath("//div[contains(@class, 'Order_Modal__YZ-d3')]");

private By confirmOrderYesButton = By.xpath("//button[text()='Да']");
private By orderPlaced = By.xpath("//div[contains(@class, 'Order_ModalHeader__3FDaJ') and contains(text(), 'Заказ оформлен')]");

    public OrderFormRentalConditions(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFormRental(String deliveryDate, String rentalPeriod, String color, String comment) {
        selectDeliveryDate(deliveryDate);
        selectRentalPeriod(rentalPeriod);
        selectColorScooter(color);
        setComment(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(orederModal));
    }

    public void confirmOrderYesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(confirmOrderYesButton)).click();
    }

    public boolean orderPlacedDisplayed() {
        return driver.findElement(orderPlaced).isDisplayed();
    }

    private void selectDeliveryDate(String deliveryDate) {
        driver.findElement(dateField).click();
        driver.findElement(By.xpath("//div[contains(@aria-label, '" + deliveryDate + "')]")).click();
    }

    private void selectRentalPeriod(String rentalPeriod) {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath("//div[text()='" + rentalPeriod + "']")).click();
    }

    private void selectColorScooter(String color) {
        if ("black".equals(color)) {
            driver.findElement(blackCheckbox).click();
        } else if ("grey".equals(color)) {
            driver.findElement(greyCheckbox).click();
        }
    }

    private void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
}