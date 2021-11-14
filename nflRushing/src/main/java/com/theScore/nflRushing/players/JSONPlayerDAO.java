package com.theScore.nflRushing.players;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theScore.nflRushing.players.interfaces.PlayerDAO;

public class JSONPlayerDAO implements PlayerDAO
{
	private String name;
	private String team;
	private String position;
	private String rushingAttemptsPerGameAverage;
	private String rushingAttempts;
	private String totalRushingYards;
	private String rushingAverageYardsPerAttempt;
	private String rushingYardsPerGame;
	private String totalRushingTouchdowns;
	private String longestRush;
	private String rushingFirstDowns;
	private String rushingFirstDownPercentage;
	private String rushing20PlusYardsEach;
	private String rushing40PlusYardsEach;
	private String rushingFumbles;
	 
	public JSONPlayerDAO(String name, String team, String position, String rushingAttemptsPerGameAverage, String rushingAttempts,
			String totalRushingYards, String rushingAverageYardsPerAttempt, String rushingYardsPerGame, String totalRushingTouchdowns,
			String longestRush, String rushingFirstDowns, String rushingFirstDownPercentage, String rushing20PlusYardsEach,
			String rushing40PlusYardsEach, String rushingFumbles)
	{
		this.name = name;
		this.team = team;
		this.position = position;
		this.rushingAttemptsPerGameAverage = rushingAttemptsPerGameAverage;
		this.rushingAttempts = rushingAttempts;
		this.totalRushingYards = totalRushingYards;
		this.rushingAverageYardsPerAttempt = rushingAverageYardsPerAttempt;
		this.rushingYardsPerGame = rushingYardsPerGame;
		this.totalRushingTouchdowns = totalRushingTouchdowns;
		this.longestRush = longestRush;
		this.rushingFirstDowns = rushingFirstDowns;
		this.rushingFirstDownPercentage = rushingFirstDownPercentage;
		this.rushing20PlusYardsEach = rushing20PlusYardsEach;
		this.rushing40PlusYardsEach = rushing40PlusYardsEach;
		this.rushingFumbles = rushingFumbles;
	}
	
	public JSONPlayerDAO()
	{
		
	}
	
	@JsonProperty("Player")
	public String getName()
	{
		return name;
	}

	@JsonProperty("Team")
	public String getTeam() 
	{
		return team;
	}

	@JsonProperty("Pos")
	public String getPosition() 
	{
		return position;
	}

	@JsonProperty("Att/G")
	public String getRushingAttemptsPerGameAverage() 
	{
		return rushingAttemptsPerGameAverage;
	}

	@JsonProperty("Att")
	public String getRushingAttempts() 
	{
		return rushingAttempts;
	}

	@JsonProperty("Yds")
	public String getTotalRushingYards() 
	{
		return totalRushingYards;
	}

	@JsonProperty("Avg")
	public String getRushingAverageYardsPerAttempt()
	{
		return rushingAverageYardsPerAttempt;
	}

	@JsonProperty("Yds/G")
	public String getRushingYardsPerGame() 
	{
		return rushingYardsPerGame;
	}

	@JsonProperty("TD")
	public String getTotalRushingTouchdowns() 
	{
		return totalRushingTouchdowns;
	}
	
	@JsonProperty("Lng")
	public String getLongestRush() 
	{
		return longestRush;
	}

	@JsonProperty("1st")
	public String getRushingFirstDowns() 
	{
		return rushingFirstDowns;
	}

	@JsonProperty("1st%")
	public String getRushingFirstDownPercentage() 
	{
		return rushingFirstDownPercentage;
	}

	@JsonProperty("20+")
	public String getRushing20PlusYardsEach() 
	{
		return rushing20PlusYardsEach;
	}

	@JsonProperty("40+")
	public String getRushing40PlusYardsEach() 
	{
		return rushing40PlusYardsEach;
	}
	
	/**
	 * Convert the JSON object to a Player object
	 * @return
	 */
	private Player map()
	{
		// Change up object such that specified fields are float, instead of a String
		Player player  = new Player();
		player.setName(name);
		player.setTeam(team);
		player.setPosition(position);
		player.setRushingAttemptsPerGameAverage(Float.parseFloat(rushingAttemptsPerGameAverage));
		player.setRushingAttempts(Float.parseFloat(rushingAttempts));
		player.setTotalRushingYards(Float.parseFloat(totalRushingYards.replace(",", "")));
		player.setRushingAverageYardsPerAttempt(Float.parseFloat(rushingAverageYardsPerAttempt));
		player.setRushingYardsPerGame(Float.parseFloat(rushingYardsPerGame));
		player.setTotalRushingTouchdowns(Float.parseFloat(totalRushingTouchdowns));
		player.setLongestRush(Float.parseFloat(longestRush.replace("T", "")));
		player.setRushingFirstDowns(Float.parseFloat(rushingFirstDowns));
		player.setRushingFirstDownPercentage(Float.parseFloat(rushingFirstDownPercentage));
		player.setRushing20PlusYardsEach(Float.parseFloat(rushing20PlusYardsEach));
		player.setRushing40PlusYardsEach(Float.parseFloat(rushing40PlusYardsEach));
		player.setRushingFumbles(Float.parseFloat(rushingFumbles));
		player.setLongestRushATouchdown(longestRush.contains("T"));
		player.setIsLongestRushATouchdownString(longestRush.contains("T") ? "T" : null);
	
		return player;
	}

	@JsonProperty("FUM")
	public String getRushingFumbles() 
	{
		return rushingFumbles;
	}
	
	@Override
	public List<Player> createPlayers()
	{
		ObjectMapper mapper = new ObjectMapper();
		String name;
		List<Player> players = new LinkedList<>();
		
		try 
		{
			name = new File(".").getCanonicalPath();
			File testFile = new File(name, "/" + "src\\main\\resources\\rushing.json");
			List<JSONPlayerDAO> jsonPlayers = mapper.readValue(testFile, new TypeReference<List<JSONPlayerDAO>>(){});
			
			jsonPlayers.stream().forEach(jsonPlayer -> players.add(jsonPlayer.map()));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return players;
	}
}
