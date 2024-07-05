package com.example.webapp.jasper;

public class ReportData {

    private String bedrijfsnaam;
    private String inhoudingsnummer;
    private String naamWerknemer;
    private String persoonsKenmerk;
    private String maand;
    private String maandStatus;
    private String tijdDatumPrint;

    public ReportData(String bedrijfsnaam, String inhoudingsnummer, String naamWerknemer, String persoonsKenmerk, String maand, String maandStatus, String tijdDatumPrint) {
        this.bedrijfsnaam = bedrijfsnaam;
        this.inhoudingsnummer = inhoudingsnummer;
        this.naamWerknemer = naamWerknemer;
        this.persoonsKenmerk = persoonsKenmerk;
        this.maand = maand;
        this.maandStatus = maandStatus;
        this.tijdDatumPrint = tijdDatumPrint;
    }

    public ReportData() {
    }

    public String getTijdDatumPrint() {
        return tijdDatumPrint;
    }

    public void setTijdDatumPrint(String tijdDatumPrint) {
        this.tijdDatumPrint = tijdDatumPrint;
    }

    public String getMaandStatus() {
        return maandStatus;
    }

    public void setMaandStatus(String maandStatus) {
        this.maandStatus = maandStatus;
    }

    public String getMaand() {
        return maand;
    }

    public void setMaand(String maand) {
        this.maand = maand;
    }

    public String getPersoonsKenmerk() {
        return persoonsKenmerk;
    }

    public void setPersoonsKenmerk(String persoonsKenmerk) {
        this.persoonsKenmerk = persoonsKenmerk;
    }

    public String getNaamWerknemer() {
        return naamWerknemer;
    }

    public void setNaamWerknemer(String naamWerknemer) {
        this.naamWerknemer = naamWerknemer;
    }

    public String getInhoudingsnummer() {
        return inhoudingsnummer;
    }

    public void setInhoudingsnummer(String inhoudingsnummer) {
        this.inhoudingsnummer = inhoudingsnummer;
    }

    public String getBedrijfsnaam() {
        return bedrijfsnaam;
    }

    public void setBedrijfsnaam(String bedrijfsnaam) {
        this.bedrijfsnaam = bedrijfsnaam;
    }
}
