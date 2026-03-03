package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderFormDataCustomer {
    private WebDriver driver;

    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public OrderFormDataCustomer(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(String name, String surname, String address, String stationName, String phone) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroField).sendKeys(stationName);
        selectMetroStation(stationName);
        driver.findElement(phoneField).sendKeys(phone);
    }

    private void selectMetroStation(String stationName) {
        driver.findElement(By.xpath(".//button[contains(., '" + stationName + "')]")).click();
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
}