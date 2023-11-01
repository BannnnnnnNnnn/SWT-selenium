package Baitap;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class testcase04 {

    @Test
    public void Testcase04(){

        WebDriver driver = driverFactory.getChromeDriver();

        try {
            // TC04: Verify that you are able to compare two products
            // Step 1: Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            // Step 2: Click on "MOBILE" menu
            WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
            mobileMenu.click();

            // Step 3: Click on "Add To Compare" for 2 mobiles (Sony Xperia & iPhone)
            WebElement sonyXperiaCompare = driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[2]//a[1]"));
            sonyXperiaCompare.click();
            WebElement iPhoneCompare = driver.findElement(By.xpath("//li[3]//div[1]//div[3]//ul[1]//li[2]//a[1]"));
            iPhoneCompare.click();

            // Step 4: Click on "COMPARE" button
            WebElement compareButton = driver.findElement(By.xpath("//button[@title='Compare']//span//span[contains(text(),'Compare')]"));
            compareButton.click();
            String mainWindowHandle = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // Step 5: Verify the pop-up window and check that the products are reflected in it
            WebElement compareHeading = driver.findElement(By.xpath("//h1[normalize-space()='Compare Products']"));
            Assert.assertEquals(compareHeading.getText(),"COMPARE PRODUCTS");

            // Step 6: Close the Popup Windows
            driver.close();
            driver.switchTo().window(mainWindowHandle);

            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("C:\\Users\\HP\\Desktop\\SWT\\SWT\\selenium-webdriver-java\\screenshottestcase4.png"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }
}
