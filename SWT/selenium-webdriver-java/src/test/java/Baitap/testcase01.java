/*

Test Steps

Step 1. Go to http://live.techpanda.org/

Step 2. Verify Title of the page

Step 3. Click on -> MOBILE -> menu

Step 4. In the list of all mobile , select SORT BY -> dropdown as name

Step 5. Verify all products are sorted by name

*/

package Baitap;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class testcase01 {

    @Test
    public  static void Testcase01() {
        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //2. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            //3. Verify Title of the page
            WebElement actualTitle = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]"));
            Assert.assertEquals(actualTitle.getText(), "THIS IS DEMO SITE FOR   ");
            //4. Click on -> MOBILE -> menu
            WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
            mobileMenu.click();
            //5. In the list of all mobile , select SORT BY -> dropdown as name
            WebElement sortByDropdown = driver.findElement(By.cssSelector("select[title='Sort By']"));
            Select dropdown = new Select(sortByDropdown);
            dropdown.selectByVisibleText("Name");
            //6. screenshot
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("C:\\Users\\HP\\Desktop\\selenium-webdriver-java\\selenium-webdriver-java\\screenshot.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}
