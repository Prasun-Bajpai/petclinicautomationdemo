package com.petclinic.shared.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * @author bajpaip
 * @since 19-04-2021
 */
public class PetClinicVeterinariansData {
    @JsonProperty("veterinarians")
    private List<VeterinariansData> veterinariansData;

        public List<VeterinariansData> getVeterinariansData() {
        return veterinariansData;
    }

    public void setVeterinariansData(List<VeterinariansData> veterinariansData) {
        this.veterinariansData = veterinariansData;
    }

    @JsonRootName(value = "veterinarians")
    public static class VeterinariansData {
        @JsonProperty("name")
        private String name;
        @JsonProperty("speciality")
        private String speciality;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSpeciality() {
            return speciality;
        }

        public void setSpeciality(String speciality) {
            this.speciality = speciality;
        }
    }
}
