package com.example.webapp;

import net.sf.jasperreports.engine.*;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;
import java.util.HashMap;

public class JasperConfig {

    @Bean
    public JasperReport jasperReport() throws JRException {
        InputStream inputStream = getClass().getResourceAsStream("/reports/reportTemplate.jrxml");
        return JasperCompileManager.compileReport(inputStream);
    }

    @Bean
    public JasperPrint jasperPrint(JasperReport jasperReport) throws JRException {
        return JasperFillManager.fillReport(jasperReport, new HashMap<>(), new JREmptyDataSource());
    }
}
