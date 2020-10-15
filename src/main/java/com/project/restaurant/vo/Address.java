package com.project.restaurant.vo;

/**
 * @description: storing the address information for customers and employees
 */
public class Address {

    String addressId;
    String stressName;
    String city;
    String state;
    String zipCode;

    /**
     * get Id for address
     * @return address Id
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * set Id for address
     * @param addressId   Address id
     */
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    /**
     *  get stress Name for address
     * @return stress name
     */
    public String getStressName() {
        return stressName;
    }

    /**
     *  set stress Name for address
     * @param stressName
     */
    public void setStressName(String stressName) {
        this.stressName = stressName;
    }

    /**
     * get City Name for address
     * @return city name
     */
    public String getCity() {
        return city;
    }

    /**
     *  set city Name for address
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *  get state Name for address
     * @return state name
     */
    public String getState() {
        return state;
    }

    /**
     *  set state Name for address
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *  get zipcode for address
     * @return zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     *  set zipcode for address
     * @param zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
