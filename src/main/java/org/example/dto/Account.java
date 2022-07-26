package org.example.dto;

import java.util.Objects;

public class Account {

    private String accountName;
    private String parentAccount;
    private String website;
    private String phone;
    private String type1;
    private String type2;
    private String employees;
    private String billingCity;
    private String billingZip;
    private String province;
    private String billingCountry;
    private String shippingCity;
    private String shippingZip;
    private String shippingState;
    private String shippingCountry;
    private String description;
    private String billingStreet;
    private String shippingStreet;

    public Account(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getParentAccount() {
        return parentAccount;
    }

    public void setParentAccount(String parentAccount) {
        this.parentAccount = parentAccount;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingZip() {
        return billingZip;
    }

    public void setBillingZip(String billingZip) {
        this.billingZip = billingZip;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingZip() {
        return shippingZip;
    }

    public void setShippingZip(String shippingZip) {
        this.shippingZip = shippingZip;
    }

    public String getShippingState() {
        return shippingState;
    }

    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBillingStreet() {
        return billingStreet;
    }

    public void setBillingStreet(String billingStreet) {
        this.billingStreet = billingStreet;
    }

    public String getShippingStreet() {
        return shippingStreet;
    }

    public void setShippingStreet(String shippingStreet) {
        this.shippingStreet = shippingStreet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountName.equals(account.accountName) && Objects.equals(parentAccount, account.parentAccount) &&
                Objects.equals(website, account.website) && Objects.equals(phone, account.phone) &&
                Objects.equals(type1, account.type1) && Objects.equals(type2, account.type2) &&
                Objects.equals(employees, account.employees) && Objects.equals(billingCity, account.billingCity) &&
                Objects.equals(billingZip, account.billingZip) && Objects.equals(province, account.province) &&
                Objects.equals(billingCountry, account.billingCountry) && Objects.equals(shippingCity,
                account.shippingCity) && Objects.equals(shippingZip, account.shippingZip) &&
                Objects.equals(shippingState, account.shippingState) && Objects.equals(shippingCountry,
                account.shippingCountry) && Objects.equals(description, account.description) &&
                Objects.equals(billingStreet, account.billingStreet) && Objects.equals(shippingStreet, account.shippingStreet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountName, parentAccount, website, phone, type1, type2, employees, billingCity, billingZip,
                province, billingCountry, shippingCity, shippingZip, shippingState, shippingCountry, description,
                billingStreet, shippingStreet);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", parentAccount='" + parentAccount + '\'' +
                ", website='" + website + '\'' +
                ", phone='" + phone + '\'' +
                ", type1='" + type1 + '\'' +
                ", type2='" + type2 + '\'' +
                ", employees='" + employees + '\'' +
                ", billingCity='" + billingCity + '\'' +
                ", billingZip='" + billingZip + '\'' +
                ", province='" + province + '\'' +
                ", billingCountry='" + billingCountry + '\'' +
                ", shippingCity='" + shippingCity + '\'' +
                ", shippingZip='" + shippingZip + '\'' +
                ", shippingState='" + shippingState + '\'' +
                ", shippingCountry='" + shippingCountry + '\'' +
                ", description='" + description + '\'' +
                ", billingStreet='" + billingStreet + '\'' +
                ", shippingStreet='" + shippingStreet + '\'' +
                '}';
    }
}
