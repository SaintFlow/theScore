package com.theScore.nflRushing.players.dao.factories;

import com.theScore.nflRushing.players.dao.interfaces.PlayerDAO;
import com.theScore.nflRushing.players.dao.json.JSONPlayerDAO;

public class PlayerDAOFactory 
{
	private static PlayerDAO dao = null;
	
	public static PlayerDAO getDAO()
	{
		//JSON "DAO" only exists for now. Could be based on config file if scaling application
		if (dao == null)
		{
			dao = new JSONPlayerDAO();
		}
		
		return dao;
	}
}
