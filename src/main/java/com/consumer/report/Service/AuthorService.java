package com.consumer.report.Service;

import com.consumer.report.Dto.AuthorDto;

public interface AuthorService {
    String insertAuthor(AuthorDto authorDto, String bearerToken);
    String deleteAuthor(Long id, String bearerToken);
}
