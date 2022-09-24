import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class task7 {
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
    void shouldDeleteAddedProductFromCart() {

        WebElement checkProduct = driver.findElement(By.cssSelector("a[class='product-name'][title='Faded Short Sleeve T-shirts']"));
        checkProduct.click();

        WebElement addToCart = driver.findElement(By.cssSelector("button[class='exclusive']"));
        addToCart.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Proceed to checkout']")));

        WebElement proceedToCheckoutButton = driver.findElement(By.cssSelector("a[title='Proceed to checkout']"));
        proceedToCheckoutButton.click();

        WebElement deleteProduct = driver.findElement(By.className("icon-trash"));
        deleteProduct.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#center_column > .alert-warning")));

        String emptyCartAlert = driver.findElement(By.cssSelector("#center_column > .alert-warning")).getText();
        Assertions.assertEquals("Your shopping cart is empty.", emptyCartAlert);
    }
}
