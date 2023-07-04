package com.consumer.report.Controller;

import com.consumer.report.Dto.BookTransactionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RequiredArgsConstructor
@RestController
@RequestMapping("/report")
public class ReportController {

    private final RestTemplate restTemplate;

    @GetMapping("/requestDataWithFilter")
    public ResponseEntity<BookTransactionResponseDto[]> requestReportDataWithFilter(@RequestParam("param") String param) {
//        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/bookTransaction/reportDataWithFilter/" + param;
        BookTransactionResponseDto[] response = restTemplate.getForObject(url, BookTransactionResponseDto[].class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/generate")
    public ResponseEntity<String> generateReport() {
        String url = "http://localhost:8080/bookTransaction/generateReport";
        return  restTemplate.getForEntity(url, String.class);
    }

    @GetMapping("/generateWithFilter")
    public ResponseEntity<String> generateReportWithFilter(@RequestParam("searchParam") String searchParam) {
        String url = "http://localhost:8080/bookTransaction/generateReportWithFilter?searchParam=" + searchParam;
        return restTemplate.getForEntity(url, String.class);
    }
}
