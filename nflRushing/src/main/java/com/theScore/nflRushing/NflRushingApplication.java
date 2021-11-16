package com.theScore.nflRushing;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.theScore.nflRushing.players.Player;
import com.theScore.nflRushing.players.PlayerImpl;

@SpringBootApplication
@RestController
public class NflRushingApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(NflRushingApplication.class, args);
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/players")
	public List<Player> home(@RequestParam Map<String,String> allParams)
	{
		System.out.println(allParams);
		return PlayerImpl.getPlayers(allParams);
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/players.csv")
	public void getFiltedList(HttpServletResponse response, @RequestParam Map<String,String> allParams)
	{	
		List<Player> players = PlayerImpl.getPlayers(allParams);
		response.setContentType("text/csv");
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.setHeader("Content-Disposition", "attachment; filename=players.csv");
		
		try 
		{
			PlayerImpl.getCSV(players, response.getOutputStream());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
