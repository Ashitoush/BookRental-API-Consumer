package com.consumer.report.Service;

import com.consumer.report.Dto.BookTransactionResponseDto;
import org.springframework.http.ResponseEntity;

public interface ReportService {
    ResponseEntity<BookTransactionResponseDto[]> requestDataWithFilter(String searchParam);
    ResponseEntity<String> generateReport();
    ResponseEntity<String> generateWithFilter(String searchParam);
}
