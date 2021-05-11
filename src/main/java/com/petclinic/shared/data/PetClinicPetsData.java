package com.petclinic.shared.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author bajpaip
 * @since 19-04-2021
 */
public class PetClinicPetsData {
    @JsonProperty("petAddData")
    private PetAddData petAddData;

    public PetAddData getPetAddData() {
        return petAddData;
    }

    public void setPetAddData(PetAddData petAddData) {
        this.petAddData = petAddData;
    }

    @JsonRootName(value = "petAddData")
    public static class PetAddData {
        private String name;
        private String birthDate;
        private String type;

        public String getName() {
            return name;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public String getType() {
            return type;
        }

    }

}
