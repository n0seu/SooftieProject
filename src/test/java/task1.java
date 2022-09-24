import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task1 {
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
    void shouldVerifySignInWithNoLogin() {

        WebElement signInButton = driver.findElement(By.className("login"));
        signInButton.click();

        WebElement passwordInput = driver.findElement(By.cssSelector("#passwd"));
        passwordInput.sendKeys("1qaz@WSX");

        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.click();

        String alertText = driver.findElement(By.cssSelector("#center_column > .alert-danger")).getText();
        Assertions.assertEquals("There is 1 error\n" +
                "An email address required.", alertText);
        Assertions.assertTrue(alertText.contains("An email address required."));
    }
}
