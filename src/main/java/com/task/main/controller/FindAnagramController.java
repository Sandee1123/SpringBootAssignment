package com.task.main.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindAnagramController {

	@GetMapping("generic/{sentence}")
	public ResponseEntity<String> findAnagramsInSentence(@PathVariable("sentence") String sentence) {

		//String s = "silent race in an acre should listen with care if it is a night thing";
		String[] words = sentence.split(" ");
		Map<String, Integer> finalString = new HashMap<String, Integer>();

		if (words.length > 0) {

			Map<String, Integer> initialMap = new HashMap<String, Integer>();
			for (String word : words) {
				// System.out.println(word);
				String sorteds = sort(word);
				// System.out.println(sorteds);
				if (initialMap.containsKey(sorteds)) {
					//
					initialMap.put(sorteds, initialMap.get(sorteds) + 1);
				} else {
					initialMap.put(sorteds, 1);
				}
			}
			Iterator<String> m = initialMap.keySet().iterator();
			while(m.hasNext()) {
				String temp = m.next();
				// System.out.println(temp);
				 if(initialMap.get(temp) > 1) {
						System.out.println(temp + "-" + initialMap.get(temp));
					   finalString.put(temp,initialMap.get(temp));

					} 

			}
			
			
		}
		
		return new ResponseEntity<String>(finalString.toString(),HttpStatus.OK);
	}

	public static String sort(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		// System.out.println(chars);
		return new String(chars);
	}

}