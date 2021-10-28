package com.cos.dietApp.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;

@Component
public class CalorieAPITest {	
	public String Calorie(String kor, String page) {
    	StringBuilder sb = new StringBuilder();
        try {
        	System.out.println(kor);
        	System.out.println(URLEncoder.encode(kor, "UTF-8"));
        	String sKey = "GEenzrfqpLS1IKjRAxv02SvRSzD7cSYwrFkcbZsI95GFYEIXoFnsSBkzMRDsuFdb6XWcFhUfaHPZyLexeJngeQ%3D%3D";
        	StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1"); /*URL*/
        	urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + sKey); /*Service Key*/
        	urlBuilder.append("&" + URLEncoder.encode("desc_kor","UTF-8") + "=" + URLEncoder.encode(kor, "UTF-8")); /*식품이름*/
        	urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(page, "UTF-8")); /*페이지번호*/
        	urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        //	urlBuilder.append("&" + URLEncoder.encode("bgn_year","UTF-8") + "=" + URLEncoder.encode("2017", "UTF-8")); /*구축년도*/
        //	urlBuilder.append("&" + URLEncoder.encode("animal_plant","UTF-8") + "=" + URLEncoder.encode("(유)돌코리아", "UTF-8")); /*가공업체*/
        //	urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("인증키 (URL Encode)", "UTF-8")); /*공공데이터포털에서 발급받은 인증키*/
        	urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*응답데이터 형식(xml/json) Default: xml*/
        	URL url = new URL(urlBuilder.toString());
        	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        	conn.setRequestMethod("GET");
        	conn.setRequestProperty("Content-type", "application/json");
        	System.out.println("Response code: " + conn.getResponseCode());
        	BufferedReader rd;
        	if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
        		rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        	} else {
        		rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        	}
        	String line;
        	while ((line = rd.readLine()) != null) {
        		sb.append(line);
        	}
        	rd.close();
        	conn.disconnect();
		} catch (Exception e) {
			System.out.println("뭔가 오류뜸");
		}
        return sb.toString();
	}
}
