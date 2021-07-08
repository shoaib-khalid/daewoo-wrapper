package com.kalsym.daewoowrapper.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Quotation {

    String quotationId;
    String charges;
    Order orderDetails;

}
