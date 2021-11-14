package com.theScore.nflRushing;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
class NflRushingApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void testJSONLoading() throws IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		String name = new File(".").getCanonicalPath();
		System.out.println("Testddd "+ name);
		
		
		//File testFile = new File(name, "/" + "src\\main\\resources\\rushing.json");
		//List<JSONPlayerDAO> players = mapper.readValue(testFile, new TypeReference<List<JSONPlayerDAO>>(){});
		//List<Map<?, ?>> map = mapper.readValue(testFile, Map.class);
		//System.out.println("Size is "+ players.size());
		System.out.println(System.getProperty("java.runtime.version"));
	}

}
