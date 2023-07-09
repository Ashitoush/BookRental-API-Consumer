package com.consumer.report.Controller;

import com.consumer.report.Dto.BookTransactionResponseDto;
import com.consumer.report.Service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/dataWithFilter")
    public Flux<BookTransactionResponseDto> dataWithFilter(@RequestParam("searchParam") String searchParam) {
        return reportService.getDataWithFilter(searchParam);
    }

    @GetMapping("/generateWithFilter")
    public ResponseEntity<Resource> generateReportWithFilter(@RequestParam("searchParam") String searchParam) {
        InputStreamResource inputStreamResource = reportService.generateReportWithFilter(searchParam);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=Book Transaction.xlsx")
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(inputStreamResource);
    }

    @GetMapping("/generate")
    public ResponseEntity<Resource> generate() {
        InputStreamResource inputStreamResource = reportService.generateReport();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=Book Transaction.xlsx")
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(inputStreamResource);
    }

}
