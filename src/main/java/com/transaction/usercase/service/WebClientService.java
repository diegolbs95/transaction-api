package com.transaction.usercase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebClientService {

    private final WebClient webClient;

    public String authorizer(){
        return webClient.get()
                .uri("/5794d450-d2e2-4412-8131-73d0293ac1cc")
                .retrieve()
                .onStatus(HttpStatusCode::isError,
                        error -> Mono.error(new RuntimeException("Error when calling Authorizer Request")))
                .bodyToMono(String.class)
                .block();
    }

    public Boolean notification(){
        return webClient.get()
                .uri("/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6")
                .retrieve()
                .onStatus(HttpStatusCode::isError,
                        error -> Mono.error(new RuntimeException("Error when calling Request from Notification")))
                .bodyToMono(Boolean.class)
                .block();
    }
}
