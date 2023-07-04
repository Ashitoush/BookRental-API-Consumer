package com.consumer.report.Controller;

import com.consumer.report.Dto.AuthorDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RequiredArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {

    private final RestTemplate restTemplate;

    @PostMapping("/insert")
    public ResponseEntity<String> insertAuthor(@RequestBody AuthorDto authorDto, HttpServletRequest request) {
        String url = "http://localhost:8080/author/create";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String bearerToken = request.getHeader("Authorization");
        headers.setBearerAuth(bearerToken);
        HttpEntity<AuthorDto> entity = new HttpEntity<>(authorDto, headers);

        String result = restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAuthor(@RequestParam("id") Long id, HttpServletRequest request) {
        String url = "http://localhost:8080/author/delete/" + id;
        HttpHeaders headers = new HttpHeaders();
        String bearerToken = request.getHeader("Authorization");
        headers.setBearerAuth(bearerToken);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String result = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class).getBody();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
