package com.study.map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.study.model.Geo;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Scanner;

public class ParseUtil {
    private static final String KEY = "AIzaSyA2VPluxh03IM7N0t6qzFXpK1Yrf7UY8n8";
    private static final String HOST = "https://maps.googleapis.com/maps/api";
    private static final String ADDR_TO_LATLNG = "%s/geocode/json?address=%s&key=%s";
    private static final String LATLNG_TO_ADDR = "%s/geocode/json?latlng=%s&key=%s";
    private static final String DIRECTIONS = "%s/directions/json?origin=%s&destination=%s&key=%s";
    private static final String STREETVIEW = "%s/streetview?location=%s&size=%s&key=%s";
    // 墨尼尼義大利餐廳新北淡水店, Buona%20Pasta%20金雞母店, MiNi廚房%20義大利麵
        
    public static Geo getGeoByName(String name) throws Exception {
        
        String url = String.format(ADDR_TO_LATLNG, HOST, URLEncoder.encode(name, "UTF-8"), KEY);
        //System.out.println(url);
        
        String jsonString = new Scanner(new URL(url).openStream(), "UTF-8")
                                .useDelimiter("\\A") // 資料全選
                                .next(); // 取得字串資料
        //System.out.println(jsonString);
        
        // 利用 Gson 剖析 jsonString 內容
        JsonObject root = JsonParser.parseString(jsonString).getAsJsonObject();
        String status = root.get("status").getAsString();
        //System.out.println(status);
        if(!status.equalsIgnoreCase("OK")) {
            System.out.println("Json 資料錯誤無法分析~");
            return null;
        }
        JsonArray results = root.getAsJsonArray("results");
        JsonObject jo = results.get(0).getAsJsonObject();
        String address = jo.get("formatted_address").getAsString();
        //System.out.println(address);
        JsonObject location = jo.getAsJsonObject("geometry").getAsJsonObject("location");
        Double lat = location.get("lat").getAsDouble();
        Double lng = location.get("lng").getAsDouble();
        
        Geo geo = new Geo();
        geo.setName(name);
        geo.setAddress(address);
        geo.setLat(lat);
        geo.setLng(lng);
        
        //System.out.println(geo);
        return geo;
    }
    
    
    
    
}
