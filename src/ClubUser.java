
public class ClubUser extends server{
	
	// variables
	int clubId;
	String clubName;
	String clubEmail;
	int fundsAvailTransfer;
	
	// constructor
	public ClubUser(int clubId, String clubName, String clubEmail, int fundsAvailTransfer) {
		super();
		this.clubId = clubId;
		this.clubName = clubName;
		this.clubEmail = clubEmail;
		this.fundsAvailTransfer = fundsAvailTransfer;
	}

	// getter and setter methods
	int getClubId() {
		return clubId;
	}

	

	String getClubName() {
		return clubName;
	}


	private int getFundsAvailTransfer() {
		return fundsAvailTransfer;
	}

	private void setFundsAvailTransfer(int fundsAvailTransfer) {
		this.fundsAvailTransfer = fundsAvailTransfer;
	}

	// to string method
	@Override
	public String toString() {
		return "ClubUser clubId=" + clubId + ", clubName=" + clubName + ", clubEmail=" + clubEmail
				+ ", fundsAvailTransfer=" + fundsAvailTransfer;
	}
	
	
}
