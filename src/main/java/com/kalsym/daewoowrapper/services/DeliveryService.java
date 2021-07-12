package com.kalsym.daewoowrapper.services;

import com.google.gson.Gson;
import com.kalsym.daewoowrapper.models.Delivery;
import com.kalsym.daewoowrapper.models.DropoffDetails;
import com.kalsym.daewoowrapper.models.PickupDetails;
import com.kalsym.daewoowrapper.models.TrackingInfo;
import com.kalsym.daewoowrapper.models.enums.Status;
import com.kalsym.daewoowrapper.models.request.QuotationRequest;
import com.kalsym.daewoowrapper.models.response.QuotationResponse;
import com.kalsym.daewoowrapper.repositories.DeliveryRepository;
import com.kalsym.daewoowrapper.repositories.DropoffDetailsRepository;
import com.kalsym.daewoowrapper.repositories.PickupDetailsRepository;
import com.kalsym.daewoowrapper.repositories.TrackingInfoRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private DropoffDetailsRepository dropoffDetailsRepository;

    @Autowired
    private PickupDetailsRepository pickupDetailsRepository;

    @Autowired
    private TrackingInfoRepository trackingInfoRepository;

    @Value("${daewoo.base.url}")
    private String BASE_URL;

    @Value("${daewoo.endpoint.place.order}")
    private String ENDPOINT_PLACE_ORDER;

    @Value("${daewoo.endpoint.quotation}")
    private String ENDPOINT_QUOTATION;

    public Delivery addQuotation(Delivery delivery){
        RestTemplate restTemplate = new RestTemplate();
        QuotationRequest request = new QuotationRequest("10","1","1.5");
        JSONObject requestBody = new JSONObject(request);
        HttpEntity<String> req =new HttpEntity<>(requestBody.toString());
        JSONObject responseJson = new JSONObject(restTemplate.exchange(BASE_URL+ENDPOINT_QUOTATION,HttpMethod.POST, req, String.class).getBody());
        QuotationResponse response = new Gson().fromJson(responseJson.toString(), QuotationResponse.class);

        delivery.setCharges(response.getServiceCharges());
        delivery.setStatus(Status.QUOTED);

        PickupDetails pickupDetails = delivery.getPickupDetails();
        DropoffDetails dropoffDetails = delivery.getDropoffDetails();
        TrackingInfo trackingInfo = delivery.getTrackingInfo();

        delivery.setObjectsNull();

        delivery = deliveryRepository.save(delivery);

        pickupDetails.setDeliveryId(delivery.getId());
        dropoffDetails.setDeliveryId(delivery.getId());
        trackingInfo.setDeliveryId(delivery.getId());

        pickupDetailsRepository.save(pickupDetails);
        dropoffDetailsRepository.save(dropoffDetails);
        trackingInfoRepository.save(trackingInfo);

        delivery.setDropoffDetails(dropoffDetails);
        delivery.setPickupDetails(pickupDetails);
        delivery.setTrackingInfo(trackingInfo);

        return delivery;
    }

    public Delivery placeDeliveryOrder(String quotationId){
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.exchange(BASE_URL+ENDPOINT_PLACE_ORDER, HttpMethod.POST, )


        String dpRefId = "12316892173";
        String trackingNo = "8934262374";

        Optional<Delivery> optDelivery = deliveryRepository.findById(quotationId);

        if(!optDelivery.isPresent()){
            return null;
        }

        Delivery delivery = optDelivery.get();
        Optional<TrackingInfo> optTrackingInfo = trackingInfoRepository.findById(quotationId);
        if(!optTrackingInfo.isPresent()){
            return null;
        }
        TrackingInfo trackingInfo = optTrackingInfo.get();

        delivery.setDpRefId(dpRefId);
        trackingInfo.setTrackingNo(trackingNo);

        trackingInfoRepository.save(trackingInfo);

        return deliveryRepository.save(delivery);

    }
}
