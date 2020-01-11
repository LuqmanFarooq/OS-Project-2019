import java.util.*;

public class AgentUser extends server{
	String agentName;
	int agentId;
	String agentEmail;
	
	public AgentUser(String agentName, int agentId, String agentEmail) {
		super();
		this.agentName = agentName;
		this.agentId = agentId;
		this.agentEmail = agentEmail;
	}

	String getAgentName() {
		return agentName;
	}

	private void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	 int getAgentId() {
		return agentId;
	}

	private void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	private String getAgentEmail() {
		return agentEmail;
	}

	private void setAgentEmail(String agentEmail) {
		this.agentEmail = agentEmail;
	}

	@Override
	public String toString() {
		return "AgentUser agentName=" + agentName + ", agentId=" + agentId + ", agentEmail=" + agentEmail;
	}
	
	
	
}

