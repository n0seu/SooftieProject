import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task3 {
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
    void shouldVerifyIsLogoOnMainPage() {

        WebElement logo = driver.findElement(By.className("logo"));
        WebElement searchQuery = driver.findElement(By.id("search_query_top"));

        Assertions.assertTrue(logo.isDisplayed());
        Assertions.assertTrue(searchQuery.isDisplayed());
    }

    @Test
    void shouldVerifyIsLogoOnSingInPage() {

        WebElement signInButton = driver.findElement(By.className("login"));
        signInButton.click();

        WebElement logo = driver.findElement(By.className("logo"));
        WebElement searchQuery = driver.findElement(By.id("search_query_top"));

        Assertions.assertTrue(logo.isDisplayed());
        Assertions.assertTrue(searchQuery.isDisplayed());
    }
}
