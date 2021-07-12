package com.kalsym.daewoowrapper.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dropoff_details")
public class DropoffDetails extends AddressDetails{

    String remarks;

}
