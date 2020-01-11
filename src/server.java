import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.UUID;

//test
public class server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServerSocket listener;
		int clientid = 0;
		try {
			listener = new ServerSocket(10000, 10);

			while (true) {
				System.out.println("Main thread listening for incoming new connections");
				Socket newconnection = listener.accept();

				System.out.println("New connection received and spanning a thread");
				Connecthandler t = new Connecthandler(newconnection, clientid);
				clientid++;
				t.start();
			}

		}

		catch (IOException e) {
			System.out.println("Socket not opened");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Connecthandler extends Thread {

	Socket individualconnection;
	int socketid;
	ObjectOutputStream out;
	ObjectInputStream in;
	String message;

	public Connecthandler(Socket s, int i) {
		individualconnection = s;
		socketid = i;
	}

	void sendMessage(String msg) {
		try {
			out.writeObject(msg);
			out.flush();
			System.out.println("client>" + msg);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	public void run() {
		// club variables
		int clubId;
		String clubName;
		String clubEmail;
		int fundsAvailTransfer;

		// agent variables
		String agentName;
		int agentId;
		String agentEmail;
		String username;
		int password;
		ClubUser cLoggedInUser = null;
		AgentUser aLoggedInUser = null;

		// player variables
		String pName;
		int playerAge;
		int playerId = 0;
		int cId;
		int aId;
		int playerValuation;
		String playerStatus = "";
		String playerPosition = "";

		try {

			out = new ObjectOutputStream(individualconnection.getOutputStream());
			out.flush();
			in = new ObjectInputStream(individualconnection.getInputStream());
			System.out.println("Connection" + socketid + " from IP address " + individualconnection.getInetAddress());

			// Commence
			// Array List of user's data
			ArrayList<ClubUser> clubuser = new ArrayList<ClubUser>();
			ArrayList<AgentUser> agentuser = new ArrayList<AgentUser>();
			ArrayList<Player> players = new ArrayList<Player>();
			do {

				do {
					// initial message to the user
					sendMessage("Please Enter 1 to Register or 2 to Login");
					message = (String) in.readObject();
				} while (!message.equals("1") && !message.equals("2"));

				if (message.equals("1")) {

					sendMessage("Enter 1 to Register Club or 2 to Register Player Agent");
					message = (String) in.readObject();

					// Club Registration

					if (message.equals("1")) 
					{
						// club name input
						sendMessage("Enter Club Name: ");
						message = (String) in.readObject();
						clubName = message;
						// club id input
						sendMessage("Enter Club Id: ");
						message = (String) in.readObject();
						clubId = Integer.parseInt(message);
						// club email input
						sendMessage("Enter Club Email: ");
						message = (String) in.readObject();
						clubEmail = message;
						// club funds input
						sendMessage("Enter Funds Available To Transfer: ");
						message = (String) in.readObject();
						fundsAvailTransfer = Integer.parseInt(message);
						
						// clubuser object
						ClubUser cu = new ClubUser(clubId, clubName, clubEmail, fundsAvailTransfer);
						// adding objects to arraylist
						clubuser.add(cu);
						// printing arraylist to server
						for (ClubUser u : clubuser) {
							System.out.println(u);
						} // for

					} // innerif

					// Agent Registration

					else if (message.equals("2")) {
						// agent name input
						sendMessage("Enter Agent Name: ");
						message = (String) in.readObject();
						agentName = message;
						// agent id input
						sendMessage("Enter Agent Id: ");
						message = (String) in.readObject();
						agentId = Integer.parseInt(message);
						// agent email input
						sendMessage("Enter Agent Email: ");
						message = (String) in.readObject();
						agentEmail = message;
						// agent object
						AgentUser au = new AgentUser(agentName, agentId, agentEmail);
						// adding object to agentuser arraylist
							agentuser.add(au);
						
							// printing arraylist to the server console
						for (AgentUser u : agentuser) {
							System.out.println(u);
						} // for
					} // inner else if
					else {
						sendMessage("Wrong input");
					} // inner else

				} // outerif

				else if (message.equals("2")) {
					sendMessage("Enter 1 to Login as Club or 2 to Login as Player Agent");
					message = (String) in.readObject();
					// club login credentials
					if (message.equals("1")) {
						
						sendMessage("Please enter Club Name: ");
						message = (String) in.readObject();
						username = message;

						sendMessage("Please enter Club Id: ");
						message = (String) in.readObject();
						password = Integer.parseInt(message);
						// login validatin
						// searches the array list 
						for (ClubUser user : clubuser) {
							if (user.getClubId() == (password)) {
								if (user.getClubName().equalsIgnoreCase(username)) {

									cLoggedInUser = user;

									// when a user is found, "break" stops iterating through the list
									break;
								} // inner if
							} // outer if
						} // for
						// if successfully logged in as club user
						if (cLoggedInUser != null) {
							sendMessage("welcome!!!!!! " + cLoggedInUser.getClubName());
							// club user options
							sendMessage("Please Enter\n" + "1 to Search for all players in a given position\n"
									+ "2 to Search for all players for sale in their club\n"
									+ "3 to Suspend/Resume the sale of a player in their club");
							message = (String) in.readObject();

							if (message.equals("1")) {
								String chkPlayerPos = "";
								// player id to check
								sendMessage("Select Player Position to search Enter\n" + "1. for Goalkeeper\n"
										+ "2. Defender\n" + "3. Midfield\n" + "4. Attacker");
								message = (String) in.readObject();
								if (message.equals("1")) {
									chkPlayerPos = "Goalkeeper";
								} else if (message.equals("2")) {
									chkPlayerPos = "Defender";
								} else if (message.equals("3")) {
									chkPlayerPos = "Midfield";
								} else if (message.equals("4")) {
									chkPlayerPos = "Attacker";
								}

								for (Player p : players) {
									if (p.getPlayerPosition().equalsIgnoreCase(chkPlayerPos)) {

										sendMessage(p.toString());
										
									} // if
									
								} // for

							} // inner else s
						}

						else {
							sendMessage("Wrong Club Name or Id.... try again");

						}
					} // inner club login if

					else if (message.equals("2")) {
						// Agent login credentials
						sendMessage("Please enter Agent Name: ");
						message = (String) in.readObject();
						username = message;

						sendMessage("Please enter Agent Id: ");
						message = (String) in.readObject();
						password = Integer.parseInt(message);

						for (AgentUser user : agentuser) {
							if (user.getAgentId() == (password)) {
								if (user.getAgentName().equalsIgnoreCase(username)) {

									aLoggedInUser = user;

									// when a user is found, "break" stops iterating through the list
									break;
								}
							}
						} // for
						// if logged in successfully as agent
						if (aLoggedInUser != null) {
							// welcome messsage
							sendMessage("welcome!!!!!! " + aLoggedInUser.getAgentName());
							// agent user options after login
							sendMessage("Please Enter\n" + "1 to Add a Player\n"
									+ "2 to Update the player’s valuation\n" + "3 to Update the player’s status");
							message = (String) in.readObject();

							// add a player
							if (message.equals("1")) {
								// player name input 
								sendMessage("Enter Player Name: ");
								message = (String) in.readObject();
								pName = message;
								// player age input
								sendMessage("Enter Player Age: ");
								message = (String) in.readObject();
								playerAge = Integer.parseInt(message);
								// club id input
								sendMessage("Enter Club Id: ");
								message = (String) in.readObject();
								cId = Integer.parseInt(message);
								// agent id input
								sendMessage("Enter Agent Id: ");
								message = (String) in.readObject();
								aId = Integer.parseInt(message);
								// player valuation input
								sendMessage("Enter Valuation: ");
								message = (String) in.readObject();
								playerValuation = Integer.parseInt(message);
								// player status input
								sendMessage(
										"Player Status Enter\n" + "1. For Sale\n" + "2. Sold\n" + "3. Sale Suspended");
								message = (String) in.readObject();
								if (message.equals("1")) {
									playerStatus = "For Sale";
								} else if (message.equals("2")) {
									playerStatus = "Sold";
								} else if (message.equals("3")) {
									playerStatus = "Sale Suspended";
								}
								// player position input
								sendMessage("Player Position Enter\n" + "1. for Goalkeeper\n" + "2. Defender\n"
										+ "3. Midfield\n" + "4. Attacker");
								message = (String) in.readObject();
								if (message.equals("1")) {
									playerPosition = "Goalkeeper";
								} else if (message.equals("2")) {
									playerPosition = "Defender";
								} else if (message.equals("3")) {
									playerPosition = "Midfield";
								} else if (message.equals("4")) {
									playerPosition = "Attacker";
								}
								// giving unique id to players
								playerId = playerId + 1;
								// player object
								Player p = new Player(pName, playerAge, playerId, cId, aId, playerValuation,
										playerStatus, playerPosition);
								// adding object to arraylist
								players.add(p);
								sendMessage(String.valueOf(players.size()));
								// printing playes to server console
								for (Player u : players) {
									sendMessage(u.toString());
								} // for

							} // add player inner if

							// update valuation
							else if (message.equals("2")) {
								// player id to check
								sendMessage("Enter Player Id: ");
								message = (String) in.readObject();
								int chkpid = Integer.parseInt(message);
								// new valuation of that player if found
								sendMessage("Enter new valuation: ");
								message = (String) in.readObject();
								int newValuation = Integer.parseInt(message);

								for (Player p : players) {
									// checking player id to match the id of the player given by user to update
									if (p.getPlayerId() == (chkpid)) {
										// setting new valuation
										p.setPlayerValuation(newValuation);
										sendMessage("New Valuation set successfully");
										break;
									} // if
									else {
										sendMessage("Wrong id Player not found!!!!!");
									} // else
								} // for
								for (Player p : players) {
									sendMessage(p.toString());
								} // print players
							} // inner else update valuation

							// update status
							else if (message.equals("3")) {
								// player id to check
								sendMessage("Enter Player Id: ");
								message = (String) in.readObject();
								int chkpid = Integer.parseInt(message);
								// new status of that player if found
								String updateStatus = "";
								sendMessage("Player update Status Enter\n" + "1. For Sale\n" + "2. Sold\n"
										+ "3. Sale Suspended");
								message = (String) in.readObject();
								if (message.equals("1")) {
									updateStatus = "For Sale";
								} else if (message.equals("2")) {
									updateStatus = "Sold";
								} else if (message.equals("3")) {
									updateStatus = "Sale Suspended";
								}

								for (Player p : players) {
									if (p.getPlayerId() == (chkpid)) {

										p.setPlayerStatus(updateStatus);
										sendMessage("status updated successfully");
										break;
									} // if
									else {
										sendMessage("Wrong id Player not found!!!!!");
									} // else
								} // for
								for (Player p : players) {
									sendMessage(p.toString());
								} // print players
							} // inner else update valuation
						}

						else {
							sendMessage("Wrong Agent Name or Id.... try again ");
						}

					} // inner else if Agent login
				} // else if

				sendMessage("Y to repeat or N to terminate");
				message = (String) in.readObject();
			} while (message.equalsIgnoreCase("Y"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				out.close();
				in.close();
				individualconnection.close();
			}

			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
