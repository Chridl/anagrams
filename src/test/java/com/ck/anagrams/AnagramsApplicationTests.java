package com.ck.anagrams;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AnagramsApplicationTests {

	@Autowired
	private AnagramsApplication anagramsApplication;

	@Test
	void contextLoads() {
		assertNotNull(anagramsApplication);
	}
}