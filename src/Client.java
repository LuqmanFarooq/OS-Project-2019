import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Scanner;
//test
public class Client 
{
	
	private Socket connection;
	private String message;
	private  Scanner console;
	private  String ipaddress;
	private  int portaddress;
	private ObjectOutputStream out;
	private ObjectInputStream in;

	public Client()
	{
		console = new Scanner(System.in);
		
		System.out.println("Enter the IP Address of the server");
		ipaddress = console.nextLine();
		
		System.out.println("Enter the TCP Port");
		portaddress  = console.nextInt();
		
	}
	
	void sendMessage(String msg)
	{
		try{
			out.writeObject(msg);
			out.flush();
			System.out.println("client>" + msg);
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) 
	{
			Client temp = new Client();
			temp.clientapp();
	}

	public void clientapp()
	{
		
		try 
		{
			connection = new Socket(ipaddress,portaddress);
		
			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();
			in = new ObjectInputStream(connection.getInputStream());
			System.out.println("Client Side ready to communicate");
		
		
		    /// Client App.
			
			do
			{
				do
				{
					message = (String)in.readObject();
					System.out.println(message);
					message = console.next();
					sendMessage(message);
				}while(!message.equalsIgnoreCase("1")&&!message.equalsIgnoreCase("2"));
				
				if(message.equals("1"))
				{
					// reg as club or agent
					message = (String)in.readObject();
					System.out.println(message);
					message = console.next();
					sendMessage(message);
					
					if(message.equals("1"))
					{
						// club name
						message = (String)in.readObject();
						System.out.println(message);
						message = console.next();
						sendMessage(message);
						// club id
						message = (String)in.readObject();
						System.out.println(message);
						message = console.next();
						sendMessage(message);
						// club email
						message = (String)in.readObject();
						System.out.println(message);
						message = console.next();
						sendMessage(message);
						// club funds
						message = (String)in.readObject();
						System.out.println(message);
						message = console.next();
						sendMessage(message);
					}// inner if
				
					// Agent registration
					
					else if(message.equals("2")){
						
						// Agent name
						message = (String)in.readObject();
						System.out.println(message);
						message = console.next();
						sendMessage(message);
						// Agent id
						message = (String)in.readObject();
						System.out.println(message);
						message = console.next();
						sendMessage(message);
						// Agent email
						message = (String)in.readObject();
						System.out.println(message);
						message = console.next();
						sendMessage(message);
						
					}//inner if
				}// outer if
			
				else if(message.equals("2"))
				{
					// Login as club or agent
					
					message = (String)in.readObject();
					System.out.println(message);
					message = console.next();
					sendMessage(message);
					
					if(message.equals("1"))
					{
					// club name
					message = (String)in.readObject();
					System.out.println(message);
					message = console.next();
					sendMessage(message);
					// club id
					message = (String)in.readObject();
					System.out.println(message);
					message = console.next();
					sendMessage(message);
					
					// welcome message
					message = (String)in.readObject();
					System.out.println(message);
					}// inner if club login
					
					else if(message.equals("2"))
					{
					// Agent name
					message = (String)in.readObject();
					System.out.println(message);
					message = console.next();
					sendMessage(message);
					// Agent id
					message = (String)in.readObject();
					System.out.println(message);
					message = console.next();
					sendMessage(message);
					
					// welcome message
					message = (String)in.readObject();
					System.out.println(message);
					
					// player functions
					message = (String)in.readObject();
					System.out.println(message);
					message = console.next();
					sendMessage(message);
					
					if(message.equals("1"))
					{
						// player name
						message = (String)in.readObject();
						System.out.println(message);
						message = console.next();
						sendMessage(message);
						// player age
						message = (String)in.readObject();
						System.out.println(message);
						message = console.next();
						sendMessage(message);
						// club id	
						message = (String)in.readObject();
						System.out.println(message);
						message = console.next();
						sendMessage(message);
						// Agent id
						message = (String)in.readObject();
						System.out.println(message);
						message = console.next();
						sendMessage(message);
						// valuation
						message = (String)in.readObject();
						System.out.println(message);
						message = console.next();
						sendMessage(message);
						// Status
						message = (String)in.readObject();
						System.out.println(message);
						message = console.next();
						sendMessage(message);
						// Position
						message = (String)in.readObject();
						System.out.println(message);
						message = console.next();
						sendMessage(message);
						
						// printing players
						message = (String)in.readObject();
						System.out.println(message);
					}//if add player
					else if(message.equals("2"))
					{
						// player id to check
						message = (String)in.readObject();
						System.out.println(message);
						message = console.next();
						sendMessage(message);
						
						// new valuation for change
						message = (String)in.readObject();
						System.out.println(message);
						message = console.next();
						sendMessage(message);
						
						// success or failure message
						message = (String)in.readObject();
						System.out.println(message);
						
						// printing players
						message = (String)in.readObject();
						System.out.println(message);
					}// else if update valuation
					else if(message.equals("3"))
					{
						// player id to check
						message = (String)in.readObject();
						System.out.println(message);
						message = console.next();
						sendMessage(message);
						
						// status for change
						message = (String)in.readObject();
						System.out.println(message);
						message = console.next();
						sendMessage(message);
						
						// success or failure message
						message = (String)in.readObject();
						System.out.println(message);
						
						// printing players
						message = (String)in.readObject();
						System.out.println(message);
					}// else if update player status
					}// inner if Agent login
					
				}// outer else if
			
				message = (String)in.readObject();
				System.out.println(message);
				message = console.next();
				sendMessage(message);
				
			}while(message.equalsIgnoreCase("Y"));
			
			out.close();
			in.close();
			connection.close();
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
