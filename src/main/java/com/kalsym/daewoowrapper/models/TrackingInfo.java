package com.kalsym.daewoowrapper.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tracking_info")
@Setter
@Getter
@NoArgsConstructor
public class TrackingInfo {

    @Id
    String deliveryId;

    String trackingNo;
    String merchantTrackingUrl;
    String customerTrackingUrl;

}
