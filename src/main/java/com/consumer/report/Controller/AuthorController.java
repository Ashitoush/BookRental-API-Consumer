package com.consumer.report.Controller;

import com.consumer.report.Dto.AuthorDto;
import com.consumer.report.Service.AuthorService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RequiredArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/insert")
    public ResponseEntity<String> insertAuthor(@RequestBody AuthorDto authorDto, HttpServletRequest request) {
        return authorService.insertAuthor(authorDto, getTokenFromRequest(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAuthor(@RequestParam("id") Long id, HttpServletRequest request) {
        return authorService.deleteAuthor(id, getTokenFromRequest(request));
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }
}
