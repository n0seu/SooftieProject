import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task8 {
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

    public void login(){ // Alternatywa z (String a, String b)
        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("akselenium@test.com"); //email.sendKeys(a);

        WebElement passwd = driver.findElement(By.cssSelector("#passwd"));
        passwd.sendKeys("zaq1@WSX"); //passwd.sendKeys(b);
    }

    @Test
    void shouldLoginInToAccountWithMethod() {

        WebElement signInButton = driver.findElement(By.className("login"));
        signInButton.click();

        login(); // login("valueA", "valueB")

        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.click();

        String myAccountText = driver.findElement(By.className("page-heading")).getText();
        Assertions.assertEquals("MY ACCOUNT", myAccountText);
    }
}
