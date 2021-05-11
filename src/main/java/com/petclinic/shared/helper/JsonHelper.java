package com.petclinic.shared.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petclinic.shared.data.PetClinicVeterinariansData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author bajpaip
 * @since 18-04-2021
 */
public class JsonHelper {

    private JsonHelper() {
    }

//    /**
//     * Method to deserialize a json file to list of Objects (For example, please refer timecardData.json and EFPTimecardApiTest)
//     *
//     * @param fileName  json file location + name
//     * @param className class to which the json is to be serialized
//     * @return deserialized list of objects of the class.
//     */
//    public static PetClinicVeterinariansData parseJSONFileToListOfObjects(String fileName, Class className) {
//        try {
//            byte[] data = Files.readAllBytes(Paths.get(fileName));
//            ObjectMapper mapper = new ObjectMapper();
//            return (PetClinicVeterinariansData)mapper.readValue(data,className);
//        } catch (IOException e) {
//            throw new RuntimeException("Couldn't deserialize file:" + fileName + " to list of objects! " + e.getMessage());
//        }
//    }

    /**
     * Method to deserialize a json file to objects
     *
     * @param fileName  json file location + name
     * @param className class to which the json is to be serialized
     * @return deserialized object of the class. Need to cast the object into respective file to get the exact object of the class
     */
    public static <T> T parseJSONFileToObjects(String fileName, Class<T> className) {
        try {
            byte[] data = Files.readAllBytes(Paths.get(fileName));
            ObjectMapper mapper = new ObjectMapper();
            return (T) mapper.readValue(data, className);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't deserialize file: " + fileName + " to object...!!!" + e.getMessage());
        }
    }

}