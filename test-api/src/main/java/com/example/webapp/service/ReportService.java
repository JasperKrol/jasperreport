package com.example.webapp.service;

import com.example.webapp.Automerk;
import com.example.webapp.jasper.ReportData;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.*;

@Service
public class ReportService {

    public ReportService() {
    }

    public byte[] generatePdfReport() throws Exception {
        ReportData reportData = getReportData();

        // Parameters for the report
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("bedrijfsnaam", reportData.getBedrijfsnaam());
        parameters.put("inhoudingsnummer", reportData.getInhoudingsnummer());
        parameters.put("naamWerknemer", reportData.getNaamWerknemer());
        parameters.put("persoonsKenmerk", reportData.getPersoonsKenmerk());
        parameters.put("maand", reportData.getMaand());
        parameters.put("maandStatus", reportData.getMaandStatus());
        parameters.put("tijdDatumPrint", reportData.getTijdDatumPrint());

        List<Automerk> automerkList = new ArrayList<>();

        // Adding Automerk objects to the list
        automerkList.add(new Automerk("Toyota", "diesel"));
        automerkList.add(new Automerk("Honda", "diesel"));
        automerkList.add(new Automerk("Porche", "eu98"));
        automerkList.add(new Automerk("Kaaswagen", "eu85"));
        automerkList.add(new Automerk("blyatmobiel", "wodka"));
        automerkList.add(new Automerk("Toyota", "gist"));
        automerkList.add(new Automerk("Toyota", "water")); automerkList.add(new Automerk("Toyota", "diesel"));
        automerkList.add(new Automerk("Honda", "diesel"));
        automerkList.add(new Automerk("Porche", "eu98"));
        automerkList.add(new Automerk("Kaaswagen", "eu85"));
        automerkList.add(new Automerk("blyatmobiel", "wodka"));
        automerkList.add(new Automerk("Toyota", "gist"));
        automerkList.add(new Automerk("Toyota", "water"));


        // Load JasperReports template
        String jasperTemplatePath = "/jasperxml/BarsRegistratieRapport.jrxml";
        InputStream templateStream = getClass().getResourceAsStream(jasperTemplatePath);

        // Compile the .jrxml file to .jasper
        JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);

        JRBeanCollectionDataSource listItemJRBean = new JRBeanCollectionDataSource(automerkList);
        parameters.put("Automerk", listItemJRBean);

        // Fill the report
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, listItemJRBean);

        // Export to PDF as byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        return outputStream.toByteArray();
    }

    // Simulate fetching report data (replace with actual data retrieval logic)
    private ReportData getReportData() {
        ReportData reportData = new ReportData();
        reportData.setBedrijfsnaam("Your company name");
        reportData.setInhoudingsnummer("12345");
        reportData.setNaamWerknemer("John Doe");
        reportData.setPersoonsKenmerk("ABC123");
        reportData.setMaand("June 2024");
        reportData.setMaandStatus("Open");
        reportData.setTijdDatumPrint("2024-07-03");
        return reportData;
    }
}
