package com.kalsym.daewoowrapper.controllers;

import com.kalsym.daewoowrapper.models.*;
import com.kalsym.daewoowrapper.repositories.DeliveryRepository;
import com.kalsym.daewoowrapper.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Track;
import javax.validation.Valid;

@RestController()
@RequestMapping("/")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping(path = {"/quotation/generate"} , name = "get-quotation")
    public ResponseEntity<HttpResponse> getPrice(HttpServletRequest request,
                                                 @Valid @RequestBody Delivery delivery){
        String logprefix = request.getRequestURI() + " ";
        String location = Thread.currentThread().getStackTrace()[1].getMethodName();

        HttpResponse response = new HttpResponse(request.getRequestURI());
        response.setSuccessStatus(HttpStatus.OK);
        response.setData(deliveryService.addQuotation(delivery));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping(path = {"/quotation/{quotationId}/order"}, name = "place-delivery-order")
    public ResponseEntity<HttpResponse> placeDeliveryOrder (HttpServletRequest request,
                                                            @PathVariable String quotationId){
        HttpResponse response = new HttpResponse(request.getRequestURI());
        response.setSuccessStatus(HttpStatus.OK);
        response.setData(deliveryService.placeDeliveryOrder(quotationId));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

//    @GetMapping(path = {"/callback/{trackingNo}"}, name = "callback")
//    public ResponseEntity<HttpResponse> getDeliveryStatus(HttpServletRequest request,
//                                                          @PathVariable String trackingNo){
//        HttpResponse response = new HttpResponse(request.getRequestURI());
//        response.setSuccessStatus(HttpStatus.OK);
//        response.setData(new Object());
//
//        return ResponseEntity<HttpResponse>
//    }

}
