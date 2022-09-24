import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task5 {
    static WebDriver driver;

    @BeforeAll
    static void prepareBrowser() {
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
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
    void shouldTakeYouOnMainPage() {

        WebElement logo = driver.findElement(By.className("logo"));
        logo.click();

        WebElement homeslider = driver.findElement(By.id("homeslider"));
        String practiceSelenium = driver.findElement(By.cssSelector("#editorial_block_center > h1")).getText();

        Assertions.assertTrue(homeslider.isDisplayed());
        Assertions.assertEquals("Automation Practice Website", practiceSelenium);
    }
}
