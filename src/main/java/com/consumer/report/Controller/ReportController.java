package com.consumer.report.Controller;

import com.consumer.report.Dto.BookTransactionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/report")
public class ReportController {

    private final WebClient webClient;

    @GetMapping("/dataWithFilter")
    public Flux<BookTransactionResponseDto> dataWithFilter(@RequestParam("searchParam") String searchParam) {
        ResponseSpec bookTransactionResponseDto = webClient.get()
                .uri("/reportDataWithFilter/" + searchParam)
                .retrieve();
        return bookTransactionResponseDto.bodyToFlux(BookTransactionResponseDto.class);
    }

//    @GetMapping("/generateWithFilter")
//    public Mono<?> generateReportWithFilter(@RequestParam("searchParam") String searchParam) {
//        ResponseSpec inputStreamResource = webClient.get()
//                .uri("/generateReportWithFilter?searchParam=" + searchParam)
//                .retrieve();
//
//        return inputStreamResource.bodyToMono(InputStreamResource.class).;
//    }

}
