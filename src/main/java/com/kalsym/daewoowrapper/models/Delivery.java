package com.kalsym.daewoowrapper.models;

import com.kalsym.daewoowrapper.models.enums.Status;
import com.kalsym.daewoowrapper.models.enums.VehicleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "delivery")
@Getter
@Setter
@NoArgsConstructor
public class Delivery {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;


    private Double charges;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String dpRefId;
    private String sfRefId;
    private Double weight;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    @CreationTimestamp
    private Date created;
    @UpdateTimestamp
    private Date updated;


    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "deliveryId", insertable = false, updatable = false, nullable = true)
    private TrackingInfo trackingInfo;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "deliveryId", insertable = false, updatable = false, nullable = true)
    private PickupDetails pickupDetails;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "deliveryId", insertable = false, updatable = false, nullable = true)
    private DropoffDetails dropoffDetails;

    public void setObjectsNull(){
        this.trackingInfo = null;
        this.pickupDetails = null;
        this.dropoffDetails = null;
    }


}
