package com.kalsym.daewoowrapper.models;

import com.kalsym.daewoowrapper.models.enums.Currency;
import com.kalsym.daewoowrapper.models.enums.ItemType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class Order {

    String orderId;
    String customerId;
    Integer merchantId;
    String productCode;
    Integer deliveryProviderId;

    ItemType itemType;

    Double totalWeightKg;
    String transactionId;
    String shipmentContent;
    Integer pieces;
    boolean isInsurance;
    Double shipmentValue;
    String storeId;
    String cartId;
    Pickup pickup;
    Delivery delivery;
    Currency currency;
    Date expiry;
    TrackingInfo trackingInfo;


}
