package Baitap;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;

public class testcase10 {
    @Test
    public void Testcase10() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("http://live.techpanda.org/index.php/backendlogin");

            // Login the credentials provided
            WebElement usernameInput = driver.findElement(By.id("username"));
            WebElement passwordInput = driver.findElement(By.id("login"));

            usernameInput.clear();
            usernameInput.sendKeys("user01");
            passwordInput.clear();
            passwordInput.sendKeys("guru99com");

            WebElement loginButton = driver.findElement(By.xpath("//input[@title='Login']"));
            loginButton.click();

            WebElement closePopup = driver.findElement(By.xpath("//span[normalize-space()='close']"));
            closePopup.click();
            // Go to Sales -> Orders menu
            WebElement salesMenu = driver.findElement(By.xpath("//span[normalize-space()='Sales']"));

            Actions actions = new Actions(driver);
            actions.moveToElement(salesMenu).perform();
            WebElement ordersSubMenu = driver.findElement(By.xpath("//span[normalize-space()='Orders']"));
            ordersSubMenu.click();

//            Actions builder = new Actions(driver);
//            builder.moveToElement(salesMenu).moveToElement(ordersSubMenu).click().build().perform();

            // Input OrderId and FromDate -> ToDate
            WebElement orderIdInput = driver.findElement(By.id("sales_order_grid_filter_real_order_id"));
            WebElement fromDateInput = driver.findElement(By.name("created_at[from]"));
            WebElement toDateInput = driver.findElement(By.name("created_at[to]"));

            orderIdInput.sendKeys("100000001");
            fromDateInput.sendKeys("2023-11-01");
            toDateInput.sendKeys("2023-11-30");

            // Click Search button
            WebElement searchButton = driver.findElement(By.xpath("//span[contains(text(),'Search')]"));
            searchButton.click();

            Thread.sleep(3000);
            // Screenshot capture
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("C:\\Users\\HP\\Desktop\\SWT\\SWT\\selenium-webdriver-java\\screenshottestcase10.png"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
