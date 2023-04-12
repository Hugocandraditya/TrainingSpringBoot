//package com.travel.paymentService.repository;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.net.URI;
//
//@FeignClient(name = "channel-client")
//public interface AccountClientRepository {
//
//    @GetMapping
//    OmniResponse<ServiceList> getServiceList(
//            URI url,
//            @RequestParam("channel-id") String channelId,
//            @RequestParam("service-name") String serviceName
//    );
//
//    @GetMapping
//    ChannelWsid getChannelWsidByChannelId(URI url);
//
//}
