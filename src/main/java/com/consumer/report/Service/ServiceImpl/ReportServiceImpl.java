package com.consumer.report.Service.ServiceImpl;

import com.consumer.report.Constant.AppConstant;
import com.consumer.report.Dto.BookTransactionResponseDto;
import com.consumer.report.Service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
@RequiredArgsConstructor
@Service
public class ReportServiceImpl implements ReportService {

    private final WebClient webClient;

    @Override
    public Flux<BookTransactionResponseDto> getDataWithFilter(String searchParam) {
        return webClient.get()
                .uri(AppConstant.REPORT_PATH + "/reportDataWithFilter/" + searchParam)
                .retrieve()
                .bodyToFlux(BookTransactionResponseDto.class);
    }

    @Override
    public InputStreamResource generateReportWithFilter(String searchParam) {
        return webClient.get()
                .uri(AppConstant.REPORT_PATH + "/generateReportWithFilter?searchParam=" + searchParam)
                .retrieve()
                .bodyToMono(InputStreamResource.class)
                .block();
    }

    @Override
    public InputStreamResource generateReport() {
        return webClient.get()
                .uri(AppConstant.REPORT_PATH + "/generateReport")
                .retrieve()
                .bodyToMono(InputStreamResource.class)
                .block();
    }
}
