package com.petclinic.shared.helper;

import com.google.common.io.Resources;
import com.petclinic.shared.data.PetClinicOwnersData;
import com.petclinic.shared.data.PetClinicPetsData;
import com.petclinic.shared.data.PetClinicVeterinariansData;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author bajpaip
 * @since 18-04-2021
 */
public class DataHelper {

    private static final String VETERINARIANS_FILE_NAME = "model/veterinariansData.json";
    private static final String OWNERS_FILE_NAME = "model/ownersData.json";
    private static final String PETS_FILE_NAME = "model/petsData.json";

    /**
     * Method to get the absolute path for the file (usually json data file)
     *
     * @param fileName name of the file
     * @return
     */
    private static String getAbsolutePathForFile(String fileName) {
        return getFileFromProjectOrJar(fileName).getAbsolutePath();
    }

    public static PetClinicVeterinariansData getVeterinariansData() {

        return JsonHelper.parseJSONFileToObjects(getAbsolutePathForFile(VETERINARIANS_FILE_NAME), PetClinicVeterinariansData.class);

    }

    public static PetClinicOwnersData getOwnersData() {

        return JsonHelper.parseJSONFileToObjects(getAbsolutePathForFile(OWNERS_FILE_NAME), PetClinicOwnersData.class);

    }

    public static PetClinicPetsData getPetsData() {

        return JsonHelper.parseJSONFileToObjects(getAbsolutePathForFile(PETS_FILE_NAME), PetClinicPetsData.class);

    }

    public static File getFileFromProjectOrJar(String relativePathInsideResources) {

        File outputFile = FileUtils.toFile(Resources.getResource(relativePathInsideResources));

        return outputFile;
    }

}

