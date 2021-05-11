package com.petclinic.shared.pages;

import com.petclinic.shared.base.PetClinicBasePage;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bajpaip
 * @since 19-04-2021
 */
public class PetClinicFindOwnersPage extends PetClinicBasePage{

    //PageTitle
    private static final String PAGE_TITLE = "Find Owners";

    //Locators
    private static final By FIND_OWNER_BUTTON = By.xpath("//button[contains(text(),'Find\n" + "')]");
    private static final By ADD_OWNER_BUTTON = By.xpath("//a[normalize-space()='Add Owner']");
    private static final By LAST_NAME_TEXTBOX = By.xpath("//input[@id='lastName']");

    public void clickFindOwner(){
        click(FIND_OWNER_BUTTON);
    }

    public void clickAddOwner(){
        click(ADD_OWNER_BUTTON);
    }

    public void setLastName(String lastName){
        setTextboxValue(LAST_NAME_TEXTBOX, lastName);
    }

    public Map<String, String> getOwnersInformationTable(int listSize) {
        int nameIndex = 1;
        int telephoneIndex = 4;

        Map<String, String> ownersMap = new HashMap<>();
        for (int i = 1; i <= listSize; i++) {

            String name = driver.findElement(By.xpath(".//*[@class=\"container xd-container\"]/table/tbody/tr[" + (i) + "]/td[" + (nameIndex) + "]")).getText();
          String  telephoneNumber = driver.findElement(By.xpath(".//*[@class=\"container xd-container\"]/table/tbody/tr[" + (i) + "]/td[" + (telephoneIndex) + "]")).getText();
            ownersMap.put(telephoneNumber, name);
        }
        return ownersMap;
    }

}