package com.petclinic.shared.pages;

import com.petclinic.shared.base.PetClinicBasePage;
import org.openqa.selenium.By;

/**
 * @author bajpaip
 * @since 19-04-2021
 */
public class PetClinicNewPetPage  extends PetClinicBasePage {

    //PageTitle
    private static final String PAGE_TITLE = "New Pet";

    //Locators
    private static final By OWNER_NAME_LABLE = By.xpath("//div[@class='col-sm-10']");
    private static final By ADD_PET_BUTTON = By.xpath("//button[normalize-space()='Add Pet']");
    private static final By NAME_TEXT_BOX = By.xpath("//input[@id='name']");
    private static final By BIRTH_DATE_TEXT_BOX = By.xpath("//input[@id='birthDate']");
    private static final By TYPE_DROPDOWN = By.xpath("//select[@id='type']");

    public void clickAddPet() {
        click(ADD_PET_BUTTON);
    }

    public void setName(String name) {
        setTextboxValue(NAME_TEXT_BOX, name);
    }

    public void setBirthDate(String birthDate) {
        setTextboxValue(BIRTH_DATE_TEXT_BOX, birthDate);
    }

    public String getOwnerName(){
      return getText(OWNER_NAME_LABLE);
    }
    public void selectType(String type){
        selectFromDropdown(TYPE_DROPDOWN, type);
    }

}
