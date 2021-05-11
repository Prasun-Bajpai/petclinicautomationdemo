package com.petclinic.shared.pages;

import com.petclinic.shared.base.PetClinicBasePage;
import com.petclinic.shared.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

/**
 * @author bajpaip
 * @since 18-04-2021
 */
public class PetClinicWelcomePage extends PetClinicBasePage {

    //PageTitle
    private static final String PAGE_TITLE = "Welcome";

    //Locators
    private static final By HOME_LINK = By.xpath("//a[@title='home page']");
    private static final By IMAGE = By.xpath("//img[contains(@class,'img-responsive')]");
    private static final By FIND_OWNERS_LINK = By.xpath("//a[@title='find owners']");
    private static final By VETERINARIANS_LINK = By.xpath("//span[normalize-space()='Veterinarians']");
    private static final By ERROR_LINK = By.xpath("//span[contains(@class,'glyphicon-warning-sign')]");

    @Override
    public String getPageTitle() {
        return PAGE_TITLE;
    }

    public void clickFindOwners(){
       click(FIND_OWNERS_LINK);
    }

    public void clickVeterinarians(){
        click(VETERINARIANS_LINK);
    }

    public void clickError(){
        click(ERROR_LINK);
    }

    public boolean isImagePresentOnWelcomePage(){
      return  isImagePresent(IMAGE);
    }

    public void captureImageOnWelcomePage() throws IOException {
        super.captureImage(IMAGE);
    }

    public Boolean isCapturedImageDifferent() throws IOException{
      return super.compareImages(IMAGE);
    }

}
