package com.example.quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

@SpringBootTest
class QuizApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test // 報錯
	public void test2() {
		List<Integer> list = new ArrayList<>(List.of(1, 2));
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		list.remove(3);
		System.out.println(list);
	}
	
	@Test
	public void test3() { // 使用迭代器
		List<String> list = List.of("A", "B", "C", "D", "E");
		String str = "AABBBCDDAEEEAACCDD";
		// 計算 A,B,C,D,E 各出現了幾次
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) { // hasNext(): 判斷是否有下一個元素 
			String item = iter.next(); // .next(): 取得下一個元素
			System.out.println(item + ":" + StringUtils.countOccurrencesOf(str, item));
		}
	}
	
	@Test
	public void test4() { // 使用 Map
		List<String> list = List.of("A", "B", "C", "D", "E");
		String str = "AABBBCDDAEEEAACCDD";
		// 計算 A,B,C,D,E 各出現了幾次
		Map<String, Integer> map = new HashMap<>();
		for(String item : list) {
			String newStr = str.replace(item, "");// 要計算的字變成空字串，變成一個空字串長度會 -1
			int count = str.length() - newStr.length();// 原本的長度 - 空字串的長度 = 出現次數
			map.put(item, count); // key : value
		}
		System.out.println(map);
	}
}
