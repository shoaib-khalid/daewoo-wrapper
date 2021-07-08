package com.kalsym.daewoowrapper.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Delivery {

    String deliveryAddress;
    String deliveryPostcode;
    String deliveryState;
    String deliveryCity;
    String deliveryCountry;

    String deliveryContactName;
    String deliveryContactPhone;
    String deliveryContactEmail;

}
