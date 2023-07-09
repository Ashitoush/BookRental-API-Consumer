package com.consumer.report.Controller;

import com.consumer.report.Dto.BookTransactionResponseDto;
import com.consumer.report.Service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/requestDataWithFilter")
    public ResponseEntity<BookTransactionResponseDto[]> requestReportDataWithFilter(@RequestParam("param") String param) {
        return reportService.requestDataWithFilter(param);
    }

    @GetMapping("/generate")
    public ResponseEntity<String> generateReport() {
        return reportService.generateReport();
    }

    @GetMapping("/generateWithFilter")
    public ResponseEntity<String> generateReportWithFilter(@RequestParam("searchParam") String searchParam) {
        return reportService.generateWithFilter(searchParam);
    }
}
