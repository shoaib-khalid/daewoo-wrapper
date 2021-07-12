package com.kalsym.daewoowrapper.models.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class QuotationRequest {

    private String destination_terminal_id;
    private String qty;
    private String weight;

}
