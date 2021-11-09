package com.cos.dietApp;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class Test1 {

	@Test
	public void 디시멀() {
		BigDecimal b = new BigDecimal("1");
		System.out.println(b);
		Integer c = b.intValue();
		System.out.println("인트 : "+c);
	}
}
