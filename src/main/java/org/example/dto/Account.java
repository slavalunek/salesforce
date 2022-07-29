package org.example.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
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
}
