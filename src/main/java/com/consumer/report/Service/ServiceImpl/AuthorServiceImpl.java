package com.consumer.report.Service.ServiceImpl;

import com.consumer.report.Constant.AppConstant;
import com.consumer.report.Dto.AuthorDto;
import com.consumer.report.Service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final WebClient webClient;

    @Override
    public String insertAuthor(AuthorDto authorDto, String bearerToken) {
        return webClient.post()
                .uri(AppConstant.AUTHOR_PATH + "/create")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", bearerToken)
                .bodyValue(authorDto)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @Override
    public String deleteAuthor(Long id, String bearerToken) {
        return webClient.delete()
                .uri(AppConstant.AUTHOR_PATH + "/delete/" + id)
                .header("Authorization", bearerToken)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
