package Baitap;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testcase09 {
    @Test
    public void Testcase09() {
        String couponCode = "GURU50";

        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("http://live.techpanda.org/");

            WebElement MobileLink = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
            MobileLink.click();

            WebElement AddToCartbtn = driver.findElement(By.xpath("//li[1]//div[1]//div[3]//button[1]//span[1]//span[1]"));
            AddToCartbtn.click();

            // Apply Coupon Code
            WebElement couponCodeInput = driver.findElement(By.id("coupon_code"));
            couponCodeInput.clear();
            couponCodeInput.sendKeys(couponCode);

            WebElement applyCouponButton = driver.findElement(By.xpath("//span[contains(text(),'Apply')]"));
            applyCouponButton.click();

            WebElement grandTotal = driver.findElement(By.cssSelector("strong span[class='price']"));

            String[] granTotalParts = grandTotal.getText().split("\\$");
            double price1 = Double.parseDouble(granTotalParts[1]);

            WebElement grandTotalDiscount = driver.findElement(By.cssSelector("strong span[class='price']"));
            String[] grandTotalDiscountParts = grandTotalDiscount.getText().split("\\$");
            double price2 = Double.parseDouble(grandTotalDiscountParts[1]);

            Assert.assertNotEquals(price1,price2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}
