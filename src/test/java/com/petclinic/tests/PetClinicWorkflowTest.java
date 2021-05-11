package com.petclinic.tests;

import com.petclinic.shared.base.TestBase;
import com.petclinic.shared.data.PetClinicOwnersData;
import com.petclinic.shared.data.PetClinicPetsData;
import com.petclinic.shared.data.PetClinicVeterinariansData;
import com.petclinic.shared.helper.DataHelper;
import com.petclinic.shared.pages.*;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author bajpaip
 * @since 18-04-2021
 */
public class PetClinicWorkflowTest extends TestBase {

    //Constants
    private static final int VETERINARIANS_ROW_SIZE = 6;
    private static final int VETERINARIANS_COLUMN_SIZE = 2;
    private static final int EXISTING_OWNERS_LIST_SIZE = 10;

    //Pages
    private PetClinicWelcomePage welcomePage;
    private PetClinicVeterinariansPage veterinariansPage;
    private PetClinicOwnersPage ownersPage;
    private PetClinicNewPetPage newPetPage;
    private PetClinicOwnerInformationPage ownerInformationPage;
    private PetClinicFindOwnersPage findOwnersPage;

    //Data
    private List<PetClinicVeterinariansData.VeterinariansData> veterinariansData = new ArrayList<>();
    private List<PetClinicOwnersData.OwnersData> ownersData = new ArrayList<>();
    private PetClinicOwnersData.OwnersAddData ownersAddData;
    private PetClinicPetsData.PetAddData petsAddData;

    @BeforeClass
    public void setUp() throws IOException {
        initialization();
        welcomePage = new PetClinicWelcomePage();
        veterinariansPage = new PetClinicVeterinariansPage();
        ownersPage = new PetClinicOwnersPage();
        newPetPage = new PetClinicNewPetPage();
        ownerInformationPage = new PetClinicOwnerInformationPage();
        findOwnersPage = new PetClinicFindOwnersPage();

        //Fetching test data
        veterinariansData = DataHelper.getVeterinariansData().getVeterinariansData();
        ownersData = DataHelper.getOwnersData().getOwnersData();
        ownersAddData = DataHelper.getOwnersData().getOwnerAddData();
        petsAddData = DataHelper.getPetsData().getPetAddData();
    }

    @Test(description = "This test verifies if image is present on welcome page and it's the expected image", priority = 0)
    public void testIfImageIsSameAsExpected() throws IOException {
        welcomePage.switchToPage();

        if (!welcomePage.isImagePresentOnWelcomePage()) {
            Assert.fail("Image is not present on home page ...!!!");
        }

        welcomePage.captureImageOnWelcomePage();
        welcomePage.isImagePresentOnWelcomePage();

        if (!welcomePage.isCapturedImageDifferent()) {
            Assert.fail("Image present on the welcome page is not a valid image ...!!!");
        }
    }

    @Test(description = "This test verifies if all the list of veterinarians contains all veterinarians names")
    public void testToFindAllVeterinarians() {
        welcomePage.clickVeterinarians();

        Assert.assertEquals("Number of columns in Veterinarians list is not correct", VETERINARIANS_COLUMN_SIZE, veterinariansPage.getVeterinariansNameListColumnSize());
        Assert.assertEquals("Number of rows in Veterinarians list is not correct", VETERINARIANS_ROW_SIZE, veterinariansPage.getVeterinariansNameListRowSize());

        List<String> veterianariansInformation = veterinariansPage.getVeterinarians(VETERINARIANS_ROW_SIZE);

        for (PetClinicVeterinariansData.VeterinariansData v : veterinariansData) {
            Assert.assertTrue("Name is not present in the list", veterianariansInformation.contains((v.getName())));
        }
    }

    @Test(description = "This test verifies if all the owners with respect to there telephone numbers in owners page")
    public void testToFindAllExistingOwners() {
        welcomePage.clickFindOwners();

        findOwnersPage.switchToPage();
        findOwnersPage.clickFindOwner();

        Map<String, String> ownersNameAndTelephoneData = ownersPage.getOwners(EXISTING_OWNERS_LIST_SIZE);
        for (PetClinicOwnersData.OwnersData o : ownersData) {
            String ownersName = ownersNameAndTelephoneData.get(o.getTelephone());
            Assert.assertTrue("Owner is not present in the list...!!!", ownersName.contentEquals(o.getName()));
        }
    }

    @Test(description = "This test verifies if a new owner can be added via owners page")
    public void testToVerifyAddNewOwner() {
        welcomePage.clickFindOwners();

        findOwnersPage.switchToPage();
        findOwnersPage.clickAddOwner();

        ownersPage.switchToPage();
        ownersPage.setFirstName(ownersAddData.getFirstName());
        ownersPage.setLastName(ownersAddData.getLastName());
        ownersPage.setAddress(ownersAddData.getAddress());
        ownersPage.setCity(ownersAddData.getCity());
        ownersPage.setTelephone(ownersAddData.getTelephone());
        ownersPage.clickAddOwner();
        ownersPage.clickAddNewPet();

        newPetPage.switchToPage();
        newPetPage.setName(petsAddData.getName());
        newPetPage.setBirthDate(petsAddData.getBirthDate());
        newPetPage.selectType(petsAddData.getType());
        newPetPage.clickAddPet();

        Assert.assertEquals("Owner Information", ownerInformationPage.getPageLable());
    }

    @Test(description = "This test verifies the information of a new owner and pet", dependsOnMethods = "testToVerifyAddNewOwner")
    public void testToVerifyAddedInformation() {
        ownerInformationPage.switchToPage();

        List<String> ownerInformation = ownerInformationPage.getOwnerInformationPane(4);

        //Verify newly added owner's information
        Assert.assertTrue("Name of the owner is not present in the list", ownerInformation.get(0).equals(ownersAddData.getFirstName() + " " + ownersAddData.getLastName()));
        Assert.assertTrue("Address is not present in the list", ownerInformation.get(1).equals(ownersAddData.getAddress()));
        Assert.assertTrue("City is not present in the list", ownerInformation.get(2).equals(ownersAddData.getCity()));
        Assert.assertTrue("Telephone is not present in the list", ownerInformation.get(3).equals(ownersAddData.getTelephone()));
        Assert.assertTrue("Name of the pet is not present in the list", ownerInformationPage.getPetInformationPane().contains(petsAddData.getName()));
        Assert.assertTrue("Date of Birth of the pet is not present in the list", ownerInformationPage.getPetInformationPane().contains(petsAddData.getBirthDate()));
        Assert.assertTrue("Type of pet is not present in the list", ownerInformationPage.getPetInformationPane().contains(petsAddData.getType()));
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp() {
        driver.quit();
    }
}
