import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;

    @Before
    public void startUp() {
// WebDriverManager.firefoxdriver().setup();
// driver = new FirefoxDriver();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);

        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage.acceptCookies();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}