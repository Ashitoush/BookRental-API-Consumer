package com.consumer.report.Service.ServiceImpl;

import com.consumer.report.Constant.AppConstant;
import com.consumer.report.Dto.BookTransactionResponseDto;
import com.consumer.report.Service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class ReportServiceImpl implements ReportService {

    private static final String URL = AppConstant.BASE_URL + "/bookTransaction";
    private final RestTemplate restTemplate;

    @Override
    public ResponseEntity<BookTransactionResponseDto[]> requestDataWithFilter(String searchParam) {
        String url = URL + "/reportDataWithFilter/" + searchParam;
        BookTransactionResponseDto[] responseDtoList = restTemplate.getForObject(url, BookTransactionResponseDto[].class);
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> generateReport() {
        String url = URL + "/generateReport";
        return restTemplate.getForEntity(url, String.class);
    }

    @Override
    public ResponseEntity<String> generateWithFilter(String searchParam) {
        String url = URL + "/generateReportWithFilter?searchParam=" + searchParam;
        return restTemplate.getForEntity(url, String.class);
    }
}
