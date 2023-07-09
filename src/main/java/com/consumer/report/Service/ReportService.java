package com.consumer.report.Service;

import com.consumer.report.Dto.BookTransactionResponseDto;
import org.springframework.core.io.InputStreamResource;
import reactor.core.publisher.Flux;

public interface ReportService {
    Flux<BookTransactionResponseDto> getDataWithFilter(String searchParam);
    InputStreamResource generateReportWithFilter(String searchParam);
    InputStreamResource generateReport();
}
