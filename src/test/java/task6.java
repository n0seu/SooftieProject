import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class task6 {
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
    void shouldAddProductToCart() {

        WebElement checkProduct = driver.findElement(By.cssSelector("a[class='product-name'][title='Faded Short Sleeve T-shirts']"));
        checkProduct.click();

        WebElement addToCart = driver.findElement(By.cssSelector("button[class='exclusive']"));
        addToCart.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Proceed to checkout']")));

        WebElement proceedToCheckoutButton = driver.findElement(By.cssSelector("a[title='Proceed to checkout']"));
        String productAddedSuccsefully = driver.findElement(By.cssSelector(".layer_cart_product > h2")).getText();

        Assertions.assertTrue(proceedToCheckoutButton.isDisplayed());
        Assertions.assertEquals("Product successfully added to your shopping cart", productAddedSuccsefully);
    }
}
