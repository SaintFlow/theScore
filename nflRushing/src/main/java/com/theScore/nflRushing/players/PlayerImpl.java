package com.theScore.nflRushing.players;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletOutputStream;

import com.theScore.nflRushing.players.interfaces.PlayerDAO;

public class PlayerImpl 
{	
	/**
	 * Retrieve a list of players from the storage, and filter them based on the parameters provided
	 * @param allParams
	 * @return
	 */
	public static List<Player> getPlayers(Map<String,String> allParams)
	{
		PlayerDAO dao = new JSONPlayerDAO();
		
		List<Player> players = dao.createPlayers();
		players = filterPlayers(players, allParams);
		
		return players;
	}
	
	/**
	 * Convert the player list into a .csv file for export
	 * @param players
	 * @param servletOutputStream
	 * @return
	 */
	public static Writer getCSV(List<Player> players, ServletOutputStream servletOutputStream)
	{
		try
		{
			Writer writer = new OutputStreamWriter(servletOutputStream, StandardCharsets.UTF_8);
			
			for (Player player : players)
			{
				writer.write(player.toCSV() + "\n");
			}
			
			writer.flush();
		}
		catch (IOException e)
		{
			System.out.println("Failed to write to file");
		}
		
		return null;
	}
	
	/**
	 * Filter the list of players based on the parameters provided
	 * @param players
	 * @param allParams
	 * @return
	 */
	public static List<Player> filterPlayers(List<Player> players, Map<String,String> allParams)
	{
		for (Map.Entry<String, String> entry: allParams.entrySet())
		{
			if (entry.getKey().equals("name") && entry.getKey() != null && !entry.getValue().isEmpty())
			{
				players = filterByName(players, entry.getValue());
			}
			else if (entry.getKey().equals("totalRushingYards") && entry.getKey() != null && !entry.getValue().isEmpty())
			{
				players = sortByTotalRushingYards(players, entry.getValue());
			}
			else if (entry.getKey().equals("longestRush") && entry.getKey() != null && !entry.getValue().isEmpty())
			{
				players = sortByLongestRush(players, entry.getValue());
			}
			else if (entry.getKey().equals("totalRushingTouchdowns") && entry.getKey() != null && !entry.getValue().isEmpty())
			{
				players = totalRushingtouchdowns(players, entry.getValue());
			}
		}
		
		return players;
	}
	
	public static List<Player> filterByName(List<Player> players, String name)
	{
		return players.stream().filter(player -> player.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
	}
	
	public static List<Player> sortByTotalRushingYards(List<Player> players, String direction)
	{
		return players.stream().sorted((a,b) -> (direction.equals("asc") ? 1 : -1) * Float.compare(a.getTotalRushingYards(), b.getTotalRushingYards())).collect(Collectors.toList());
	}
	
	public static List<Player> sortByLongestRush(List<Player> players, String direction)
	{
		return players.stream().sorted((a,b) -> (direction.equals("asc") ? 1 : -1) * Float.compare(a.getLongestRush(), b.getLongestRush())).collect(Collectors.toList());
	}
	
	public static List<Player> totalRushingtouchdowns(List<Player> players, String direction)
	{
		return players.stream().sorted((a,b) -> (direction.equals("asc") ? 1 : -1) * Float.compare(a.getTotalRushingTouchdowns(), b.getTotalRushingTouchdowns())).collect(Collectors.toList());
	}
}
