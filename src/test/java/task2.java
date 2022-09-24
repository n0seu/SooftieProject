import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task2 {
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
    void shouldVerifySignInWithNoPassword() {

        WebElement signInButton = driver.findElement(By.className("login"));
        signInButton.click();

        WebElement emailInput = driver.findElement(By.cssSelector("#email"));
        emailInput.sendKeys("test123@test.com");

        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.click();

        String alertText = driver.findElement(By.cssSelector("#center_column > .alert-danger")).getText();
        Assertions.assertEquals("There is 1 error\n" +
                "Password is required.", alertText);
        Assertions.assertTrue(alertText.contains("Password is required."));
    }
}
