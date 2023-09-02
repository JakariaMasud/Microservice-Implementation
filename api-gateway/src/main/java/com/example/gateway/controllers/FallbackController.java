package com.example.gateway.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/orderFallback")
    Mono<String> orderFallback(){
        return Mono.just("order service is down");
    }

    @RequestMapping("/paymentFallback")
    Mono<String> paymentFallback(){
        return Mono.just("payment service is down");
    }
}
