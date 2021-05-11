package com.petclinic.shared.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.By.xpath;

/**
 * @author bajpaip
 * @since 18-04-2021
 */
public class PetClinicBasePage extends TestBase {
    String handle = driver.getWindowHandle();

    public void switchToPage() {
        driver.switchTo().window(handle).getTitle().contains(getPageTitle());
    }

    public String getPageTitle() {
        return driver.switchTo().window(handle).getTitle();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void setTextboxValue(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    public void selectFromDropdown(By Locator, String value){
        Select se = new Select(driver.findElement(Locator));
       se.selectByVisibleText(value);
    }

    public String getText(By Locator){
      return  driver.findElement(Locator).getText();
    }

    public boolean isImagePresent(By locator) {
        return (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", (driver.findElement(locator)));
    }

    public void captureImage(By locator)throws IOException {
        Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, driver.findElement(locator));
        ImageIO.write(logoImageScreenshot.getImage(),"png",new File("C://Projects/petclinicautomationdemo/screenshots/welcomeScreenCapture.png"));
        File f = new File("C://Projects/petclinicautomationdemo/screenshots/welcomeScreenCapture.png");
        if(f.exists())
        {
            System.out.println("Image File Captured");
    }
        else
        {
            System.out.println("Image File NOT exist");
        }
    }

    public Boolean compareImages(By locator) throws IOException {
        BufferedImage expectedImage = ImageIO.read(new File("C://Users/bajpaip/Desktop/pets.png"));

        Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, driver.findElement(locator));
        BufferedImage actualImage = logoImageScreenshot.getImage();

        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
        if (diff.hasDiff() == false) {
            return true;
        }return false;
    }
}