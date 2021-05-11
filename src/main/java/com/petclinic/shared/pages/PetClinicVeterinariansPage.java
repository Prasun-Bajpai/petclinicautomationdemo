package com.petclinic.shared.pages;

import com.petclinic.shared.base.PetClinicBasePage;
import com.petclinic.shared.base.TestBase;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bajpaip
 * @since 19-04-2021
 */
public class PetClinicVeterinariansPage extends PetClinicBasePage {

    //PageTitle
    private static final String PAGE_TITLE = "Veterinarians";

    //Locators
    private static final By NAME = By.xpath("//th[normalize-space()='Name']");
    private static final By LIST_OF_VETERINARIANS = By.xpath(".//*[@id='vets']/table/thead/tr/th");
    private static int size ;

    public int getVeterinariansNameListRowSize() {
        List row = driver.findElements(By.xpath(".//*[@class=\"container xd-container\"]/table/tbody/tr/td[1]"));
        return size = +row.size();
    }

    public int getVeterinariansNameListColumnSize() {
        List col = driver.findElements(By.xpath(".//*[@class=\"container xd-container\"]/table/thead/tr/th"));
        return size = +col.size();
    }

    public List<String> getVeterinarians(int listSize){
        List<String> listOfVeterinarians = new ArrayList<>();
        for(int i = 1; i<=listSize ; i++){

               String veterinariansName = driver.findElement(By.xpath(".//*[@class=\"container xd-container\"]/table/tbody/tr["+(i)+"]/td[" + (1) + "]")).getText();
                listOfVeterinarians.add(veterinariansName);
        }
        return listOfVeterinarians;
    }

}