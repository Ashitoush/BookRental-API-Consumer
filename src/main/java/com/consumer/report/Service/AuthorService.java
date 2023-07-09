package com.consumer.report.Service;

import com.consumer.report.Dto.AuthorDto;
import org.springframework.http.ResponseEntity;

public interface AuthorService {
    ResponseEntity<String> insertAuthor(AuthorDto authorDto, String token);
    ResponseEntity<String> deleteAuthor(Long id, String token);
}
