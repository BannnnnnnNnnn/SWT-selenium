package Baitap;

import POM.CartPage;
import POM.CheckoutPage;
import POM.LoginPage;
import POM.WishlistPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class testcase06 {
    @Test
    public void Testcase06() {
        String email = "TranVanGiaBantest9223913123sasd@gmail.com";
        String password = "123456";
        String billingAddress = "123 Main Street";
        String billingCity = "US";
        String billingRegion = "43";
        String billingZip = "10001";
        String billingTelephone = "1234567890";

        WebDriver driver = driverFactory.getChromeDriver();
        try {

            driver.get("http://live.techpanda.org/");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickMyAccountLink();
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();

//            for (String handle : driver.getWindowHandles()) {
//                driver.switchTo().window(handle);
//            }
            WebElement myWishlistLink = driver.findElement(By.linkText("MY WISHLIST"));
            myWishlistLink.click();

            WishlistPage wishlistPage = new WishlistPage(driver);
            wishlistPage.clickAddToCart();

            CartPage cartPage = new CartPage(driver);
            cartPage.selectCountry(billingCity);
            cartPage.selectRegion(billingRegion);
            cartPage.enterZip(billingZip);
            cartPage.clickEstimate();
            cartPage.selectShippingCost();
            //8. Verify Shipping cost generated
            String shipType = driver.findElement(By.xpath("//dt[normalize-space()='Flat Rate']")).getText();
            Assert.assertEquals(shipType, "Flat Rate");

            //String shipCost = driver.findElement(By.cssSelector("label[for='s_method_flatrate_flatrate']")).getText();

            cartPage.clickUpdateTotal();
            Thread.sleep(1000);

            //10. Verify shipping cost is added to total
            String shipTotal = driver.findElement(By.xpath("//td[normalize-space()='Shipping & Handling (Flat Rate - Fixed)']")).getText();
            Assert.assertTrue(!shipTotal.isEmpty());

            cartPage.clickProceedToCheckout();
            Thread.sleep(1000);

            CheckoutPage checkoutPage = new CheckoutPage(driver);
            checkoutPage.BillingNewAddress();
            checkoutPage.enterBilling(billingAddress, billingCity, billingRegion, billingZip, billingTelephone);
            checkoutPage.clickDifferentAddess();
            checkoutPage.clickBillingContinue();
            Thread.sleep(1000);

            checkoutPage.ShippingNewAddress();
            checkoutPage.enterShipping(billingAddress+"123", billingCity,billingRegion, billingZip+"123", billingTelephone+"999");
            checkoutPage.clickShippingContinue();
            Thread.sleep(1000);

            String shipMethod = driver.findElement(By.xpath("//dt[normalize-space()='Flat Rate']")).getText();
            Assert.assertEquals(shipMethod, "Flat Rate");

            checkoutPage.clickShippingMethodContinue();
            Thread.sleep(1000);

            checkoutPage.selectCheckMoneyOrderPaymentMethod();
            checkoutPage.clickPaymentContinue();
            Thread.sleep(1000);

            checkoutPage.clickPlaceOrder();
            Thread.sleep(3000);

            WebElement orderID = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/p[1]/a[1]"));
            System.out.println("Số đơn hàng đã được tạo: " + orderID.getText());

            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("C:\\Users\\HP\\Desktop\\SWT\\SWT\\selenium-webdriver-java\\screenshottestcase6.png"));
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}