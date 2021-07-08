package com.kalsym.daewoowrapper.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TrackingInfo {

    String trackingNo;
    String trackingUrl;
    String merchantTrackingUrl;
    String customerTrackingUrl;
    String barcode;

}
