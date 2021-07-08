package com.kalsym.daewoowrapper.models;

import com.kalsym.daewoowrapper.models.enums.VehicleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Pickup {

    String parcelReadyTime;
    String pickupDate;
    String pickupTime;
    String pickupOption;
    VehicleType vehicleType;

    String pickupAddress;
    String pickupPostcode;
    String pickupState;
    String pickupCountry;
    String pickupCity;
    Integer pickupLocationId;

    String pickupContactName;
    String pickupContactPhone;
    String pickupContactEmail;
    boolean isTrolleyRequired;
    String remarks;

}
