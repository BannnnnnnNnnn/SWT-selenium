package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;

    By BillingNewAddress = By.id("billing-address-select");
    By BillingAddress = By.id("billing:street1");
    By BillingCity = By.id("billing:city");
    By Billingregion = By.id("billing:region_id");
    By Billingzip = By.id("billing:postcode");
    By Billingtelephone = By.id("billing:telephone");

    By DifferentAddess = By.xpath("//label[@for='billing:use_for_shipping_no']");
    By BillingContinueBtn = By.xpath("//button[@onclick='billing.save()']//span//span[contains(text(),'Continue')]");

    By ShippingAddress = By.id("shipping:street1");
    By ShippingCity = By.id("shipping:city");
    By Shippingregion = By.id("shipping:region_id");
    By Shippingzip = By.id("shipping:postcode");
    By Shippingtelephone = By.id("shipping:telephone");
    By ShippingNewAddress = By.id("shipping-address-select");
    By ShippingContinueBtn = By.xpath("//button[@onclick='shipping.save()']");

    By ShippingMethodContinueBtn = By.xpath("//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]");

    By CheckMoneyOrder = By.xpath("//label[@for='p_method_checkmo']");
    By PaymentContinueBtn = By.xpath("//button[@onclick='payment.save()']");

    By PlaceOrderBtn = By.xpath("//button[@title='Place Order']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterBilling(String address, String city, String region, String zip, String telephone) {
        WebElement addressElement = driver.findElement(BillingAddress);
        addressElement.clear();
        addressElement.sendKeys(address);

        WebElement cityElement = driver.findElement(BillingCity);
        cityElement.clear();
        cityElement.sendKeys(city);

        Select regionDropdown = new Select(driver.findElement(Billingregion));
        regionDropdown.selectByValue(region);

        WebElement zipElement = driver.findElement(Billingzip);
        zipElement.clear();
        zipElement.sendKeys(zip);

        WebElement telephoneElement = driver.findElement(Billingtelephone);
        telephoneElement.clear();
        telephoneElement.sendKeys(telephone);
    }
    public void BillingNewAddress(){
        Select NewAddressDropdowm = new Select(driver.findElement(BillingNewAddress));
        NewAddressDropdowm.selectByVisibleText("New Address");
    }
    public void ShippingNewAddress(){
        Select NewAddressDropdowm = new Select(driver.findElement(ShippingNewAddress));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("shipping-address-select")));
        element.click();
        NewAddressDropdowm.selectByVisibleText("New Address");
    }
    public void clickDifferentAddess(){
        driver.findElement(DifferentAddess).click();
    }
    public void clickBillingContinue() {
        WebElement continueButton = driver.findElement(BillingContinueBtn);
        continueButton.click();
    }

    public void enterShipping(String address, String city, String region, String zip, String telephone) {
        WebElement addressElement = driver.findElement(ShippingAddress);
        addressElement.clear();
        addressElement.sendKeys(address);

        WebElement cityElement = driver.findElement(ShippingCity);
        cityElement.clear();
        cityElement.sendKeys(city);

        Select regionDropdown = new Select(driver.findElement(Shippingregion));
        regionDropdown.selectByValue(region);

        WebElement zipElement = driver.findElement(Shippingzip);
        zipElement.clear();
        zipElement.sendKeys(zip);

        WebElement telephoneElement = driver.findElement(Shippingtelephone);
        telephoneElement.clear();
        telephoneElement.sendKeys(telephone);
    }

    public void clickShippingContinue() {
        WebElement continueButton = driver.findElement(ShippingContinueBtn);
        continueButton.click();
    }

    public void clickShippingMethodContinue() {
        WebElement continueButton = driver.findElement(ShippingMethodContinueBtn);
        continueButton.click();
    }

    public void selectCheckMoneyOrderPaymentMethod() {
        WebElement checkMoneyOrderElement = driver.findElement(CheckMoneyOrder);
        checkMoneyOrderElement.click();
    }

    public void clickPaymentContinue() {
        WebElement continueButton = driver.findElement(PaymentContinueBtn);
        continueButton.click();
    }

    public void clickPlaceOrder() {
        WebElement placeOrderButtonElement = driver.findElement(PlaceOrderBtn);
        placeOrderButtonElement.click();
    }
}
