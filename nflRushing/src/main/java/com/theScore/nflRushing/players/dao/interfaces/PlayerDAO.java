package com.theScore.nflRushing.players.dao.interfaces;

import java.util.List;

import com.theScore.nflRushing.players.Player;

public interface PlayerDAO
{	
	/**
	 * Return a list of players taken from a database or storage
	 * @return List of players
	 */
	public List<Player> createPlayers();
}
