package com.petclinic.shared.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * @author bajpaip
 * @since 19-04-2021
 */
public class PetClinicOwnersData {
    @JsonProperty("owners")
    private List<OwnersData> ownersData;

    @JsonProperty("ownerAddData")
    private OwnersAddData ownerAddData;

    public List<OwnersData> getOwnersData() {
        return ownersData;
    }

    public void setOwnersData(List<OwnersData> ownersData) {
        this.ownersData = ownersData;
    }

    public OwnersAddData getOwnerAddData(){return ownerAddData;}

    public void setOwnerAddData(OwnersAddData ownerAddData){this.ownerAddData = ownerAddData;}

    @JsonRootName(value = "owners")
    public static class OwnersData {
        private String name;
        private String address;
        private String city;
        private String telephone;
        private String pets;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getPets() {
            return pets;
        }

        public void setPets(String pets) {
            this.pets = pets;
        }
    }
    @JsonRootName(value = "ownerAddData")
    public static class OwnersAddData {
        private String firstName;
        private String lastName;
        private String address;
        private String city;
        private String telephone;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }
    }
}