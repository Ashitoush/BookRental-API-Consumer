package com.consumer.report.Controller;

import com.consumer.report.Dto.AuthorDto;
import com.consumer.report.Service.AuthorService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/insert")
    public ResponseEntity<String> insertAuthor(@RequestBody AuthorDto authorDto, HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        String response = authorService.insertAuthor(authorDto, bearerToken);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAuthor(@RequestParam("id") Long id, HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        String response = authorService.deleteAuthor(id, bearerToken);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
