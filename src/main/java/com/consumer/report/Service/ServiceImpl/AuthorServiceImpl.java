package com.consumer.report.Service.ServiceImpl;

import com.consumer.report.Constant.AppConstant;
import com.consumer.report.Dto.AuthorDto;
import com.consumer.report.Helper.HeaderHelper;
import com.consumer.report.Service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final RestTemplate restTemplate;
    private static final String URL = AppConstant.BASE_URL + "/author";

    @Override
    public ResponseEntity<String> insertAuthor(AuthorDto authorDto, String token) {
        String url = URL + "/create";
        HttpHeaders headers = HeaderHelper.setHeader(token);
        HttpEntity<AuthorDto> entity = new HttpEntity<>(authorDto, headers);
        String result = restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteAuthor(Long id, String token) {
        String url = URL + "/delete/" + id;
        String result = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class).getBody();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
