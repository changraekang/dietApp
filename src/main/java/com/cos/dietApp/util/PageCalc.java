package com.cos.dietApp.util;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.dietApp.web.dto.PageReqDto;
import com.cos.dietApp.web.dto.PageRespDto;


@RestController
public class PageCalc {
	
	@PostMapping("/pagecal")
	public PageRespDto pagecal(@RequestBody PageReqDto dto) {
		int pageten = (int) (Math.ceil(dto.getNowPage() / 10.0) * 10);
		int nowPage = dto.getNowPage();
		int lastPage = (int) Math.ceil(dto.getTotalCount() / 10.0);
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
