/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.jsoncountries;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author xblong
 */
public class CountryData {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void writeToJson(List<Country> countries, String countryFile) throws IOException {
        try(FileWriter writer = new FileWriter(countryFile)) {
            Iterator<Country> it = countries.iterator();
            while(it.hasNext()){
                Country item = it.next();
                writer.write(gson.toJson(item));
            }
            
        }
    }

    public static List<Country> readFromJsons(String areaFile, String populationFile, String gdpFile) throws IOException {
        List<Country> countries = new ArrayList<>();
        //try {
        JsonParser parser = new JsonParser();
        JsonArray areaArray = parser.parse(new JsonReader(new FileReader(areaFile)))
                    .getAsJsonObject().get("Root").getAsJsonObject().get("data").getAsJsonObject()
                    .get("record").getAsJsonArray();
        JsonArray populationArray = parser.parse(new JsonReader(new FileReader(populationFile)))
                    .getAsJsonObject().get("Root").getAsJsonObject().get("data").getAsJsonObject()
                    .get("record").getAsJsonArray();

        JsonArray gdpArray = parser.parse(new JsonReader(new FileReader(gdpFile)))
                .getAsJsonObject().get("Root").getAsJsonObject().get("data").getAsJsonObject()
                .get("record").getAsJsonArray();
        
        for(int i = 0; i<areaArray.size();i++) {
            JsonObject areaObject = areaArray.get(i).getAsJsonObject();
                            String countryName = areaObject.get("field").getAsJsonArray().get(0)
                        .getAsJsonObject().get("value").getAsString();

                double area = areaObject.get("field").getAsJsonArray().get(2)
                        .getAsJsonObject().get("value").getAsDouble();

                long population = populationArray.get(i).getAsJsonObject().get("field").getAsJsonArray().get(2)
                        .getAsJsonObject().get("value").getAsLong();

                double gdp = gdpArray.get(i).getAsJsonObject().get("field").getAsJsonArray().get(2)
                        .getAsJsonObject().get("value").getAsDouble();
                Country country = new Country(countryName, area, population, gdp);
                countries.add(country);
        }
        //} catch (FileNotFoundException e) {
        //    return Collections.emptyList();
        //}
        
        
        return countries;
    }
}
