package com.petclinic.shared.pages;

import com.petclinic.shared.base.PetClinicBasePage;
import org.openqa.selenium.By;

/**
 * @author bajpaip
 * @since 19-04-2021
 */
public class PetClincNewOwnerPage extends PetClinicBasePage {

    //PageTitle
    private static final String PAGE_TITLE = "Owners";

    //Locators
    private static final By FIND_OWNER_BUTTON = By.xpath("//button[contains(text(),'Find\n" + "')]");
    private static final By ADD_OWNER_BUTTON = By.xpath("//a[normalize-space()='Add Owner']");
    private static final By ADD_NEW_PET_BUTTON = By.xpath("//a[contains(text(),'Add\n" + "')]");
    private static final By FIRST_NAME_TEXT_BOX = By.xpath("//input[@id='firstName']");
    private static final By LAST_NAME_TEXT_BOX = By.xpath("//input[@id='lastName']");
}
