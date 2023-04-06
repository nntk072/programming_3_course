/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.jsoncountries;

/**
 *
 * @author xblong
 */
public class Country implements Comparable<Country> {
    private final String country;
    private final double area;
    private final long population;
    private final double gdp;
    public Country(String country, double area, long population, double gdp) {
        this.country = country;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
                
    }

    public double getArea() {
        return area;
    }

    public long getPopulation() {
        return population;
    }

    public double getGdp() {
        return gdp;
    }
    
        
    
    @Override
    public int compareTo(Country o) {
        return country.compareTo(o.country);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(country);
        sb.append("\n");
        sb.append("  Area: ").append(String.format("%.1f", area)).append(" km2\n");
        sb.append("  Population: ").append(population).append("\n");
        sb.append("  GDP: ").append(String.format("%.1f", gdp)).append(" (2015 USD)\n");
        return sb.toString();
    }
    
    
}
