package com.cos.dietApp.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cos.dietApp.domain.news.News;

@Component
public class DietNewsCraw {
		
		public List<News> collect() {
			RestTemplate rt = new RestTemplate();
			List<News> newsList = new ArrayList<>();
				
			for (int i = 0; i < 10; i++) {
				
				
				try {
			String url = "http://www.mdtoday.co.kr/news/search.php?q=%EB%8B%A4%EC%9D%B4%EC%96%B4%ED%8A%B8&sfld=subj&period=WEEK";
			String html = rt.getForObject(url, String.class);
			Document doc = null;
			doc = Jsoup.parse(html);
			
				Element headelem	 =  doc.selectFirst("#listWrap > div:nth-child("+ i +") > dl > dt > a");
				Element summary		 =  doc.selectFirst("#listWrap > div:nth-child("+ i + ") > dl > dd.conts");
				Element thumnail	 =  doc.selectFirst("");
				Element href		 =	doc.selectFirst("#listWrap > div:nth-child(\"+ i +\") > dl > dt > a href");
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			}
			
			
			
			return newsList;
		}
	
	
	
}
