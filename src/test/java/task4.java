import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task4 {
    static WebDriver driver;

    @BeforeAll
    static void prepareBrowser() {
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @BeforeEach
    void cookiesClear() {
        driver.manage().deleteAllCookies();
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }

    @Test
    void shouldTakeYouOnContactPage() {

        WebElement contactUsButton = driver.findElement(By.cssSelector("#contact-link > a"));
        contactUsButton.click();

        String contactUsText = driver.findElement(By.cssSelector("#center_column > h1")).getText();

        Assertions.assertTrue(contactUsText.contains("CUSTOMER SERVICE - CONTACT US"));
    }
}
