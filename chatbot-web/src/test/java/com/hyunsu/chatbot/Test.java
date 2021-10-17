package com.hyunsu.chatbot;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. List, map, String, int 등 자유롭게 사용하여 결과화면처럼 출력
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, List<Integer>> submap = new HashMap<String,List<Integer>>();
		List<Integer> semilist = new ArrayList<Integer>();
		List<Integer> finallist = new ArrayList<Integer>();
		
		semilist.add(10);
		semilist.add(11);
		semilist.add(12);
		
		finallist.add(11);
		finallist.add(12);
		finallist.add(23);
		
		submap.put("semi", semilist);
		submap.put("final", finallist);
		
		map.put("person", "사람");
		map.put("sports", "야구");
		map.put("score", submap);
		
		
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("person", "사람2");
		map2.put("sports", "축구");
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("person", "사람3");
		map3.put("sports", "농구");
		
		
		
		list.add(map);
		list.add(map2);
		list.add(map3);
		
		System.out.println(list.toString());
		
		Map<String, Object> res = list.get(0);
		Map<String, List<Integer>> scoreMap =(Map<String, List<Integer>>)map.get("score");
		
		List<Integer> semi = scoreMap.get("semi");
		int value = semi.get(1);
		
		System.out.println(value);
		
		/*
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("10 ,11, 12");
		list.add("final");
		list.add("11 ,12, 23");
		
		map.put("person1", "사람");
		map.put("sports1", "야구");
		
		map.put("person2", "사람2");
		map.put("sports2", "축구");
		
		map.put("person3", "사람3");
		map.put("sports3", "농구");
		
		System.out.println("person :" + map.get("person1"));
		System.out.println("sports :" + map.get("sports1"));
		System.out.println("score  : \n semi :" + list);
		System.out.println("person :" + map.get("person2"));
		System.out.println("sports :" + map.get("sports2"));
		System.out.println("person :" + map.get("person3"));
		System.out.println("sports :" + map.get("sports3"));
		
		//2. 첫번째 사람의 두번째 세미 스코어 값을 출력하시오 11로 나와야 함.
		System.out.println("");

*/
	}

}
