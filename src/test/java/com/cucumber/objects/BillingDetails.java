package com.cucumber.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BillingDetails {
    private String billingFirstName;
    private String billingLastName;
    private String billingCountryName;
    private String billingAddressOne;
    private String billingCity;
    private String billingStateName;
    private String billingZip;
    private String billingEmail;

    public BillingDetails(String billingFirstName, String billingLastName, String billingCountryName,
                          String billingAddressOne, String billingCity,
                          String billingStateName, String billingZip, String billingEmail) {
        this.billingFirstName = billingFirstName;
        this.billingLastName = billingLastName;
        this.billingCountryName = billingCountryName;
        this.billingAddressOne = billingAddressOne;
        this.billingCity = billingCity;
        this.billingStateName = billingStateName;
        this.billingZip = billingZip;
        this.billingEmail = billingEmail;
    }
}
