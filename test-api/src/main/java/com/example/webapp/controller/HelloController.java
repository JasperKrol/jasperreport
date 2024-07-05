package com.example.webapp.controller;

import com.example.webapp.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@RestController
@RequestMapping("/api")
//http://localhost:8080/spring_web_app_war/api/generate
public class HelloController {

    private final ReportService reportService;

    public HelloController(ReportService reportService) {
        this.reportService = reportService;
    }

    //    http://localhost:8080/spring_web_app_war/hello
    @GetMapping("/hello")
    public String hello() {
        return "hello"; // This string corresponds to the name of the JSP file (hello.jsp)
    }

    @GetMapping("/generate")
    public void generatePdf(HttpServletResponse response) {

        try {
            byte[] pdfContent = reportService.generatePdfReport();

            // Set response headers
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=report.pdf");

            // Write PDF content to response output stream
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(pdfContent);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions or return appropriate response
        }
    }
}
