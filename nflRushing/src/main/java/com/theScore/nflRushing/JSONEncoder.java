package com.theScore.nflRushing;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.theScore.nflRushing.players.Player;
import com.theScore.nflRushing.players.PlayerImpl;

public class JSONEncoder 
{
	public static List<Player> players;
	
	public List<Player> getFiltedList(Map<String,String> allParams) throws JsonParseException, JsonMappingException, IOException
	{
		players = PlayerImpl.getPlayers(allParams);
		
		return players;
	}
}
