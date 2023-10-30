/*

Test Steps:

1. Goto http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)

4. Click on Sony Xperia mobile

5. Read the Sony Xperia mobile from detail page.

6. Compare Product value in list and details page should be equal ($100).

*/

package Baitap;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testcase02 {

    @Test
    public void Testcase02(){

        WebDriver driver = driverFactory.getChromeDriver();

        try {
            //1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //2. Click on "MOBILE" menu
            WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
            mobileMenu.click();

            //3. Read the cost of Sony Xperia mobile (which is $100)
            WebElement sonyXperiaPriceElement = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]"));
            String sonyXperiaPrice = sonyXperiaPriceElement.getText();

            //4. Click on Sony Xperia mobile
            WebElement sonyXperiaLink = driver.findElement(By.xpath("//a[@title='Sony Xperia']"));
            sonyXperiaLink.click();

            //5. Read the Sony Xperia mobile from detail page.
            WebElement sonyXperiaDetailPriceElement = driver.findElement(By.xpath("//span[@class='price']"));
            String sonyXperiaDetailPrice = sonyXperiaDetailPriceElement.getText();

            //6. Compare Product value in list and details page should be equal ($100).
            Assert.assertEquals(sonyXperiaPrice, sonyXperiaDetailPrice);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }
}
