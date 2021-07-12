package com.kalsym.daewoowrapper.models;

import com.kalsym.daewoowrapper.models.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class AddressDetails {

    @Id
    String deliveryId;

    String address;
    String postcode;
    String state;
    String country;
    String city;
    Integer locationId;
    Double latitude;
    Double longitude;

    String contactName;
    String contactPhone;
    String contactEmail;

}
