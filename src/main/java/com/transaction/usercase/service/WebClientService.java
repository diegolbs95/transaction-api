package com.transaction.usercase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebClientService {

    @Value("${transaction.path.authorizer}")
    private String pathAuthorizer;
    @Value("${transaction.path.notification}")
    private String pathNotification;

    private final WebClient webClient;

    public String authorizer(){
        return webClient.get()
                .uri(pathAuthorizer)
                .retrieve()
                .onStatus(HttpStatusCode::isError,
                        error -> Mono.error(new RuntimeException("Error when calling Authorizer Request")))
                .bodyToMono(String.class)
                .block();
    }

    public String notification(){
        return webClient.get()
                .uri(pathNotification)
                .retrieve()
                .onStatus(HttpStatusCode::isError,
                        error -> Mono.error(new RuntimeException("Error when calling Request from Notification")))
                .bodyToMono(String.class)
                .block();
    }
}