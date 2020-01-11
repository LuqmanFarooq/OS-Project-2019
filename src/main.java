import java.util.*;
public class main {
	
	public static void main(String[] args) {
		ArrayList<ClubUser> clubuser = new ArrayList<ClubUser>();
		ArrayList<AgentUser> agents = new ArrayList<AgentUser>();
		Scanner console = new Scanner(System.in);
		int choice;
		int clubId;
		String clubName;
		String clubEmail;
		int fundsAvailTransfer;
		String agentName;
		int agentId;
		String agentEmail;
		ClubUser loggedInUser = null;
		
		System.out.println("Please Enter 1 to Register or 2 to Login -1 to exit");
		choice = console.nextInt();
		while(choice!=-1)
		{
		if(choice ==1)
		{
			System.out.println("Enter 1 to Register as Club or 2 to Register as Player Agent");
			int opt = console.nextInt();
			if(opt == 1)
			{
				
			System.out.println("enter clubid: ");
			clubId = console.nextInt();
			System.out.println("enter clubname: ");
			clubName = console.next();
			System.out.println("enter clubemail: ");
			clubEmail = console.next();
			System.out.println("funds: ");
			fundsAvailTransfer = console.nextInt();
			
			ClubUser cu = new ClubUser(clubId, clubName, clubEmail, fundsAvailTransfer);
			clubuser.add(cu);
			}
			else if (opt==2) {
				System.out.println("Enter Agent Name: ");
				agentName = console.next();
				System.out.println("Enter Agent Id: ");
				agentId = console.nextInt();
				System.out.println("Enter agent Email: ");
				agentEmail = console.next();
				
				AgentUser au = new AgentUser(agentName, agentId, agentEmail);
				agents.add(au);
			}
            
		}
		else if(choice ==2)
		{
			System.out.println("CLub users:");
            for (main u : clubuser)
            {
                System.out.println(u);
            }
            System.out.println("Agent users:");
            for (AgentUser u : agents)
            {
                System.out.println(u);
            }
			
            System.out.println("enter club name to login:");
            String username = console.next();
            System.out.println("enter clubid to login:");
            int password = console.nextInt();
            for (ClubUser user : clubuser)
	        {
	            if (user.getClubName().equals(username))
	            {
	                if (user.getClubId()==(password))
	                {
	                	
	                	loggedInUser = user;
	                 
	                    // when a user is found, "break" stops iterating through the list
	                    break;
	                }
	            }
	        }
            if(loggedInUser != null)
            {
            	System.out.println("welcome!!!!!! " + loggedInUser.getClubName());
            }
            else
            {
            	System.out.println("try again ");
            }
            
		}
		else {
			System.out.println("Wrong input! try again");
			System.out.println("Please Enter 1 to Register or 2 to Login");
			choice = console.nextInt();
		}
		System.out.println("Please Enter 1 to Register or 2 to Login -1 to exit");
		choice = console.nextInt();
		}
		
	}

}
