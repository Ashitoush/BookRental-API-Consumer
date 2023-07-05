package com.consumer.report.Controller;

import com.consumer.report.Dto.AuthorDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {

    private final WebClient webClient;

    @PostMapping("/insert")
    public Mono<String> insertAuthor(@RequestBody AuthorDto authorDto, HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        ResponseSpec responseSpec = webClient.post()
                .uri("/author/create")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", bearerToken)
                .bodyValue(authorDto)
                .retrieve();
        return responseSpec.bodyToMono(String.class);
    }

    @DeleteMapping("/delete")
    public Mono<String> deleteAuthor(@RequestParam("id") Long id, HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        Mono<String> response = webClient.delete()
                .uri("/author/delete/"+ id)
                .header("Authorization", bearerToken)
                .retrieve()
                .bodyToMono(String.class);
        return response;
    }
}
