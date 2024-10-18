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

	@Test // ����
	public void test2() {
		List<Integer> list = new ArrayList<>(List.of(1, 2));
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		list.remove(3);
		System.out.println(list);
	}
	
	@Test
	public void test3() { // �ϥέ��N��
		List<String> list = List.of("A", "B", "C", "D", "E");
		String str = "AABBBCDDAEEEAACCDD";
		// �p�� A,B,C,D,E �U�X�{�F�X��
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) { // hasNext(): �P�_�O�_���U�@�Ӥ��� 
			String item = iter.next(); // .next(): ���o�U�@�Ӥ���
			System.out.println(item + ":" + StringUtils.countOccurrencesOf(str, item));
		}
	}
	
	@Test
	public void test4() { // �ϥ� Map
		List<String> list = List.of("A", "B", "C", "D", "E");
		String str = "AABBBCDDAEEEAACCDD";
		// �p�� A,B,C,D,E �U�X�{�F�X��
		Map<String, Integer> map = new HashMap<>();
		for(String item : list) {
			String newStr = str.replace(item, "");// �n�p�⪺�r�ܦ��Ŧr��A�ܦ��@�ӪŦr����׷| -1
			int count = str.length() - newStr.length();// �쥻������ - �Ŧr�ꪺ���� = �X�{����
			map.put(item, count); // key : value
		}
		System.out.println(map);
	}
}
