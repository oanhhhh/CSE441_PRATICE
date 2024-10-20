package com.example.prac03;

public class Country {
    private int flag;
    private String countryName;
    private String countryCapital;
    private String countryPopulation;
    private String countryArea;
    private String countryDensity;
    private String getCountryWorldShare;

    public Country(int flag, String countryName, String countryCapital, String countryPopulation, String countryArea, String countryDensity, String getCountryWorldShare) {
        this.flag = flag;
        this.countryName = countryName;
        this.countryCapital = countryCapital;
        this.countryPopulation = countryPopulation;
        this.countryArea = countryArea;
        this.countryDensity = countryDensity;
        this.getCountryWorldShare = getCountryWorldShare;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }

    public String getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(String countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public String getCountryArea() {
        return countryArea;
    }

    public void setCountryArea(String countryArea) {
        this.countryArea = countryArea;
    }

    public String getCountryDensity() {
        return countryDensity;
    }

    public void setCountryDensity(String countryDensity) {
        this.countryDensity = countryDensity;
    }

    public String getGetCountryWorldShare() {
        return getCountryWorldShare;
    }

    public void setGetCountryWorldShare(String getCountryWorldShare) {
        this.getCountryWorldShare = getCountryWorldShare;
    }
}
