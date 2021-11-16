package com.theScore.nflRushing.players;

public class Player
{
	private String name;
	private String team;
	private String position;
	private float rushingAttemptsPerGameAverage;
	private float rushingAttempts;
	private float totalRushingYards;
	private float rushingAverageYardsPerAttempt;
	private float rushingYardsPerGame;
	private float totalRushingTouchdowns;
	private float longestRush;
	private float rushingFirstDowns;
	private float rushingFirstDownPercentage;
	private float rushing20PlusYardsEach;
	private float rushing40PlusYardsEach;
	private float rushingFumbles;
	private boolean isLongestRushATouchdown;
	private String isLongestRushATouchdownString;
	
	public Player(String name, String team, String position, float rushingAttemptsPerGameAverage, float rushingAttempts,
			float totalRushingYards, float rushingAverageYardsPerAttempt, float rushingYardsPerGame,
			float totalRushingTouchdowns, float longestRush, float rushingFirstDowns, float rushingFirstDownPercentage,
			float rushing20PlusYardsEach, float rushing40PlusYardsEach, float rushingFumbles) 
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

	public Player() 
	{
		// TODO Auto-generated constructor stub
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getTeam() 
	{
		return team;
	}

	public void setTeam(String team) 
	{
		this.team = team;
	}

	public String getPosition() 
	{
		return position;
	}

	public void setPosition(String position) 
	{
		this.position = position;
	}

	public float getRushingAttemptsPerGameAverage() 
	{
		return rushingAttemptsPerGameAverage;
	}

	public void setRushingAttemptsPerGameAverage(float rushingAttemptsPerGameAverage) 
	{
		this.rushingAttemptsPerGameAverage = rushingAttemptsPerGameAverage;
	}

	public float getRushingAttempts() 
	{
		return rushingAttempts;
	}

	public void setRushingAttempts(float rushingAttempts) 
	{
		this.rushingAttempts = rushingAttempts;
	}

	public float getTotalRushingYards() 
	{
		return totalRushingYards;
	}

	public void setTotalRushingYards(float totalRushingYards) 
	{
		this.totalRushingYards = totalRushingYards;
	}

	public float getRushingAverageYardsPerAttempt() 
	{
		return rushingAverageYardsPerAttempt;
	}

	public void setRushingAverageYardsPerAttempt(float rushingAverageYardsPerAttempt) 
	{
		this.rushingAverageYardsPerAttempt = rushingAverageYardsPerAttempt;
	}

	public float getRushingYardsPerGame() 
	{
		return rushingYardsPerGame;
	}

	public void setRushingYardsPerGame(float rushingYardsPerGame) 
	{
		this.rushingYardsPerGame = rushingYardsPerGame;
	}

	public float getTotalRushingTouchdowns() 
	{
		return totalRushingTouchdowns;
	}

	public void setTotalRushingTouchdowns(float totalRushingTouchdowns) 
	{
		this.totalRushingTouchdowns = totalRushingTouchdowns;
	}

	public float getLongestRush() 
	{
		return longestRush;
	}

	public void setLongestRush(float longestRush) 
	{
		this.longestRush = longestRush;
	}

	public float getRushingFirstDowns() 
	{
		return rushingFirstDowns;
	}

	public void setRushingFirstDowns(float rushingFirstDowns) 
	{
		this.rushingFirstDowns = rushingFirstDowns;
	}

	public float getRushingFirstDownPercentage() 
	{
		return rushingFirstDownPercentage;
	}

	public void setRushingFirstDownPercentage(float rushingFirstDownPercentage) 
	{
		this.rushingFirstDownPercentage = rushingFirstDownPercentage;
	}

	public float getRushing20PlusYardsEach() 
	{
		return rushing20PlusYardsEach;
	}

	public void setRushing20PlusYardsEach(float rushing20PlusYardsEach) 
	{
		this.rushing20PlusYardsEach = rushing20PlusYardsEach;
	}

	public float getRushing40PlusYardsEach() 
	{
		return rushing40PlusYardsEach;
	}

	public void setRushing40PlusYardsEach(float rushing40PlusYardsEach) 
	{
		this.rushing40PlusYardsEach = rushing40PlusYardsEach;
	}

	public float getRushingFumbles() 
	{
		return rushingFumbles;
	}

	public void setRushingFumbles(float rushingFumbles) 
	{
		this.rushingFumbles = rushingFumbles;
	}
	
	public boolean isLongestRushATouchdown() 
	{
		return isLongestRushATouchdown;
	}

	public void setLongestRushATouchdown(boolean isLongestRushATouchdown) 
	{
		this.isLongestRushATouchdown = isLongestRushATouchdown;
	}

	public String getIsLongestRushATouchdownString() 
	{
		return isLongestRushATouchdownString;
	}

	public void setIsLongestRushATouchdownString(String isLongestRushATouchdownString) 
	{
		this.isLongestRushATouchdownString = isLongestRushATouchdownString;
	}
	
	/**
	 * Convert the player to a row in a .csv file
	 * @return String containing the player's information as a row in a .csv file
	 */
	public String toCSV()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getName()).append(",")
		             .append(getTeam()).append(",")
		             .append(getPosition()).append(",")
		             .append(getRushingAttemptsPerGameAverage()).append(",")
		             .append(getRushingAttempts()).append(",")
		             .append(getTotalRushingYards()).append(",")
		             .append(getRushingAverageYardsPerAttempt()).append(",")
		             .append(getRushingYardsPerGame()).append(",")
		             .append(getTotalRushingTouchdowns()).append(",")
		             .append(getLongestRush()).append(isLongestRushATouchdown() ? "T" : "").append(",")
		             .append(getRushingFirstDowns()).append(",")
		             .append(getRushingFirstDownPercentage()).append(",")
		             .append(getRushing20PlusYardsEach()).append(",")
		             .append(getRushing40PlusYardsEach()).append(",")
		             .append(getRushingFumbles());
		
		return stringBuilder.toString();
	}
}
