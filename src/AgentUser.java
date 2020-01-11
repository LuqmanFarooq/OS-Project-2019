import java.util.*;

public class AgentUser extends server {
	String agentName;
	int agentId;
	String agentEmail;

	// constructor
	public AgentUser(String agentName, int agentId, String agentEmail) {
		super();
		this.agentName = agentName;
		this.agentId = agentId;
		this.agentEmail = agentEmail;
	}

	// getter methods
	String getAgentName() {
		return agentName;
	}

	int getAgentId() {
		return agentId;
	}

	// to string method
	@Override
	public String toString() {
		return "AgentUser agentName=" + agentName + ", agentId=" + agentId + ", agentEmail=" + agentEmail;
	}

}
