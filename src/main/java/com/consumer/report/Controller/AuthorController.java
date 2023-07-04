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
    public Mono<String> insertAuthor(@RequestBody AuthorDto authorDto, HttpServletRequest request) throws Exception {
        Mono<AuthorDto> authorDtoMono = Mono.just(authorDto);
        String bearerToken = request.getHeader("Authorization");
        ResponseSpec responseSpec = webClient.post()
                .uri("/author/create")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", bearerToken)
                .body(authorDtoMono, Mono.class)
                .retrieve();
//        Mono<AuthorDto> result = responseSpec.bodyToMono(AuthorDto.class);
        return responseSpec.bodyToMono(String.class);
//        return result;
    }

//    @DeleteMapping("/delete")
//    public ResponseEntity<String> deleteAuthor(@RequestParam("id") Long id, HttpServletRequest request) {
//        String url = "http://localhost:8080/author/delete/" + id;
//        HttpHeaders headers = new HttpHeaders();
//        String bearerToken = request.getHeader("Authorization");
//        headers.setBearerAuth(bearerToken);
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//
//        String result = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class).getBody();
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
}
