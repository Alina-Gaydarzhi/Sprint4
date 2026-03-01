import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebElement cookieButton = driver.findElement(By.id("rcc-confirm-button"));
        cookieButton.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}