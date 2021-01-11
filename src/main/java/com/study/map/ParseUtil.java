package com.study.map;

import java.net.URL;
import java.util.Scanner;

public class ParseUtil {
    private static final String KEY = "AIzaSyA2VPluxh03IM7N0t6qzFXpK1Yrf7UY8n8";
    private static final String HOST = "https://maps.googleapis.com/maps/api";
    private static final String ADDR_TO_LATLNG = "%s/geocode/json?address=%s&key=%s";
    private static final String LATLNG_TO_ADDR = "%s/geocode/json?latlng=%s&key=%s";
    private static final String DIRECTIONS = "%s/directions/json?origin=%s&destination=%s&key=%s";
    private static final String STREETVIEW = "%s/streetview?location=%s&size=%s&key=%s";
    
    public static void main(String[] args) throws Exception {
        // 墨尼尼義大利餐廳新北淡水店, Buona%20Pasta%20金雞母店, MiNi廚房%20義大利麵
        // 建立 "墨尼尼義大利餐廳新北淡水店" 的 Geo 物件
        String url = String.format(ADDR_TO_LATLNG, HOST, "墨尼尼義大利餐廳新北淡水店", KEY);
        System.out.println(url);
        
        String jsonString = new Scanner(new URL(url).openStream(), "UTF-8")
                                .useDelimiter("\\A") // 資料全選
                                .next(); // 取得字串資料
        System.out.println(jsonString); 
        
        // 利用 Gson 剖析 jsonString 內容
        
    }
    
}
