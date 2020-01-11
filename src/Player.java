import java.util.UUID;

public class Player extends server{
	
	// variables
	String pName;
	int playerAge;
	int playerId;
	int clubId;
	int agentId;
	int playerValuation;
	String playerStatus;
	String playerPosition;
	
	// constructor
	public Player(String pName, int playerAge, int playerId, int clubId, int agentId, int playerValuation,
			String playerStatus, String playerPosition) {
		super();
		this.pName = pName;
		this.playerAge = playerAge;
		this.playerId = playerId;
		this.clubId = clubId;
		this.agentId = agentId;
		this.playerValuation = playerValuation;
		this.playerStatus = playerStatus;
		this.playerPosition = playerPosition;
	}

	int getPlayerValuation() {
		return playerValuation;
	}

	void setPlayerValuation(int playerValuation) {
		this.playerValuation = playerValuation;
	}

	String getPlayerStatus() {
		return playerStatus;
	}

	void setPlayerStatus(String playerStatus) {
		this.playerStatus = playerStatus;
	}

	String getpName() {
		return pName;
	}

	int getPlayerAge() {
		return playerAge;
	}

	int getPlayerId() {
		return playerId;
	}


	int getClubId() {
		return clubId;
	}

	int getAgentId() {
		return agentId;
	}

	String getPlayerPosition() {
		return playerPosition;
	}
	
	@Override
	public String toString() {
		return "Player [player Name=" + pName + ", player Age=" + playerAge + ", player Id=" + playerId + ", club Id=" + clubId
				+ ", agent Id=" + agentId + ", player Valuation=" + playerValuation + ", player Status=" + playerStatus
				+ ", player Position=" + playerPosition + "]";
	}
	
}
