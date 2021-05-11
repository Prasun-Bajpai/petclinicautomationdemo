package com.petclinic.shared.pages;

import com.petclinic.shared.base.PetClinicBasePage;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bajpaip
 * @since 19-04-2021
 */
public class PetClinicOwnersPage extends PetClinicBasePage {

    //PageTitle
    private static final String PAGE_TITLE = "Owners";

    //Locators
    private static final By FIND_OWNER_BUTTON = By.xpath("//button[contains(text(),'Find\n" + "')]");
    private static final By ADD_OWNER_BUTTON = By.xpath("//button[normalize-space()='Add Owner']");
    private static final By ADD_NEW_PET_BUTTON = By.xpath("//a[contains(text(),'Add\n" + "')]");
    private static final By FIRST_NAME_TEXT_BOX = By.xpath("//input[@id='firstName']");
    private static final By LAST_NAME_TEXT_BOX = By.xpath("//input[@id='lastName']");
    private static final By ADDRESS_TEXT_BOX = By.xpath("//input[@id='address']");
    private static final By CITY_TEXT_BOX = By.xpath("//input[@id='city']");
    private static final By TELEPHONE_TEXT_BOX = By.xpath("//input[@id='telephone']");

    private static int Size;
    private String name;
    private String telephoneNumber;

    public void clickFindOwner() {
        click(FIND_OWNER_BUTTON);
    }

    public void clickAddNewPet(){
        click(ADD_NEW_PET_BUTTON);
    }

    public void clickAddOwner() {
        click(ADD_OWNER_BUTTON);
    }

    public void setFirstName(String firstName) {
        setTextboxValue(FIRST_NAME_TEXT_BOX, firstName);
    }

    public void setLastName(String lastName) {
        setTextboxValue(LAST_NAME_TEXT_BOX, lastName);
    }

    public void setAddress(String address) {
        setTextboxValue(ADDRESS_TEXT_BOX, address);
    }

    public void setCity(String city) {
        setTextboxValue(CITY_TEXT_BOX, city);
    }

    public void setTelephone(String telephoneNumber) {
        setTextboxValue(TELEPHONE_TEXT_BOX, telephoneNumber);
    }

    public int getOwnersListRowSize() {
        List row = driver.findElements(By.xpath(".//*[@class=\"container xd-container\"]/table/tbody/tr/td[1]"));
        return Size = +row.size();
    }

    public int getOwnersListColumnSize() {
        List col = driver.findElements(By.xpath(".//*[@class=\"container xd-container\"]/table/thead/tr/th"));
        return Size = +col.size();
    }

    public Map<String, String> getOwners(int listSize) {
        int nameIndex = 1;
        int telephoneIndex = 4;

        Map<String, String> ownersMap = new HashMap<>();
        for (int i = 1; i <= listSize; i++) {

            name = driver.findElement(By.xpath(".//*[@class=\"container xd-container\"]/table/tbody/tr[" + (i) + "]/td[" + (nameIndex) + "]")).getText();
            telephoneNumber = driver.findElement(By.xpath(".//*[@class=\"container xd-container\"]/table/tbody/tr[" + (i) + "]/td[" + (telephoneIndex) + "]")).getText();
            ownersMap.put(telephoneNumber, name);
        }
        return ownersMap;
    }
    public List<String> getOwnerInformationList(int listSize){
        List<String> listOfOwnerInformation = new ArrayList<>();
        for(int i = 1; i<=listSize ; i++){

            name = driver.findElement(By.xpath(".//*[@class=\"container xd-container\"]/table/tbody/tr["+(i)+"]/td[" + (1) + "]")).getText();
            listOfOwnerInformation.add(name);
        }
        return listOfOwnerInformation;
    }

}