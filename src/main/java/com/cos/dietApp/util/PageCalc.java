package com.cos.dietApp.util;

import org.springframework.stereotype.Component;

import com.cos.dietApp.web.dto.PageRespDto;

@Component
public class PageCalc {
	
	public PageRespDto pagecal(int nowPage, double totalCount) {
		int pageten = (int) (Math.ceil(nowPage / 10.0) * 10);
		int lastPage = (int) Math.ceil(totalCount / 10.0);
		int prePage = pageten - 10;
		int nextPage = pageten + 1;
		int endPage = nextPage - 1;
		if(nextPage > lastPage) {
			endPage = lastPage;
		}
		PageRespDto pageRespDto = new PageRespDto (nowPage, lastPage, prePage, nextPage, endPage);
		return pageRespDto;
	}
	public PageRespDto pagecal(int nowPage, int lastPage) {
		int pageten = (int) (Math.ceil(nowPage / 10.0) * 10);
		int prePage = pageten - 10;
		int nextPage = pageten + 1;
		int endPage = nextPage - 1;
		if(nextPage > lastPage) {
			endPage = lastPage;
		}
		PageRespDto pageRespDto = new PageRespDto (nowPage, lastPage, prePage, nextPage, endPage);
		return pageRespDto;
	}
}
