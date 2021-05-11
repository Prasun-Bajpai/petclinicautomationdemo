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
public class PetClinicOwnerInformationPage extends PetClinicBasePage {

    //PageTitle
    private static final String PAGE_TITLE = "Owner Information";

    //Locators
    private static final By PAGE_LABLE = By.xpath("//h2[normalize-space()]");
    private static final By FIND_OWNER_BUTTON = By.xpath("//span[normalize-space()='Find owners']");

    private static int Size;
    private String name;
    private String telephoneNumber;


    public String getPageLable(){
        return super.getText(PAGE_LABLE);
    }
    public int getOwnerInformationListRowSize() {
        List row = driver.findElements(By.xpath(".//*[@class=\"table table-striped\"]/table/tbody/tr/td[1]"));
        return Size = +row.size();
    }

    public void clickFindOwner(){
        super.click(FIND_OWNER_BUTTON);
    }

    public int getOwnersListColumnSize() {
        List col = driver.findElements(By.xpath(".//*[@class=\"table table-striped\"]/table/thead/tr/th"));
        return Size = +col.size();
    }

    public List<String> getOwnerInformationPane(int listSize){
        List<String> listOfOwnerInformation = new ArrayList<>();
        for(int i = 1; i<=listSize ; i++){

            name = driver.findElement(By.xpath(".//*[@class=\"container xd-container\"]/table/tbody/tr["+(i)+"]/td[" + (1) + "]")).getText();
            listOfOwnerInformation.add(name);
        }
        return listOfOwnerInformation;
    }

    public String getPetInformationPane(){
        String petInformation = driver.findElement(By.xpath(".//*[@class=\"container xd-container\"]/table[2]/tbody/tr[1]")).getText();
        return petInformation;
    }
}