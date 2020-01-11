
public class ClubUser extends server{
	int clubId;
	String clubName;
	String clubEmail;
	int fundsAvailTransfer;
	
	public ClubUser(int clubId, String clubName, String clubEmail, int fundsAvailTransfer) {
		super();
		this.clubId = clubId;
		this.clubName = clubName;
		this.clubEmail = clubEmail;
		this.fundsAvailTransfer = fundsAvailTransfer;
	}

	int getClubId() {
		return clubId;
	}

	private void setClubId(int clubId) {
		this.clubId = clubId;
	}

	String getClubName() {
		return clubName;
	}

	private void setClubName(String clubName) {
		this.clubName = clubName;
	}

	private String getClubEmail() {
		return clubEmail;
	}

	private void setClubEmail(String clubEmail) {
		this.clubEmail = clubEmail;
	}

	private int getFundsAvailTransfer() {
		return fundsAvailTransfer;
	}

	private void setFundsAvailTransfer(int fundsAvailTransfer) {
		this.fundsAvailTransfer = fundsAvailTransfer;
	}

	@Override
	public String toString() {
		return "ClubUser clubId=" + clubId + ", clubName=" + clubName + ", clubEmail=" + clubEmail
				+ ", fundsAvailTransfer=" + fundsAvailTransfer;
	}
	
	
}
