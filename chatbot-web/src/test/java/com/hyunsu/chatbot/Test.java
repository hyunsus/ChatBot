package com.hyunsu.chatbot;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. List, map, String, int �� �����Ӱ� ����Ͽ� ���ȭ��ó�� ���
		
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
		
		map.put("person", "���");
		map.put("sports", "�߱�");
		map.put("score", submap);
		
		
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("person", "���2");
		map2.put("sports", "�౸");
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("person", "���3");
		map3.put("sports", "��");
		
		
		
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
		
		map.put("person1", "���");
		map.put("sports1", "�߱�");
		
		map.put("person2", "���2");
		map.put("sports2", "�౸");
		
		map.put("person3", "���3");
		map.put("sports3", "��");
		
		System.out.println("person :" + map.get("person1"));
		System.out.println("sports :" + map.get("sports1"));
		System.out.println("score  : \n semi :" + list);
		System.out.println("person :" + map.get("person2"));
		System.out.println("sports :" + map.get("sports2"));
		System.out.println("person :" + map.get("person3"));
		System.out.println("sports :" + map.get("sports3"));
		
		//2. ù��° ����� �ι�° ���� ���ھ� ���� ����Ͻÿ� 11�� ���;� ��.
		System.out.println("");

*/
	}

}
